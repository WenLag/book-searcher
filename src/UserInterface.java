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
	int decision;
	ArrayList<Account> loggedInAccount = AP.parseAccount();
	Account MainAccount;
	Scanner input = new Scanner(System. in);
	public void front() throws IOException, ParseException {
		Scanner input = new Scanner(System. in);
		System.out.println("\nPlease type in the following number corresponding to the action");
		System.out.println("__________________________________");
		System.out.println("\n1:Login\n2:Register\n3:Guest Login\n4:Exit");
		System.out.println("__________________________________");				
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
		System.out.println("Would you like to...\n1:Search");
		decision = input.nextInt();
		if (decision == 1) {
			System.out.println("Enter the item title");
			input.nextLine();
			String title = input.nextLine();
			MP.search(title);		
		}
	}
	
	public void averageUserUI() {
		
		System.out.println("Would you like to...\n1:Search\n2:View Fines\n3:View Waitlist\n4:Checkout\n5:Exit");
		decision = input.nextInt();
		if (decision == 1) {
			searchUI();				
		}
		else if (decision == 2) {
			
		}
		else if (decision == 3) {
			
		}
		else if (decision == 4) {
			checkoutUI();	
		}
		
		else if (decision == 5) {
			
		} 
		else {
			System.out.println("invalid input");
			averageUserUI();
		}
		
		
	}
		
	public void librarianUI() throws IOException {
		
		System.out.println("Would you like to...\n1:Search\n2:Checkout\n3:Add Media\n4:Remove Media\n5:Access Accounts\n6:Add Account\n7:Remove Account\n8:Exit");
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
		if (choice == 4) {
			
		}
		if (choice == 5) {
			
		}
		if (choice == 6) {
			MainAccount.addToDatabase();
		}
		if (choice == 7) {
			
		}
		if (choice == 8) {
			//updateDB();
		}
	}
	
	public void childUI() {
		System.out.println("Would you like to...\n1:Search\n2:View Waitlist");
		decision = input.nextInt();
		if (decision == 1) {
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
		
		System.out.println("Would you like to checkout more?\n1:Yes\n2:No");
		int ans = input.nextInt();
		if (ans == 1) {
			checkoutUI();
		} else { 
			if (MainAccount.getType().equals("Librarian")){
				try {
					librarianUI();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
		}
			
			else if (MainAccount.getType().equals("AverageUser")) {
				averageUserUI();
			}
			else if (MainAccount.getType().equals("Teacher")) {
				averageUserUI();
			} 
		}
		
	}

	
	

}

	

