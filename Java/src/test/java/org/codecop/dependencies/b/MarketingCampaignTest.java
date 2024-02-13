package org.codecop.dependencies.b;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;

public class MarketingCampaignTest {

    @Test
    public void tuesdayIsNotCrazySales() {
        MarketingCampaign campaign = new MarketingCampaign() {
            @Override
            protected DayOfWeek dayOfWeek() {
                return DayOfWeek.TUESDAY;
            }
        };

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }

    @Test
    public void fridayIsCrazySales() {
        MarketingCampaign campaign = new MarketingCampaign() {
            @Override
            protected DayOfWeek dayOfWeek() {
                return DayOfWeek.FRIDAY;
            }
        };
        
        boolean isCrazySalesDay = campaign.isCrazySalesDay();
        
        assertTrue(isCrazySalesDay);
    }
}
