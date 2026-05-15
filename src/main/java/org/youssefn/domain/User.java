package org.youssefn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    private static int nextId = 1;

    public User(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    /**
     * Adds item to the borrowed items list
     * @param item the item input
     */
    public void borrowItem(Item item) {
        if (item == null) {
            System.out.println("Item not found");
            return;
        }

        borrowedItems.add(item);
    }

    /**
     * Removes the item from the user
     * @param item the item input
     */
    public void returnItem(Item item) {
        if (item == null) {
            System.out.println("Item not found");
            return;
        }

        borrowedItems.remove(item);
    }

    /**
     * Gets the borrow limit depending on the user
     * @return the borrow limit
     */
    public abstract int getBorrowLimit();
}
