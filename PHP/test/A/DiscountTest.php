<?php

namespace Org\Codecop\Dependencies\Tests\A;

use PHPUnit\Framework\TestCase;
use Brick\Math\BigDecimal;
use Org\Codecop\Dependencies\A\Discount;
use Org\Codecop\Dependencies\A\Money;

class DiscountTest extends TestCase {

    public function test1() {
        $discount = new Discount();

        $net = new Money(1002);
        $total = $discount->discountFor($net);

        $this->assertEquals(new Money(new BigDecimal("901.8")), $total);
    }
}
