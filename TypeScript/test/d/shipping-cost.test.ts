import { ShippingCost } from "../../app/d/shipping.cost";
import { expect } from "chai";

describe('ShippingCost', () => {

    it('test 4', () => {
        const shippingCost = new ShippingCost();

        expect(shippingCost).not.to.be.null;
    });

});
