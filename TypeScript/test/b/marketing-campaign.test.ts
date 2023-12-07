import { MarketingCampaign } from "../../app/b/marketing-campaign";
import { expect } from "chai";

describe('MarketingCampaign', () => {

    it('test 2', () => {
        const campaign = new MarketingCampaign();

        const isCrazySalesDay: boolean = campaign.isCrazySalesDay();

        expect(isCrazySalesDay).to.be.false;
    });

});
