import java.util.Scanner;

public class Main {
    private static final String ADD = "+";
    private static final String REMOVE = "-";
    private static final String QUERY = "?";
    private static final String MAX_BOOKS = "!";
    private static final String QUIT = "Quit";

    private static final Library library = new Library();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String prm1, prm2, prm3, prm4;

        System.out.println("Please insert queries or commans you would like to execute. To quit this program, please enter " + QUIT);

        //starting to get the commands from the user
        prm1 = scan.next();

        //as long as the user does not want to quit this program
        while (!prm1.equals(QUIT)) {

            if (prm1.equals(ADD)) { //the user wants to add a new costumer to the Costumers DataBase
                prm2 = scan.next(); // getting the costumer's last name
                prm3 = scan.next(); // getting the costumer's id number
                library.addCustomer(prm2, prm3);
            }
            for (Customer customer:library.getCustomersDB().customers.values()) {
                System.out.println(customer.toString(customer));
            }


//			else if (prm1.equals(REMOVE){ //the user wants to delete a costumer from the Costumers DataBase
//                prm2 = scan.next(); // getting the costumer's last name
//                prm3 = scan.next(); // getting the costumer's id number
//                costumers.removeCostumer (prm2,prm3);
//            }
//
//			else if (prm1.equals(QUERY)) { //the user want to ask a query
//                prm2 = scan.next();
//
//                if (prm2.charAt(0)>= 48 && prm2.charAt(0)<=57) { //this is a number-> the user wantes to check which books are loaned by a costumer with this id number
//                    Costumers.loanedBooks(prm2);
//                }
//
//                else if { (prm2.charAt(0)>=65 && prm2.charAt(0)<=90) //this is a letter -> the user wants to check who is the costumer who loaned the book with this number identificator
//                    Books.loanedBy(prm2);
//                }
//
//				else if (prm2.equals(MAX_BOOKS)){// the user wants to check who are the costumers who are loaning the highest numbers of books, at the moment
//                    Costumers.maxLoan();
//                }
//
//                else { //the user wants to loan or return a costumer's book
//                    prm2 = scan.next();
//                    prm3 = scan.next();
//                    prm4 = scan.next();
//
//				/*Client client = clients.findClient(param2, param1);
//                Book book = books.findBook(param3);
//
//
//				// if book isn't on the shelf, add it
//                if (book == null) {
//                	book = books.addBook(param3);
//                }
//
//				*/// !!!! C H E C K !!!!
//
//                    if (prm4.equals(ADD){// the user wants loan a book to this costumer
//
//                        costumer.addBook(prm3);
//                        book.setCostumer(prm2);
//
//                    }
//
//
//                }
//            }
//
//
//        }
//
//    }

        }
    }
}