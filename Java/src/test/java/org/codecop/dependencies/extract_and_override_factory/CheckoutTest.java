package org.codecop.dependencies.extract_and_override_factory;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

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

/*
1. run test - UI oui - kein automatisierter test
2. was ist das Problem. was kann ich machen?
   2.1. extract and override factory method
   2.2. PowerMock static JOptionPane.showConfirmDialog
   2.3. Parameterize constructor 2 parameters,
        lose messages out of class
        need lambdas (Supplier) for that because we must not start them earlier
   2.4. AWT Robot kann UI fernsteuern
   2.5. UI Testing Tool in Java?
3. only with tools
   * extract message local variable
   * extract method, replace all
   * inline message
   * make protected
   * use in test
4. add more test
   * variant of one or two factory methods make test easier
   * quite some work figuring out which mock to return for multiple calls of factory
 */