import java.util.LinkedList;

public class Customer {
    private String id;
    private String lastName;
    private LinkedList<Book> borrowed;

    public Customer(String id, String lastName){
        this.id = id;
        this.lastName = lastName;
        borrowed  = new LinkedList<Book>();
    }
}
