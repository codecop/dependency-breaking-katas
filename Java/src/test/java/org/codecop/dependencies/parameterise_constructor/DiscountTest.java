package org.codecop.dependencies.parameterise_constructor;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DiscountTest {

    @Test
    public void test1() {
        final Discount discount = new Discount();

        final Money net = new Money(1002);
        final Money total = discount.discountFor(net);

        Assert.assertEquals(new Money(new BigDecimal("901.8")), total);
    }

}
