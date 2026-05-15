package org.youssefn.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    /**
     * Adds an item and its title to the corresponding lists and maps the id to it
     * @param item the item input
     */
    public void addItem(Item item) {
        items.add(item);
        uniqueTitles.add(item.getTitle());
        itemMap.put(item.getId(), item);
    }

    /**
     * Adds a user to the user list
     * @param user the user input
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Borrows an item form the library system
     * @param user User that wishes to borrow an item
     * @param item the item that the user wants to borrow
     */
    public void borrowItem(User user, Item item) {
        if (item.getItemStatus() != ItemStatus.IN_STORE) {
            throw new IllegalArgumentException("Item is not available");
        }

        if (user instanceof Student && !(item instanceof Book)) {
            throw new IllegalArgumentException("Students can only borrow books");
        }

        if (user.getBorrowedItems().size() >= user.getBorrowLimit()) {
            throw new IllegalArgumentException("Borrow limit reached");
        }

        user.borrowItem(item);
        item.setItemStatus(ItemStatus.BORROWED);
    }

    /**
     * Removes the item from the user
     * @param user the user that wants to return the item
     * @param item the item that the user wants to return
     */
    public void returnItem(User user, Item item) {
        user.returnItem(item);
        item.setItemStatus(ItemStatus.IN_STORE);
        returnedItems.push(item);
    }

    /**
     * Search items by their titles
     * @param title the title input
     * @return the corresponding item
     */
    public List<Item> searchByTitle(String title) {
        List<Item> results = new ArrayList<>();
        Set<String> alreadyAdded = new HashSet<>();

        for (Item item : items) {

            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {

                if (!alreadyAdded.contains(item.getTitle())) {
                    results.add(item);
                    alreadyAdded.add(item.getTitle());
                }
            }
        }

        return results;
    }

    /**
     * Searches an item by the author
     * @param author the author input
     * @return the corresponding item
     */
    public List<Item> searchByAuthor(String author) {
        List<Item> results = new ArrayList<>();
        Set<String> alreadyAdded = new HashSet<>();

        for (Item item : items) {
            if (item instanceof Book book) {
                if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                    if (!alreadyAdded.contains(book.getTitle())) {
                        results.add(book);
                        alreadyAdded.add(book.getTitle());
                    }
                }
            }
        }

        return results;
    }

    /**
     * Searches for an item by the title recursively
     * @param index the index input
     * @param title the title input
     * @return the corresponding item
     */
    public Item recursiveSearch(int index, String title) {
        if (index >= items.size()) {
            return null;
        }

        if (items.get(index).getTitle().equalsIgnoreCase(title)) {
            return items.get(index);
        }

        return recursiveSearch(index + 1, title);
    }

    /**
     * Searches for an item by their title while using stream
     * @param title the title input
     * @return the corresponding item
     */
    public List<Item> streamSearch(String title) {

        return items.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .distinct()
                .toList();
    }

    /**
     * Exports items to the csv files
     * @param path the path input
     */
    public void exportItems(String path) {
        try {
            FileWriter writer = new FileWriter(path);

            for (Item item : items) {
                writer.write(item.toString() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error exporting items");
        }
    }

    /**
     * Exports users to the csv file
     * @param path the path input
     */
    public void exportUsers(String path) {
        try {
            FileWriter writer = new FileWriter(path);

            for (User user : users) {
                writer.write(user.toString() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error exporting users");
        }
    }

    /**
     * Loads books from the csv file
     * @param path the path input
     */
    public void loadBooks(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                String isbn = data[1];
                String title = data[2];
                String author = data[3];
                String genre = data[4];

                Book book = new Book(title, isbn, author, genre);
                this.addItem(book);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Books file not found");
        }
    }

    /**
     * Loads users from the csv file
     * @param path the path input
     */
    public void loadUsers(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                String name = data[1];
                String type = data[2];

                switch (type) {
                    case "Student":
                        this.addUser(new Student(name));
                        break;

                    case "Teacher":
                        this.addUser(new Teacher(name));
                        break;

                    case "Admin":
                        this.addUser(new Admin(name));
                        break;
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Users file not found");
        }
    }
}
