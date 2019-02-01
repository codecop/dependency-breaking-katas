using Org.Codecop.Dependencies.D;
using Xunit;

namespace Org.Codecop.Dependencies.D.Tests
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
