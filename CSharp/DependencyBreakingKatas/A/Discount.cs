namespace Org.Codecop.Dependencies.A
{
    public class Discount
    {
        private readonly MarketingCampaign marketingCampaign;

        public Discount()
        {
            this.marketingCampaign = new MarketingCampaign();
        }

        public Money DiscountFor(Money netPrice)
        {
            if (marketingCampaign.IsCrazySalesDay())
            {
                return netPrice.ReduceBy(15);
            }
            if (netPrice.MoreThan(Money.OneThousand))
            {
                return netPrice.ReduceBy(10);
            }
            if (netPrice.MoreThan(Money.OneHoundred) && marketingCampaign.IsActive())
            {
                return netPrice.ReduceBy(5);
            }
            return netPrice;
        }
    }
}
