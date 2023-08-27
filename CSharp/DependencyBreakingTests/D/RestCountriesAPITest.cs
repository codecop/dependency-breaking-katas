using Org.Codecop.Dependencies.D;
using Xunit;

namespace Org.Codecop.Dependencies.D.Tests
{
    public class RestCountriesAPITest
    {
        [Fact(Skip = "slow")]
        public void IsAmericas()
        {
            Country us = new Country("US");
            Assert.True(GetInstance().IsInAmericas(us));
        }

        [Fact(Skip = "slow")]
        public void IsNotCommonMarket()
        {
            Country us = new Country("US");
            Assert.False(GetInstance().IsInCommonMarket(us));
        }

        [Fact]
        public void GetDistance()
        {
            Country us = new Country("US");
            Assert.Equal(8284768, GetInstance().DistanceTo(us));
        }

        [Fact(Skip = "slow")]
        public void IsNotAmericas()
        {
            Country at = new Country("AT");
            Assert.False(GetInstance().IsInAmericas(at));
        }

        [Fact(Skip = "slow")]
        public void IsCommonMarket()
        {
            Country at = new Country("AT");
            Assert.True(GetInstance().IsInCommonMarket(at));
        }

        [Fact(Skip = "slow")]
        public void GetNoDistance()
        {
            Country at = new Country("AT");
            Assert.Equal(0, GetInstance().DistanceTo(at));
        }

        private RestCountriesAPI GetInstance()
        {
            return RestCountriesAPI.GetInstance();
        }
    }

}
