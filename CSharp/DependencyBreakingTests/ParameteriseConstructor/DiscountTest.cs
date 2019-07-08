using Org.Codecop.Dependencies.ParameteriseConstructor;
using Xunit;

namespace Org.Codecop.Dependencies.ParameteriseConstructor.Tests
{
    public class DiscountTest
    {
        [Fact]
        public void Test1()
        {
            var discount = new Discount();

            var net = new Money(1002);
            var total = discount.DiscountFor(net);

            Assert.Equal(new Money(901.8m), total);
        }
    }
}
