public class Book {
    private String serialNumber;
    private Customer owner;

    public Book(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public Book(String serialNumber, Customer owner){
        this.serialNumber = serialNumber;
        this.owner = owner;
    }
}
