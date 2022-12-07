package org.codecop.dependencies.c;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckoutTest {

    @Test
    public void test3() {
        Checkout checkout = new Checkout();
        
        checkout.createReceipt(new Money(12));
        
        assertNotNull(checkout);
    }
}
