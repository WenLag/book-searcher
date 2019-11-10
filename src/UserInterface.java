import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class UserInterface {
	AccountParser AP = new AccountParser();
	MediaParser MP = new MediaParser();
	
	ArrayList<Media> item = MP.parserMedia();
	//ArrayList<Media> medias = MP.getList();
	int decision;
	ArrayList<Account> loggedInAccount = AP.parseAccount();
	Account MainAccount;
	Scanner input = new Scanner(System. in);
	public void front() throws IOException, ParseException {
		Scanner input = new Scanner(System. in);
		System.out.println("\nPlease type in the following number corresponding to the action");
		System.out.println("__________________________________");
		System.out.println("\n1:Login\n2:Register\n3:Guest Login\n4:Exit");
		System.out.println("__________________________________");
		int choice = input.nextInt();
		if (choice == 1) {
			Login();
		}
		else if (choice == 2) {
			Register();
		}
		else if (choice == 3) {
			searchUI();
		}
		else if (choice == 4) {
			System.exit(0);
		}
		else{
			System.out.println("invalid input");
			front();
		}
	}
	public void Login() throws IOException {
		boolean found = false;
		System.out.println("Enter ID: ");
		String ID = input.nextLine();
		System.out.println("Password: ");
		String Password = input.nextLine();

		for (int i = 0; i < loggedInAccount.size(); i++) {
			String iD = loggedInAccount.get(i).getId();
			String passwordMatch = loggedInAccount.get(i).getPasswordString();
			String name = loggedInAccount.get(i).getName();
			String type = loggedInAccount.get(i).getType();
			if (passwordMatch.equals(Password) && iD.equals(ID)) {
				MainAccount = loggedInAccount.get(i);
				MainAccount.notifyHold();;
				System.out.println("Your're logged in as " + name + " as an " + type);
				if (type.equals("AverageUser")) {
					averageUserUI();

				}
				if (type.equals("Librarian")) {

					librarianUI();
				}
				found = true;
			}

			if (i == loggedInAccount.size()-1 && found == false){
				System.out.println("Wrong ID or Password");
				Login();
			}



			}
		}
	/**
	 * Register Methods
	 */
	@SuppressWarnings("unchecked")
	public void Register() throws IOException, ParseException {
		System.out.println("_____________________________________");
		System.out.println("Register an Account");
		System.out.println("_____________________________________");
		System.out.println("Please enter your name: ");
		String name = input.nextLine();
		System.out.println("Please enter your age: ");
		long age = input.nextInt();
		System.out.println("Please type in your desired ID: ");
		String ID = input.nextLine();
		System.out.println("Please type your desired password: ");
		String password = input.nextLine();
		System.out.println("Please type in your email: ");
		String email = input.nextLine();
		ArrayList<Account> accounts = AP.getList();
		AverageUser newAccount = new AverageUser(ID,email,password,age);
		if(newAccount.checkInput()) {
			newAccount = (AverageUser) newAccount.ungradeAccount();
			addAccountToDB(newAccount, accounts);
			System.out.println("You've successfully made an account!");
		} else {
			Register();
		}
	


			}

	public void averageUserUI() throws IOException {
		System.out.println("_____________________________________");
		System.out.println("Would you like to...\n1:Search\n2:Checkout\n3:Return\n4:View Waitlist\n5:View Fines\n6:Comment\n7:Exit");
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
			System.out.println("You're on the wait list for");
			for (int i = 0; i < MainAccount.getWaitList().size(); i++) {
				System.out.println((i+1)+":"+MainAccount.getWaitList().get(i));
			}
			mainUI();
		}

		else if (decision == 5) {
			fineUI();
		}
		else if (decision == 6){
			System.out.println("Enter the title you want to comment on");
			String title = input.nextLine();
			Media media = MP.search(item, title);
			media.addComment();
			updateDB();

		} else if (decision == 7){
			try {
				updateDB();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("invalid input");
			mainUI();
		}


	}

	private void fineUI() throws IOException {
		System.out.println("Your total fine: " + MainAccount.getBalance());
		if (MainAccount.getBalance() != 0) {
			System.out.println("_____________________________________");
			System.out.println("would you like to pay for your fines?\n1:Yes\n2:No");
			System.out.println("_____________________________________");
			int ans = input.nextInt();
			if (ans == 1) {
				System.out.println("Enter the amount you'd like to add to your account.");
				long amount = input.nextInt();
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
			updateDB();
			mainUI();
			
		}
		if (choice == 4) {
			String aMediaName = input.nextLine();
			Media media = MP.search(item, aMediaName);
			librarian.updateItem(media);
			mainUI();
		}
		if (choice == 5) {

		}
		if (choice == 6) {
			
		}
		if (choice == 7) {

		}
		if (choice == 8) {
			updateDB();
		}
	}

	public void childUI() {
		System.out.println("Would you like to...\n1:Search\n2:View Waitlist");
		decision = input.nextInt();
		if (decision == 1) {
			searchUI();
		}
	}

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

	public void mainUI() throws IOException{
		if(MainAccount.getType().equals("AverageUser")) {
			averageUserUI();
			updateDB();
		}
		if(MainAccount.getType().equals("Librarian")) {
			librarianUI();
			updateDB();
		}
		if(MainAccount.getType().equals("Teacher")) {
			averageUserUI();
			updateDB();
		} else {
			searchUI();
		}
	}

	public void checkoutUI() {
		System.out.println("Enter the item title or IBSN that you'd like to checkout");
		System.out.println("_____________________________________");
		String title = input.nextLine();
		Media temp = MP.search(item,title);
			MainAccount.checkoutItem(temp);
			System.out.println("Would you like to checkout more?\n1:Yes\n2:No");
			int ans = input.nextInt();
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
