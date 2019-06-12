using Org.Codecop.Dependencies.E;
using Moq;
using Xunit;
using Xunit.Abstractions;

namespace Org.Codecop.Dependencies.E.Tests
{
    public class CheckoutTest
    {
        // see https://xunit.net/docs/capturing-output
        private readonly ITestOutputHelper output;
        private readonly Mock<IEmailService> emailServiceMock;

        public CheckoutTest(ITestOutputHelper output)
        {
            this.output = output;
            this.emailServiceMock = new Mock<IEmailService>();
        }

        [Fact]
        public void Test5()
        {
            output.WriteLine("note for tester:");
            output.WriteLine("* Accept Newsletter");
            output.WriteLine("* Do not Accept Terms");

            var polkaDotSocks = new Product("Polka-dot Socks");
            var checkout = new Checkout(polkaDotSocks, emailServiceMock.Object);

            Assert.Throws<OrderCancelledException>(() => checkout.ConfirmOrder());
        }
    }
}
