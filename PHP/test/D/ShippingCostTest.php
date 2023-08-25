<?php

namespace Org\Codecop\Dependencies\Tests\D;

use PHPUnit\Framework\TestCase;
use Org\Codecop\Dependencies\D\ShippingCost;

class ShippingCostTest extends TestCase {

    public function test4() {
        $shippingCost = new ShippingCost();

        $this->assertNotNull($shippingCost);
    }
}
