package org.codecop.dependencies.d.restcountries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDescription {

    public Codes codes;

    public String region;

    public Coordinates coordinates;

    public Codes getCodes() {
        return codes;
    }

    public String getRegion() {
        return region;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

}
