package org.codecop.dependencies.b

import org.junit.Assert.assertFalse
import org.junit.Test

class MarketingCampaignTest {

    @Test
    fun test2() {
        val campaign = MarketingCampaign()

        val isCrazySalesDay = campaign.isCrazySalesDay()

        assertFalse(isCrazySalesDay)
    }

}