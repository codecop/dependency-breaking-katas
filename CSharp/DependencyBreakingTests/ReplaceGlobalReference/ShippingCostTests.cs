using Org.Codecop.Dependencies.ReplaceGlobalReference;
using Xunit;

namespace Org.Codecop.Dependencies.ReplaceGlobalReference.Tests
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
