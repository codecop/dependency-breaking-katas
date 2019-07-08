using System.Collections.Generic;
using Newtonsoft.Json;

namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class Translations
    {
        public string de { get; set; }

        public string es { get; set; }

        public string fr { get; set; }

        public string ja { get; set; }

        public string it { get; set; }

        public string br { get; set; }

        public string pt { get; set; }

        public string nl { get; set; }

        public string hr { get; set; }

        public string fa { get; set; }

        [JsonExtensionData]
        private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

    }
}
