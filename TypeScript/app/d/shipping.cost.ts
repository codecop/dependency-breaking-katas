import { Money } from "./money";
import { Country } from "./country";
import { RestCountriesAPI } from "./rest-countries-api";

export enum DeliveryOptions {
    Standard,
    Express
}

export class ShippingCost {

    public async calculate(country: Country, options: DeliveryOptions): Promise<Money> {
        let cost: Money;

        if (await RestCountriesAPI.getCurrent().isInCommonMarket(country)) {
            // flat rate in EU
            cost = new Money(5);

        } else if (await RestCountriesAPI.getCurrent().isInAmericas(country)) {
            // US & Canada & South American
            if (options === DeliveryOptions.Express) {
                cost = new Money(40);
            } else {
                cost = new Money(15);
            }

        } else {
            // other countries, e.g. Asia
            const km = await RestCountriesAPI.getCurrent().distanceTo(country);
            cost = new Money(km).percentage(10);
        }

        return cost;
    }
}
