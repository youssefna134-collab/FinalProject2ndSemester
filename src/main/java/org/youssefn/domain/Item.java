package org.youssefn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;

@Getter
@ToString
@EqualsAndHashCode
public abstract class Item {
    private String id;
    private String title;
    @Setter
    private ItemStatus itemStatus;

    private static int nextId = 1;

    public Item(String title) {
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.itemStatus = ItemStatus.IN_STORE;
    }

    public class ItemComparatorByTitle implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.getTitle().compareToIgnoreCase(o2.getTitle());
        }
    }
}
