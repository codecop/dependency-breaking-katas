<?php

namespace Org\Codecop\Dependencies\D;

use Unirest\Request;

class RestCountriesAPI {

    private const HOME_BASE = 'AT';
    private const COUNTRY_INFORMATION_SERVICE_URL = 'https://api.restcountries.com/countries/v5?pretty=1&limit=100';

    private static $instance;

    public static function getInstance() {
        if (!isset(self::$instance)) {
            self::$instance = new RestCountriesAPI();
        }
        return self::$instance;
    }

    public function isInCommonMarket(Country $country): bool {
        $countryDescription = $this->getCountryDescriptionViaRestCall($country);
        return $countryDescription !== null && $countryDescription->region === 'Europe';
    }

    public function isInAmericas(Country $country): bool {
        $countryDescription = $this->getCountryDescriptionViaRestCall($country);
        return $countryDescription !== null && $countryDescription->region === 'Americas';
    }

    public function distanceTo(Country $country): int {
        $austria = $this->getCountryDescriptionViaRestCall(new Country(self::HOME_BASE));
        $other = $this->getCountryDescriptionViaRestCall($country);

        if ($austria === null || $other === null) {
            throw new RestCountriesAPIException('Could not find country ' . self::HOME_BASE . ' or ' . $country);
        }

        return $this->distBetween(
            $austria->coordinates->lat, $austria->coordinates->lng,
            $other->coordinates->lat, $other->coordinates->lng,
        );
    }

    private function distBetween(float $fromLatitude, float $fromLongitude, float $toLatitude, float $toLongitude): int {
        $earthRadius = 6371000; // meters
        $fLat = deg2rad($fromLatitude);
        $toLat = deg2rad($toLatitude);
        $diffLat = deg2rad($toLatitude - $fromLatitude);
        $diffLng = deg2rad($toLongitude - $fromLongitude);
        $a = sin($diffLat / 2) * sin($diffLat / 2)
            + cos($fLat) * cos($toLat) * sin($diffLng / 2) * sin($diffLng / 2);
        $c = 2 * atan2(sqrt($a), sqrt(1 - $a));
        $dist = $earthRadius * $c;
        return (int) $dist;
    }

    private function getCountryDescriptionViaRestCall(Country $country) {
        $countryDescriptions = $this->slowHttpCall();
        foreach ($countryDescriptions as $c) {
            if ($c->codes->alpha_2 === $country->__toString()) {
                return $c;
            }
        }
        return null;
    }

    public function slowHttpCall(): array {
        $countryDescriptions = [];

        try {
            for ($offset = 0; $offset < 300; $offset += 100) {
                usleep(300000); // Sleep for 1 second (in microseconds)
                $headers = [
                    'accept'  => 'application/json',
                    'Authorization' => 'Bearer ' . getenv('RESTCOUNTRIES_API_KEY')
                ];
                $response = Request::get(self::COUNTRY_INFORMATION_SERVICE_URL . "&offset=" . $offset, $headers);
                $jsonBody = json_decode($response->raw_body);
                $countryDescriptions = array_merge($countryDescriptions, $jsonBody->data->objects);
            }

        } catch (\Exception $e) {
            throw new RestCountriesAPIException('Could not read country information from ' . self::COUNTRY_INFORMATION_SERVICE_URL, 0, $e);
        }

        return $countryDescriptions;
    }

}
