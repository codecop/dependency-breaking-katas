export class MarketingCampaign {

    public isActive(): boolean {
        let now: Date = new Date();
        return now.getMilliseconds() % 2 == 0;
    }

    public isCrazySalesDay(): boolean {
        let now: Date = new Date();
        return now.getDay() === 5;
    }

}
