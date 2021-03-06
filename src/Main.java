import java.util.Scanner;

public class Main {
    private static final String ADD = "+";
    private static final String REMOVE = "-";
    private static final String QUERY = "?"; //assuming there is a space after it every time
    private static final String MAX_BOOKS = "!";
    private static final String QUIT = "Quit";

    private static final Library library = new Library();

    public static void main(String[] args) {

        for (int i = 1000; i < 1100; i++) {
            String s = "ab" + i;
            library.addBook(s);
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            String prm1, prm2, prm3, prm4;
            System.out.println("Please insert queries or commands you would like to execute. To quit this program, please enter " + QUIT);

            //starting to get the commands from the user
            prm1 = scan.next();

            //as long as the user does not want to quit this program
            if (prm1.equals(QUIT))
                break;

            else if (prm1.equals(ADD)) { //the user wants to add a new costumer to the Costumers DataBase
                prm2 = scan.next(); // getting the costumer's last name
                prm3 = scan.next(); // getting the costumer's id number
                library.addCustomer(prm2, prm3);
            }

            else if (prm1.equals(REMOVE)) { //the user wants to delete a costumer from the Costumers DataBase
                prm2 = scan.next(); // getting the costumer's last name
                prm3 = scan.next(); // getting the costumer's id number
                library.removeCustomer(prm3);
            }

            //queries
            else if (prm1.equals(QUERY)) { //the user want to ask a query
                prm2 = scan.next();
                if (prm2.charAt(0) >= 48 && prm2.charAt(0) <= 57) { //this is a number-> the user wants to check which books are loaned by a costumer with this id number
                    library.loanedBooksByCustomer(prm2);
                } else if (prm2.charAt(0) >= 65 && prm2.charAt(0) <= 90 || prm2.charAt(0) >= 97 && prm2.charAt(0) <= 122) { //this is a letter -> the user wants to check who is the costumer who loaned the book with this number identificator
                    System.out.println(prm2);
                    library.getCustomerByBook(prm2);
                } else if (prm2.equals(MAX_BOOKS)) {// the user wants to check who are the costumers who are loaning the highest numbers of books, at the moment
                    library.getMaxloaned();
                }
            }
            else { //the user wants to loan or return a costumer's book
                prm2 = scan.next(); // costumer's id
                prm3 = scan.next(); // book's serial number
                prm4 = scan.next(); //operator: + for loaning, - for returning

                if (prm4.equals(ADD))// the costumer wants to loan a book
                    library.bookBorrow(prm2, prm3);

                else if (prm4.equals(REMOVE)) // the costumer wants to returm a book
                    library.bookReturn(prm2, prm3);
            }
        }
    }
}