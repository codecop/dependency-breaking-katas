package org.codecop.dependencies.b;

public class Astrologer_ {

    public boolean willIWinTheLotteryToday() {
        return numberPlanetsInFirstHouse() % 2 == 0;
    }

    private long numberPlanetsInFirstHouse() {
        /*
         * This small private method is not deterministic during test.
         * What to do?
         */
        return Planets.planetsFirstTwelfth();
    }

    public boolean isMyLuckyDay() {
        return phaseOfMoon() == Moon.FULL;
    }

    private Moon phaseOfMoon() {
        /*
         * This small private method is not deterministic during test.
         * What to do?
         */
        return Moon.now().phase();
    }
}
