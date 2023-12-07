import {MarketingCampaign} from "../../app/b/marketing-campaign";
import {expect} from "chai";

describe('MarketingCampaign Test', () => {

    it('test in b', () => {
        let campaign = new MarketingCampaign();

        let isCrazySalesDay: boolean = campaign.isCrazySalesDay();

        expect(isCrazySalesDay).to.be.false;
    });

});