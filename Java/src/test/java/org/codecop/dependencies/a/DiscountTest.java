package org.codecop.dependencies.a;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class DiscountTest {

    @Test
    public void forAmmountOneThousand() {
        MarketingCampaign marketingCampaign = mock(MarketingCampaign.class);
        Discount discount = new Discount(marketingCampaign);

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money("901.8"), total);
    }

    @Test
    public void forCrazySalesDay() {
        MarketingCampaign marketingCampaign = mock(MarketingCampaign.class);
        when(marketingCampaign.isCrazySalesDay()).thenReturn(true);
        Discount discount = new Discount(marketingCampaign);
        
        Money net = new Money(100);
        Money total = discount.discountFor(net);
        
        assertEquals(new Money(85), total);
    }

}
