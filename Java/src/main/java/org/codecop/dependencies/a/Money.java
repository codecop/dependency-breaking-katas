package org.codecop.dependencies.a;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    public static final Money ONE_THOUSAND = new Money(1000);
    public static final Money ONE_HOUNDRED = new Money(100);

    private final BigDecimal value;

    public Money(int value) {
        this(new BigDecimal(value));
    }

    public Money(BigDecimal value) {
        this.value = value;
    }

    public Money reduceBy(int p) {
        return new Money(value.multiply(new BigDecimal(100 - p)).divide(new BigDecimal(100)));
    }

    public boolean moreThan(Money other) {
        return this.value.compareTo(other.value) > 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Money money = (Money) other;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
