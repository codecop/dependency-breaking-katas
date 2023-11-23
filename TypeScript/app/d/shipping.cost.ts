import {Money} from "./money";
import {Country} from "./country";
import {RestCountriesAPI} from "./rest-countries-api";

export enum DeliveryOptions {
    Standard,
    Express
}

export class ShippingCost {

    public async calculate(destination: Country, options: DeliveryOptions): Promise<Money> {
        let cost: Money;

        if (await RestCountriesAPI.getCurrent().isInCommonMarket(destination)) {
            // flat rate in EU
            return new Money(5);
        } else if (await RestCountriesAPI.getCurrent().isInAmericas(destination)) {
            // US & Canada & South American
            if (options === DeliveryOptions.Express) {
                cost = new Money(40);
            } else {
                cost = new Money(15);
            }
            return cost;
        } else {
            // other countries, e.g. Asia
            const km = await RestCountriesAPI.getCurrent().distanceTo(destination);
            return new Money(km).percentage(10);
        }
        // flat rate in EU
        return new Money(5);
    }
}
