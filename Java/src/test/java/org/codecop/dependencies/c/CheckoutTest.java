package org.codecop.dependencies.c;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckoutTest {

    @Test
    public void createReceipt() {
        Checkout checkout = new Checkout() {
            @Override
            protected void store(Receipt receipt) {
            }
        };

        Receipt receipt = checkout.createReceipt(new Money(12));

        assertEquals(new Money("14.4"), receipt.getTotal());
    }
}
