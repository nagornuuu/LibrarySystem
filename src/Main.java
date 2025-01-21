import java.util.Scanner;

// Main class for the interactive menu
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        boolean running = true; // flag to control the menu loop

        while (running) {
            // Display the menu option
            System.out.println("\nLibrary System: "
                                + "\n1. Add a book"
                                + "\n2. Display all books"
                                + "\n3. Delete a book"
                                + "\n4. Total books in a library"
                                + "\n5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            // Handle user choice using switch-case
            switch (choice) {
                case 1:
                    Library.addBook(sc); // add a book
                    break;
                case 2:
                    Library.displayBooks(); // display all book
                    break;
                case 3:
                    Library.deleteBook(sc); // Delete a book
                    break;
                case 4:
                    System.out.println("\nTotal books in a library: " + Library.totalBooks); // Display total count of books
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }
}