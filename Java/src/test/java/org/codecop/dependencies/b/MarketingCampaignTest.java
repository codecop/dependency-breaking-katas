package org.codecop.dependencies.b;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MarketingCampaignTest {

    @Test
    public void test2() {
        Astrologer_ campaign = new Astrologer_();

        boolean isCrazySalesDay = campaign.isMyLuckyDay();

        assertFalse(isCrazySalesDay);
    }
}
