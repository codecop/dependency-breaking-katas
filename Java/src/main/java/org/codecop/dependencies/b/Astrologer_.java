package org.codecop.dependencies.b;

public class Astrologer_ {

    public boolean willWinTheLotteryToday() {
        return numberPlanetsInFirstHouse() > 5;
    }

    /*
     * This small private method is not deterministic during test.
     * What to do?
     */
    private long numberPlanetsInFirstHouse() {
        return Planets.planetsFirstTwelfth();
    }

    public boolean isMyLuckyDay() {
        return phaseOfMoon() == Moon.FULL;
    }

    /*
     * This small private method is not deterministic during test.
     * What to do?
     */
    private Moon phaseOfMoon() {
        return Moon.now().phase();
    }

}
