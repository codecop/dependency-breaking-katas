using System.Collections.Generic;
using Newtonsoft.Json;

namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class Currency
    {
        public string code { get; set; }

        public string name { get; set; }

        public string symbol { get; set; }

        [JsonExtensionData]
        private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

    }
}
