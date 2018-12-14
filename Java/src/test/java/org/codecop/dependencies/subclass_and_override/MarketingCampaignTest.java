package org.codecop.dependencies.subclass_and_override;

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

/*
1. run tests -> red or green
2. falls red -> was ist das Problem
3. ich sehe es nicht weil kein gescheites Assert
   3.1. change assert to equals oder assertThat mit message "CrazySalesDay"
4. test anpassen?
   green
   run with coverage -> 1 von 4 branches grün.
5. add more test cases
   egal was wir machen, es ist immer today (Freitag)
   5.1. override dayOfWeek() and millis()
        (viel weniger invasiv)
   5.2. Timer interface auslagern mit 2 Methoden
        (mehr Arbeit - mehr Risiko, dafür SOLID)
        TODO wie kann man den Code so machen, dass er rausziehen will
        - Versprechen von Reuse
        - Zwang von Austauschbarkeit (OCP) -> Strategy
        - sichtbar nicht cohesive (SRP)
        - ist kompliziert und passt nicht zum Rest
        - Kopplung/LoD -> Middle Man
   5.3. power mock (stub LocalDate, stub System)

6. modify code via 5.1, only automatic, minimal code change in production?
   same test, make protected, anonymous subclass. fertig.
   widen access ist immer technisch OK.

7. cleanup test cases
   factory method
   names
   assertions
*/