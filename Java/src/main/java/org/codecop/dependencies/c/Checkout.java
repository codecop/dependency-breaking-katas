package org.codecop.dependencies.c;

public class Checkout {

    public Receipt createReceipt(Money amount) {
        Receipt receipt = new Receipt();
        Money vat = amount.percentage(20);

        receipt.setAmount(amount);
        receipt.setTax(vat);
        receipt.setTotal(amount.add(vat));

        store(receipt);

        return receipt;
    }

    protected void store(Receipt receipt) {
        ReceiptRepository.store(receipt);
    }
}
