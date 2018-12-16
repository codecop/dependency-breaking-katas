package org.codecop.dependencies.extract_and_override_factory;

public class OrderCancelledException extends RuntimeException {

    private static final long serialVersionUID = 9042143130337520025L;

    public OrderCancelledException(Product product) {
        super(product.name());
    }

}
