package servicerepository;
import model.Book;

import java.util.ArrayList;
import java.util.List;
public class Inventory {
    private List<Book> books;

    // Constructor
    public Inventory() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the inventory
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to inventory: " + book.getTitle());
    }

    // Method to remove a book from the inventory
    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book removed from inventory: " + book.getTitle());
        } else {
            System.out.println("Book not found in inventory: " + book.getTitle());
        }
    }

    // Method to display all books in the inventory
    public void display() {
        System.out.println("Inventory:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + ", Price: $" + book.getPrice());
        }
    }

    // Method to find a book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Method to find books by author
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result; // List of books by the given author
    }

    // Method to find books within a price range
    public List<Book> findBooksByPriceRange(double minPrice, double maxPrice) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
                result.add(book);
            }
        }
        return result;
    }
}
