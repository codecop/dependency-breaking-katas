package org.codecop.dependencies.b;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.time.DayOfWeek;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MarketingCampaignTest {

    @Test
    public void FRIDAY_is_crazySalesDay() {
        MarketingCampaign campaign = createCampaignAndTodayIs(DayOfWeek.FRIDAY);

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertThat("crazySalesDay", isCrazySalesDay, CoreMatchers.is(true));
    }

    @Test
    public void not_a_crazySalesDay() {
        MarketingCampaign campaign = createCampaignAndTodayIs(DayOfWeek.MONDAY);

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertEquals("crazySalesDay", false, isCrazySalesDay);
    }

    @Test
    public void active_when_millis_are_even() {
        MarketingCampaign campaign = createCampainAndMillisIs(2);

        assertEquals("active", true, campaign.isActive());
    }

    @Test
    public void inactive_when_millis_are_odd() {
        MarketingCampaign campaign = createCampainAndMillisIs(1);

        assertEquals("active", false, campaign.isActive());
    }

    private MarketingCampaign createCampainAndMillisIs(int millis) {
        return new MarketingCampaign() {
            @Override
            protected long milliSeconds() {
                return millis;
            }
        };
    }

    private MarketingCampaign createCampaignAndTodayIs(DayOfWeek dayOfWeek) {
        return new MarketingCampaign() {
            @Override
            protected DayOfWeek dayOfWeek() {
                return dayOfWeek;
            }
        };
    }
}
