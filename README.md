# Library Management System

A Java-based Library Management System with a JavaFX GUI for managing books, members, and book borrowing/returning operations.

## Features

- **Book Management**: Add, search, and manage books in the library
- **Member Management**: Add and manage library members
- **Borrowing System**: Track book borrowing and returns
- **Overdue Tracking**: Automatic calculation of overdue books and fines
- **User-Friendly Interface**: Intuitive JavaFX-based GUI


1. **Clone the repository**
   ```bash
   git clone [repository-url]
   cd LibraryManagementSystem
   ```

2. **Compile the project**
   ```bash
   javac --module-path "path-to-javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml -d out/production/LibraryManagementSystem src/main/java/com/library/*.java src/main/java/com/library/controller/*.java src/main/java/com/library/model/*.java
   ```

3. **Run the application**
   ```bash
   java --module-path "path-to-javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml -cp out/production/LibraryManagementSystem com.library.MainApp
   ```

## Project Structure

```
src/
  main/
    java/
      com/
        library/
          MainApp.java
          controller/
            MainController.java
          model/
            Book.java
            Member.java
            BorrowRecord.java
            Library.java
    resources/
      main.fxml
```

## Usage

1. **Books Tab**:
   - Search for books by title, author, or ISBN
   - Add new books to the library
   - View book availability

2. **Members Tab**:
   - Search for members
   - Add new members to the system
   - View member details and borrowed books

3. **Borrow Book Tab**:
   - Enter member ID and book ISBN
   - Process book borrowing
   - View due dates

4. **Return Book Tab**:
   - Find borrowed books by member ID
   - Process book returns
   - Calculate and display any overdue fines

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
