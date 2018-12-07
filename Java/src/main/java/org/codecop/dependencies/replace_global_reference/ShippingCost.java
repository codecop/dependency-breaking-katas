package org.codecop.dependencies.replace_global_reference;

public class ShippingCost {

    public Money calculate(Country country, DeliveryOptions options) {
        final Money cost;

        if (GoogleMapsAPI.getInstance().isInCommonMarket(country)) {
            // flat rate in EU
            cost = new Money(5);

        } else if (GoogleMapsAPI.getInstance().isInAmericas(country)) {
            // US & Canada & South American
            if (options == DeliveryOptions.EXPRESS) {
                cost = new Money(40);
            } else {
                cost = new Money(15);
            }

        } else {
            // other countries, e.g. Asia
            int km = GoogleMapsAPI.getInstance().distanceTo(country);
            cost = new Money(km).percentage(10);
        }

        return cost;
    }

}
