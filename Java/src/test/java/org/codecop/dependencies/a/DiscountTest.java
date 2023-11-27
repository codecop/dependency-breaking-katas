package org.codecop.dependencies.a;

import java.math.BigDecimal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    @Test
    public void test1() {
        Скидка_ discount = new Скидка_();

        Деньги net = new Деньги(1002);
        Деньги total = discount.скидкаДля(net);

        assertEquals(new Деньги(new BigDecimal("901.8")), total);
    }

}
