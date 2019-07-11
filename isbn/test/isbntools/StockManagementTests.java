package isbntools;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTests {

    private ExternalISBNDataService webService;
    private ExternalISBNDataService databaseService;
    private StockManager stockManager;

    @Before
    public void setup() {
        // instance of that stockManager class.
        stockManager = new StockManager();

        // Mock for the web service
        webService = mock(ExternalISBNDataService.class);
        stockManager.setWebSservice(webService);

        // Mock for the database service
        databaseService = mock(ExternalISBNDataService.class);
        stockManager.setDatabaseService(databaseService);
    }

    @Test
    public void testCanGetACorrectLocatorCode() {

        when(webService.lookup(anyString())).thenReturn(new Book("0140177396", "Of Mice and Men", "J. Steinback"));
        when(databaseService.lookup(anyString())).thenReturn(null);

        // "Of Mice and Men" by J. Steinback isbn
        String isbn = "0140177396";

        //That's going to return a String,
        //which will be our locatorCode.
        String locatorCode = stockManager.getLocatorCode(isbn);

        // Check the result
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {

        //What we want to do in this version is say,
        //when the lookup method of our database service is called,
        //we do need to return something that is valid.
        //Now, there is a method of Mockito
        //that allows us to provide this implementation
        //and it's called when,
        //and it gets followed up with a then return.
        when(databaseService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

        // "Of Mice and Men" by J. Steinback isbn
        String isbn = "0140177396";

        //That's going to return a String,
        //which will be our locatorCode.
        String locatorCode = stockManager.getLocatorCode(isbn);

        // Check the result
        verify(databaseService).lookup("0140177396");
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void databaseIsUsedIfDataIsNotPresentInDatabase() {

        //What we want to do in this version is say,
        //when the lookup method of our database service is called,
        //we do need to return something that is valid.
        //Now, there is a method of Mockito
        //that allows us to provide this implementation
        //and it's called when,
        //and it gets followed up with a then return.
        when(webService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));


        // "Of Mice and Men" by J. Steinback isbn
        String isbn = "0140177396";

        //That's going to return a String,
        //which will be our locatorCode.
        String locatorCode = stockManager.getLocatorCode(isbn);

        // Check the result
        verify(databaseService).lookup("0140177396");
        verify(webService).lookup("0140177396");
    }
}
