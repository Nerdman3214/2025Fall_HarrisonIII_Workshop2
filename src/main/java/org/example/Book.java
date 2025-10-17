package org.example;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean checkedIn;
    private boolean checkedOut;
    private String category;

    // Constructor
    public Book(int id, String isbn, String title, boolean checkedIn, boolean checkedOut, String category) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.checkedIn = checkedIn;
        this.checkedOut = checkedOut;
        this.category = category;
    }



    // Getters
    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isCheckedIn() { return checkedIn; }
    public boolean isCheckedOut() { return !checkedIn; }
    public String getCategory() { return category; }

    // Setters
    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedIn = !checkedOut;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", checkedIn=" + checkedIn +
                ", category='" + category + '\'' +
                '}';
    }
}
