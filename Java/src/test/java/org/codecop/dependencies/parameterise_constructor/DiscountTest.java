package org.codecop.dependencies.parameterise_constructor;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DiscountTest {

    @Test
    public void discountFor() {
        final Discount discount = new Discount();

        final Money money = discount.discountFor(new Money(new BigDecimal(1002)));

        Assert.assertEquals(new Money(new BigDecimal(901)), money);
    }


}