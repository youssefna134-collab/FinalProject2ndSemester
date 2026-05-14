package org.youssefn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public abstract class Item {
    private String id;
    private String title;
    @Setter private ItemStatus itemStatus;

    private static int nextId = 1;

    public Item(String title) {
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.itemStatus = ItemStatus.IN_STORE;
    }
}
