package org.codecop.dependencies.d.restcountries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Codes {
    public String alpha_2;
}
