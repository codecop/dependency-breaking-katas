package org.codecop.dependencies.c;

import java.math.BigDecimal;

public class Деньги {

    private final BigDecimal value;

    public Деньги(int value) {
        this(new BigDecimal(value));
    }

    public Деньги(BigDecimal value) {
        this.value = value;
    }

    public Деньги add(Деньги other) {
        return new Деньги(value.add(other.value));
    }

    public Деньги процент(int p) {
        return new Деньги(value.multiply(new BigDecimal(p)).divide(new BigDecimal(100)));
    }

    public String format() {
        return String.format("%.2f", value);
    }

    public BigDecimal asBigDecimal() {
        return value;
    }
}
