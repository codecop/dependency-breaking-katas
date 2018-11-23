package org.codecop.dependencies.parameterise_constructor;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DiscountTest {

    @Test
    public void discountFor() {
        final Discount discount = new Discount();

        final Money netPrice = new Money(1002);
        final Money totalPrice = discount.discountFor(netPrice);

        Assert.assertEquals(new Money(new BigDecimal("901")), totalPrice);
    }


}