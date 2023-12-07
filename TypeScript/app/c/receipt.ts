import { Money } from "./money";

export class Receipt {

    amount: Money;
    tax: Money;
    total: Money

    format(): string[] {
        return [ //
            "Receipt", //
            "=======", //
            "Item 1 ... " + this.amount.format(), //
            "Tax    ... " + this.tax.format(), //
            "----------------", //
            "Total  ... " + this.total.format() //
        ];
    }

}
