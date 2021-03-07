import java.util.HashMap;

public class CustomersDB {
    private HashMap<String,Customer> customers;

    public CustomersDB(){
        customers = new HashMap<String,Customer>();
    }
    public HashMap<String,Customer> getCustomers(){
        return customers;
    }
}
