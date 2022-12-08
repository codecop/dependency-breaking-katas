package org.codecop.dependencies.a;

public class Discount {

    private final MarketingCampaign marketingCampaign;

    public Discount(MarketingCampaign marketingCampaign1) {
        this.marketingCampaign = marketingCampaign1;
    }

    public Money discountFor(Money netPrice) {
        if (marketingCampaign.isCrazySalesDay()) {
            return netPrice.reduceBy(15);
        }
        if (netPrice.moreThan(Money.ONE_THOUSAND)) {
            return netPrice.reduceBy(10);
        }
        if (netPrice.moreThan(Money.ONE_HUNDRED) && marketingCampaign.isActive()) {
            return netPrice.reduceBy(5);
        }
        return netPrice;
    }
}
