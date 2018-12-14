package org.codecop.dependencies.replace_global_reference;

public class ShippingCost {

    public Money calculate(Country country, DeliveryOptions options) {
        final Money cost;

        if (getGoogleMapsAPI().isInCommonMarket(country)) {
            // flat rate in EU
            cost = new Money(5);

        } else if (getGoogleMapsAPI().isInAmericas(country)) {
            // US & Canada & South American
            if (options == DeliveryOptions.EXPRESS) {
                cost = new Money(40);
            } else {
                cost = new Money(15);
            }

        } else {
            // other countries, e.g. Asia
            int km = getGoogleMapsAPI().distanceTo(country);
            cost = new Money(km).percentage(10);
        }

        return cost;
    }

    /* for test */
    protected GoogleMapsAPI getGoogleMapsAPI() {
        return GoogleMapsAPI.getInstance();
    }

}
