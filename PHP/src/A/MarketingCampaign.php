<?php

namespace Org\Codecop\Dependencies\A;

class MarketingCampaign {

    public function isActive(): bool {
        return (floor(microtime(true) * 1000)) % 2 == 0;
    }

    public function isCrazySalesDay(): bool {
        return date('N') == 5; // Friday corresponds to day number 5
    }
}
