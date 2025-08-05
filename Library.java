package com.library.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, Member> members;
    private List<BorrowRecord> borrowRecords;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.borrowRecords = new ArrayList<>();
    }

    // Book management
    public void addBook(Book book) {
        if (!books.containsKey(book.getIsbn())) {
            books.put(book.getIsbn(), book);
        } else {
            // If book exists, just increase the quantity
            Book existingBook = books.get(book.getIsbn());
            existingBook.setQuantity(existingBook.getQuantity() + book.getQuantity());
            existingBook.setAvailable(existingBook.getAvailable() + book.getQuantity());
        }
    }

    public Book findBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        String searchQuery = query.toLowerCase();
        
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(searchQuery) ||
                book.getAuthor().toLowerCase().contains(searchQuery) ||
                book.getIsbn().toLowerCase().contains(searchQuery)) {
                results.add(book);
            }
        }
        return results;
    }

    // Member management
    public void addMember(Member member) {
        if (!members.containsKey(member.getMemberId())) {
            members.put(member.getMemberId(), member);
        }
    }

    public Member findMemberById(String memberId) {
        return members.get(memberId);
    }

    // Borrow and return operations
    public boolean borrowBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);
        
        if (member != null && book != null && book.isAvailable()) {
            member.borrowBook(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);
        
        if (member != null && book != null) {
            return member.returnBook(book);
        }
        return false;
    }

    // Getters
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    public List<BorrowRecord> getBorrowRecords() {
        return new ArrayList<>(borrowRecords);
    }
}
