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

        private const string CountryInformationServiceUrl = "https://restcountries.eu/rest/v2/all";

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
            if (countryDescription == null)
            {
                return false;
            }
            IList<object> regionalBlocs = countryDescription.regionalBlocs;
            if (regionalBlocs.Count == 0)
            {
                return false;
            }
            IDictionary<string, string> bloc = (IDictionary<string, string>)regionalBlocs[0];
            return bloc["acronym"] != null && bloc["acronym"].Equals("EU");
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
            return DistBetween(austria.latlng, other.latlng);
        }

        private int DistBetween(IList<double> fromCoordinates, IList<double> toCoordinates)
        {
            return DistBetween(fromCoordinates[0], fromCoordinates[1], toCoordinates[0], toCoordinates[1]);
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
            return SlowHttpCall().Where(c => c.alpha2Code.Equals(country.ToString())).FirstOrDefault(null);
        }

        public IList<CountryDescription> SlowHttpCall()
        {
            try
            {
                // TODO System.Threading.Thread.Sleep(1000);
                var jsonResponse = Unirest //
                    .get(CountryInformationServiceUrl)
                    .header("accept", "application/json")
                    .asString();
                var body = jsonResponse.Body;
                return JsonConvert.DeserializeObject<CountryDescription[]>(body);
            }
            catch (Exception e)
            {
                throw new RestCountriesAPIException("Could not read country information from " + CountryInformationServiceUrl, e);
            }
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
