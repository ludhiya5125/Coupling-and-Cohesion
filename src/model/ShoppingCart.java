package model;
import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
    private List<Book> items;

    // Constructor
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Method to calculate the total price of items in the shopping cart
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Book item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Method to add a book to the shopping cart
    public void addItem(Book book) {
        items.add(book);
        System.out.println("Book added to shopping cart: " + book.getTitle());
    }

    // Method to remove a book from the shopping cart
    public void removeItem(Book book) {
        if (items.remove(book)) {
            System.out.println("Book removed from shopping cart: " + book.getTitle());
        } else {
            System.out.println("Book not found in shopping cart: " + book.getTitle());
        }
    }

    // Method to display all items in the shopping cart
    public void displayItems() {
        System.out.println("Shopping Cart:");
        for (Book item : items) {
            System.out.println(item.getTitle() + " by " + item.getAuthor() + ", Price: $" + item.getPrice());
        }
    }
}
