import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserInterface {
	AccountParser AP = new AccountParser();
	MediaParser MP = new MediaParser();
	ArrayList<Media> item;
	String decision;
	Scanner input = new Scanner(System. in);
	public void front() throws IOException, ParseException {
		Scanner input = new Scanner(System. in);
		System.out.println("\nPlease type in the following actions you desire\n"
							+"\nLogin, Register, Guest Login, Exit" + "\n");
		
		String choice = input.next();
		
		if (choice.equalsIgnoreCase("login")) {
			Login();			
		}
		else if (choice.equalsIgnoreCase("register")) {
			Register();
		}
		else if (choice.equalsIgnoreCase("guest login")) {
			
		} 
		else if (choice.equalsIgnoreCase("exit")) {
			System.exit(0);
		} 	
		else{
			System.out.println("invalid input");
			front();
		}
	}
	public void Login() {
		System.out.println("Enter ID");
		String ID = input.next();
		System.out.println("Password");
		String Password = input.next();
		ArrayList<Account> loggedInAccount = AP.parseAccount(); 
		for (int i = 0; i < loggedInAccount.size(); i++) {
			String iD = loggedInAccount.get(i).getId();
			String passwordMatch = loggedInAccount.get(i).getPasswordString();
			String name = loggedInAccount.get(i).getName();
			String type = loggedInAccount.get(i).getType();
			if (passwordMatch.equals(Password) && iD.equals(ID)) {
				System.out.println("Your're logged in as " + name + " as an " + type);
				if (type.equals("AverageUser")) {
					averageUserUI();
				}
				if (type.equals("Librarian")) {
					librarianUI();
				}
					break;
				} 
				
			if (i == loggedInAccount.size()-1){
				System.out.println("Wrong ID or Password");
				Login();
			}
			
				
				
			}
		}
	
	public void Register() throws IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();  
		 
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
		JSONObject account = new JSONObject();
		JSONObject obj = new JSONObject();
		account.put("age", age);
		account.put("Balance", 0);
		obj.put("account",account);
		
 
 
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("accountDatabase.json")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			
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
		
		System.out.println("Would you like to...\nSearch\nView Fines\nView Waitlist\n");
		decision = input.next();
		if (decision.equalsIgnoreCase("Search")) {
			System.out.println("Enter the item title");
			input.nextLine();
			String title = input.nextLine();
			MP.search(title);					
		}
		if (decision.equalsIgnoreCase("Pay Fines")) {
			
		}
		
	}
		
	public void librarianUI() {
		
		System.out.println("Would you like to...\nSearch\nAdd Media\nRemove Media\nAccess Accounts\nAdd/Remove Account");
		decision = input.next();
		if (decision.equalsIgnoreCase("Search")) {
			System.out.println("Enter the item title");
			input.nextLine();
			String title = input.nextLine();
			MP.search(title);					
		}
		if (decision.equalsIgnoreCase("Pay Fines")) {
			
		}
	}
	
	public void childUI() {
		
		System.out.println("Would you like to...\nSearch\nView Waitlist");
		decision = input.next();
		if (decision.equalsIgnoreCase("Search")) {
			System.out.println("Enter the item title");
			input.nextLine();
			String title = input.nextLine();
			MP.search(title);				
		}
	}

}

	

