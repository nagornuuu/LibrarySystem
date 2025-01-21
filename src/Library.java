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
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + ". " + genres[i]); // display genre options
        }

        System.out.println("Select a Genre (1-" + GENRES + "): ");
        int genreChoice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (genreChoice < 0 || genreChoice > GENRES) {
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

    public static void displayBooks() {
        System.out.println("\nLibrary Books: ");
        for (int i = 0; i < genres.length; i++) {
            System.out.println("Genre: " + genres[i]);
            if (bookAdded[i] == 0) {
                System.out.println(" No Books available");
            } else {
                for (int j = 0; j < bookAdded[i]; j++) {
                    System.out.println("  - " + books[i][j].getName());
                }
            }
        }
    }

    public static void deleteBook(Scanner scanner) {
        System.out.println("\nAvailable Genres: ");
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + ". " + genres[i]);
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
