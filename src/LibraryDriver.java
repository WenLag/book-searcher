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
			System.out.println("\nyou have decided to Login!");
			/**
			 * Login Methods
			 */
			
		}
		else if (choice.equalsIgnoreCase("register")) {
			System.out.println("\nyou have decided to Register!");
			/**
			 * Register Methods
			 */
		}
		else if (choice.equalsIgnoreCase("guest login")) {
			System.out.println("\nyou have decided to Guest Login!");
			/**
			 * Guest Login Methods
			 */
		} 
		else{
			System.out.println("invalid input");
			System.exit(0);
		}
		
	JSONObject obj = new JSONObject();
        
		JSONParser parser = new JSONParser();
	
		try (Reader reader = new FileReader("accountDatabase.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            
            System.out.println("\n"+jsonObject);
            
		}  catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
      }
 

	}
}
