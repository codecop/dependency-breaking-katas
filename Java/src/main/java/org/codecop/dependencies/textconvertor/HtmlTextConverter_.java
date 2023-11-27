package org.codecop.dependencies.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class HtmlTextConverter_ {
    
    private String fullFilenameWithPath;

    /*
     * We can test this class but working with files is pain.
     * What to do?
     */
    public HtmlTextConverter_(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {

        try (BufferedReader reader = 
             new BufferedReader(new FileReader(fullFilenameWithPath))) {
            
            String html = "";

            String line = reader.readLine();
            while (line != null) {
                html += StringEscapeUtils.escapeHtml(line);
                html += "<br />";
                line = reader.readLine();
            }

            return html;
            
        }
    }
}
