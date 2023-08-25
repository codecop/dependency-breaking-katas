<?php

namespace Org\Codecop\Dependencies\D;

class ShippingCost {

    public function calculate(Country $country, string $options): Money {
        $cost = null;

        if (RestCountriesAPI::getInstance()->isInCommonMarket($country)) {
            // flat rate in EU
            $cost = new Money(5);

        } else if (RestCountriesAPI::getInstance()->isInAmericas($country)) {
            // US & Canada & South American
            if ($options === DeliveryOptions::EXPRESS) {
                $cost = new Money(40);
            } else {
                $cost = new Money(15);
            }

        } else {
            // other countries, e.g. Asia
            $km = RestCountriesAPI::getInstance()->distanceTo($country);
            $cost = (new Money($km))->percentage(10);
        }

        return $cost;
    }
}
