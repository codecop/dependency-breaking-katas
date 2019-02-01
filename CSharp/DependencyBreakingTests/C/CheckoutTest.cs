using Org.Codecop.Dependencies.C;
using Xunit;

namespace Org.Codecop.Dependencies.C.Tests
{
    public class CheckoutTest
    {
        [Fact]
        public void Test3()
        {
            var checkout = new Checkout();
            checkout.CreateReceipt(new Money(12));
            Assert.NotNull(checkout);
        }
    }
}
