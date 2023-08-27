<?php

namespace Org\Codecop\Dependencies\Tests\D;

use PHPUnit\Framework\TestCase;
use Org\Codecop\Dependencies\D\Country;
use Org\Codecop\Dependencies\D\RestCountriesAPI;

class RestCountriesAPITest extends TestCase {

    /**
     * @test
     * @group slow
     */
    public function testIsAmericas() {
        $us = new Country("US");
        $this->assertTrue($this->getInstance()->isInAmericas($us));
    }

    /**
     * @test
     * @group slow
     */
    public function testIsNotCommonMarket() {
        $us = new Country("US");
        $this->assertFalse($this->getInstance()->isInCommonMarket($us));
    }

    /**
     * @test
     */
    public function testGetDistance() {
        $us = new Country("US");
        $this->assertEquals(8284767, $this->getInstance()->distanceTo($us));
    }

    /**
     * @test
     * @group slow
     */
    public function testIsNotAmericas() {
        $at = new Country("AT");
        $this->assertFalse($this->getInstance()->isInAmericas($at));
    }

    /**
     * @test
     * @group slow
     */
    public function testIsCommonMarket() {
        $at = new Country("AT");
        $this->assertTrue($this->getInstance()->isInCommonMarket($at));
    }

    /**
     * @test
     * @group slow
     */
    public function testGetNoDistance() {
        $at = new Country("AT");
        $this->assertEquals(0, $this->getInstance()->distanceTo($at));
    }

    private function getInstance() {
        return RestCountriesAPI::getInstance();
    }
}
