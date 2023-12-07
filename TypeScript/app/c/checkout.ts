import { Money } from "./money";
import { Receipt } from "./receipt";
import { ReceiptRepository } from "./receipt-repository";


export class Checkout {

    createReceipt(amount: Money): Promise<Receipt | Error> {
        const receipt: Receipt = new Receipt();
        const vat = amount.percentage(20);

        receipt.amount = amount;
        receipt.tax = vat;
        receipt.total = amount.add(vat);

        return ReceiptRepository.store(receipt).
            then(_ => receipt);
    }
}
