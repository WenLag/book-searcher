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
import java.util.ArrayList;
public class AccountParser {
	LoadAccountDatabase load = new LoadAccountDatabase();
	private static final String ACCOUNT_FILE_NAME = "AccountDatabase.json";
	UserInterface UI = new UserInterface();
	public ArrayList<Account> parseAccount(String ID, String Password) {
		ArrayList<Account> account = new ArrayList<Account>();
		try {
			FileReader reader = new FileReader(ACCOUNT_FILE_NAME);
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray peopleJSON = (JSONArray)jsonData.get("account");

			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String name = (String)personJSON.get("name");
				String type = (String)personJSON.get("type");
				String email = (String)personJSON.get("email");
				String id = (String)personJSON.get("id");
				String password = (String)personJSON.get("password");
				long maxCheckout = (long)personJSON.get("maxCheckout");
				boolean isFlagged = (boolean)personJSON.get("isFlagged");
				double balance = (double)personJSON.get("Balance");
				int age = (int)personJSON.get("age");
				
				account.add(load.Load(id, email, name, type, isFlagged, maxCheckout, balance, password, age));
			}
			
			for (int i = 0; i < account.size(); i++) {
				String iD = account.get(i).getId();
				String passwordMatch = account.get(i).getPasswordString();
				String name = account.get(i).getName();
				if (Password.equals(passwordMatch) && iD.equals(ID)) {
					System.out.println("\nYou are logged in as " + name);
				} 
				else {
					System.out.println("Not registered. Please consider Registering.");
					break;
				}
				
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		
	}
	
	public void AddAccounts() {
		JSONObject accountdetails = new JSONObject();
		//accountdetails.put( , )
		
	}
	
	
	
}

