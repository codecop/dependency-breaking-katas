<?php

namespace Org\Codecop\Dependencies\B;

class MarketingCampaign {

    public function isActive(): bool {
        return $this->milliSeconds() % 2 == 0;
    }

    private function milliSeconds() {
        return floor(microtime(true) * 1000);
    }

    public function isCrazySalesDay(): bool {
        return $this->dayOfWeek() == 4; // Friday
    }

    private function dayOfWeek() {
        return date('N');
    }
}
