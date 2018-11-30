package org.codecop.dependencies.subclass_and_override;

import org.junit.Test;

import static org.junit.Assert.*;

public class MarketingCampaignTest {

    @Test
    public void test2() {
        MarketingCampaign campaign = new MarketingCampaign();

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }
}
