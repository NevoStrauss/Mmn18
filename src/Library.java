import java.util.LinkedList;

public class Library{
    private final CustomersDB users; //Hash maps
    private final BookDB warehouse;

    //empty ctr
    public Library(){
        users = new CustomersDB();
        warehouse = new BookDB();
    }

    //getters
    public CustomersDB getCustomersDB(){
        return users;
    }

    public BookDB getBookDB(){
        return warehouse;
    }


    //METHODS
    //This method updates the
    public void bookBorrow(String id, String serialNumber){
        Book toBorrow = warehouse.books.get(serialNumber);
        if(!toBorrow.isBorrowed){ //not borrowed
            if (users.customers.get(id).getLoanedBooks().size()<10) { //loaned less than 10 books
                Customer loaner = users.customers.get(id);//new Owner
                if (loaner != null) {
                    toBorrow.setOwner(loaner);  //set new owner to this book
                    toBorrow.isBorrowed = true;
                    loaner.getLoanedBooks().add(toBorrow);//add the book to the customer's linkedlist of borrowed books
                    System.out.println("Book number: " + serialNumber + " is now loaned to " + loaner.toString(loaner));
                }
                else
                    System.out.println("Customer is null");
            }
            else
                System.out.println("this customer has 10 books already");
        }
        else
            System.out.println("this book is already borrowed....");
    }


    public void bookReturn(String id, String serialNumber){
        Book toReturn = warehouse.books.get(serialNumber); //Book to return
        Customer returner = users.customers.get(id);       //Customer wishes to return
        if (toReturn!=null && returner!=null) {
            if (toReturn.getIsBorrowed() && toReturn.getOwner().equals(returner)) { //this book belongs to this customer
                returner.getLoanedBooks().remove(toReturn); //remove book from the borrowed book of the customer
                toReturn.setOwner(null); //update the owner of the book
                toReturn.isBorrowed = false; //update state of book
                System.out.println("Book: "+toReturn.toString(toReturn)+" returned by: "+returner.toString(returner));
            }
            else
                System.out.println("this books isn't loaned to this customer");
        }
        else
            System.out.println("Customer or Book is null");
    }

    public void addCustomer(String lastName, String id){
        Customer newCustomer = new Customer(id, lastName); //create new customer
        if (users.customers.containsKey(id))
            System.out.println("Customer: "+newCustomer.toString(newCustomer)+" is already in the system");
        else {
            users.customers.put(id,newCustomer); //add to hash map database
            System.out.println("Customer: "+newCustomer.toString(newCustomer)+" added to the system");
        }
    }

    public void addBook(String serialNumber){
        Book toAdd = new Book(serialNumber);
        warehouse.books.put(serialNumber,toAdd);
    }

    public void removeCustomer (String id) {
        Customer toLeave = users.customers.get(id);
        if (toLeave != null) {
            if (toLeave.getLoanedBooks().isEmpty()) {//returned all their books
                users.customers.remove(id);        //remove costumer
                System.out.println("Customer "+ toLeave.toString(toLeave)+" removed from the system");
            }
                else
                System.out.println("Please return all of your books!!!");
        }
        else {
            System.out.println("Customer: "+toLeave.toString(toLeave)+" is null");
        }
    }

    //QUERIES

    public LinkedList<Book> loanedBooksByCustomer(String id) {
        System.out.println("Which books are loaned by: "+id+"?");
        if (users.customers.get(id) != null) {
            LinkedList<Book> loanedBooks = users.customers.get(id).getLoanedBooks();
            for (Book book : loanedBooks) {
                System.out.println(book.toString(book));
            }
            return loanedBooks;
        }
        else {
            System.out.println("id doesn't exist");
            return null;
        }
    }

    public Customer getCustomerByBook(String serialNumber){
        System.out.println("Which customer loaned the book number: "+serialNumber+"?");
        if (warehouse.books.get(serialNumber)==null){
            System.out.println("This book doesn't exist in the library");
            return null;
        }
        Customer owner = warehouse.books.get(serialNumber).getOwner();
        if (!warehouse.books.get(serialNumber).getIsBorrowed()) {//book not borrowed
            System.out.println("book not borrowed");
        }
        else
            System.out.println("the owner is: "+owner.toString(owner));
        return owner;
    }

    public LinkedList<Customer> getMaxloaned(){
        System.out.println("Who are the customers who loaned the maximum number of books?");
        Integer maxNumber = findMax(); //maximum books loaned by any of that customers
        System.out.println("The maximum amount of loaned books is: "+maxNumber);
        System.out.println("The customers who loaned them are:");
        LinkedList<Customer> maxOwnerList = maxOwnerList(maxNumber);
        for (Customer c:maxOwnerList) { //print all costumer with the highest amount of loaned books
            System.out.println(c.toString(c));
        }
        return maxOwnerList;
    }

    //finds the number of the maximum books loaned by any of that customers
    private Integer findMax(){
        int max=0;
        for (Customer c:users.customers.values()) {
            if (c.getLoanedBooks() != null) { //there are books in this customers list
                int currMax = c.getLoanedBooks().size();
                if (currMax > max)
                    max = currMax;
            }
        }
        return max;
    }

    //returns a list of all the customers having max number of books loaned
    private LinkedList<Customer> maxOwnerList(Integer max){
        LinkedList<Customer> maxOwnerList = new LinkedList<>();
        for (Customer c:users.customers.values()) {
            if (c.getLoanedBooks() != null) {
                if (c.getLoanedBooks().size() == max) {
                    maxOwnerList.add(c);
                }
            }
        }
        return maxOwnerList;
    }
}
