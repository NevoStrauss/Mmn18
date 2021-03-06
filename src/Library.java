import java.util.HashMap;

public class Library{
    private CustomersDB users; //Hash maps
    private BookDB warehouse;

    //ctr receives full data
    public Library(CustomersDB userData, BookDB bookData){
        users = userData;
        warehouse = bookData;
    }

    //empty ctr
    public Library(){
        users = new CustomersDB();
        warehouse = new BookDB();
    }

    //METHODS
    private void bookBorrow(String lastName,String id, String serialNumber, String operator){
        if(warehouse.books.get(serialNumber) == null){
            Customer newOwner = users.customers.get(id);
            warehouse.books.put(serialNumber,newOwner);
            System.out.println("Book number: "+serialNumber+" is now ......");
        }
        else
            System.out.println("this book is already borrowed....");
    }




    public static void main(String[] args) {
    }
}
