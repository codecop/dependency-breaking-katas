using System;

namespace Org.Codecop.Dependencies.D
{
    public class RestCountriesAPIException : ApplicationException
    {
        public RestCountriesAPIException(string message)
            : base(message)
        {
        }

        public RestCountriesAPIException(string message, Exception cause)
            : base(message, cause)
        {
        }
    }
}
