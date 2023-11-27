package org.codecop.dependencies.b;

public class Planets {

    public static long planetsFirstTwelfth() {
        return 0;
    }

    public static Planets now() {
        return new Planets();
    }

    public Moon moon() {
        return Moon.FULL;
    }

}
