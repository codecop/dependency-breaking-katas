using System;
using System.Runtime.Serialization;

namespace Org.Codecop.Dependencies.ExtractAndOverrideCall
{
    [Serializable]
    internal class SqlRuntimeException : Exception
    {
        public SqlRuntimeException()
        {
        }

        public SqlRuntimeException(string message) : base(message)
        {
        }

        public SqlRuntimeException(string message, Exception innerException) : base(message, innerException)
        {
        }

        protected SqlRuntimeException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}