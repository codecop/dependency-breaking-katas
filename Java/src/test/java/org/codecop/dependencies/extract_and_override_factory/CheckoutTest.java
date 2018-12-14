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

    @Mock
    private UserConfirmation acceptTermsMock;

    @Test(expected = OrderCancelledException.class)
    public void test5() {
        System.out.println("(note for tester) Do not Accept Terms");

        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock) {
            @Override
            protected UserConfirmation createUserConfirmation(String message) {
                return acceptTermsMock;
            }
        };

        checkout.confirmOrder();
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
   *
 */