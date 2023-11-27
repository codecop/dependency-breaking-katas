package org.codecop.dependencies.c;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CheckoutTest {

    @Test
    public void test3() {
        Оплата_ checkout = new Оплата_();
        
        checkout.coldWarOperation(new Деньги(12));
        
        assertNotNull(checkout);
    }
}
