import java.util.ArrayList;
import java.util.List;

class LibraryCatalog {
    private List<Book> books;

    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    public void removeBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                break;
            }
        }
    }

    public List<Book> searchByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    public void displayAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library catalog.");
        } else {
            System.out.println("Available Books:");
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }
}

