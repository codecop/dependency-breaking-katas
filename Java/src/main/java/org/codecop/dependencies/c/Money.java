package org.codecop.dependencies.c;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final BigDecimal value;

    public Money(int value) {
        this(new BigDecimal(value));
    }

    public Money(String value) {
        this(new BigDecimal(value));
    }
    
    public Money(BigDecimal value) {
        this.value = value;
    }

    public Money add(Money other) {
        return new Money(value.add(other.value));
    }

    public Money percentage(int p) {
        return new Money(value.multiply(new BigDecimal(p)).divide(new BigDecimal(100)));
    }

    public String format() {
        return String.format("%.2f", value);
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
    
    public BigDecimal asBigDecimal() {
        return value;
    }
}
