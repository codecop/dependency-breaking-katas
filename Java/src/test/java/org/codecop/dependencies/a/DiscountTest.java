package org.codecop.dependencies.a;

import java.math.BigDecimal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    @Test
    public void moreThanOneThousand() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }
        });

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

    @Test
    public void crazySalesDay() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return true;
            }
        });

        Money net = new Money(100);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("85")), total);
    }

}
