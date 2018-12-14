package org.codecop.dependencies.extract_and_override_factory;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private EmailService emailServiceMock;

    @Mock
    private UserConfirmation subscribeEmailMock;
    @Mock
    private UserConfirmation acceptTermsMock;

    @Test(expected = OrderCancelledException.class)
    public void termsNotAccepted() {
        when(acceptTermsMock.isAccepted()).thenReturn(false);

        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock) {
            @Override
            protected UserConfirmation createUserConfirmation(String message) {
                return acceptTermsMock;
            }
        };

        checkout.confirmOrder();
    }

    @Test
    public void termsAcceptedNoEmails() {
        when(subscribeEmailMock.isAccepted()).thenReturn(false);
        when(acceptTermsMock.isAccepted()).thenReturn(true);

        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock) {

            @Override
            protected UserConfirmation createUserConfirmation(String message) {
                if (message.contains("Subscribe")) {
                    return subscribeEmailMock;
                } else {
                    return acceptTermsMock;
                }
            }

        };

        checkout.confirmOrder();
    }

    @Test
    public void termsAcceptedEmailSubscribed() {
        when(subscribeEmailMock.isAccepted()).thenReturn(true);
        when(acceptTermsMock.isAccepted()).thenReturn(true);

        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock) {

            @Override
            protected UserConfirmation createUserConfirmation(String message) {
                if (message.contains("Subscribe")) {
                    return subscribeEmailMock;
                } else {
                    return acceptTermsMock;
                }
            }

        };

        checkout.confirmOrder();

        verify(emailServiceMock, times(1)).subscribeUserFor(polkaDotSocks);
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

 */