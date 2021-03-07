import java.util.HashMap;

public class CustomersDB {
    private final HashMap<String,Customer> customers;

    public CustomersDB(){
        customers = new HashMap<>();
    }
    public HashMap<String,Customer> getCustomers(){
        return customers;
    }
}
