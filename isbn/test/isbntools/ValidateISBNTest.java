package isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void TenDigitCheckAValidISBN() {
        // create an object for the ISBN code
        ValidateISBN validator = new ValidateISBN();

        // Store the result of the check
        boolean result = validator.checkISBN("0140449116");

        //Pass into that method the value that we want to check.
        assertTrue("ISBN: 140449116 ", result);

        // check another one
        result = validator.checkISBN("0140177396");

        //Check the second one.
        assertTrue("ISBN: 0140177396", result);
    }

    @Test
    public void checkAValid13DigitISBN() {
        // create an object for the ISBN code
        ValidateISBN validator = new ValidateISBN();

        // Store the result of the check
        boolean result = validator.checkISBN("9781853260087");

        //Pass into that method the value that we want to check.
        assertTrue("13DigitISBN: 9781853260087 ", result);
    }

    @Test
    public void TenDigitCheckAInValidISBN() {
        // create an object for the ISBN code
        ValidateISBN validator = new ValidateISBN();

        // Store the result of the check
        boolean result = validator.checkISBN("0140449117");

        //Pass into that method the value that we want to check.
        assertFalse("ISBN: 0140449117", result);
    }

    @Test
    public void CheckAInValid13DigitsISBN() {
        // create an object for the ISBN code
        ValidateISBN validator = new ValidateISBN();

        // Store the result of the check
        boolean result = validator.checkISBN("9781853267336");

        //Pass into that method the value that we want to check.
        assertFalse("ISBN: 9781853267336", result);
    }

    @Test
    public void TenDigitISBNNumbersEndingInAnXAreValid() {
        // create an object for the ISBN code
        ValidateISBN validator = new ValidateISBN();

        // Store the result of the check
        boolean result = validator.checkISBN("012000030X");

        //Pass into that method the value that we want to check.
        assertTrue(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNsAreNotAllowed() {
        // create an object for the ISBN code
        ValidateISBN validator = new ValidateISBN();

        // Check a nine digit isbn
        validator.checkISBN("123456789");
    }

    @Test
    public void tenDigitISBNsAreAllowed() {
        // create an object for the ISBN code
        ValidateISBN validator = new ValidateISBN();

        // Check a nine digit isbn
        boolean result = validator.checkISBN("0123456789");

        assertTrue(result);
    }


    @Test(expected = NumberFormatException.class)
    public void nonNumbersAreNotAllowed() {
        // create an object for the ISBN code
        ValidateISBN validator = new ValidateISBN();

        // Check a nine digit isbn
        validator.checkISBN("helloworld");
    }
}
