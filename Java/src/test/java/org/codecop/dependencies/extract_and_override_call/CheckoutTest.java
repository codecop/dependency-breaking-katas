package org.codecop.dependencies.extract_and_override_call;

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