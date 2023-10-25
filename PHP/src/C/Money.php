<?php

namespace Org\Codecop\Dependencies\C;

use Brick\Math\BigDecimal;
// see https://github.com/brick/math

class Money {

    private $value;

    public function __construct($value) {
        if (is_int($value)) {
            $this->value = BigDecimal::of($value);
        } elseif ($value instanceof BigDecimal) {
            $this->value = $value;
        }
    }

    public function add(Money $other): Money {
        return new Money($this->value->plus($other->value));
    }

    public function percentage(int $p): Money {
        return new Money($this->value->multipliedBy(BigDecimal::of($p))->exactlyDividedBy(100));
    }

    public function format(): String {
        return number_format($this->value->toFloat(), 2, '.', '');
    }

    public function asBigDecimal(): BigDecimal {
        return $this->value;
    }
}
