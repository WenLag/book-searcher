import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Librarian extends Account{

	private Librarian(String id, String email, String password, int age) {
		super(id, email, password,age);
		this.setMaxCheckout();
	}
	
	public Librarian(Account account) {
		// TODO Auto-generated constructor stub
		super(account); 
	}
	
	/**
	 * Load data from database
	 */
	public Librarian(String id, String email, String name, String type, boolean isFlagged, long maxCheckout,
			double balance, String passwordString, long age) {
		
		super(id, email, name, type, isFlagged, maxCheckout,
				balance, passwordString, age);
		
	}
	
	protected void setMaxCheckout() {
		this.maxCheckout = 999999;
	}
	
	protected void addItem() {
		MediaParser MP = new MediaParser();
		try {
			MP.addMediaDatabase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void removeItem() {
		//TODO
	}
	
	protected void updateItem() {
		//TODO
	}
	
	protected void accessAcount(Account account) {
		//TODO
	}
	
	@SuppressWarnings("unchecked")
	protected void addAccount() {
		AccountParser AP = new AccountParser();
		Scanner input = new Scanner(System. in);
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void romeAccount() {
		//TODO
	}
	
}
