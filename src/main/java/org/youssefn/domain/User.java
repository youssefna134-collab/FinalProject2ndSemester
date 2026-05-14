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
    private String id;
    private String name;
    private List<Item> borrowedItems;

    private static int nextId = 1;

    public User(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(Item item) {
        borrowedItems.add(item);
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }
}
