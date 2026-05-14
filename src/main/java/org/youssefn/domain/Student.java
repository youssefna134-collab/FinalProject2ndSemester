package org.youssefn.domain;

import org.youssefn.Util.Constants;

public class Student extends User {

    public Student(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return Constants.MAX_BOOKS_STUDENT;
    }
}
