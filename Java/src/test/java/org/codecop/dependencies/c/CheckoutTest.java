package org.codecop.dependencies.c;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CheckoutTest {

    @Test
    public void test3() {
        Checkout checkout = new Checkout();
        checkout.createReceipt(new Money(12));
        assertNotNull(checkout);
    }
}
