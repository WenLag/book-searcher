import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.*;

public class LibraryDriver {
	

	public static void main(String[] args) throws IOException, ParseException {
		Scanner input = new Scanner(System. in);
		System.out.println("Hello, Please type in the following actions you desire"
							+ "\n \n" + 
							"Login, Register, Guest Login" + "\n");
		
		String choice = input.next();
		
		if (choice.equalsIgnoreCase("login")) {
			System.out.println("\nyou have decided to Login!\n");
			
			/**
			 * Login Methods
			 */
			System.out.println("Enter ID");
			String ID = input.next();
			
			System.out.println("Password");
			String Password = input.next();
			
			AccountParser AP = new AccountParser();
			ArrayList<Account> account = AP.parseAccount(ID,Password);
			
			
		}
		else if (choice.equalsIgnoreCase("register")) {
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
		
		else if (choice.equalsIgnoreCase("guest login")) {
			System.out.println("\nyou have decided to Guest Login!");
			/**
			 * Guest Login Methods 
			 * allow guest user to search books
			 */
		} 
		else{
			System.out.println("invalid input");
			System.exit(0);
		}
		}
 

}

