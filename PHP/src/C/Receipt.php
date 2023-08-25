<?php

namespace Org\Codecop\Dependencies\C;

class Receipt {
    private $amount;
    private $tax;
    private $total;

    public function getAmount(): Money {
        return $this->amount;
    }

    public function setAmount(Money $amount): void {
        $this->amount = $amount;
    }

    public function getTax(): Money {
        return $this->tax;
    }

    public function setTax(Money $tax): void {
        $this->tax = $tax;
    }

    public function getTotal(): Money {
        return $this->total;
    }

    public function setTotal(Money $total): void {
        $this->total = $total;
    }

    public function format(): array {
        return [ //
            "Receipt", //
            "=======", //
            "Item 1 ... " . $this->amount->format(), //
            "Tax    ... " . $this->tax->format(), //
            "----------------", //
            "Total  ... " . $this->total->format() //
        ];
    }
}
