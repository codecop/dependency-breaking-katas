package org.codecop.dependencies.d;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ShippingCostTest {

    @Test
    public void inEuropeanUnion() {
        RestCountriesAPI restCountriesAPI = mock(RestCountriesAPI.class);
        when(restCountriesAPI.isInCommonMarket(any(Country.class))).thenReturn(true);
        ShippingCost shippingCost = new ShippingCost() {
            @Override
            protected RestCountriesAPI getRestApiInstance() {
                return restCountriesAPI;
            }
        };

        Money cost = shippingCost.calculate(new Country("AT"), DeliveryOptions.STANDARD);

        assertEquals(new Money(5), cost);
        // 0 seconds :-(
    }
}
