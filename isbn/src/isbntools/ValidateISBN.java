package isbntools;

public class ValidateISBN {

    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;
    public static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String isbn) {

        if (isbn.length() == LONG_ISBN_LENGTH) {
            return checkLongDigitsISBN(isbn);
        } else if (isbn.length() == SHORT_ISBN_LENGTH) {
            return checkShortDigitsISBN(isbn);
        } else {
            throw new NumberFormatException("ISBN numbers must be " + SHORT_ISBN_LENGTH + " or " + LONG_ISBN_LENGTH + " digits long");
        }
    }

    /**
     * Each of the first nine digits of the 10-digit ISBN—excluding the check digit itself—is multiplied by its (integer) weight,
     * descending from 10 to 2, and the sum of these nine products found. The value of the check digit is simply the one number between 0 and 10 which,
     * when added to this sum, means the total is a multiple of 11.
     *
     * @param isbn ISBN number
     * @return True/False = Valid/InValid
     */
    private boolean checkShortDigitsISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN numbers must be numerical");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
            }
        }

        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    /**
     * Appendix 1 of the International ISBN Agency's official user manual[11]:33 describes how the 13-digit ISBN check
     * digit is calculated. The ISBN-13 check digit, which is the last digit of the ISBN, must range from 0 to 9 and
     * must be such that the sum of all the thirteen digits, each multiplied by its (integer) weight, alternating
     * between 1 and 3, is a multiple of 10.
     *
     * @param isbn ISBN number
     * @return True/False = Valid/InValid
     */
    private boolean checkLongDigitsISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }

        return total % LONG_ISBN_MULTIPLIER == 0;
    }
}
