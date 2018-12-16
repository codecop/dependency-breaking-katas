package org.codecop.dependencies.replace_global_reference;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShippingCostTest {

    @Test
    public void europeShipsAtCostOf5() {
        Country germany = new Country("DE");
        GoogleMapsAPI googleMapsAPIStub = createGoogleMapAPIInEurope(germany);
        ShippingCost shippingCost = createShippingCostForTest(googleMapsAPIStub);

        Money cost = shippingCost.calculate(germany, DeliveryOptions.STANDARD);

        assertEquals(new Money(5), cost);
    }

    @Test
    public void americasShipsAtCostOf15() {
        Country canada = new Country("CA");
        GoogleMapsAPI googleMapsAPIStub = createGoogleMapAPIInAmericas(canada);
        ShippingCost shippingCost = createShippingCostForTest(googleMapsAPIStub);

        Money cost = shippingCost.calculate(canada, DeliveryOptions.STANDARD);

        assertEquals(new Money(15), cost);
    }

    @Test
    public void americasExpressShipsAtCostOf25() {
        Country canada = new Country("CA");
        GoogleMapsAPI googleMapsAPIStub = createGoogleMapAPIInAmericas(canada);
        ShippingCost shippingCost = createShippingCostForTest(googleMapsAPIStub);

        Money cost = shippingCost.calculate(canada, DeliveryOptions.EXPRESS);

        assertEquals(new Money(40), cost);
    }

    @Test
    public void otherShipsAtCostWithDistance() {
        Country egypt = new Country("EG");
        GoogleMapsAPI googleMapsAPIStub = createGoogleMapAPIInOtherWithDistance(egypt, 2380);
        ShippingCost shippingCost = createShippingCostForTest(googleMapsAPIStub);

        Money cost = shippingCost.calculate(egypt, DeliveryOptions.EXPRESS);

        assertEquals(new Money(238), cost);
    }

    private GoogleMapsAPI createGoogleMapAPIInEurope(Country expectedCountry) {
        return new GoogleMapsAPI() {
            @Override
            public boolean isInCommonMarket(Country country) {
                assertEquals(expectedCountry, country);
                return true;
            }
        };
    }

    private GoogleMapsAPI createGoogleMapAPIInAmericas(Country expectedCountry) {
        return new GoogleMapsAPI() {
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

    private GoogleMapsAPI createGoogleMapAPIInOtherWithDistance(Country expectedCountry, int distance) {
        return new GoogleMapsAPI() {
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

    private ShippingCost createShippingCostForTest(GoogleMapsAPI googleMapsAPIStub) {
        return new ShippingCost() {
            @Override
            protected GoogleMapsAPI getGoogleMapsAPI() {
                return googleMapsAPIStub;
            }
        };
    }
}

/*
  1. test for EU (e.g. DE)
  2. see it red or green
     green but very slow - it is the web call
  3. egal was wir machen, es geht nicht, weil slow ist oder crashed.
   3.1 3x Extract and Override
   3.2 Replace Global Data with Getter
   3.3 Powermock
   3.4 Wrap Singleton in neue Klasse, übergebe an Shipping Cost
   3.5 WireMock
   3.6 lokaler HTTP server mit stub Antworten (ganze Antworten recorden)

4. Replace Global Data with Getter
   * Extract Method automatisch auf alle Fälle
   * Make protected
   * anonymous subclass
   * 2nd anonymous subclass
   -> green and fast
   run with coverage -> 3 von 4 branches rot.

5. add more test cases
  * refactor test and improve fixtures

 */
