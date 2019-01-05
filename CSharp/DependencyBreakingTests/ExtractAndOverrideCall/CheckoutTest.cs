using Org.Codecop.Dependencies.ExtractAndOverrideCall;
using Xunit;

namespace Org.Codecop.Dependencies.ExtractAndOverrideCall.Tests
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
