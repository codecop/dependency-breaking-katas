using Org.Codecop.Dependencies.ExtractAndOverrideFactory;
using Xunit;

namespace Org.Codecop.Dependencies.ExtractAndOverrideFactory.Tests
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
