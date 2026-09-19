using System.Collections.Generic;
using Newtonsoft.Json;

namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class Codes
    {
        public string alpha_2 { get; set; }

        [JsonExtensionData]
        private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

    }
}
