package org.codecop.dependencies.textconvertor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HtmlTextConverterTest {

    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("fixme", converter.getFilename());
    }

}
