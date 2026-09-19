package org.codecop.dependencies.d.restcountries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Root {

    @JsonIgnoreProperties({"meta"})
    public static class Data {
        public List<CountryDescription> objects;
    }

    public Data data;

}
