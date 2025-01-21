import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary System: "
                                + "\n1. Add a book"
                                + "\n2. Display all books"
                                + "\n3. Delete a book"
                                + "\n4. Total books in a library"
                                + "\n5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Library.addBook(sc);
                    break;
                case 2:
                    Library.displayBooks();
                    break;
                case 3:
                    Library.deleteBook(sc);
                    break;
                case 4:
                    System.out.println("\nTotal books in a library: " + Library.totalBooks);
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