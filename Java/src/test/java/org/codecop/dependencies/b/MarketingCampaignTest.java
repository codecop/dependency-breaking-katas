package org.codecop.dependencies.b;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MarketingCampaignTest {

    @Test
    public void test2() {
        MarketingCampaign campaign = new MarketingCampaign();

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }
}
