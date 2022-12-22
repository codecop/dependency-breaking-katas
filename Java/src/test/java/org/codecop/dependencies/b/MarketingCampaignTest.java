package org.codecop.dependencies.b;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MarketingCampaignTest {

    @Test
    public void fridayIsCrazySaleDay() {
        MarketingCampaign campaign = new MarketingCampaign(() -> LocalDateTime.now().getDayOfWeek(), () -> System.currentTimeMillis()) {
            @Override
            protected DayOfWeek dayOfWeek() {
                return DayOfWeek.FRIDAY;
            }
        };

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertTrue(isCrazySalesDay);
    }

    @Test
    public void saturdayIsNotCrazySaleDay() {
        MarketingCampaign campaign = new MarketingCampaign(() -> DayOfWeek.SATURDAY, () -> System.currentTimeMillis());

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }
        @Test
    public void isActiveForEvenMs() {

        MarketingCampaign campaign = new MarketingCampaign(() -> LocalDateTime.now().getDayOfWeek(), () -> Long.valueOf(8) );


        boolean isActive = campaign.isActive();

        assertTrue(isActive);
    }
}
