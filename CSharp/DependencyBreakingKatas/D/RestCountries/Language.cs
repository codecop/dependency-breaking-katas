namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class Language
    {
        public string iso6391 { get; set; }

        public string iso6392 { get; set; }

        public string name { get; set; }

        public string nativeName { get; set; }

        // [JsonIgnore]
        // private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

        // [JsonAnyGetter]
        // public IDictionary<string, object> GetAdditionalProperties()
        // {
        //     return this.additionalProperties;
        // }

        // [JsonAnySetter]
        // public void SetAdditionalProperty(string name, object value)
        // {
        //     this.additionalProperties.Put(name, value);
        // }
    }
}
