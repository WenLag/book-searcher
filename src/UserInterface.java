import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	Scanner input = new Scanner(System. in);
	public void Login() {
		
			System.out.println("\nyou have decided to Login!\n");
			System.out.println("Enter ID");
			String ID = input.next();
			
			System.out.println("Password");
			String Password = input.next();
			
			AccountParser AP = new AccountParser();
			ArrayList<Account> account = AP.parseAccount(ID,Password);	
		}
	
	public void Register() {
			System.out.println("\nyou have decided to Register!\n");
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

