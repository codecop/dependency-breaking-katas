export class MarketingCampaign {

    public isActive(): boolean {
        return this.milliseconds() % 2 == 0;
    }

    public isCrazySalesDay(): boolean {
        return this.dayOfWeek() == 5; // Friday
    }

    private milliseconds(): number {
        const now: Date = new Date();
        return now.getMilliseconds();
    }

    private dayOfWeek(): number {
        const date: Date = new Date();
        return date.getDay();
    }
}
