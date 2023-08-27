package org.codecop.dependencies.d;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class RestCountriesAPITest {

    @Ignore("slow")
    @Test
    public void isAmericas() {
        Country us = new Country("US");
        assertTrue(getInstance().isInAmericas(us));
    }

    @Ignore("slow")
    @Test
    public void isNotCommonMarket() {
        Country us = new Country("US");
        assertFalse(getInstance().isInCommonMarket(us));
    }

    @Test
    public void getDistance() {
        Country us = new Country("US");
        assertEquals(8284768, getInstance().distanceTo(us));
    }

    @Ignore("slow")
    @Test
    public void isNotAmericas() {
        Country at = new Country("AT");
        assertFalse(getInstance().isInAmericas(at));
    }

    @Ignore("slow")
    @Test
    public void isCommonMarket() {
        Country at = new Country("AT");
        assertTrue(getInstance().isInCommonMarket(at));
    }

    @Ignore("slow")
    @Test
    public void getNoDistance() {
        Country at = new Country("AT");
        assertEquals(0, getInstance().distanceTo(at));
    }

    private RestCountriesAPI getInstance() {
        return RestCountriesAPI.getInstance();
    }

}
