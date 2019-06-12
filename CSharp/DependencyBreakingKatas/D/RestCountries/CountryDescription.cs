using System.Collections.Generic;

namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class CountryDescription
    {
        public string name { get; set; }

        public IList<string> topLevelDomain { get; set; }

        public string alpha2Code { get; set; }

        public string alpha3Code { get; set; }

        public IList<string> callingCodes { get; set; }

        public string capital { get; set; }

        public IList<string> altSpellings { get; set; }

        public string region { get; set; }

        public string subregion { get; set; }

        public int population { get; set; }

        public IList<double> latlng { get; set; }

        public string demonym { get; set; }

        public int area { get; set; }

        public object Gini { get; set; }

        public IList<string> timezones { get; set; }

        public IList<object> borders { get; set; }

        public string nativeName { get; set; }

        public string numericCode { get; set; }

        public IList<Currency> currencies { get; set; }

        public IList<Language> languages { get; set; }

        public Translations translations { get; set; }

        public string flag { get; set; }

        public IList<object> regionalBlocs { get; set; }

        public string cioc { get; set; }

        // [JsonIgnore]
        // private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

        // [JsonAnyGetter]
        // public virtual IDictionary<string, object> GetAdditionalProperties()
        // {
        //     return this.additionalProperties;
        // }

        // [JsonAnySetter]
        // public virtual void SetAdditionalProperty(string name, object value)
        // {
        //     this.additionalProperties.Put(name, value);
        // }
    }
}
