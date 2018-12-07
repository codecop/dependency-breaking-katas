package org.codecop.dependencies.replace_global_reference;

/**
 * Calls the Google Maps API. Pay attention not to call this 
 * too often in tests as we have to pay per usage.
 */
public class GoogleMapsAPI {

    private static final GoogleMapsAPI instance = new GoogleMapsAPI();

    public static GoogleMapsAPI getInstance() {
        return instance;
    }

    public boolean isInCommonMarket(Country country) {
        // TODO implement basic HTTP call
        slowHttp();
        return false;
    }

    public boolean isInAmericas(Country country) {
        slowHttp();
        return true;
    }

    public int distanceTo(Country country) {
        slowHttp();
        return 5000;
    }

    private void slowHttp() {
        try {
            Thread.sleep(5000);
        } catch (@SuppressWarnings("unused") InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
