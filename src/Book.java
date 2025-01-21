/**
 * Class which represents a book
 */
public class Book {
    private String name;
    private String genre;

    // Contructor which initialize book details
    public Book (String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    // Getter which return book name
    public String getName() {
        return name;
    }

    // Getter which return book genre
    public String getGenre() {
        return genre;
    }
}
