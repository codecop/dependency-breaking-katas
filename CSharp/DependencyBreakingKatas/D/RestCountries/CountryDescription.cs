using System.Collections.Generic;
using Newtonsoft.Json;

namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class CountryDescription
    {
        public Codes codes { get; set; }

        public string region { get; set; }

        public Coordinates coordinates { get; set; }

        [JsonExtensionData]
        private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

    }
}
