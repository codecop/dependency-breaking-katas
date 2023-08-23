<?php

namespace Org\Codecop\Dependencies\A;

use Brick\Math\BigDecimal;

class Money {

    public static $ONE_THOUSAND = new Money(1000);
    public static $ONE_HUNDRED = new Money(100);

    private $value;

    public function __construct($value) {
        if (is_int($value)) {
            $this->value = BigDecimal::of($value);
        } elseif ($value instanceof BigDecimal) {
            $this->value = $value;
        }
    }

    public function reduceBy(int $p): Money {
        $percentage = BigDecimal::of(100)->minus($p);
        return new Money($this->value->multipliedBy($percentage)->dividedBy(100));
    }

    public function moreThan(Money $other): bool {
        return $this->value->compareTo($other->value) > 0;
    }

    public function __equals($other): bool {
        return $this->value->isEqualTo($other->value);
    }
}
