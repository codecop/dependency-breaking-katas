package org.codecop.dependencies.c;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class CheckoutTest {

    @Test
    public void createsReceipt() {
        Checkout checkout = new Checkout() {
            @Override
            protected void store(Receipt receipt) {
            }
        };

        Receipt receipt = checkout.createReceipt(new Money(12));

        assertEquals(new BigDecimal(12), receipt.getAmount().asBigDecimal());
    }
}
