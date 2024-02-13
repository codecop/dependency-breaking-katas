package org.codecop.dependencies.a;

import java.math.BigDecimal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountTest {

    @Test
    public void discountForMoreThanThousand() {
        MarketingCampaign marketingCampaign = mock(MarketingCampaign.class);
        when(marketingCampaign.isCrazySalesDay()).thenReturn(false);
        Discount discount = new Discount(marketingCampaign);

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

    @Test
    public void discountForCrazySalesDay() {
        MarketingCampaign marketingCampaign = mock(MarketingCampaign.class);
        when(marketingCampaign.isCrazySalesDay()).thenReturn(true);
        Discount discount = new Discount(marketingCampaign);
        
        Money net = new Money(100);
        Money total = discount.discountFor(net);
        
        assertEquals(new Money(85), total);
    }

}
