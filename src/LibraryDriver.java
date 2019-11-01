import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class LibraryDriver {
	

	public static void main(String[] args) throws IOException, ParseException {
		UserInterface UI = new UserInterface();
		Scanner input = new Scanner(System. in);
		System.out.println("Hello, Please type in the following actions you desire"
							+ "\n \n" + 
							"Login, Register, Guest Login" + "\n");
		
		String choice = input.next();
		
		if (choice.equalsIgnoreCase("login")) {
			UI.Login();
						
		}
		else if (choice.equalsIgnoreCase("register")) {
			UI.Register();
		}
		else if (choice.equalsIgnoreCase("guest login")) {
			
		} 
		else{
			System.out.println("invalid input");
			System.exit(0);
		}
			
	
		
		}
 

}

