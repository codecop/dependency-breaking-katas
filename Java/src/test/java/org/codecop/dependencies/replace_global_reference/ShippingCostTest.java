package org.codecop.dependencies.replace_global_reference;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShippingCostTest {

    @Test
    public void europeShipsAtCostOf5() {
        ShippingCost shippingCost = new ShippingCost();

        Money cost = shippingCost.calculate(new Country("DE"), DeliveryOptions.STANDARD);

        assertEquals(new Money(5), cost);
    }
}

/*
  1. test for EU (e.g. DE)
  2. see it red or green

 */