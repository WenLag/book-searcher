import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	Scanner input = new Scanner(System. in);
	public void Login() {
			System.out.println("Enter ID");
			String ID = input.next();
			
			System.out.println("Password");
			String Password = input.next();
			
			AccountParser AP = new AccountParser();
			
			ArrayList<Account> loggedInAccount = AP.parseAccount(); 
			for (int i = 0; i < loggedInAccount.size(); i++) {
				String iD = loggedInAccount.get(i).getId();
				String passwordMatch = loggedInAccount.get(i).getPasswordString();
				String name = loggedInAccount.get(i).getName();
				String type = loggedInAccount.get(i).getType();
				if (passwordMatch.equals(Password) && iD.equals(ID)) {
					System.out.println("Your're logged in as " + name + " as an " + type);
					if (type.equals("AverageUser")) {
						System.out.println("Would you like to...\nCheckout an Item\nPay Fines");
					}
					String decision = input.next();
					
					break;
				} 
				else if (i == loggedInAccount.size()-1){
					System.out.println("Wrong ID or Password");
					break;
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
	
		
		

	}

