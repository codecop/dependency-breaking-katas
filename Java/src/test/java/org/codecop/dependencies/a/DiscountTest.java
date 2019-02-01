package org.codecop.dependencies.a;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountTest {

    @Test
    public void higher_discount_for_CrazySalesDay() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return true;
            }
        });
        
        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("851.7")).describe(), total.describe());
    }

    @Test
    public void good_discount_for_huge_purchase() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }
        });

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")).describe(), total.describe());
    }

    @Test
    public void some_discount_for_small_purchase() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }

            @Override
            public boolean isActive() {
                return true;
            }
        });

        Money net = new Money(102);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("96.9")).describe(), total.describe());
    }

    @Test
    public void no_discount_for_small_purchase_when_campaign_not_active() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }

            @Override
            public boolean isActive() {
                return false;
            }
        });

        Money net = new Money(102);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("102")).describe(), total.describe());
    }

    @Test
    public void no_discount_for_usual_day() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }
        });

        Money net = new Money(10);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("10")).describe(), total.describe());
    }

    @Test
    public void no_discount_for_usual_day_mockito() {
        MarketingCampaign campaign = mock(MarketingCampaign.class);
        when(campaign.isCrazySalesDay()).thenReturn(false);
        Discount discount = new Discount(campaign);

        Money net = new Money(10);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("10")).describe(), total.describe());
    }
}
