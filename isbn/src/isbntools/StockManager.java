package isbntools;

public class StockManager {

    private ExternalISBNDataService webSservice;
    private ExternalISBNDataService databaseService;

    public String getLocatorCode(String isbn) {
        Book book = databaseService.lookup(isbn);

        if (book == null) {
            book = webSservice.lookup(isbn);
        }

        StringBuilder locator = new StringBuilder();
        locator.append(isbn.substring(isbn.length() - 4));
        locator.append(book.getAuthor().substring(0, 1));
        locator.append(book.getTitle().split(" ").length);
        return locator.toString();
    }

    public void setWebSservice(ExternalISBNDataService webSservice) {
        this.webSservice = webSservice;
    }

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }
}
