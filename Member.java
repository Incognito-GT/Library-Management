package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private List<BorrowRecord> borrowedBooks;

    public Member(String memberId, String name, String email, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and Setters
    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public List<BorrowRecord> getBorrowedBooks() { return borrowedBooks; }
    
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            BorrowRecord record = new BorrowRecord(this, book);
            borrowedBooks.add(record);
            book.decrementAvailable();
        }
    }
    
    public boolean returnBook(Book book) {
        for (BorrowRecord record : borrowedBooks) {
            if (record.getBook().equals(book) && !record.isReturned()) {
                record.returnBook();
                book.incrementAvailable();
                return true;
            }
        }
        return false;
    }
}
