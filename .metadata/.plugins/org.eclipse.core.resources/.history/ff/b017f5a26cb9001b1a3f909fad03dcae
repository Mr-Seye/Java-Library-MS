import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Users {
	static int userID;
	String username;
	String surname;
	
	protected class Address {
		int doorNo;
		String postCode;
		String city;
		
	}
	/* Function which belongs to the parent class 'Users' which both customers and admins belong to which prints
	 *  all the books listed in Stock.txt 
	 */
	 static void viewBooks() {
		 // Testing file reading
		 
		/* System.out.println("viewBooks executed.");
		try {
		      File viewBook = new File("Stock.txt");
		      Scanner myReader = new Scanner(viewBook);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] ary = data.split(",");
		        System.out.println("ISBN: " + ary[0] + " "
		        		+ "Book Type: " + ary[1] + " "
		        				+ "Title: " + ary[2] + " "
		        						+ "Language: " + ary[3] + " "
		        								+ "Genre: " + ary[4] + " "
		        										+ "Release Date: " + ary[5] + " "
		        												+ "Retail Price: " + ary[6] + " "
		        														+ "Quantity: " + ary[7] + " "
		        																+ "No. of Pages/Duration(hrs): " + ary[8] + " "
		        																		+ "Condition/Format :" + ary[9]);
		      }
		      myReader.close();
		      System.out.println("Finished.");
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } */ 
		
	}
	public static void main(String[] args) {
		
		// viewBooks(); Testing file reading

	}

}

class customer extends Users {
	
	// Attempt to describe the shopping basket as an object
	private class ShoppingBasket {
		int numberOfItems;
		double totalPrice;
		
		
		
		
	}
	// Methods which would allow the customer to perform their different actions
	static void addBookToBasket() {
			
	}
		
	static void purchaseItems() {
		
	}
	static void cancelBasket() {
		
	}
}

class admin extends Users {
	// admin constructor
	public admin(int userID, String username, String surname, int doorNo, String postCode, String city) {
		userID = 101;
	}
	// Methods which would allow the customer to perform their different actions
	static void newBookPaperback() {
		
	}
	static void newBookEbook() {
		
	}
	static void newBookAudiobook() {
	
}
	public static void main(String[] args) {
		// viewBooks();
		// newBook();

	}
}

