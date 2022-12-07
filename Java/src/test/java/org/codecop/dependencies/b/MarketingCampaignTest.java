package org.codecop.dependencies.b;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MarketingCampaignTest {

    @Test
    public void test2() {
        MarketingCampaign campaign = new MarketingCampaign();

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }
}
