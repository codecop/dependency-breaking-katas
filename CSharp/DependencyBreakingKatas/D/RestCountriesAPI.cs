using System;
using System.Linq;
using System.Collections.Generic;
using Org.Codecop.Dependencies.D.Restcountries;
using unirest_net.http;
using Newtonsoft.Json;

namespace Org.Codecop.Dependencies.D
{
    public class RestCountriesAPI
    {
        private static readonly Country HomeBase = new Country("AT");

        private const string CountryInformationServiceUrl = "https://api.restcountries.com/countries/v5?pretty=1&limit=100";

        private static readonly RestCountriesAPI instance = new RestCountriesAPI();

        private RestCountriesAPI()
        {
        }

        public static RestCountriesAPI GetInstance()
        {
            return instance;
        }

        public bool IsInCommonMarket(Country country)
        {
            CountryDescription countryDescription = GetCountryDescriptionViaRestCall(country);
            return countryDescription?.region.Equals("Europe") ?? false;
        }

        public bool IsInAmericas(Country country)
        {
            CountryDescription countryDescription = GetCountryDescriptionViaRestCall(country);
            return countryDescription?.region.Equals("Americas") ?? false;
        }

        public int DistanceTo(Country country)
        {
            CountryDescription austria = GetCountryDescriptionViaRestCall(HomeBase);
            CountryDescription other = GetCountryDescriptionViaRestCall(country);

            if (austria == null || other == null)
            {
                throw new RestCountriesAPIException("Could not find country " + HomeBase + " or " + country);
            }

            return DistBetween(austria.coordinates.lat, austria.coordinates.lng, 
                               other.coordinates.lat, other.coordinates.lng);
        }

        private int DistBetween(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude)
        {
            double earthRadius = 6371000; // meters
            double fLat = ConvertToRadians(fromLatitude);
            double toLat = ConvertToRadians(toLatitude);
            double diffLat = ConvertToRadians(toLatitude - fromLatitude);
            double diffLng = ConvertToRadians(toLongitude - fromLongitude);
            double a = Math.Sin(diffLat / 2) * Math.Sin(diffLat / 2)
                + Math.Cos(fLat) * Math.Cos(toLat) * Math.Sin(diffLng / 2) * Math.Sin(diffLng / 2);
            double c = 2 * Math.Atan2(Math.Sqrt(a), Math.Sqrt(1 - a));
            float dist = (float)(earthRadius * c);
            return (int)dist;
        }

        private double ConvertToRadians(double angle)
        {
            return (Math.PI / 180) * angle;
        }

        private CountryDescription GetCountryDescriptionViaRestCall(Country country)
        {
            return SlowHttpCall().
                Where(c => c.codes.alpha_2.Equals(country.ToString())).
                SingleOrDefault();
        }

        public IList<CountryDescription> SlowHttpCall()
        {
            List<CountryDescription> countryDescriptions = new List<CountryDescription> {};

            try
            {
                for (int offset = 0; offset < 300; offset += 100) {
                    System.Threading.Thread.Sleep(300);
                    var jsonResponse = Unirest //
                        .get(CountryInformationServiceUrl + "&offset=" + offset)
                        .header("accept", "application/json")
                        .header("Authorization", "Bearer " + System.Environment.GetEnvironmentVariable("RESTCOUNTRIES_API_KEY"))
                        .asString();

                    var body = jsonResponse.Body;
                    var jsonBody = JsonConvert.DeserializeObject<Root>(body);
                    countryDescriptions.AddRange(jsonBody.data.objects);
                }

            }
            catch (Exception e)
            {
                throw new RestCountriesAPIException("Could not read country information from " + CountryInformationServiceUrl, e);
            }

            return countryDescriptions;
        }
        
        public static void Main(string[] args)
        {
            Console.WriteLine(new Country("US"));
            Console.WriteLine(GetInstance().IsInAmericas(new Country("US")));
            Console.WriteLine(GetInstance().IsInCommonMarket(new Country("US")));
            Console.WriteLine(GetInstance().DistanceTo(new Country("US")));
            Console.WriteLine(new Country("AT"));
            Console.WriteLine(GetInstance().IsInAmericas(new Country("AT")));
            Console.WriteLine(GetInstance().IsInCommonMarket(new Country("AT")));
            Console.WriteLine(GetInstance().DistanceTo(new Country("AT")));
        }
    }
}
