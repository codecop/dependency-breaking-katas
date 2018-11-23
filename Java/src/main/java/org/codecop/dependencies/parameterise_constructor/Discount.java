package org.codecop.dependencies.parameterise_constructor;

public class Discount {

    private final MarketingCampaign marketingCampaign;

    public Discount() {
        this.marketingCampaign = new MarketingCampaign();
    }

    public Money discountFor(Money netPrice) {
        if (marketingCampaign.isCrazySalesDay()) {
            return netPrice.reduceBy(15);
        }
        if (netPrice.moreThan(Money.ONE_THOUSAND)) {
            return netPrice.reduceBy(10);
        }
        if (netPrice.moreThan(Money.ONE_HOUNDRED) && marketingCampaign.isActive()) {
            return netPrice.reduceBy(5);
        }
        return netPrice;
    }
}
