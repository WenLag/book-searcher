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
			double balance, String passwordString, long age,ArrayList<String> aWaitList, ArrayList<String> checList) {
		
		super(id, email, name, type, isFlagged, maxCheckout,
				balance, passwordString, age, aWaitList, checList);
		
	}
	
	protected void setMaxCheckout() {
		this.maxCheckout = 999999;
	}
	
	protected void addItem(ArrayList<Media> aList, String aTpye) {
		if(aTpye.equalsIgnoreCase("book")) {
			BookItem newBookItem = new BookItem();
			MP.input(newBookItem);
			aList.add(newBookItem);
		}else if (aTpye.equalsIgnoreCase("ebook")) {
			Ebook newItem = new Ebook();
			MP.input(newItem);
			aList.add(newItem);
		}else if (aTpye.equalsIgnoreCase("magazine")) {
			Magazine newItem = new Magazine();
			MP.input(newItem);
			aList.add(newItem);
		}else if (aTpye.equalsIgnoreCase("dvd")) {
			DVD newItem = new DVD();
			MP.input(newItem);
			aList.add(newItem);
		}else {
			System.out.println("Unknown Type");
		}
	}
	
	protected void removeItem() {
		//TODO
		MediaParser mp = new MediaParser();
		mp.removeMediaDatabase();
	}
	
	protected void updateItem(Media media) {
		//TODO
		//MediaParser mp = new MediaParser();
		Scanner key = new Scanner(System. in);
		boolean quit = false;
		String inputString;
		//Media media = mp.search(title);
		if(media == null) {
			System.out.println(" is not find!");
			return;
		}
		while (!quit) {
			System.out.println(media.toString());
			System.out.println("*************************************"
					+ "*************************************");
			System.out.println("Enter 1 to update author"
					+ "\nEnter 2 to update gener"
					+ "\nEnter 3 to update holdlist"
					+ "\nEnter 4 to update ISBN"
					+ "\nEnter 5 to update is Checkout"
					+ "\nEnter 6 to update is New Arrive"
					+ "\nEnter 7 to update maxrent"
					+ "\nEnter 8 to update number of copies"
					+ "\nEnter 9 to update publisher"
					+ "\nEnter 10 to update reting"
					+ "\nEnter 11 to update title"
					+ "\nEnter 12 to update year"
					+ "\nExter 0 to quit");
			//inputString = key.next();
			inputString = key.nextLine();
			int temp;
			try {
				temp = Integer.parseInt(inputString);
			} catch (NumberFormatException e) {
				continue;
				// TODO: handle exception
			}
			switch (temp) {
			case 1:
				System.out.println("Enter a Author:");
				inputString = key.nextLine();
				media.setAuthor(inputString);
				break;

			case 2:
				System.out.println("Enter a Genre:");
				inputString = key.nextLine();
				media.setGenre(inputString);
				break;
				
			case 3:
				System.out.println("Enter a User add to list:");
				inputString = key.nextLine();
				media.holdlist.add(inputString);
				break;	
				
			case 4:
				System.out.println("Enter a ISBN:");
				inputString = key.nextLine();
				media.setISBN(inputString);
				break;	
				
			case 5:
				System.out.println("Enter 1 set to true 0 to false:");
				inputString = key.nextLine();
				if(inputString.equals("1")) {
					media.setisCheckout(true);
				}else if(inputString.equals("2")) {
					media.setisCheckout(false);
				}else {
					System.out.println("Invalid input");
				}
				break;
				
			case 6:
				System.out.println("Enter 1 set to true 0 to false:");
				inputString = key.nextLine();
				if(inputString.equals("1")) {
					media.setisNewArrive(true);
				}else if(inputString.equals("2")) {
					media.setisNewArrive(false);
				}else {
					System.out.println("Invalid input");
				}
				break;
				
			case 7:
				System.out.println("Enter a Maxrent:");
				inputString = key.nextLine();
				try {
					int temp2 = Integer.parseInt(inputString);
					media.setMaxrent(temp2);
				}  catch(NumberFormatException e){
					System.out.println("Invalid input");
				}
				break;	
				
			case 8:
				System.out.println("Enter a number of copies:");
				inputString = key.nextLine();
				try {
					int temp2 = Integer.parseInt(inputString);
					media.setNumberOfCopy(temp2);
				}  catch(NumberFormatException e){
					System.out.println("Invalid input");
				}
				break;	
				
			case 9:
				System.out.println("Enter a publisher:");
				inputString = key.nextLine();
				media.setPublisher(inputString);
				break;	
				
			case 10:
				System.out.println("Enter a number of rating:");
				inputString = key.nextLine();
				try {
					int temp2 = Integer.parseInt(inputString);
					media.setRating(temp2);
				}  catch(NumberFormatException e){
					System.out.println("Invalid input");
				}
				break;
				
			case 11:
				System.out.println("Enter a title:");
				inputString = key.nextLine();
				media.setName(inputString);
				break;
				
			case 12:
				System.out.println("Enter a year:");
				inputString = key.nextLine();
				media.setYear(inputString);
				break;	
				
			case 0:
				quit = true;
				break;
				
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}
	
	protected void accessAcount(Account account, ArrayList<Media> aMedias) {
		//TODO
		//AccountParser ap = new AccountParser();
		Scanner key = new Scanner(System. in);
		MediaParser mp = new MediaParser();
		boolean quit = false;
		String inputString;
		while (!quit) {
			System.out.println(account.toString());
			System.out.println("Enter 1 to update age"
					+ "\nEnter 2 to update belance"
					+ "\\nEnter 3 to update checkouted"
					+ "\\nEnter 4 to update checkouted list"
					+ "\\nEnter 5 to update email"
					+ "\\nEnter 6 to update id"
					+ "\\nEnter 7 to update is flagged"
					+ "\\nEnter 8 to update max checkout"
					+ "\\nEnter 9 to update name"
					+ "\\nEnter 10 to update password string"
					+ "\\nEnter 11 to update type"
					+ "\\nEnter 12 to update wait list"
					+ "\\nEnter 0 to quit");
			inputString = key.nextLine();
			int temp1;
			try {
				temp1 = Integer.parseInt(inputString);
			} catch (NumberFormatException e) {
				continue;
				// TODO: handle exception
			}
			switch (temp1) {
			case 1:
				System.out.println("Enter a age:");
				inputString = key.nextLine();
				try {
					int temp = Integer.parseInt(inputString);
					account.setAge(temp);
				}  catch(NumberFormatException e){
					System.out.println("Invalid input");
				}
				break;

			case 2:
				System.out.println("Enter a balance:");
				inputString = key.nextLine();
				try {
					int temp = Integer.parseInt(inputString);
					account.setAge(temp);
				}  catch(NumberFormatException e){
					System.out.println("Invalid input");
				}
				break;	
				
			case 3:
				System.out.println("Enter a checkouted number:");
				inputString = key.nextLine();
				try {
					int temp = Integer.parseInt(inputString);
					account.setCheckouted(temp);
				}  catch(NumberFormatException e){
					System.out.println("Invalid input");
				}
				break; 
				
			case 4:
				System.out.println("Enter 1 to add, 2 to remove:");
				inputString = key.nextLine();
				if(inputString.equals("1")) {
					System.out.println("Enter a title:");
					inputString = key.nextLine();
					account.getCheckoutList().add(inputString);
					account.getCheckoutList().add(account.date());
				}else if (inputString.equals("2")) {
					System.out.println("Enter a title:");
					inputString = key.nextLine();
					int temp = account.getCheckoutList().indexOf(inputString);
					if(temp >= 0) {
						account.getCheckoutList().remove(temp+1);
						account.getCheckoutList().remove(temp);
					}
					else
						System.out.println("Item not find!");
				}
				break;
				
			case 5:
				System.out.println("Enter a email:");
				inputString = key.nextLine();
				account.setEmail(inputString);
				break;	
				
			case 6:
				System.out.println("Enter a ID:");
				inputString = key.nextLine();
				account.setId(inputString);
				break;
				
			case 7:
				System.out.println("Enter 1 set to true 0 to false:");
				inputString = key.nextLine();
				if(inputString.equals("1")) {
					account.setFlagged(true);
				}else if(inputString.equals("2")) {
					account.setFlagged(false);
				}else {
					System.out.println("Invalid input");
				}
				break;	
				
			case 8:
				account.setMaxCheckout();
				break;	
				
			case 9:
				System.out.println("Enter a Name:");
				inputString = key.nextLine();
				account.setName(inputString);
				break;
				
			case 10:
				System.out.println("Enter a password:");
				inputString = key.nextLine();
				account.resetPassword(inputString);
				break;
				
			case 11:
				System.out.println("Enter a type:");
				inputString = key.nextLine();
				account.setType(inputString);
				break;
				
			case 12:
				System.out.println("Enter 1 to add, 2 to remove:");
				inputString = key.nextLine();
				if(inputString.equals("1")) {
					System.out.println("Enter a title:");
					inputString = key.nextLine();
					Media media = mp.search(aMedias,inputString);
					if(media != null) {
						account.getWaitList().add(media.getName());
						media.holdlist.add(account.getId());
					}
					else
						System.out.println("Item not find!");
				}else if (inputString.equals("2")) {
					System.out.println("Enter a title:");
					inputString = key.nextLine();
					Media media = mp.search(aMedias, inputString);
					if(media != null) {
						account.getWaitList().remove(media);
						media.holdlist.remove(account.getId());
					}
					else
						System.out.println("Item not find!");
				}
				break;
				
			case 0:
				quit = true;
				break;
				
			default:
				break;
			}
		}
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
