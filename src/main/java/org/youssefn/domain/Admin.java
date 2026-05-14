package org.youssefn.domain;

import org.youssefn.Interfaces.Reportable;

public class Admin extends User implements Reportable {

    public Admin(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 0;
    }

    @Override
    public void generateReport(Library library) {
        for (Item item : library.getItems()) {
            System.out.println(item);
        }
    }
}
