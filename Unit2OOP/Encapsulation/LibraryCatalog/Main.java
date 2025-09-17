import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        catalog.addBook("The Catcher in the Rye", "J.D. Salinger");
        catalog.addBook("To Kill a Mockingbird", "Harper Lee");
        catalog.addBook("1984", "George Orwell");
        catalog.addBook("The Great Gatsby", "F. Scott Fitzgerald");

        System.out.println("Available books information");
        catalog.displayAvailableBooks();

        System.out.println("Books by Harper Lee:");
        List<Book> harperLeeBooks = catalog.searchByAuthor("Harper Lee");
        for (Book book : harperLeeBooks) {
            System.out.println(book.toString());
        }

        System.out.println("\nRemoving '1984' from the catalog...");
        catalog.removeBook("1984");

        System.out.println("\nAvailable books after removal:");
        catalog.displayAvailableBooks();
    }
}
