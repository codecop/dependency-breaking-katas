using System.Collections.Generic;
using Newtonsoft.Json;

namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class Language
    {
        public string iso6391 { get; set; }

        public string iso6392 { get; set; }

        public string name { get; set; }

        public string nativeName { get; set; }

        [JsonExtensionData]
        private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

    }
}
