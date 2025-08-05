package com.library.controller;

import com.library.model.Library;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainController {
    @FXML private TabPane mainTabPane;
    @FXML private Tab booksTab;
    @FXML private Tab membersTab;
    @FXML private Tab borrowTab;
    @FXML private Tab returnTab;
    
    private Library library;
    
    public MainController() {
        this.library = new Library();
    }
    
    @FXML
    public void initialize() {
        // Initialize tabs and their controllers
        setupBooksTab();
        setupMembersTab();
        setupBorrowTab();
        setupReturnTab();
    }
    
    private void setupBooksTab() {
        // Will be implemented to show book management interface
    }
    
    private void setupMembersTab() {
        // Will be implemented to show member management interface
    }
    
    private void setupBorrowTab() {
        // Will be implemented to show book borrowing interface
    }
    
    private void setupReturnTab() {
        // Will be implemented to show book return interface
    }
    
    public Library getLibrary() {
        return library;
    }
}
