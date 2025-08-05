package com.library.model;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private int quantity;
    private int available;

    public Book(String isbn, String title, String author, int publicationYear, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
        this.available = quantity;
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public int getAvailable() { return available; }
    public void setAvailable(int available) { this.available = available; }
    
    public boolean isAvailable() {
        return available > 0;
    }
    
    public void incrementAvailable() {
        if (available < quantity) {
            available++;
        }
    }
    
    public void decrementAvailable() {
        if (available > 0) {
            available--;
        }
    }
}
