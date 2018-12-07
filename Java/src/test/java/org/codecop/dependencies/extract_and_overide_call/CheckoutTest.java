package org.codecop.dependencies.extract_and_overide_call;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CheckoutTest {

    @Test
    public void test3() {
        Checkout checkout = new Checkout() {
            @Override
            protected void store(Receipt receipt) {
            }
        };

        Receipt receipt = checkout.createReceipt(new Money(147));

        assertThat(receipt.fomat(), CoreMatchers.hasItem("Item 1 ... 147,00"));
        assertThat(receipt.fomat(), CoreMatchers.hasItem("Tax    ... 29,40"));
        assertThat(receipt.fomat(), CoreMatchers.hasItem("Total  ... 176,40"));
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
   4.1 Globale Debug Klasse mit statischen Flag
   4.2 System Property "unit-test" flag.
   4.3 Extract and Override
   4.4 Powermock
   4.5 Wrap Singleton in neue Klasse, übergebe an Checkout
       aus 4.3 als followup extact class und danach interface für Wrapper
   4.6 HSQLDB setup (keine Schemata)

*/
