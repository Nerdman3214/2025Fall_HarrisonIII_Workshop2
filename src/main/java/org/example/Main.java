package org.example;


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
        Book[] books = new Book[] {
                // Horror
                new Book(1, "H001", "The Haunted Manor", true, false, "Horror"),
                new Book(2, "H002", "Whispers in the Dark", false, true, "Horror"),
                new Book(3, "H003", "The Last Scream", true, false, "Horror"),
                new Book(4, "H004", "Shadows of the Grave", true, false, "Horror"),
                new Book(5, "H005", "Blood Moon Rising", false, true, "Horror"),

                // Science Fiction
                new Book(6, "SF001", "Galactic Wars", true, false, "Science Fiction"),
                new Book(7, "SF002", "The Quantum Voyage", false, true, "Science Fiction"),
                new Book(8, "SF003", "Echoes of Mars", true, false, "Science Fiction"),
                new Book(9, "SF004", "The AI Uprising", false, true, "Science Fiction"),
                new Book(10, "SF005", "Stars Beyond Reach", true, false, "Science Fiction"),

                // Comedy
                new Book(11, "C001", "Laughing Matters", true, false, "Comedy"),
                new Book(12, "C002", "Oops! My Bad", false, true, "Comedy"),
                new Book(13, "C003", "The Clumsy Detective", true, false, "Comedy"),
                new Book(14, "C004", "Bananas Everywhere", true, false, "Comedy"),
                new Book(15, "C005", "Prank Wars", false, true, "Comedy"),

                // History
                new Book(16, "HIS001", "The Roman Empire", true, false, "History"),
                new Book(17, "HIS002", "World War II Chronicles", false, true, "History"),
                new Book(18, "HIS003", "The Pharaohs of Egypt", true, false, "History"),
                new Book(19, "HIS004", "The American Revolution", true, false, "History"),
                new Book(20, "HIS005", "Medieval Europe", false, true, "History")
        };

        //Print all books
        Scanner scan = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("1) Show available books (check out)");
            System.out.println("2) Show checked out books (check in)");
            System.out.println("3) Exit");

            int option = scan.nextInt();
            scan.nextLine(); // clear buffer

            switch (option) {
                case 1: // Show available books
                    System.out.println("\nAvailable Books:");
                    for (Book book : books) {
                        if (book.isCheckedIn()) {
                            System.out.println(book.getId() + ") " + book.getTitle() + " [" + book.getCategory() + "]");
                        }
                    }
                    System.out.print("Enter book ID to check out (or 0 to cancel): ");
                    int checkoutId = scan.nextInt();
                    for (Book book : books) {
                        if (book.getId() == checkoutId && book.isCheckedIn()) {
                            book.setCheckedOut(true);
                            System.out.println(" You checked out: " + book.getTitle());
                        }
                    }
                    break;

                case 2: // Show checked out books
                    System.out.println("\nChecked Out Books:");
                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            System.out.println(book.getId() + ") " + book.getTitle() + " [" + book.getCategory() + "]");
                        }
                    }
                    System.out.print("Enter book ID to check in (or 0 to cancel): ");
                    int checkIn = scan.nextInt();
                    for (Book book : books) {
                        if (book.getId() == checkIn && book.isCheckedOut()) {
                            book.setCheckedIn(true);
                            System.out.println(" You checked in: " + book.getTitle());
                        }
                    }
                    break;

                case 3: // Exit
                    go = false;
                    break;

                default:
                    System.out.println(" Invalid Option");
            }
        }
    }
}