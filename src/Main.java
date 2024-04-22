import model.Book;
import model.ShoppingCart;
import servicerepository.Inventory;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("ABC", "Gurugari Ludhiya", 10.99);
        Book book2 = new Book("XYZ", "Yash Mahajan", 12.50);
        Book book3 = new Book("LMN", "Likitha", 8.75);
        Inventory inventory = new Inventory();
        inventory.addBook(book1);
        inventory.addBook(book2);
        inventory.addBook(book3);
        System.out.println("\nInventory:");
        inventory.display();
        // Finding a book by using title
        String titleToFind = "Adventures of Tom Sawyer";
        Book foundBook = inventory.findBookByTitle(titleToFind);
        if (foundBook != null) {
            System.out.println("\nFound book by title: " + foundBook.getTitle());
        } else {
            System.out.println("\nBook not found by title: " + titleToFind);
        }
        // Find books by author
        String authorToFind = "Yash Mahajan";
        List <Book> booksByAuthor = inventory.findBooksByAuthor(authorToFind);
        System.out.println("\nBooks by author " + authorToFind + ":");
        for (Book book : booksByAuthor) {
            System.out.println(book.getTitle());
        }
        // Find books by price range
        double minPrice = 10.0;
        double maxPrice = 15.0;
        List<Book> booksInPriceRange = inventory.findBooksByPriceRange(minPrice, maxPrice);
        System.out.println("\nBooks in price range $" + minPrice + " - $" + maxPrice + ":");
        for (Book book : booksInPriceRange) {
            System.out.println(book.getTitle() + " ($" + book.getPrice() + ")");
        }
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(book1);
        cart.addItem(book2);

        // Display the shopping cart
        System.out.println("\nShopping Cart:");
        cart.displayItems();

        // Remove an item from the shopping cart
        cart.removeItem(book2);

        // Display the updated shopping cart
        System.out.println("\nUpdated Shopping Cart:");
        cart.displayItems();

        // Calculate the total price of items in the shopping cart
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("\nTotal Price of Items in Shopping Cart: $" + totalPrice);
    }
}