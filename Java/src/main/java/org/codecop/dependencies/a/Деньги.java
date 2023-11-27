package org.codecop.dependencies.a;

import java.math.BigDecimal;
import java.util.Objects;

public class Деньги {

    public static final Деньги ТЫСЯЧА = new Деньги(1000);
    public static final Деньги СТО = new Деньги(100);

    private final BigDecimal value;

    public Деньги(int value) {
        this(new BigDecimal(value));
    }

    public Деньги(BigDecimal value) {
        this.value = value;
    }

    public Деньги уменьшитьНа(int p) {
        return new Деньги(value.multiply(new BigDecimal(100 - p)).divide(new BigDecimal(100)));
    }

    public boolean moreThan(Деньги other) {
        return this.value.compareTo(other.value) > 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Деньги money = (Деньги) other;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
