package org.youssefn.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
@EqualsAndHashCode
public class Library {
    private List<Item> items;
    private List<User> users;
    private Stack<Item> returnedItems;
    private Queue<User> waitingQueue;
    private Set<String> uniqueTitles;
    private Map<String, Item> itemMap;

    public Library() {
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
        this.returnedItems = new Stack<>();
        this.waitingQueue = new LinkedList<>();
        this.uniqueTitles = new HashSet<>();
        this.itemMap = new HashMap<>();
    }

    public void addItem(Item item) {
        items.add(item);
        uniqueTitles.add(item.getTitle());
        itemMap.put(item.getId(), item);
    }

    public void borrowItem(User user, Item item) {
        user.borrowItem(item);
        item.setItemStatus(ItemStatus.BORROWED);
    }

    public void returnItem(User user, Item item) {
        user.returnItem(item);
        item.setItemStatus(ItemStatus.IN_STORE);
        returnedItems.push(item);
    }
}
