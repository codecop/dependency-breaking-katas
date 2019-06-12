namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class Currency
    {
        public string code { get; set; }

        public string name { get; set; }

        public string symbol { get; set; }

        // [JsonIgnore]
        // private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();


        // [JsonAnyGetter]
        // public virtual IDictionary<string, object> GetAdditionalProperties()
        // {
        // 	return this.additionalProperties;
        // }

        // [JsonAnySetter]
        // public virtual void SetAdditionalProperty(string name, object value)
        // {
        // 	this.additionalProperties.Put(name, value);
        // }
    }
}
