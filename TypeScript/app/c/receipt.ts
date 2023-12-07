import {Money} from "./money";

export class Receipt {
    constructor(public amount: Money, public tax: Money, public total:Money) {
        this.amount = Money.ZERO;
        this.tax = Money.ZERO;
    }
}
