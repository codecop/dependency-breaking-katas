using Org.Codecop.Dependencies.SubclassAndOverride;
using Xunit;

namespace Org.Codecop.Dependencies.SubclassAndOverride.Tests
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
