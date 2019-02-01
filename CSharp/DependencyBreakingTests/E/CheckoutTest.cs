using Org.Codecop.Dependencies.E;
using Xunit;

namespace Org.Codecop.Dependencies.E.Tests
{
    public class HelloTest
    {
        [Fact]
        public void ShouldGreet()
        {
            var hello = new Hello();

            var greeting = hello.greetings();

            Assert.Equal("Hello World", greeting);
        }
    }
}
