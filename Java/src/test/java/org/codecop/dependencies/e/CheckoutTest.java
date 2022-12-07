package org.codecop.dependencies.e;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutTest {

    @Mock
    private EmailService emailServiceMock;

    @Test
    public void test5() {
        System.out.println("note for tester:");
        System.out.println("* Accept Newsletter");
        System.out.println("* Do not Accept Terms");

        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock);

        assertThrows(OrderCancelledException.class,
                () -> checkout.confirmOrder(),
                "expect confirmOrder to throw exception");
    }

}
