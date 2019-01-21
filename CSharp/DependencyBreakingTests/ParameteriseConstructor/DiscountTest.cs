using Org.Codecop.Dependencies.ParameteriseConstructor;
using Xunit;

namespace Org.Codecop.Dependencies.ParameteriseConstructor.Tests
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
