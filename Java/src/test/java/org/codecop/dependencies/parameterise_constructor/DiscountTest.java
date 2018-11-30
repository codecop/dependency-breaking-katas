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

        Assert.assertEquals(new Money(new BigDecimal("851.7")), total);
    }


}

/*

1. run tests -> red or green
2. falls red -> was ist das Problem
3. ich sehe es nicht weil Money kein toString hat
   3.1. debuggen
        breakpoint, starten, 2x auffalten
        test anpassen? -> 851.7
        green
        run with coverage
   3.2. add toString
        darf ich das mit einer Methode die polymorph aufgerufen wird. eigentlich nicht.
   3.3. matcher für Money

 */