using Org.Codecop.Dependencies.B;
using Xunit;

namespace Org.Codecop.Dependencies.B.Tests
{
    public class MarketingCampaignTest
    {
        [Fact]
        public void Test2()
        {
            var campaign = new MarketingCampaign();

            var isCrazySalesDay = campaign.IsCrazySalesDay();

            Assert.False(isCrazySalesDay);
        }
    }
}
