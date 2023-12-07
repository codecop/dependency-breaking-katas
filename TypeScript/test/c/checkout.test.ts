import { Checkout } from "../../app/c/checkout";
import { Money } from "../../app/c/money";
import { expect } from "chai";

describe('Checkout', () => {

    it('test 3', async () => {
        const checkout = new Checkout();

        await checkout.createReceipt(new Money(12.00))
            .then(receipt => expect(checkout).not.to.be.null);
    });

});
