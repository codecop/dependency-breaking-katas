import { Discount } from "../../app/a/discount";
import { Money } from "../../app/a/money";
import { expect } from "chai";

describe('Discount', () => {

    it('test 1', () => {
        const discount = new Discount();

        const net = new Money(1002);
        const total = discount.discountFor(net);

        expect(total.value).to.be.equal(901.8);
    });

});
