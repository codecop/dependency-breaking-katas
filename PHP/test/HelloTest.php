<?php

namespace Org\Codecop\Dependencies\Tests;

use PHPUnit\Framework\TestCase;
use Org\Codecop\Dependencies\Hello;

class HelloTest extends TestCase {

    /**
     * @test
     */
    public function shouldGreet() {
        $hello = new Hello();

        $greeting = $hello->greeting();

        $this->assertEquals("Hello World", $greeting);
    }

}
