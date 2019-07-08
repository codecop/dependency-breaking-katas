using System;

namespace Org.Codecop.Dependencies.E
{
    public class OrderCancelledException : ApplicationException
    {
        public OrderCancelledException(Product product)
            : base(product.Name)
        {
        }
    }
}
