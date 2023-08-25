<?php

namespace Org\Codecop\Dependencies\Tests\C;

use PHPUnit\Framework\TestCase;
use Org\Codecop\Dependencies\C\Checkout;
use Org\Codecop\Dependencies\C\Money;

class CheckoutTest extends TestCase {

    public function test3() {
        $checkout = new Checkout();

        $checkout->createReceipt(new Money(12));

        $this->assertNotNull($checkout);
    }
}
