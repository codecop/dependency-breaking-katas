namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class Language
    {
        public string Iso6391 { get; set; }

        public string Iso6392 { get; set; }

        public string Name { get; set; }

        public string NativeName { get; set; }

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
