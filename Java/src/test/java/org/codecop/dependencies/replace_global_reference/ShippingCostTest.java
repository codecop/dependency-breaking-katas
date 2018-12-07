package org.codecop.dependencies.replace_global_reference;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShippingCostTest {

    @Test
    public void europeShipsAtCostOf5() {
        GoogleMapsAPI googleMapsAPIStub = createGoogleMapAPIInEurope(true);
        ShippingCost shippingCost = createShippingCostForTest(googleMapsAPIStub);

        Money cost = shippingCost.calculate(new Country("DE"), DeliveryOptions.STANDARD);

        assertEquals(new Money(5), cost);
    }

    private GoogleMapsAPI createGoogleMapAPIInEurope(boolean isCommonMarket) {
        return new GoogleMapsAPI() {
            @Override
            public boolean isInCommonMarket(Country country) {
                return isCommonMarket;
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
