import {Country} from "./country";

import fetch from 'node-fetch';

interface RestRegionalBlocs {
    acronym?: string;
    name: string;
}

interface RestCountry {
    name: string;
    alpha2Code: string;
    region: string;
    latlng: number[];
    regionalBlocs?: RestRegionalBlocs[];
}

export class RestCountriesAPI {
    readonly HOME_BASE: Country = {name: 'AT'};
    readonly apiURL: string = 'https://restcountries.com/v3.1/all';

    static getCurrent(): RestCountriesAPI {
        return new RestCountriesAPI();
    }

    private constructor() {

    }

    public isInCommonMarket(country: Country) {
        let countryDescription = this.getCountry(country);

        return countryDescription.then((c) =>
            c?.regionalBlocs?.filter(b => b.acronym === 'EU').length === 1
        );
    }

    public isInAmericas(country: Country) {
        let countryDescription = this.getCountry(country);

        return countryDescription.then((c) => c?.region === 'Americas');
    }

    public distanceTo(country: Country) {
        return Promise.all([
            this.getCountry(this.HOME_BASE),
            this.getCountry(country)
        ]).then(bothCountries => {
            if (!bothCountries || !bothCountries[0] || !bothCountries[1]) {
                return 0;
            }
            return (this.distBetween(bothCountries[0].latlng[0], bothCountries[0].latlng[1], bothCountries[1].latlng[0], bothCountries[1].latlng[1])/1000).toFixed(0);
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
        return dist;
    }

    private toRadians(value: number): number {
        return value * Math.PI / 180;
    }

    private async getCountry(country: Country): Promise<RestCountry | undefined> {
        let data = await this.getAllCountries();

        let countries: RestCountry[] = JSON.parse(data);

        return countries.filter(c => c.alpha2Code === country.name).at(0);
    }

    private async getAllCountries(): Promise<string> {
        const sleep = (ms: number) => new Promise((resolve) => setTimeout(resolve, ms));

        try {
            await sleep(4000);
            let res = await fetch(this.apiURL);
            return await res.text();
        } catch (error) {
            console.log(error);
        }
        return "";
    }
}
