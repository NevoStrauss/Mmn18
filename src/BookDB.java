import java.util.HashMap;

public class BookDB {
    private HashMap<String,Book> books;

    public BookDB(){
        books = new HashMap<String,Book>();
    }

    public HashMap<String,Book> getBooks(){
        return books;
    }
}
