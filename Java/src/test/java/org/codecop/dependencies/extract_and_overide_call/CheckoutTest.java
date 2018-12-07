package org.codecop.dependencies.extract_and_overide_call;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CheckoutTest {

    @Test
    public void receiptContainsPriceTaxAndTotal() {
        Checkout checkout = new Checkout() {
            @Override
            protected void store(@SuppressWarnings("unused") Receipt receipt) {
            }
        };

        Receipt receipt = checkout.createReceipt(new Money(147));

        assertThat(receipt.fomat(), hasItem("Item 1 ... 147,00"));
        assertThat(receipt.fomat(), hasItem("Tax    ... 29,40"));
        assertThat(receipt.fomat(), hasItem("Total  ... 176,40"));
    }

    @Test
    public void receiptIsStored() {
        boolean[] wasCalled = { false };
        Checkout checkout = new Checkout() {
            @Override
            protected void store(Receipt receipt) {
                wasCalled[0] = true;

                assertThat(receipt.fomat(), hasItem("Item 1 ... 147,00"));
                assertThat(receipt.fomat(), hasItem("Tax    ... 29,40"));
                assertThat(receipt.fomat(), hasItem("Total  ... 176,40"));
            }
        };

        checkout.createReceipt(new Money(147));

        assertTrue("receipt not stored", wasCalled[0]);
    }
}

/*

1. add real test into first test method
2. run tests -> red or green
3. falls red -> was ist das Problem
   * debuggen
   * code lesen
   -> finde System.exit()
   vielleicht zu böse, die Gefahr dass Leute es einfach auskommentieren
   TODO write real JDBC code so it is ovious that we need that

4. egal was wir machen, es geht nicht, weil repository crashed.
   4.0 auskommentieren - eigentlich nicht ;-)
   4.1 Extract and Override
   4.2 Globale Debug Klasse mit statischen Flag
   4.3 System Property "unit-test" flag.
   4.4 Powermock
   4.5 Wrap Singleton in neue Klasse, übergebe an Checkout
       aus 4.3 als followup extact class und danach interface für Wrapper
   4.6 HSQLDB setup (keine Schemata)

4.3. einfach machen, 3 Schritte, IDE macht alles

5. add more test cases
   * store was called
*/
