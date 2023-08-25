package org.codecop.dependencies.d;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.codecop.dependencies.d.restcountries.CountryDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestCountriesAPI {

    private static final Country HOME_BASE = new Country("AT");
    private static final String COUNTRY_INFORMATION_SERVICE_URL = "https://restcountries.com/v3.1/all";

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

        return distBetween(austria.get().getLatlng(), other.get().getLatlng());
    }

    private int distBetween(List<Double> fromCoordinates, List<Double> toCoordinates) {
        return distBetween(fromCoordinates.get(0), fromCoordinates.get(1), toCoordinates.get(0), toCoordinates.get(1));
    }

    private int distBetween(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude) {
        double earthRadius = 6371000; // meters
        double fLat = Math.toRadians(fromLatitude);
        double toLat = Math.toRadians(toLatitude);
        double diffLat = Math.toRadians(toLatitude - fromLatitude);
        double diffLng = Math.toRadians(toLongitude - fromLongitude);
        double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2)
                + Math.cos(fLat) * Math.cos(toLat) * Math.sin(diffLng / 2) * Math.sin(diffLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        float dist = (float) (earthRadius * c);
        return (int) dist;
    }

    private Optional<CountryDescription> getCountryDescriptionViaRestCall(Country country) {
        return slowHttpCall().stream().filter(c -> c.getCca2().equals(country.toString())).findFirst();
    }

    public List<CountryDescription> slowHttpCall() {
        final List<CountryDescription> countryDescriptions = new ArrayList<>();

        try {
            Thread.sleep(1000);
            HttpResponse<JsonNode> jsonResponse = Unirest. //
                    get(COUNTRY_INFORMATION_SERVICE_URL). //
                    header("accept", "application/json"). //
                    asJson();

            String body = jsonResponse.getBody().toString();
            TypeReference<List<CountryDescription>> typeRef = new TypeReference<List<CountryDescription>>() { };
            countryDescriptions.addAll(objectMapper.readValue(body, typeRef));

        } catch (Exception e) {
            throw new RestCountriesAPIException("Could not read country information from " + COUNTRY_INFORMATION_SERVICE_URL, e);
        }

        return countryDescriptions;
    }

    public static void main(String[] args) {
        System.out.println("US: " + new Country("US"));
        System.out.println("true: " + getInstance().isInAmericas(new Country("US")));
        System.out.println("false: " + getInstance().isInCommonMarket(new Country("US")));
        System.out.println("8284768: " + getInstance().distanceTo(new Country("US")));
        System.out.println("AT: " + new Country("AT"));
        System.out.println("false: " + getInstance().isInAmericas(new Country("AT")));
        System.out.println("true: " + getInstance().isInCommonMarket(new Country("AT")));
        System.out.println("0:" + getInstance().distanceTo(new Country("AT")));
    }

}
