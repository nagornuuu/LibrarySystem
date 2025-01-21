# Library System

The **Library System** is a simple Java program designed to manage books across different genres. It provides functionality to add books, display books graphically as a shelf, delete books, and view the total number of books in the library

## Features

1. **Add Books**:
   - Allows users to add books to specific genres (Fiction, Science, History)
   - Each genre can hold a maximum of 5 books

2. **Display Books**:
   - Graphically represents books as a shelf
   - Displays books categorized by genres with empty slots marked clearly

3. **Delete Books**:
   - Enables users to remove a specific book from a genre
   - Adjusts the shelf to ensure no gaps between books

4. **View Total Books**:
   - Displays the total count of books currently stored in the library

5. **Interactive Menu**:
   - Provides an intuitive menu for interacting with the system
   - Options include adding, displaying, deleting books, and exiting the program

## Project Structure

```
LibraryManagementSystem/
├── src/
│   ├── Main.java        # Contains the main menu logic
│   ├── Library.java     # Manages library functionality
│   └── Book.java        # Represents individual books
├── README.md            # Project documentation
└── .git/                # Git version control
```

## Example Interaction

### Menu:
```
Library Management System
1. Add a Book
2. Display Books
3. Delete a Book
4. Total Books in Library
5. Exit
Enter your choice: 1
```

### Adding a Book:
```
Available Genres:
1. Fiction
2. Science
3. History
Select a genre (1-3): 1
Enter the name of the book: The Great Gatsby
Book added successfully.
```

### Displaying Books:
```
Library Shelf:

Genre: Fiction
+-----+-----+-----+-----+-----+
|The G|     |     |     |     |
+-----+-----+-----+-----+-----+

Genre: Science
+-----+-----+-----+-----+-----+
|     |     |     |     |     |
+-----+-----+-----+-----+-----+

Genre: History
+-----+-----+-----+-----+-----+
|     |     |     |     |     |
+-----+-----+-----+-----+-----+
```

### Deleting a Book:
```
Available Genres:
1. Fiction
2. Science
3. History
Select a genre (1-3): 1

Books in Fiction:
1. The Great Gatsby
Select a book to delete (1-1): 1
Book deleted successfully.
```

## Future Enhancements

1. Add support for more genres
2. Implement persistent storage using a database or file system
3. Enhance user interface with a graphical or web-based frontend
4. Include book search and sorting functionality

## Reflection

This project demonstrates the practical application of:
- Java classes and objects
- 2D and 1D arrays for data management
- Using static and final fields for shared and constant values
- Interactive menus with control flow structures

It serves as a beginner-friendly project to understand core Java concepts and their implementation
