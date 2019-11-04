import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	AccountParser AP = new AccountParser();
	MediaParser MP = new MediaParser();
	Scanner input = new Scanner(System. in);
	public void front() {
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
					System.out.println("Would you like to...\nCheckout\nPay Fines");
						
				}
					break;
				} 
				
			if (i == loggedInAccount.size()-1){
				System.out.println("Wrong ID or Password");
				Login();
			}
			
				
				
			}
		}
	
	public void Register() {
			/**
			 * Register Methods
			 */
		System.out.println("Please enter your name");
		String name = input.next();
		System.out.println("Please type in your desired ID");
		String ID = input.next();
		System.out.println("Please type your desired password.\n");
		String password = input.next();
		System.out.println("Please type in your email\n");
		String email = input.next();	
	}
	
	public void GuestLogin() {
		
	}
	
	public void averageUserUI() {
		String decision;
		System.out.println("Would you like to...\nSearch\nPay Fines");
		decision = input.next();
		if (decision.equalsIgnoreCase("Search")) {
			System.out.println("Enter the item title");
			input.nextLine();
			String title = input.nextLine();
			ArrayList<Media> item = MP.parserMedia(title);					
		}
		
		if (decision.equalsIgnoreCase("Pay Fines")) {
		}
	
	}
	
		
	public void librarianUI() {
		
	}

}

	

