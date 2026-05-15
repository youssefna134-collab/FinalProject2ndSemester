package org.youssefn.Util;

public class Validation {

    /**
     * Checks if the ISBN is valid i.e. contains 13 digits and every character is a digit
     * @param isbn the isbn input
     * @return true if it is valid. Otherwise, false
     */
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
