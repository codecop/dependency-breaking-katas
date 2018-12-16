using Org.Codecop.Dependencies.ExtractAndOverrideCall;
using Xunit;

namespace Org.Codecop.Dependencies.ExtractAndOverrideCall.Tests
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
