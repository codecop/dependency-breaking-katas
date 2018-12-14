package org.codecop.dependencies.extract_and_override_factory;

public class OrderCancelledException extends RuntimeException {

    public OrderCancelledException(Product product) {
        super(product.name());
    }

}
