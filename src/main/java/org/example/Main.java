package org.example;


import java.util.List;
import java.util.Scanner;

//Home Screen
//Show available/Checked out books and breaking or closing feature
//Show Available books
//Give user the option to select a book or exit
//If they want a book ask for name
//Say name and check book out
//Show checked out books
//Displays books that are checked out.
//Say who checked it out and have user either check in books or exit
//check in book
//ask for user the id of book to check in
// book and return to home screen
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        boolean programRunning = true;
        while (programRunning) {
            System.out.println("1) Show available books (check out)");
            System.out.println("2) Cart.  Remove or checkout");
            System.out.println("3) Show checked out books");
            System.out.println("4) Exit");

            int option = scan.nextInt();
            scan.nextLine(); // clear buffer

            switch (option) {
                case 1: // Show available books
                    System.out.println("\nAvailable Books:");
                    for (Book book : library.getAllBooks()) {
                        if (book.isCheckedIn()) {
                            System.out.println(book.getId() + ") " + book.getTitle() + " [" + book.getCategory() + "]");
                        }
                    }

                    System.out.print("Enter book ID to check out (or 0 to cancel): ");
                    int checkoutId = scan.nextInt();
                    for (Book book : library.getAllBooks()) {
                        if (book.getId() == checkoutId && book.isCheckedIn()) {
                            book.setCheckedOut(true);
                            System.out.println(" You checked out: " + book.getTitle());
                        }
                    }
                    break;

                case 2: // Show checked out books
                    System.out.println("\nChecked Out Books:");
                    for (Book book : library.getAllBooks()) {
                        if (book.isCheckedOut()) {
                            System.out.println(book.getId() + ") " + book.getTitle() + " [" + book.getCategory() + "]");
                        }
                    }
                    System.out.print("Enter book ID to check in (or 0 to cancel): ");
                    int checkIn = scan.nextInt();
                    for (Book book : library.getAllBooks()) {
                        if (book.getId() == checkIn && book.isCheckedOut()) {
                            book.setCheckedIn(true);
                            System.out.println(" You checked in: " + book.getTitle());
                        }
                    }
                    break;
                case 3: // Print receipt
                    if (shoppingCart.getCartItems().isEmpty()) {
                        System.out.println("Your cart is empty! No books to checkout.");
                    } else {
                        System.out.println("======= RECEIPT =======");
                        for (Book book : shoppingCart.getCartItems()) {
                            System.out.println("- " + book.getTitle() + " [" + book.getCategory() + "]");
                        }
                        System.out.println("=======================");
                        System.out.println("Thank you for using the library!");

                        // Clear the cart if checkout is complete
                        shoppingCart.clearCart();
                    }
                    break;

                // Exit
                case 4:
                    programRunning = false;
                    System.out.println("Thank you for visiting my haunted library!");
                    break;

                default:
                    System.out.println(" Invalid Option");
            }
        }
        }
    }
