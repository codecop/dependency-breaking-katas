package org.codecop.dependencies.e;

import static org.mockito.Mockito.when;

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

    @Mock
    private UserConfirmation newsletter;

    @Mock
    private UserConfirmation terms;

    @Test(expected = OrderCancelledException.class)
    public void test5() {
        when(terms.isAccepted()).thenReturn(false);

        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock) {
            @Override
            protected UserConfirmation createUserConfirmation(String message) {
                if (message.startsWith("Accept")) {
                    return terms;
                }
                return newsletter;
            }
        };

        checkout.confirmOrder();
    }

}
