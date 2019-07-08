package org.codecop.dependencies.replace_global_reference;

public class ShippingCost {

    public Money calculate(Country country, DeliveryOptions options) {
        final Money cost;

        if (getRestCountriesAPI().isInCommonMarket(country)) {
            // flat rate in EU
            cost = new Money(5);

        } else if (getRestCountriesAPI().isInAmericas(country)) {
            // US & Canada & South American
            if (options == DeliveryOptions.EXPRESS) {
                cost = new Money(40);
            } else {
                cost = new Money(15);
            }

        } else {
            // other countries, e.g. Asia
            int km = getRestCountriesAPI().distanceTo(country);
            cost = new Money(km).percentage(10);
        }

        return cost;
    }

    /* for test */
    protected RestCountriesAPI getRestCountriesAPI() {
        return RestCountriesAPI.getInstance();
    }

}
