package org.codecop.dependencies.replace_global_reference;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.codecop.dependencies.replace_global_reference.restcountries.CountryDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RestCountriesAPI {

    private static final Country HOME_BASE = new Country("AT");
    private static final String COUNTRY_INFORMATION_SERVICE_URL = "https://restcountries.eu/rest/v2/all";

    private static final RestCountriesAPI instance = new RestCountriesAPI();

    private final ObjectMapper objectMapper;

    public RestCountriesAPI() {
        this.objectMapper = new ObjectMapper();
    }

    public static RestCountriesAPI getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(new Country("US"));
        System.out.println(getInstance().isInAmericas(new Country("US")));
        System.out.println(getInstance().isInCommonMarket(new Country("US")));
        System.out.println(getInstance().distanceTo(new Country("US")));
        System.out.println(new Country("AT"));
        System.out.println(getInstance().isInAmericas(new Country("AT")));
        System.out.println(getInstance().isInCommonMarket(new Country("AT")));
        System.out.println(getInstance().distanceTo(new Country("AT")));
    }

    public boolean isInCommonMarket(Country country) {
        final Optional<CountryDescription> countryDescription = getCountryDescriptionViaRestCall(country);

        if (!countryDescription.isPresent()) {
            return false;
        }

        final List<Object> regionalBlocs = countryDescription.get().getRegionalBlocs();
        if (regionalBlocs.isEmpty()) {
            return false;
        }

        final Map<String, String> bloc = (Map<String, String>) regionalBlocs.get(0);
        return bloc.get("acronym") != null && bloc.get("acronym").equals("EU");
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

    private int distBetween(Double fromLatitude, Double fromLongitude, Double toLatitude, Double toLongitude) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(toLatitude - fromLatitude);
        double dLng = Math.toRadians(toLongitude - fromLongitude);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(fromLatitude)) * Math.cos(Math.toRadians(toLatitude)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        float dist = (float) (earthRadius * c);

        return (int) dist;
    }

    private Optional<CountryDescription> getCountryDescriptionViaRestCall(Country country) {
        return slowHttpCall().stream()
                .filter(c -> c.getAlpha2Code().equals(country.toString()))
                .findFirst();
    }

    public List<CountryDescription> slowHttpCall() {
        final List<CountryDescription> countryDescriptions = new ArrayList<>();

        try {
            Thread.sleep(1000);
            HttpResponse<JsonNode> jsonResponse = Unirest.get(COUNTRY_INFORMATION_SERVICE_URL)
                    .header("accept", "application/json")
                    .asJson();

            countryDescriptions.addAll(objectMapper.readValue(jsonResponse.getBody().toString(),
                    new TypeReference<List<CountryDescription>>() {
                    }));

        } catch (Exception e) {
            throw new RestCountriesAPIException("Could not read country information from " + COUNTRY_INFORMATION_SERVICE_URL, e);
        }

        return countryDescriptions;
    }

}
