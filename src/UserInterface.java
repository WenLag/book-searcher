import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
/*
 * Front-end class that implements all back-end method
 */
public class UserInterface {
	AccountParser AP = new AccountParser();
	MediaParser MP = new MediaParser();
	ArrayList<Media> item = MP.parserMedia();
	int decision;
	ArrayList<Account> loggedInAccount = AP.parseAccount();
	Account MainAccount;
	Scanner input = new Scanner(System. in);
	/**
	 * method that allows user to Login/Register/ Login as a guest/ or exit.
	 * @throws IOException
	 * @throws ParseException
	 */
	public void front() throws IOException, ParseException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System. in);
		System.out.println("\nPlease type in the following number corresponding to the action");
		System.out.println("__________________________________");
		System.out.println("\n1:Login\n2:Register\n3:Login as a Guest\n4:Exit");
		System.out.println("__________________________________");
		String inputString = input.nextLine();
		int temp;
		while(true) {
			try {
				temp = Integer.parseInt(inputString);
			} catch (NumberFormatException e) {
				continue;
			}
			switch (temp) {
			case 1:
				Login();
				break;
			case 2: 
				Register();
				break;
			case 3:
				guestSearchUI();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid input");
				front();
			}
		}
	}
	/**
	 * Login function checks for a match in the database and notify everything if successful
	 * @throws IOException
	 */
	
	public void Login() throws IOException {
		boolean found = false;
		System.out.println("Enter ID: ");
		String ID = input.nextLine();
		System.out.println("Password: ");
		String Password = input.nextLine();

		for (int i = 0; i < loggedInAccount.size(); i++) {
			String iD = loggedInAccount.get(i).getId();
			String passwordMatch = loggedInAccount.get(i).getPasswordString();
			
			if (passwordMatch.equals(Password) && iD.equals(ID)) {
				MainAccount = loggedInAccount.get(i);
				MainAccount.notifyHold();
				System.out.println("Successful login");
				mainUI();
				found = true;
			}

			if (i == loggedInAccount.size()-1 && found == false){
				System.out.println("Wrong ID or Password");
				Login();
			}



			}
		}
	/**
	 * Register Method that check the input if it exist and upon successful comparison, an account is created.
	 */
	public void Register() throws IOException, ParseException {
		System.out.println("_____________________________________");
		System.out.println("Register an Account");
		System.out.println("_____________________________________");
		System.out.println("Please enter your name: ");
		String name = input.nextLine();
		System.out.println("Please enter your age: ");
		long age = input.nextInt();
		input.nextLine();
		System.out.println("Please type in your desired ID: ");
		String ID = input.nextLine();
		System.out.println("Please type your desired password: ");
		String password = input.nextLine();
		System.out.println("Please type in your email: ");
		String email = input.nextLine();
		ArrayList<Account> accounts = AP.getList();
		AverageUser newAccount = new AverageUser(ID,email,password,age, name);
		if(newAccount.checkInput()) {
			newAccount = (AverageUser) newAccount.ungradeAccount();
			addAccountToDB(newAccount, accounts);
			System.out.println("You've successfully made an account!");
			mainUI();
		} else {
			Register();
		}
	


	}

	/**
	 * Average user interface
	 * @throws IOException
	 */
	public void averageUserUI() throws IOException {
		System.out.println("_____________________________________");
		System.out.println("Would you like to...\n1:Search\n2:Checkout\n3:Return\n4:View Hold list\n5:View Waitlist\n6:View Fines\n7:Comment\n8:Upgrade Account\n9:Exit");
		System.out.println("_____________________________________");
		decision = input.nextInt();
		input.nextLine();
		if (decision == 1) {
			searchUI();
		}
		else if (decision == 2) {
			checkoutUI();
		}
		else if (decision == 3) {
			System.out.println("Enter the book you want to return");
			System.out.println("_____________________________________");
			input.nextLine();
			String title = input.nextLine();
			Media temp = MP.search(item, title);
			MainAccount.returnItem(temp);
			mainUI();
		} 
		else if (decision == 4) {
			System.out.println("_____________________________________");
			System.out.println("You're holding these books");
			for (int i = 0; i < MainAccount.getCheckoutList().size(); i++) {
				System.out.println(MainAccount.getCheckoutList().get(i));
			}
			mainUI();
		}
		else if (decision == 5) {
			System.out.println("_____________________________________");
			System.out.println("You're on the wait list for");
			for (int i = 0; i < MainAccount.getWaitList().size(); i++) {
				System.out.println((i+1)+":"+MainAccount.getWaitList().get(i));
			}
			mainUI();
		}

		else if (decision == 6) {
			fineUI();
		}
		else if (decision == 7){
			System.out.println("Enter the title you want to comment on");
			String title = input.nextLine();
			Media media = MP.search(item, title);
			media.addComment();
			mainUI();

		} else if (decision == 8){
			int index = loggedInAccount.indexOf(MainAccount);
			System.out.println("Enter");
			String code = input.nextLine();
			MainAccount =  MainAccount.ungreadAccount(code);
			loggedInAccount.set(index, MainAccount);
			
		} else if (decision == 9) {
			try {
				updateDB();
				System.exit(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("invalid input");
			mainUI();
		}
	}
	
	
	/**
	 * calls FineUI when there is a fine on a account
	 * @throws IOException
	 */
	private void fineUI() throws IOException {
		System.out.println("Your total fine: " + MainAccount.getBalance());
		if (MainAccount.getBalance() != 0) {
			System.out.println("_____________________________________");
			System.out.println("would you like to pay for your fines?\n1:Yes\n2:No");
			System.out.println("_____________________________________");
			int ans = input.nextInt();
			input.nextLine();
			if (ans == 1) {
				System.out.println("Enter the amount you'd like to add to your account.");
				double amount = input.nextDouble();
				input.nextLine();
				MainAccount.setBalance(MainAccount.getBalance() + amount);
				mainUI();
			} else {
				mainUI();
			}
		} else {
			System.out.println("_____________________________________");
			System.out.println("You have no fine holds on your account");
			mainUI();
		}

	}
	
	/**
	 * Librarian user interface that allows for more access compared to the average user
	 * @throws IOException
	 */
	public void librarianUI() throws IOException {
		System.out.println("_____________________________________");
		System.out.println("Would you like to...\n1:Search\n2:Checkout\n3:Add Media\n4:update "
				+ "Media\n5:Access Accounts\n6:Add Account\n7:Remove Account\n8:Exit");
		System.out.println("_____________________________________");
		int choice = input.nextInt();
		input.nextLine();
		Librarian librarian = (Librarian) MainAccount;
		if (choice == 1) {
			searchUI();
		}
		if (choice == 2) {
			checkoutUI();
		}
		if (choice ==3) {
			System.out.println("put in type of item");
			String type = input.nextLine();
			librarian.addItem(item, type);
			mainUI();
			
		}
		if (choice == 4) {
			System.out.println("Enter a title: ");
			String aMediaName = input.nextLine();
			Media media = MP.search(item, aMediaName);
			librarian.updateItem(media);
			mainUI();
		}
		if (choice == 5) {
			System.out.println("enter the account you want to access");
			System.out.println("ID: " );
			String id = input.nextLine();
			Account temp = null;
			for (int i = 0; i < loggedInAccount.size(); i++) {
				if (id.equals(loggedInAccount.get(i).getId())) {
					temp = loggedInAccount.get(i);
					break;
				}
			}
			if(temp != null)
				librarian.accessAcount(temp, item);
			updateDB();
			mainUI();
		}
		if (choice == 6) {
			
		}
		if (choice == 7) {

		}
		if (choice == 8) {
			updateDB();
			System.exit(0);
		}
		else {
			
		}
	}

	/**
	 * calls when a child login
	 */
	public void childUI() {
		System.out.println("Would you like to...\n1:Search\n2:Checkout\n3:View Waitlist");
		decision = input.nextInt();
		input.nextLine();
		if (decision == 1) {
			searchUI();
		}
		if (decision == 2) {
			checkoutUI();
		}
		if (decision == 3) {
			MainAccount.getWaitList();
		}
	}
	
	public void guestSearchUI() {
		System.out.println("Enter the item title or IBSN you'd like to search for");
		System.out.println("_____________________________________");
		String title = input.nextLine();
		Media Searchedbook = MP.search(MP.getList(),title);
		if (Searchedbook == null) {
			System.out.println("No book with this title");
			
		} else {
			Searchedbook.printoutInfo();;
		}
		System.out.println("continue search?\n1:Yes\n2:No");
		int ans = input.nextInt();
		input.nextLine();
		if (ans == 1)
			guestSearchUI();
		if (ans != 1) 
			System.exit(0);
	}
	
	/**
	 * calls searchUI when user wants to search
	 */

	public void searchUI() {
		System.out.println("Enter the item title or IBSN you'd like to search for");
		System.out.println("_____________________________________");
		String title = input.nextLine();
		Media Searchedbook = MP.search(MP.getList(),title);
		if (Searchedbook.getName()==null) {
			System.out.println("No book with this title");
			
		} else {
			Searchedbook.printoutInfo();;
		}
		try {
			mainUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * calls MainUI everytime to go back to main interface depending on the type
	 * @throws IOException
	 */
	public void mainUI() throws IOException{
		if(MainAccount.getType().equals("AverageUser")) {
			updateDB();
			averageUserUI();
			
		}
		if(MainAccount.getType().equals("Librarian")) {
			updateDB();
			librarianUI();
			
		}
		if(MainAccount.getType().equals("Teacher")) {
			updateDB();
			averageUserUI();
		
		} 
		if (MainAccount.getType().equals("Child")) {
			updateDB();
			childUI();
		}
		else {
			updateDB();
		}
	}

	/**
	 * checkoutUI is called everytime a user wants to checkout
	 */
	public void checkoutUI() {
		System.out.println("Enter the item title or IBSN that you'd like to checkout");
		System.out.println("_____________________________________");
		String title = input.nextLine();
		Media temp = MP.search(item,title);
			MainAccount.checkoutItem(temp);
			System.out.println("\nWould you like to checkout more?\n1:Yes\n2:No");
			int ans = input.nextInt();
			input.nextLine();
			if (ans == 1) {
				checkoutUI();
			}else {
				try {
					mainUI();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

	}

	/**
	 * UpdateDB is called every time the console goes backinto the main user interface of their class type
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void updateDB() throws IOException {
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		ArrayList<Media> media = MP.getList();
		for (int i = 0; i < media.size(); i++) {
			JSONObject Media = new JSONObject();
			Media.put("title",media.get(i).getName());
			Media.put("year",media.get(i).getYear());
			Media.put("genre", media.get(i).getGenre());
			Media.put("ISBN", media.get(i).getISBN());
			Media.put("author",media.get(i).getAuthor());
			Media.put("numCopies",media.get(i).getNumberOfCopy());
			Media.put("newArrival",media.get(i).isNewArrive());
			Media.put("Maxrent",media.get(i).getMaxrent());
			Media.put("rating",media.get(i).getRating());
			Media.put("comment", media.get(i).getCommitlist());
			Media.put("type", media.get(i).getType());
			arr.add(Media);
			obj.put("books",arr);
		  }
		try (FileWriter file = new FileWriter("media.json")) {

			  file.write(obj.toString());
			  file.close();
		}
		JSONObject accountObj = new JSONObject();
		JSONArray accountArr = new JSONArray();
		
		ArrayList<Account> accounts = AP.getList();
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
			item0.put("waitlist",accounts.get(i).getWaitList());
			item0.put("checkoutlist", accounts.get(i).getCheckoutList());
			accountArr.add(item0);
			accountObj.put("account",accountArr);
			
		}
		
		try (FileWriter file = new FileWriter("accountDatabase.json")) {
			  file.write(accountObj.toString());
			  file.close();
		}

	}

	/**
	 * AddAccounttoDB is called when the librarian wishes to add an account to the Database
	 * @param newAccount
	 * @param accounts
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private void addAccountToDB(Account newAccount, ArrayList<Account> accounts) throws IOException {
		JSONArray arr = new JSONArray();
		JSONObject item1 = new JSONObject();
		JSONObject obj = new JSONObject();
		item1.put("age", newAccount.getAge());
		item1.put("Balance", 0.0);
	    item1.put("email", newAccount.getEmail());
	    item1.put("id", newAccount.getId());
	    item1.put("isFlagged", false);
	    item1.put("maxCheckout", newAccount.getMaxCheckout());
	    item1.put("name", newAccount.getName());
	    item1.put("password", newAccount.getPasswordString());
	    item1.put("type", newAccount.getType());
		item1.put("waitlist",newAccount.getCheckoutList());
		item1.put("checkoutlist", newAccount.getCheckoutList());
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
			item0.put("waitlist",accounts.get(i).getCheckoutList());
			item0.put("checkoutlist", accounts.get(i).getCheckoutList());
			arr.add(item0);
			obj.put("account",arr);
		}
		try (FileWriter file = new FileWriter("accountDatabase.json")) {

			  file.write(obj.toString());
			  file.close();
		}

	

	}


}
