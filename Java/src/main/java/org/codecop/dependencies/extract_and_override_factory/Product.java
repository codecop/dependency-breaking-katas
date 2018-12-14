package org.codecop.dependencies.extract_and_override_factory;

public class Product {

    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name();
    }
}
