import java.util.LinkedList;

public class Customer {
    private String id;
    private String lastName;
    private LinkedList<Book> loanedBooks;

    public Customer(String id, String lastName){
        this.id = id;
        this.lastName = lastName;
        loanedBooks = new LinkedList<Book>();
    }

    public String getId(){
        return id;
    }

    public String getLastName(){
        return lastName;
    }

    public LinkedList<Book> getLoanedBooks(){
        return loanedBooks;
    }

    public void setId(String newID){
        id=newID;
    }

    public void setLastName(String newLastName){
        lastName=newLastName;
    }

    public void setLoanedBooks(LinkedList<Book> newBorrowedBooks){
        loanedBooks =newBorrowedBooks;
    }

    public boolean equals(Customer other){
        if (other==null)
            throw new IllegalArgumentException("ELEMENT IS NUULLLL");
        return id.equals(other.id) & lastName.equals(other.lastName);
    }

    public String toString(Customer customer){
        String id = customer.id;
        String lastName = customer.lastName;
        return "[ID: "+id+" last name: "+lastName+"] ";
    }
}
