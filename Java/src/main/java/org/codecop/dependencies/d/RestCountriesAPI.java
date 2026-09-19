package org.codecop.dependencies.d;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.codecop.dependencies.d.restcountries.CountryDescription;
import org.codecop.dependencies.d.restcountries.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestCountriesAPI {

    private static final Country HOME_BASE = new Country("AT");
    private static final String COUNTRY_INFORMATION_SERVICE_URL = "https://api.restcountries.com/countries/v5?pretty=1&limit=100";

    private static final RestCountriesAPI instance = new RestCountriesAPI();

    private final ObjectMapper objectMapper;

    private RestCountriesAPI() {
        this.objectMapper = new ObjectMapper();
    }

    public static RestCountriesAPI getInstance() {
        return instance;
    }

    public boolean isInCommonMarket(Country country) {
        final Optional<CountryDescription> countryDescription = getCountryDescriptionViaRestCall(country);
        return countryDescription.map(description -> description.getRegion().equals("Europe")).orElse(false);
    }

    public boolean isInAmericas(Country country) {
        final Optional<CountryDescription> countryDescription = getCountryDescriptionViaRestCall(country);
        return countryDescription.map(description -> description.getRegion().equals("Americas")).orElse(false);
    }

    public int distanceTo(Country country) {
        final Optional<CountryDescription> austria = getCountryDescriptionViaRestCall(HOME_BASE);
        final Optional<CountryDescription> other = getCountryDescriptionViaRestCall(country);

        if (!austria.isPresent() || !other.isPresent()) {
            throw new RestCountriesAPIException("Could not find country " + HOME_BASE + " or " + country);
        }

        return distBetween(austria.get().getCoordinates(), other.get().getCoordinates());
    }

    private int distBetween(CountryDescription.Coordinates fromCoordinates, CountryDescription.Coordinates toCoordinates) {
        return distBetween(fromCoordinates.lat, fromCoordinates.lng, toCoordinates.lat, toCoordinates.lng);
    }

    private int distBetween(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude) {
        double earthRadius = 6371000; // meters
        double fLat = Math.toRadians(fromLatitude);
        double toLat = Math.toRadians(toLatitude);
        double diffLat = Math.toRadians(toLatitude - fromLatitude);
        double diffLng = Math.toRadians(toLongitude - fromLongitude);
        double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2) + Math.cos(fLat) * Math.cos(toLat) * Math.sin(diffLng / 2) * Math.sin(diffLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        float dist = (float) (earthRadius * c);
        return (int) dist;
    }

    private Optional<CountryDescription> getCountryDescriptionViaRestCall(Country country) {
        return slowHttpCall().stream().filter(c -> c.codes.alpha_2.equals(country.toString())).findFirst();
    }

    public List<CountryDescription> slowHttpCall() {
        final List<CountryDescription> countryDescriptions = new ArrayList<>();

        try {
            for (int offset = 0; offset < 300; offset += 100) {
                Thread.sleep(300);
                HttpResponse<JsonNode> jsonResponse = Unirest. //
                        get(COUNTRY_INFORMATION_SERVICE_URL + "&offset=" + offset). //
                        header("accept", "application/json"). //
                        header("Authorization", "Bearer " + System.getenv("RESTCOUNTRIES_API_KEY")). //
                        asJson();

                String body = jsonResponse.getBody().toString();
                TypeReference<Root> typeRef = new TypeReference<Root>() {
                };
                Root root = objectMapper.readValue(body, typeRef);
                countryDescriptions.addAll(root.data.objects);
            }

        } catch (Exception e) {
            throw new RestCountriesAPIException("Could not read country information from " + COUNTRY_INFORMATION_SERVICE_URL, e);
        }

        return countryDescriptions;
    }

}
