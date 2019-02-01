package org.codecop.dependencies.e;

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
