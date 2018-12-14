package org.codecop.dependencies.extract_and_override_factory;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CheckoutTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private EmailService emailServiceMock;

    @Test(expected = OrderCancelledException.class)
    public void test5() {
        System.out.println("(note for tester) Do not Accept Terms");

        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock);

        checkout.confirmOrder();
    }

}
