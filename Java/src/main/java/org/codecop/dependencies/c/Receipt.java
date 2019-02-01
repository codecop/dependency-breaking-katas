package org.codecop.dependencies.c;

import java.util.Arrays;
import java.util.List;

public class Receipt {
    private Money amount;
    private Money tax;
    private Money total;

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Money getTax() {
        return tax;
    }

    public void setTax(Money tax) {
        this.tax = tax;
    }

    public Money getTotal() {
        return total;
    }

    public void setTotal(Money total) {
        this.total = total;
    }

    public List<String> fomat() {
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
