package org.codecop.dependencies.d;

import java.math.BigDecimal;
import java.util.Objects;

public class Gold {

    private final BigDecimal value;

    public Gold(int value) {
        this(new BigDecimal(value));
    }

    public Gold(BigDecimal value) {
        this.value = value;
    }

    public Gold times(int p) {
        return new Gold(value.multiply(new BigDecimal(p)).divide(new BigDecimal(100)));
    }

    public String format() {
        return String.format("%.2f", value);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Gold money = (Gold) other;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
