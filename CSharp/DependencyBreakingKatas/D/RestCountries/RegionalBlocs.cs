using System.Collections.Generic;
using Newtonsoft.Json;

namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class RegionalBlocs
    {
        public string acronym { get; set; }

        public string name { get; set; }

        public IList<string> otherAcronyms { get; set; }

        public IList<string> otherNames { get; set; }

        [JsonExtensionData]
        private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

    }
}
