import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.youssefn.Util.Validation;
import org.youssefn.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DifferentTestClasses {

    @Test
    @DisplayName("Should validate correct 13-digit ISBN format")
    void testValidISBN() {
        assertTrue(Validation.isValidISBN("9780134685991"));
        assertFalse(Validation.isValidISBN("12345")); // Too short
        assertFalse(Validation.isValidISBN("978013468599A")); // Contains letter
    }

    @Test
    @DisplayName("Student should not exceed 5-book borrowing limit")
    void testStudentBorrowingLimit() {
        User student = new Student("Alice");
        List<Item> books = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            books.add(new Book("B" + i, "Title" + i, "Author", "978123456789" + i));
        }

        for(Item b : books) {
            assertDoesNotThrow(() -> student.borrowItem(b));
        }

        Book extraBook = new Book("B6", "Extra", "Author", "9780000000000");
        assertThrows(IllegalStateException.class, () -> student.borrowItem(extraBook));
    }

    @Test
    @DisplayName("Student should only be allowed to borrow Books")
    void testStudentItemRestriction() {
        User student = new Student("Bob");
        Item dvd = new DVD("D1", "Inception", 148);

        assertThrows(IllegalStateException.class, () -> student.borrowItem(dvd));
    }

    @Test
    @DisplayName("Recursive search should find item by title case-insensitively")
    void testRecursiveSearch() {
        Library library = new Library();
        library.addItem(new Book("1", "Java Programming", "Author A", "9781111111111"));
        library.addItem(new Book("2", "Python Basics", "Author B", "9782222222222"));

        Item result = library.recursiveSearch(0, "java programming");

        assertEquals("Java Programming", result.getTitle());
    }

    @Test
    @DisplayName("Stream search should return unique items (one copy only) by author")
    void testStreamSearchUnique() {
        Library library = new Library();
        library.addItem(new Book("1", "Clean Code", "Robert Martin", "9780132350884"));
        library.addItem(new Book("2", "Clean Code", "Robert Martin", "9780132350884"));

        List<Item> results = library.streamSearch("Robert Martin");
        assertEquals(1, results.size(), "Search result should only contain one copy");
    }

    @Test
    @DisplayName("Item status should change to BORROWED after successful transaction")
    void testItemStatusChange() {
        User teacher = new Teacher("Smith");
        Item book = new Book("Java", "0129989834983", "Jeremy", "horror");
        book.setItemStatus(ItemStatus.IN_STORE);

        teacher.borrowItem(book);
        assertEquals(ItemStatus.BORROWED, book.getItemStatus());

        teacher.returnItem(book);
        assertEquals(ItemStatus.IN_STORE, book.getItemStatus());
    }

    @Test
    @DisplayName("Should throw exception when borrowing an item already BORROWED")
    void testBorrowUnavailableItem() {
        User teacher1 = new Teacher("Smith");
        User teacher2 = new Teacher("Jones");
        Item book = new Book("Python", "1234567890123", "Bob", "Romance");

        teacher1.borrowItem(book);

        assertThrows(IllegalStateException.class, () -> teacher2.borrowItem(book));
    }

    @Test
    @DisplayName("Should sort users by name alphabetically")
    void testUserSorting() {
        List<User> users = Arrays.asList(
                new Student( "Zack"),
                new Student( "Alice"),
                new Teacher( "Charlie")
        );

        users.sort(new User.UserComparatorByName());
        assertEquals("Alice", users.get(0).getName());
        assertEquals("Zack", users.get(2).getName());
    }
}
