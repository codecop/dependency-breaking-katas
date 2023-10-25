<?php

namespace Org\Codecop\Dependencies\A;

use Brick\Math\BigDecimal;
// see https://github.com/brick/math

class Money {

    public static function ONE_THOUSAND():Money {
        return new Money(1000);
    }
    public static function ONE_HUNDRED():Money {
        return new Money(100);
    }

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
        return new Money($this->value->multipliedBy($percentage)->exactlyDividedBy(100));
    }

    public function moreThan(Money $other): bool {
        return $this->value->compareTo($other->value) > 0;
    }
}
