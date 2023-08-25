<?php

namespace Org\Codecop\Dependencies\D;

class Country {
    private $name;

    public function __construct(String $name) {
        $this->name = $name;
    }

    public function __toString(): String {
        return $this->name;
    }
}
