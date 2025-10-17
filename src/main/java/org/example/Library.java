package org.example;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor: runs once when you create a Library object
    public Library() {
        books = new ArrayList<>();

        // Load your existing book data here
        books.add(new Book(1, "H001", "The Haunted Manor", true, false, "Horror"));
        books.add(new Book(2, "H002", "Whispers in the Dark", false, true, "Horror"));
        books.add(new Book(3, "H003", "The Last Scream", true, false, "Horror"));
        books.add(new Book(4, "H004", "Shadows of the Grave", true, false, "Horror"));
        books.add(new Book(5, "H005", "Blood Moon Rising", false, true, "Horror"));

        books.add(new Book(6, "SF001", "Galactic Wars", true, false, "Science Fiction"));
        books.add(new Book(7, "SF002", "The Quantum Voyage", false, true, "Science Fiction"));
        books.add(new Book(8, "SF003", "Echoes of Mars", true, false, "Science Fiction"));
        books.add(new Book(9, "SF004", "The AI Uprising", false, true, "Science Fiction"));
        books.add(new Book(10, "SF005", "Stars Beyond Reach", true, false, "Science Fiction"));

        books.add(new Book(11, "C001", "Laughing Matters", true, false, "Comedy"));
        books.add(new Book(12, "C002", "Oops! My Bad", false, true, "Comedy"));
        books.add(new Book(13, "C003", "The Clumsy Detective", true, false, "Comedy"));
        books.add(new Book(14, "C004", "Bananas Everywhere", true, false, "Comedy"));
        books.add(new Book(15, "C005", "Prank Wars", false, true, "Comedy"));

        books.add(new Book(16, "HIS001", "The Roman Empire", true, false, "History"));
        books.add(new Book(17, "HIS002", "World War II Chronicles", false, true, "History"));
        books.add(new Book(18, "HIS003", "The Pharaohs of Egypt", true, false, "History"));
        books.add(new Book(19, "HIS004", "The American Revolution", true, false, "History"));
        books.add(new Book(20, "HIS005", "Medieval Europe", false, true, "History"));
    }
    public List<Book> getAllBooks() {
        return books;
    }
    public List<Book> getBooks() {
        return books;
    }


    // Show only available books
    public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book.isCheckedIn()) {
                System.out.println(book.getId() + ") " + book.getTitle() + " [" + book.getCategory() + "]");
            }
        }
    }

    // Show only checked-out books
    public void showCheckedOutBooks() {
        System.out.println("\nChecked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println(book.getId() + ") " + book.getTitle() + " [" + book.getCategory() + "]");
            }
        }
    }

    // Find book by ID
    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Mark book checked out
    public void markBookAsCheckedOut(Book b) {
        b.setCheckedOut(true);
    }

    // Mark book checked in
    public void markBookAsCheckedIn(Book b) {
        b.setCheckedIn(true);
    }
}
