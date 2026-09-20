package org.codecop.dependencies.d.restcountries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"meta"})
public class Data {
    public List<CountryDescription> objects;
}
