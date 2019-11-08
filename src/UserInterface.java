import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class UserInterface {
	AccountParser AP = new AccountParser();
	MediaParser MP = new MediaParser();
	ArrayList<Media> item;
	String decision;
	ArrayList<Account> loggedInAccount = AP.parseAccount();
	Account MainAccount;
	Scanner input = new Scanner(System. in);
	public void front() throws IOException, ParseException {
		Scanner input = new Scanner(System. in);
		System.out.println("\nPlease type in the following number corresponding to the action");
		System.out.println("__________________________________");
		System.out.println("\n1:Login\n2:Register\n3:Guest Login\n4:Exit");
		System.out.println("__________________________________\n");				
		int choice = input.nextInt();
		
		if (choice == 1) {
			Login();			
		}
		else if (choice == 2) {
			Register();
		}
		else if (choice == 3) {
			checkoutUI();
		} 
		else if (choice == 4) {
			System.exit(0);
		} 	
		else{
			System.out.println("invalid input");
			front();
		}
	}
	public void Login() throws IOException {
		boolean found = false;
		System.out.println("Enter ID");
		String ID = input.next();
		System.out.println("Password");
		String Password = input.next();
		
		for (int i = 0; i < loggedInAccount.size(); i++) {
			String iD = loggedInAccount.get(i).getId();
			String passwordMatch = loggedInAccount.get(i).getPasswordString();
			String name = loggedInAccount.get(i).getName();
			String type = loggedInAccount.get(i).getType();
			if (passwordMatch.equals(Password) && iD.equals(ID)) {
				MainAccount = loggedInAccount.get(i);
				System.out.println("Your're logged in as " + name + " as an " + type);
				if (type.equals("AverageUser")) {
					averageUserUI();
					
				}
				if (type.equals("Librarian")) {
					
					librarianUI();
				}
				found = true;
			}
				
			if (i == loggedInAccount.size()-1 && found == false){
				System.out.println("Wrong ID or Password");
				Login();
			}
			
				
				
			}
		}
	
	@SuppressWarnings("unchecked")
	public void Register() throws IOException, ParseException {
			/**
			 * Register Methods
			 */
		System.out.println("Please enter your name");
		String name = input.next();
		System.out.println("Please enter your age");
		long age = input.nextInt();
		System.out.println("Please type in your desired ID");
		String ID = input.next();
		System.out.println("Please type your desired password.\n");
		String password = input.next();
		System.out.println("Please type in your email\n");
		String email = input.next();	
		JSONObject obj = new JSONObject();
		ArrayList<Account> accounts = AP.parseAccount();
		
		JSONArray arr = new JSONArray();
		JSONObject item1 = new JSONObject();
		item1.put("age", age);
		item1.put("Balance", 0.0);
	    item1.put("email", email);
	    item1.put("id", ID);
	    item1.put("isFlagged", false);
	    item1.put("maxCheckout", 15);
	    item1.put("name", name);
	    item1.put("password", password);
	    item1.put("type", "AverageUser");
	    arr.add(item1);
		
		for (int i = 0; i < accounts.size(); i++) {
			JSONObject item0 = new JSONObject();
			item0.put("age",accounts.get(i).getAge());
			item0.put("Balance",accounts.get(i).getBalance());
			item0.put("email", accounts.get(i).getEmail());
			item0.put("id", accounts.get(i).getId());
			item0.put("isFlagged",accounts.get(i).isFlagged());
			item0.put("maxCheckout",accounts.get(i).getMaxCheckout());
			item0.put("name", accounts.get(i).getName());
			item0.put("type", accounts.get(i).getType());
			item0.put("password", accounts.get(i).getPasswordString());
			arr.add(item0);
			obj.put("account",arr);
		}
		 
		
	 
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("accountDatabase.json")) {
			
			  file.write(obj.toString());
			
			System.out.println("Successfully Added onto Database File...");
			
		}
	}
	
	public void GuestLogin() {
		String decision;
		System.out.println("Would you like to...\nSearch");
		decision = input.next();
		if (decision.equalsIgnoreCase("Search")) {
			System.out.println("Enter the item title");
			input.nextLine();
			String title = input.nextLine();
			MP.search(title);		
		}
	}
	
	public void averageUserUI() {
		
		System.out.println("Would you like to...\nSearch\nView Fines\nView Waitlist\nCheckout");
		decision = input.next();
		if (decision.equalsIgnoreCase("Search")) {
			searchUI();				
		}
		else if (decision.equalsIgnoreCase("checkout")) {
			checkoutUI();	
		}
		
		else if (decision.equalsIgnoreCase("Pay Fines")) {
			
		} 
		else {
			System.out.println("invalid input");
			averageUserUI();
		}
		
		
	}
		
	public void librarianUI() throws IOException {
		
		System.out.println("Would you like to...\n1:Search\n2:Checkout\n3:Add Media\n4:Remove Media\n5:Access Accounts\n6:Add Account\n7:Remove Account");
		int choice = input.nextInt();
		if (choice == 1) {
			searchUI();						
		}
		if (choice == 2) {
			checkoutUI();
		}
		if (choice ==3) {
			MP.addMediaDatabase();
		}
		if (choice == 5) {
			
		}
		if (choice == 6) {
			MainAccount.addToDatabase();
		}
	}
	
	public void childUI() {
		System.out.println("Would you like to...\nSearch\nView Waitlist");
		decision = input.next();
		if (decision.equalsIgnoreCase("Search")) {
			searchUI();					
		}
	}
	
	public void searchUI() {
		System.out.println("Enter the item title or IBSN you'd like to search for");
		input.nextLine();
		String title = input.nextLine();
		MP.search(title);	
	}
	
	public void checkoutUI() {
		System.out.println("Enter the item title or IBSN that you'd like to checkout");
		input.nextLine();
		String title = input.nextLine();
		MainAccount.checkoutItem(title);
		
	}
//	@SuppressWarnings("unchecked")
//	public void updateDB() throws IOException {
//		JSONArray arr = new JSONArray();
//		JSONObject obj = new JSONObject();
//		ArrayList<Media> media = MP.parserMedia();
//		for (int i = 0; i < media.size(); i++) {
//			JSONObject Media = new JSONObject();
//			Media.put("title",media.get(i).getName());
//			Media.put("year",media.get(i).getYear());
//			Media.put("genre", media.get(i).getGenre());
//			Media.put("ISBN", media.get(i).getISBN());
//			Media.put("publisher",media.get(i).getPublisher());
//			Media.put("author",media.get(i).getAuthor());
//			Media.put("numCopies",media.get(i).getNumberOfCopy());
//			Media.put("newArrival",media.get(i).isNewArrive());
//			Media.put("Maxrent",media.get(i).getMaxrent());
//			arr.add(Media);
//			obj.put("books",arr);
//		  }
//		
//		try (FileWriter file = new FileWriter("books.json")) {
//			
//			  file.write(obj.toString());
//			
//			System.out.println("Successfully Copied JSON Object to File...");
//			
//		}
//	}

}

	

