package org.codecop.dependencies.extract_and_overide_call;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class CheckoutTest {

    @Test
    public void test3() {
        Checkout checkout = new Checkout();

        Receipt receipt = checkout.createReceipt(new Money(147));

        assertThat(receipt.fomat(), CoreMatchers.hasItem("Item 1 ... 147,00"));
        assertThat(receipt.fomat(), CoreMatchers.hasItem("Tax    ... 29,40"));
        assertThat(receipt.fomat(), CoreMatchers.hasItem("Total  ... 176,40"));
    }
}