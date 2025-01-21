import java.util.Scanner;

public class Library {
    // constants
    private static final int MAX_BOOKS = 5; // The number of maximum books in each genre
    private static final int GENRES = 3;    // The Number of genres in a system

    // Fields
    private static Book[][] books = new Book[MAX_BOOKS][MAX_BOOKS];     // 2D array in which we store the books
    private static String[] genres = {"Fiction", "Science", "History"}; // Array where we store genres
    private static int[] bookAdded = new int[GENRES]; // thankfully to this variable , we can track the number of books added to genre
    protected static int totalBooks = 0;  // Track the number of books in the library

    public static void addBook(Scanner scanner) {
        System.out.println("\n Available Genres: ");
        int index = 1;
        for (String genre : genres) {
            System.out.println(index + ". " + genre);
            index++;
        }
        System.out.println("Select a Genre (1-" + GENRES + "): ");
        int genreChoice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (genreChoice < 0 || genreChoice >= GENRES) {
            System.out.println("Invalid Genre Choice. Try again");
            return;
        }

        if (bookAdded[genreChoice] >= MAX_BOOKS) {
            System.out.println("The genre is full of books. We cannot add more books");
            return;
        }

        System.out.println("Enter the name of the book: ");
        String bookName = scanner.nextLine();

        books[genreChoice][bookAdded[genreChoice]] = new Book(bookName, genres[genreChoice]);
        bookAdded[genreChoice]++;
        totalBooks++;
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
                if (j < bookAdded[i] && books[i][j] != null) {
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

    public static void deleteBook(Scanner scanner) {
        System.out.println("\nAvailable Genres: ");
        int index = 1;
        for (String genre : genres) {
            System.out.println(index + ". " + genre);
            index++;
        }
        System.out.print("Select a genre (1-" + GENRES + "): ");
        int genreChoice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (genreChoice < 0 || genreChoice >= GENRES) {
            System.out.println("Invalid Genre Choice. Try again");
            return;
        }

        if (bookAdded[genreChoice] == 0) {
            System.out.println("No Books available in this genre");
            return;
        }

        System.out.println("\nBooks in " + genres[genreChoice] + ":");
        for (int i = 0; i < bookAdded[genreChoice]; i++) {
            System.out.println((i + 1) + ". " + books[genreChoice][i].getName());
        }
        System.out.print("Select a book to delete (1-" + bookAdded[genreChoice] + "): ");
        int bookToDelete = scanner.nextInt() - 1;
        scanner.nextLine();

        if (bookToDelete < 0 || bookToDelete >= bookAdded[genreChoice]) {
            System.out.println("Invalid Book To Delete. Try again");
            return;
        }

        for (int i = bookToDelete; i < bookAdded[genreChoice] - 1; i++) {
            books[genreChoice][i] = books[genreChoice][i + 1];
        }
        books[genreChoice][bookAdded[genreChoice] - 1] = null;
        bookAdded[genreChoice]--;
        totalBooks--;
        System.out.println("Book deleted successfully");
    }
}
