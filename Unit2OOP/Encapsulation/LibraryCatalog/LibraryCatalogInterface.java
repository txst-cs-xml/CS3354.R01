import java.util.List;

/**
 * An interface representing a library catalog.
 */
public interface LibraryCatalogInterface {

    /**
     * Adds a book to the library catalog.
     *
     * @param title  The title of the book to be added.
     * @param author The author of the book to be added.
     */
    void addBook(String title, String author);

    /**
     * Removes a book from the library catalog by its title.
     *
     * @param title The title of the book to be removed.
     */
    void removeBook(String title);

    /**
     * Searches for books in the catalog by their title.
     *
     * @param title The title to search for.
     * @return A list of books with matching titles.
     */
    List<Book> searchByTitle(String title);

    /**
     * Searches for books in the catalog by their author.
     *
     * @param author The author to search for.
     * @return A list of books written by the matching author.
     */
    List<Book> searchByAuthor(String author);

    /**
     * Displays information about available books in the catalog.
     */
    void displayAvailableBooks();
}
