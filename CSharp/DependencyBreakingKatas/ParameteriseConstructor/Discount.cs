namespace Org.Codecop.Dependencies.ParameteriseConstructor
{
    public class Discount
    {
        private readonly MarketingCampaign marketingCampaign;

        public Discount()
        {
            this.marketingCampaign = new MarketingCampaign();
        }

        public virtual Money DiscountFor(Money netPrice)
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
