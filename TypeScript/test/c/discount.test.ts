import {Checkout} from "../../app/c/checkout";
import {Money} from "../../app/c/money";


describe('Checkout Test', () => {

    it('test in c', async () => {
        let checkout = new Checkout();

        await checkout.createReceipt(new Money(50.20))
            .then(
                val => console.log(val)
            );
    });

});