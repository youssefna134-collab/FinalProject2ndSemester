package org.youssefn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Magazine extends Item {
    private int issueNumber;
    private String publisher;

    public Magazine(String title, int issueNumber, String publisher) {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be positive");
        }

        super(title);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }
}
