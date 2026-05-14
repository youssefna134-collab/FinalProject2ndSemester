package org.youssefn.domain;

import org.youssefn.Util.Constants;

public class Teacher extends User {

    public Teacher(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return Constants.MAX_ITEMS_TEACHER;
    }
}
