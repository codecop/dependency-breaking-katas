package org.codecop.dependencies.d.restcountries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDescription {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Codes {
        public String alpha_2;
    }

    public Codes codes;

    @JsonProperty("region")
    private String region;

    public static class Coordinates {
        public Double lat;
        public Double lng;
    }

    public Coordinates coordinates;

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

}
