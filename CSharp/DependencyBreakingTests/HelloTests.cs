using Org.Codecop.Dependencies;
using Xunit;

namespace Org.Codecop.Dependencies.Tests
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
