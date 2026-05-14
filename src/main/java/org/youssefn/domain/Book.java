package org.youssefn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.youssefn.Util.Validation;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    public Book(String title, String isbn, String author, String genre) {
        if (!Validation.isValidISBN(isbn)) {
            throw new IllegalArgumentException("Invalid ISBN");
        }

        super(title);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }
}
