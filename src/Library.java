import java.util.Scanner;
/**
 * Class which represent a Library
 */
public class Library {
    // constants
    private static final int MAX_BOOKS = 5; // The number of maximum books in each genre
    private static final int GENRES = 3;    // The Number of genres in a system

    // Fields
    private static Book[][] books = new Book[GENRES][MAX_BOOKS];     // 2D array in which we store the books
    private static String[] genres = {"Fiction", "Science", "History"}; // Array where we store genres
    private static int[] booksAdded = new int[GENRES]; // thankfully to this variable , we can track the number of books added to genre
    protected static int totalBooks = 0;  // Track the number of books in the library

    /**
     * Adds a book to the library
     * @param sc object for user input
     */
    public static void addBook(Scanner sc) {
        System.out.println("\n Available Genres: ");

        // Display the genre options
        int index = 1;
        for (String genre : genres) {
            System.out.println(index + ". " + genre);
            index++;
        }

        System.out.println("Select a Genre (1-" + GENRES + "): ");
        int genreChoice = sc.nextInt() - 1; // added - 1 to avoid 0
        sc.nextLine();

        // here we validate genre selection
        if (genreChoice < 0 || genreChoice >= GENRES) {
            System.out.println("Invalid Genre Choice. Try again");
            return; // exit the method if input is not right
        }

        // here we check if genre has the space for more books
        if (booksAdded[genreChoice] >= MAX_BOOKS) {
            System.out.println("The genre is full of books. We cannot add more books");
            return; // exit the method if input is not right
        }

        System.out.println("Enter the name of the book: ");
        String bookName = sc.nextLine();

        // here we are adding book to 2D array
        // genreChoice - zero-based index which represents the genre chosen by user
        // bookAdded[genreChoice] - the next empty slot in that genre
        books[genreChoice][booksAdded[genreChoice]] = new Book(bookName, genres[genreChoice]);
        booksAdded[genreChoice]++;  // increment the count of book in the genre
        totalBooks++;               // increment the total number of books
        System.out.println("Book added successfully");
    }

    // Method to display all books in the library graphically
    public static void displayBooks() {
        System.out.println("\nLibrary Shelf:");
        for (int i = 0; i < genres.length; i++) {
            System.out.println("\nGenre: " + genres[i]); // Display genre name
            System.out.print("+");
            for (int k = 0; k < MAX_BOOKS; k++) {
                System.out.print("-----+"); // Top border of the shelf
            }
            System.out.println();

            // Display book slots for the current genre
            System.out.print("|");
            for (int j = 0; j < MAX_BOOKS; j++) {
                if (j < booksAdded[i] && books[i][j] != null) {
                    // %-5s| - ensures that book name can be consisted of max 5 characters in the shelf display
                    // i - representation of genre index(Fiction, Science)
                    // j - representation of the position of a specific book
                    // Math.min() - This ensures that the substring operation does not go out of bounds if the name is shorter than 5 characters
                    System.out.printf("%-5s|", books[i][j].getName().substring(0, Math.min(5, books[i][j].getName().length())));
                } else {
                    System.out.print("     |"); // Empty slot
                }
            }
            System.out.println();

            // Bottom border of the shelf
            System.out.print("+");
            for (int k = 0; k < MAX_BOOKS; k++) {
                System.out.print("-----+");
            }
            System.out.println();
        }
    }

    /**
     * Deletes a book from the library
     * @param scanner Scanner object for user input
     */
    public static void deleteBook(Scanner scanner) {
        System.out.println("\nAvailable Genres: ");

        // Display the genre options
        int index = 1;
        for (String genre : genres) {
            System.out.println(index + ". " + genre);
            index++;
        }

        System.out.print("Select a genre (1-" + GENRES + "): ");
        int genreChoice = scanner.nextInt() - 1; // added - 1 to avoid 0
        scanner.nextLine();

        // Validate genre selection
        if (genreChoice < 0 || genreChoice >= GENRES) {
            System.out.println("Invalid Genre Choice. Try again");
            return;
        }

        // Check if there are any books to delete in the genre
        if (booksAdded[genreChoice] == 0) {
            System.out.println("No Books available in this genre");
            return;
        }

        // Display the books in the selected genre
        System.out.println("\nBooks in " + genres[genreChoice] + ":");
        for (int i = 0; i < booksAdded[genreChoice]; i++) {
            System.out.println((i + 1) + ". " + books[genreChoice][i].getName());
        }

        System.out.print("Select a book to delete (1-" + booksAdded[genreChoice] + "): ");
        int bookToDelete = scanner.nextInt() - 1; // added - 1 to avoid 0
        scanner.nextLine();

        // Validate book selection to delete
        if (bookToDelete < 0 || bookToDelete >= booksAdded[genreChoice]) {
            System.out.println("Invalid Book To Delete. Try again");
            return;
        }

        // Remove the book and shift remaining books to fill the gap
        for (int i = bookToDelete; i < booksAdded[genreChoice] - 1; i++) {
            books[genreChoice][i] = books[genreChoice][i + 1];
        }

        books[genreChoice][booksAdded[genreChoice] - 1] = null; // Clear the last book
        booksAdded[genreChoice]--;  // decrement the count of books in the genre
        totalBooks--;               // decrement the total number of books
        System.out.println("Book deleted successfully");
    }
}
