export class MarketingCampaign {

    public isActive(): boolean {
        return new Date().getMilliseconds() % 2 == 0;
    }

    public isCrazySalesDay(): boolean {
        return new Date().getDay() === 5; // Friday corresponds to day number 5
    }

}
