package org.codecop.dependencies.d;

public class RestCountriesAPIException extends RuntimeException {

    private static final long serialVersionUID = -7774153411692345736L;

    public RestCountriesAPIException(String message) {
        super(message);
    }

    public RestCountriesAPIException(String message, Throwable cause) {
        super(message, cause);
    }

}
