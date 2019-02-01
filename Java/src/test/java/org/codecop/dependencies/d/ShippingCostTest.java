package org.codecop.dependencies.d;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShippingCostTest {

    @Test
    public void europeShipsAtCostOf5() {
        Country germany = new Country("DE");
        RestCountriesAPI restCountriesAPIStub = createRestCountriesAPIInEurope(germany);
        ShippingCost shippingCost = createShippingCostForTest(restCountriesAPIStub);

        Money cost = shippingCost.calculate(germany, DeliveryOptions.STANDARD);

        assertEquals(new Money(5), cost);
    }

    @Test
    public void americasShipsAtCostOf15() {
        Country canada = new Country("CA");
        RestCountriesAPI restCountriesAPIStub = createRestCountriesAPIInAmericas(canada);
        ShippingCost shippingCost = createShippingCostForTest(restCountriesAPIStub);

        Money cost = shippingCost.calculate(canada, DeliveryOptions.STANDARD);

        assertEquals(new Money(15), cost);
    }

    @Test
    public void americasExpressShipsAtCostOf25() {
        Country canada = new Country("CA");
        RestCountriesAPI restCountriesAPIStub = createRestCountriesAPIInAmericas(canada);
        ShippingCost shippingCost = createShippingCostForTest(restCountriesAPIStub);

        Money cost = shippingCost.calculate(canada, DeliveryOptions.EXPRESS);

        assertEquals(new Money(40), cost);
    }

    @Test
    public void otherShipsAtCostWithDistance() {
        Country egypt = new Country("EG");
        RestCountriesAPI restCountriesAPIStub = createRestCountriesAPIInOtherWithDistance(egypt, 2380);
        ShippingCost shippingCost = createShippingCostForTest(restCountriesAPIStub);

        Money cost = shippingCost.calculate(egypt, DeliveryOptions.EXPRESS);

        assertEquals(new Money(238), cost);
    }

    private RestCountriesAPI createRestCountriesAPIInEurope(Country expectedCountry) {
        return new RestCountriesAPI() {
            @Override
            public boolean isInCommonMarket(Country country) {
                assertEquals(expectedCountry, country);
                return true;
            }
        };
    }

    private RestCountriesAPI createRestCountriesAPIInAmericas(Country expectedCountry) {
        return new RestCountriesAPI() {
            @Override
            public boolean isInCommonMarket(Country country) {
                assertEquals(expectedCountry, country);
                return false;
            }

            @Override
            public boolean isInAmericas(Country country) {
                assertEquals(expectedCountry, country);
                return true;
            }
        };
    }

    private RestCountriesAPI createRestCountriesAPIInOtherWithDistance(Country expectedCountry, int distance) {
        return new RestCountriesAPI() {
            @Override
            public boolean isInCommonMarket(Country country) {
                assertEquals(expectedCountry, country);
                return false;
            }

            @Override
            public boolean isInAmericas(Country country) {
                assertEquals(expectedCountry, country);
                return false;
            }

            @Override
            public int distanceTo(Country country) {
                assertEquals(expectedCountry, country);
                return distance;
            }
        };
    }

    private ShippingCost createShippingCostForTest(RestCountriesAPI restCountriesAPIStub) {
        return new ShippingCost() {
            @Override
            protected RestCountriesAPI getRestCountriesAPI() {
                return restCountriesAPIStub;
            }
        };
    }
}
