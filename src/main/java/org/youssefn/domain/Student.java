package org.youssefn.domain;

public class Student extends User {

    public Student(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}
