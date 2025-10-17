package org.example;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Book> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addBook(Book book) {
        cartItems.add(book);
    }

    public void removeBook(Book book) {
        cartItems.remove(book);
    }

    public List<Book> getCartItems() {
        return cartItems;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void clearCart() {
        cartItems.clear();
    }

    public void showCart() {
        System.out.println("\n=== Your Cart ===");
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (Book b : cartItems) {
                System.out.println(b.getId() + ") " + b.getTitle() + " [" + b.getCategory() + "]");
            }
        }
    }

    public void checkout() {
        System.out.println("\n=== Checkout Receipt ===");
        if (cartItems.isEmpty()) {
            System.out.println("No books in cart.");
            return;
        }

        for (Book b : cartItems) {
            System.out.println("- " + b.getTitle() + " [" + b.getCategory() + "]");
        }

        System.out.println("========================");
        System.out.println("Total books checked out: " + cartItems.size());
        System.out.println("Thank you for visiting the library!");
        clearCart();
    }
}
