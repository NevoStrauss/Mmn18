import java.util.HashMap;

public class BookDB {
    private final HashMap<String,Book> books;

    public BookDB(){
        books = new HashMap<>();
    }

    public HashMap<String,Book> getBooks(){
        return books;
    }
}
