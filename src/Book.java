public class Book {
    private String serialNumber;
    private Customer owner;
    boolean isBorrowed;

    public Book(String serialNumber){
        this.serialNumber = serialNumber;
        owner = null;
        isBorrowed = false;
    }

    public Book(String serialNumber, Customer owner){
        this.serialNumber = serialNumber;
        this.owner = owner;
        isBorrowed = true;
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    public Customer getOwner(){
        return owner;
    }

    public boolean getIsBorrowed(){
        return isBorrowed;
    }

    public void setSerialNumber(String newSerialNumber){
        serialNumber=newSerialNumber;
    }

    public void setOwner(Customer newOwner){
        owner=newOwner;
    }

    public void setBorrowed(boolean newState){
        isBorrowed=newState;
    }

    public String toString(Book book){
        return "["+book.serialNumber+"] ";
    }
}
