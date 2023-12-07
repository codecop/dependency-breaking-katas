export class Money {

    public static readonly ONE_THOUSAND: Money = new Money(1000);
    public static readonly ONE_HUNDRED: Money = new Money(100);

    value: number;

    constructor(value: number | string) {
        if (typeof value === 'string') {
            this.value = Number.parseFloat(value);
        } else {
            this.value = value;
        }
    }

    reduceBy(p: number): Money {
        return new Money((this.value * (100 - p) / 100).toFixed(2));
    }

    moreThan(other: Money): boolean {
        return this.value > other.value;
    }

}
