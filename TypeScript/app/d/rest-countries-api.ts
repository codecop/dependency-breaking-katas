import { Country } from "./country";

import fetch from 'node-fetch';

interface RestCountry {
    name: string;
    cca2: string;
    region: string;
    latlng: number[];
}

export class RestCountriesAPI {
    private readonly HOME_BASE: Country = { name: 'AT' };
    private readonly COUNTRY_INFORMATION_SERVICE_URL: string = 'https://restcountries.com/v3.1/all';

    static getCurrent(): RestCountriesAPI {
        return new RestCountriesAPI();
    }

    private constructor() {

    }

    public isInCommonMarket(country: Country) {
        const countryDescription = this.getCountryDescriptionViaRestCall(country);

        return countryDescription.then((c) => c?.region === 'Europe');
    }

    public isInAmericas(country: Country) {
        const countryDescription = this.getCountryDescriptionViaRestCall(country);

        return countryDescription.then((c) => c?.region === 'Americas');
    }

    public distanceTo(country: Country): Promise<number> {
        return Promise.all([
            this.getCountryDescriptionViaRestCall(this.HOME_BASE),
            this.getCountryDescriptionViaRestCall(country)
        ]).then(bothCountries => {
            if (!bothCountries || !bothCountries[0] || !bothCountries[1]) {
                return 0;
            }
            return this.distBetween(bothCountries[0].latlng[0], bothCountries[0].latlng[1], bothCountries[1].latlng[0], bothCountries[1].latlng[1]);
        });
    }

    private distBetween(fromLatitude: number, fromLongitude: number, toLatitude: number, toLongitude: number): number {
        const earthRadius = 6371000; // meters
        const fLat: number = this.toRadians(fromLatitude);
        const toLat: number = this.toRadians(toLatitude);
        const diffLat: number = this.toRadians(toLatitude - fromLatitude);
        const diffLng: number = this.toRadians(toLongitude - fromLongitude);
        const a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2)
            + Math.cos(fLat) * Math.cos(toLat) * Math.sin(diffLng / 2) * Math.sin(diffLng / 2);
        const c: number = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        const dist: number = (earthRadius * c);
        return Math.floor(dist);
    }

    private toRadians(value: number): number {
        return value * Math.PI / 180;
    }

    private async getCountryDescriptionViaRestCall(country: Country): Promise<RestCountry | null> {
        const countryDescriptions: RestCountry[] = await this.slowHttpCall();

        for (let i = 0; i < countryDescriptions.length; i++) {
            if (countryDescriptions[i].cca2 === country.name) {
                return countryDescriptions[i];
            }
        }

        return null;
    }

    private async slowHttpCall(): Promise<RestCountry[]> {
        const sleep = (ms: number) => new Promise((resolve) => setTimeout(resolve, ms));
        await sleep(1000); // Sleep for 1 second
        const response = await fetch(this.COUNTRY_INFORMATION_SERVICE_URL);
        const countryDescriptions = JSON.parse(await response.text());
        return countryDescriptions;
    }
}
