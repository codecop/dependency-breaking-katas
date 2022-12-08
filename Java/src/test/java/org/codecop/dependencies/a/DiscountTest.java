package org.codecop.dependencies.a;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountTest {



    @Test
    public void reduce10IfNetPriceOver1000() {
        Discount discount = new Discount(new MarketingCampaign());
        Money net = new Money(1002);

        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

    @Test
    public void discount15ForCrazySaleDay() {
        MarketingCampaign marketingCampaign = mock(MarketingCampaign.class);
        when(marketingCampaign.isCrazySalesDay()).thenReturn(true);

        Discount discount = new Discount(marketingCampaign);
        Money money = discount.discountFor(Money.ONE_HUNDRED);

        assertEquals(new Money(new BigDecimal("85")), money);
    }

}
