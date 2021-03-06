import java.util.LinkedList;

public class Library{
    private final CustomersDB users; //Hash maps
    private final BookDB warehouse;

    //empty ctr
    public Library(){
        users = new CustomersDB();
        warehouse = new BookDB();
    }

    public CustomersDB getCustomersDB(){
        return users;
    }

    public BookDB getBookDB(){
        return warehouse;
    }


    //METHODS
    public void bookBorrow(String id, String serialNumber){
        Book toBorrow = warehouse.books.get(serialNumber);
        if(!toBorrow.isBorrowed){ //not borrowed
            if (users.customers.get(id).getLoanedBooks().size()<10) { //loaned less than 10 books
                Customer loaner = users.customers.get(id);
                toBorrow.setOwner(loaner);  //set new owner to this book
                toBorrow.isBorrowed = true;
                loaner.getLoanedBooks().add(toBorrow);//add the book to the customer's linkedlist of borrowed books
                System.out.println("Book number: " + serialNumber + " is now loaned to "+loaner.toString());
            }
            else
                System.out.println("this customer has 10 books");
        }
        else
            System.out.println("this book is already borrowed....");
    }


    public void bookReturn(String id, String serialNumber){
        Book toReturn = warehouse.books.get(serialNumber);
        Customer returner = users.customers.get(id);
        if (toReturn.getOwner().equals(returner)){ //this book belongs to this customer
            returner.getLoanedBooks().remove(toReturn); //remove book from the borrowed book of the customer
            toReturn.setOwner(null); //update the owner of the book
            toReturn.isBorrowed = false; //update state of book
        }
        else
            System.out.println("this books isnt loaned to this customer");
    }

    public void addCustomer(String id, String lastName){
        Customer newCustomer = new Customer(id, lastName); //create new customer
        users.customers.put(id,newCustomer); //add to hash map database
    }

    public void removeCustomer (String id){
        Customer toLeave = users.customers.get(id);
        if (toLeave.getLoanedBooks().isEmpty())//returned all their books
            users.customers.remove(id);//remove costumer
        else
            System.out.println("Please return all of your books!!!");
    }

    public LinkedList<Book> loanedBooksByCustomer(String id){
        LinkedList<Book> loanedBooks = users.customers.get(id).getLoanedBooks();
        for (Book book:loanedBooks) {
            System.out.println(book.toString(book));
        }
        return loanedBooks;
    }

    public Customer getCustomerByBook(String serialNumber){
        Customer owner = users.customers.get(serialNumber);
        if (!warehouse.books.get(serialNumber).getIsBorrowed()) {//book nor borrowed
            System.out.println("book nor borrowed");
        }
        else
            System.out.println("the owner is: "+owner.toString());
        return owner;
    }

    public LinkedList<Customer> getMaxloaned(){
        Integer maxNumber = findMax();
        LinkedList<Customer> maxOwnerList = maxOwnerList(maxNumber);
        for (Customer c:maxOwnerList) {
            System.out.println(c.toString(c));
        }
        return maxOwnerList;
    }

    //finds the number of the maximum books loaned by any of that customers
    private Integer findMax(){
        int max=0;
        for (Customer c:users.customers.values()) {
            int currMax = c.getLoanedBooks().size();
            if (currMax>max)
                max = currMax;
        }
        return max;
    }

    //returns a list of all the customers having max number of books loaned
    private LinkedList<Customer> maxOwnerList(Integer max){
        LinkedList<Customer> maxOwnerList = new LinkedList<Customer>();
        for (Customer c:users.customers.values()) {
            if (c.getLoanedBooks().size()==max){
                maxOwnerList.add(c);
            }
        }
        return maxOwnerList;
    }

}
