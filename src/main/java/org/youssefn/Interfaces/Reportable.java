package org.youssefn.Interfaces;

import org.youssefn.domain.Library;

public interface Reportable {

    /**
     * Generates a complete report for the library
     * @param library library input
     */
    void generateReport(Library library);
}
