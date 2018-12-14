package org.codecop.dependencies;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloTest {

    @Test
    public void shouldGreet() {
        Hello hello = new Hello();

        String greeting = hello.greeting();

        assertEquals("Hello World", greeting);
    }

}
