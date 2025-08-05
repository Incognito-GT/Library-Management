package com.library.model;

import java.time.LocalDate;

public class BorrowRecord {
    private static final int BORROW_DAYS = 14;
    
    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean returned;

    public BorrowRecord(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(BORROW_DAYS);
        this.returned = false;
    }

    // Getters
    public Member getMember() { return member; }
    public Book getBook() { return book; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isReturned() { return returned; }
    public boolean isOverdue() { 
        return !returned && LocalDate.now().isAfter(dueDate);
    }
    
    public void returnBook() {
        if (!returned) {
            this.returnDate = LocalDate.now();
            this.returned = true;
        }
    }
    
    public int calculateFine() {
        if (!isOverdue()) {
            return 0;
        }
        // Simple fine calculation: $1 per day overdue
        return (int) (LocalDate.now().toEpochDay() - dueDate.toEpochDay()) * 1;
    }
}
