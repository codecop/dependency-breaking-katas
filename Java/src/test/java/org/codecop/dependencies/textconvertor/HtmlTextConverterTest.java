package org.codecop.dependencies.textconvertor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HtmlTextConverterTest {

    @Test
    public void foo() {
        HtmlTextConverter_ converter = new HtmlTextConverter_("foo");
        assertEquals("fixme", converter.getFilename());
    }

}
