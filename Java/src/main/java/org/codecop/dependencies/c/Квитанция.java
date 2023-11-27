package org.codecop.dependencies.c;

import java.util.Arrays;
import java.util.List;

public class Квитанция {
    private Деньги amount;
    private Деньги tax;
    private Деньги total;

    public Деньги getAmount() {
        return amount;
    }

    public void установитьСуммy(Деньги amount) {
        this.amount = amount;
    }

    public Деньги getTax() {
        return tax;
    }

    public void установитьНалог(Деньги tax) {
        this.tax = tax;
    }

    public Деньги getTotal() {
        return total;
    }

    public void установитьИтог(Деньги total) {
        this.total = total;
    }

    public List<String> format() {
        return Arrays.asList( //
                "Receipt", //
                "=======", //
                "Item 1 ... " + amount.format(), //
                "Tax    ... " + tax.format(), //
                "----------------", //
                "Total  ... " + total.format() //
        );
    }
}
