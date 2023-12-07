import {Discount} from "../../app/a/discount";
import {Money} from "../../app/a/money";
import {expect} from "chai";

describe('Discount Test', () => {

    it('test in a', () => {
        let discount = new Discount();

        let net = new Money(1002);
        let total = discount.discountFor(net);

        expect(total.value).to.be.equal(901.8);
    });

});