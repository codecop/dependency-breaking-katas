package org.codecop.dependencies.b;

public enum Moon {
    FULL;

    public static Moon now() {
        return Moon.FULL;
    }

    public Moon phase() {
        return Moon.FULL;
    }
}
