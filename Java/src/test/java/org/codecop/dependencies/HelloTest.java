package org.codecop.dependencies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    public void shouldGreet() {
        Hello hello = new Hello();

        String greeting = hello.greeting();

        assertEquals("Hello World", greeting);
    }

}
