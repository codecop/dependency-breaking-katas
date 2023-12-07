import { RestCountriesAPI } from "../../app/d/rest-countries-api";
import { expect } from "chai";

describe('RestCountriesAPITest', () => {

    it('isInAmericas', async () => {
        return RestCountriesAPI.getCurrent().isInAmericas({ name: 'US' })
            .then(val => expect(val).to.be.true);
    });

    it('not isInCommonMarket', async () => {
        return RestCountriesAPI.getCurrent().isInCommonMarket({ name: 'US' })
            .then(val => expect(val).to.be.false);
    });

    it('distanceTo', async () => {
        return RestCountriesAPI.getCurrent().distanceTo({ name: 'US' })
            .then(val => expect(val).to.equal(8284767));
    });

    it('not isInAmericas', async () => {
        return RestCountriesAPI.getCurrent().isInAmericas({ name: 'AT' })
            .then(val => expect(val).to.be.false);
    });

    it('isInCommonMarket', async () => {
        return RestCountriesAPI.getCurrent().isInCommonMarket({ name: 'AT' })
            .then(val => expect(val).to.be.true);
    });

    it('no distanceTo', async () => {
        return RestCountriesAPI.getCurrent().distanceTo({ name: 'AT' })
            .then(val => expect(val).to.equal(0));
    });

});
