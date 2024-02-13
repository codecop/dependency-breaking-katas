package org.codecop.dependencies.a;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

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

    @Test
    public void moreThanOneThousandMocked() {
        MarketingCampaign marketingCampaign = mock(MarketingCampaign.class);
        // when(marketingCampaign.isCrazySalesDay()).thenReturn(true);
        Discount discount = new Discount(marketingCampaign);

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

    @Test
    public void crazySalesDayMocked() {
        MarketingCampaign marketingCampaign = mock(MarketingCampaign.class);
        when(marketingCampaign.isCrazySalesDay()).thenReturn(true);
        Discount discount = new Discount(marketingCampaign);

        Money net = new Money(100);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("85")), total);
    }

}
