import {Money} from "./money";
import {Receipt} from "./receipt";
import {ReceiptRepository} from "./receipt-repository";


export class Checkout {

    createReceipt(netAmount: Money): Promise<Error | boolean> {
        let tax = netAmount.percentage(20);
        let total = netAmount.add(tax);
        let receipt: Receipt = new Receipt(netAmount, tax, total);

        return ReceiptRepository.store(receipt);
    }
}