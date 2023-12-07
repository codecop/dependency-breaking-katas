export class Money {

    value: number;

    constructor(value: number | string) {
        if (typeof value === 'string') {
            this.value = Number.parseFloat(value);
        } else {
            this.value = value;
        }
    }

    percentage(p: number): Money {
        return new Money((this.value * p / 100).toFixed(2));
    }

    format(): string {
        return this.value.toFixed(2);
    }


}
