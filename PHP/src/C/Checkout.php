<?php

namespace Org\Codecop\Dependencies\C;

class Checkout {
    public function createReceipt(Money $amount): Receipt {
        $receipt = new Receipt();
        $vat = $amount->percentage(20);

        $receipt->setAmount($amount);
        $receipt->setTax($vat);
        $receipt->setTotal($amount->add($vat));

        ReceiptRepository::store($receipt);

        return $receipt;
    }
}
