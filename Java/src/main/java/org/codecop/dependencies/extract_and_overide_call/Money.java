package org.codecop.dependencies.extract_and_overide_call;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal value;

    public Money(int value) {
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

    public BigDecimal asBigDecimal() {
        return value;
    }
}
