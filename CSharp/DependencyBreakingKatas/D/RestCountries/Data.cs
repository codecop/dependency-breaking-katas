using System.Collections.Generic;
using Newtonsoft.Json;

namespace Org.Codecop.Dependencies.D.Restcountries
{
    public class Data
    {
        public IList<CountryDescription> objects { get; set; }

        [JsonExtensionData]
        private IDictionary<string, object> additionalProperties = new Dictionary<string, object>();

    }
}
