package org.codecop.dependencies.e;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private UserConfirmation subscribeEmail;
    @Mock
    private UserConfirmation acceptTerms;
    @Mock
    private EmailService emailServiceMock;

    private Product aProduct = new Product("Polka-dot Socks");

    @Test(expected = OrderCancelledException.class)
    public void termsNotAccepted() {
        when(acceptTerms.isAccepted()).thenReturn(false);
        Checkout checkout = createCheckoutWithMockedUi(aProduct);

        checkout.confirmOrder();
    }

    @Test
    public void termsAcceptedNoEmailsSubscribed() {
        when(subscribeEmail.isAccepted()).thenReturn(false);
        when(acceptTerms.isAccepted()).thenReturn(true);
        Checkout checkout = createCheckoutWithMockedUi(aProduct);

        checkout.confirmOrder();

        verify(emailServiceMock, never()).subscribeUserFor(aProduct);
    }

    @Test
    public void termsAcceptedEmailSubscribed() {
        when(subscribeEmail.isAccepted()).thenReturn(true);
        when(acceptTerms.isAccepted()).thenReturn(true);
        Checkout checkout = createCheckoutWithMockedUi(aProduct);

        checkout.confirmOrder();

        verify(emailServiceMock, times(1)).subscribeUserFor(aProduct);
    }

    private Checkout createCheckoutWithMockedUi(Product polkaDotSocks) {
        return new Checkout(polkaDotSocks, emailServiceMock) {

            @Override
            protected UserConfirmation createUserConfirmation(String message) {
                if (message.contains("Subscribe")) {
                    return subscribeEmail;
                } else if (message.contains("terms and conditions")) {
                    return acceptTerms;
                } else {
                    throw new AssertionError("unknown message: " + message);
                }
            }

        };
    }
}
