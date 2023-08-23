<?php

namespace Org\Codecop\Dependencies\Tests\B;

use PHPUnit\Framework\TestCase;
use Org\Codecop\Dependencies\B\MarketingCampaign;

class MarketingCampaignTest extends TestCase {

    public function test2() {
        $campaign = new MarketingCampaign();

        $isCrazySalesDay = $campaign->isCrazySalesDay();

        $this->assertFalse($isCrazySalesDay);
    }
}
