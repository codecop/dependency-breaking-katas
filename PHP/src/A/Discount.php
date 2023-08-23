<?php

namespace Org\Codecop\Dependencies\A;

class Discount {

    private $marketingCampaign;

    public function __construct() {
        $this->marketingCampaign = new MarketingCampaign();
    }

    public function discountFor(Money $netPrice): Money {
        if ($this->marketingCampaign->isCrazySalesDay()) {
            return $netPrice->reduceBy(15);
        }
        if ($netPrice->moreThan(Money::ONE_THOUSAND)) {
            return $netPrice->reduceBy(10);
        }
        if ($netPrice->moreThan(Money::ONE_HUNDRED) && $this->marketingCampaign->isActive()) {
            return $netPrice->reduceBy(5);
        }
        return $netPrice;
    }
}
