using System;
using Org.Codecop.Dependencies.E;
using Moq;
using Xunit;

namespace Org.Codecop.Dependencies.E.Tests
{
    public class CheckoutTest
    {
        private readonly Mock<IEmailService> emailServiceMock;

        public CheckoutTest()
        {
            emailServiceMock = new Mock<IEmailService>();
        }

        [Fact]
        public void Test5()
        {
            Console.WriteLine("note for tester:");
            Console.WriteLine("* Accept Newsletter");
            Console.WriteLine("* Do not Accept Terms");
            var polkaDotSocks = new Product("Polka-dot Socks");

            var checkout = new Checkout(polkaDotSocks, emailServiceMock.Object);
            checkout.ConfirmOrder();
        }
    }
}
