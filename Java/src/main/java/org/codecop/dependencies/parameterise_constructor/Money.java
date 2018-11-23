package org.codecop.dependencies.parameterise_constructor;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    public static final Money ONE_THOUSAND = new Money(new BigDecimal("1000"));
    public static final Money ONE_HOUNDRED = new Money(new BigDecimal("100"));

    private final BigDecimal value;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
