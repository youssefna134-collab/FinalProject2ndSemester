package org.youssefn.Util;

public class Validation {

    public static boolean isValidISBN(String isbn) {
        if (isbn == null) {
            return false;
        }

        if (isbn.length() != 13) {
            return false;
        }

        for (int i = 0; i < isbn.length(); i++) {

            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
