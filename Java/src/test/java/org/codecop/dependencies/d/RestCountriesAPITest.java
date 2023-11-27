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
        Kingdom us = new Kingdom("US");
        assertTrue(getInstance().isInMagicRealm(us));
    }

    @Ignore("slow")
    @Test
    public void isNotCommonMarket() {
        Kingdom us = new Kingdom("US");
        assertFalse(getInstance().isInAdventurousLands(us));
    }

    @Test
    public void getDistance() {
        Kingdom us = new Kingdom("US");
        assertEquals(8284768, getInstance().distanceTo(us));
    }

    @Ignore("slow")
    @Test
    public void isNotAmericas() {
        Kingdom at = new Kingdom("AT");
        assertFalse(getInstance().isInMagicRealm(at));
    }

    @Ignore("slow")
    @Test
    public void isCommonMarket() {
        Kingdom at = new Kingdom("AT");
        assertTrue(getInstance().isInAdventurousLands(at));
    }

    @Ignore("slow")
    @Test
    public void getNoDistance() {
        Kingdom at = new Kingdom("AT");
        assertEquals(0, getInstance().distanceTo(at));
    }

    private ExplorationGuild getInstance() {
        return ExplorationGuild.ask();
    }

}
