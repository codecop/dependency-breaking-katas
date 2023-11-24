import {RestCountriesAPI} from "../../app/d/rest-countries-api";
import {DeliveryOptions, ShippingCost} from "../../app/d/shipping.cost";

describe('ShippingCost Test', () => {

    it('test isInAmericas', () => {
        return RestCountriesAPI.getCurrent().isInAmericas({name: 'US'})
            .then(val => console.log(val));
    });

    it('test isInCommonMarket', () => {
        return RestCountriesAPI.getCurrent().isInCommonMarket({name: 'AT'})
            .then(val => console.log(val));
    });

    it('test distanceTo', () => {
        return RestCountriesAPI.getCurrent().distanceTo({name: 'US'})
            .then(val => console.log(val));
    });

    it('test ShippingCost', () => {
        let shippingCost = new ShippingCost();

        return shippingCost.calculate({name: 'US'}, DeliveryOptions.Express)
            .then(val => console.log(val));
    });

});