using Org.Codecop.Dependencies.D;
using Xunit;

namespace Org.Codecop.Dependencies.D.Tests
{
    public class ShippingCostTest
    {
        [Fact]
        public void Test4()
        {
            var shippingCost = new ShippingCost();
            Assert.NotNull(shippingCost);
        }
    }
}
