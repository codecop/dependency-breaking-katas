export class Money {

    public static readonly ZERO: Money = new Money(0);
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

     add(other: Money): Money {
        return new Money(this.value + other.value);
    }

     percentage(p: number): Money {
        return new Money((this.value * p / 100).toFixed(2));
    }

     moreThan(other: Money): boolean {
        return this.value > other.value;
    }

     format(): string {
        return this.value.toFixed(2);
    }


}
