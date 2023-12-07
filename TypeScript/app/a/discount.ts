import { Money } from "./money";
import { MarketingCampaign } from "./marketing-campaign";

export class Discount {

    private marketingCampaign: MarketingCampaign;

    constructor() {
        this.marketingCampaign = new MarketingCampaign();
    }

    discountFor(netPrice: Money): Money {
        if (this.marketingCampaign.isCrazySalesDay()) {
            return netPrice.reduceBy(15);
        }
        if (netPrice.moreThan(Money.ONE_THOUSAND)) {
            return netPrice.reduceBy(10);
        }
        if (netPrice.moreThan(Money.ONE_HUNDRED) && this.marketingCampaign.isActive()) {
            return netPrice.reduceBy(5);
        }
        return netPrice;
    }
}
