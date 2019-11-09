import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

import org.json.simple.JSONObject;

/**
 * Account class
 * An abstract class
 * @author Zeling Zhuo
 */
public abstract class Account {
	MediaParser MP = new MediaParser();
	AccountParser AP = new AccountParser();
	// Account info, attributes
	protected String id;
	protected String email;
	protected String name;
	protected String type;
	protected boolean isFlagged;
	protected long maxCheckout;
	protected double balance;
	protected String passwordString;
	protected long age;
	protected int checkouted;
	protected ArrayList<String> waitList = new ArrayList<String>();  
	protected ArrayList<String> checkoutList = new ArrayList<String>();


	public Account(String id, String email, String password, long age) {
		this.setId(id);
		this.setEmail(email);
		this.setBalance(0);
		this.setFlagged(false);
		this.setPasswordString(password);
		this.setAge(age);
		this.setType();
		this.checkouted = 0;
		waitList = new ArrayList<String>();
		// check account info and add account to database if input is valid
		checkInput();
	}

	/**
	 * Load data from database
	 */
	public Account(String id, String email, String name, String type, boolean isFlagged, long maxCheckout,
			double balance, String passwordString, long age, ArrayList<String> aWaitList, ArrayList<String> checList) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.type = type;
		this.isFlagged = isFlagged;
		this.maxCheckout = maxCheckout;
		this.balance = balance;
		this.passwordString = passwordString;
		this.age = age;
		this.waitList = aWaitList;
		this.checkoutList = checList;
		if(waitList == null)
			waitList = new ArrayList<String>();
		if(checkoutList == null)
			checkoutList = new ArrayList<String>();
	}
	
	public Account(Account account) {
		// TODO Auto-generated constructor stub
		this.copy(account);
	}

	// Accesses
	//TODO add constraints for setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		//TODO id format
		if(id.length() != 7) {
			System.out.println("Error!! ID has to be 7 chars");
			this.id = "null";
			return;
		}
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if(email == null || email == "") {
			System.out.println("No email entered!");
			this.email = "null";
			return;
		}
		this.email = email;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType() {
		if(this.getAge() < 18)
			this.setType("Child");
		else {
			this.setType("AverageUser");
		}
	}
	
	public void setType(String type) {
		// Set account type to Librarian, Teacher, Child or AverageUser, if type is not above set to Unknown
		if(type.equalsIgnoreCase("Librarian")) {
			this.type = "Librarian";
		}else if (type.equalsIgnoreCase("Teacher")) {
			this.type = "Teacher";
		}
		else if (type.equalsIgnoreCase("Child")) {
			this.type = "Child";
		}
		else if (type.equalsIgnoreCase("AverageUser")) {
			this.type = "AverageUser";
		}else {
			System.out.println("Error! Unknown Account Type!");
			this.type = "Unknown";
		}
	}
	public boolean isFlagged() {
		return isFlagged;
	}
	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}
	public long getMaxCheckout() {
		return maxCheckout;
	}
	
	
	public int getCheckouted() {
		return checkouted;
	}

	public void setCheckouted(int checkouted) {
		this.checkouted = checkouted;
	}

	protected abstract void setMaxCheckout();

	public double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	protected String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		if(passwordString.length() < 6 || passwordString.length() > 12) {
			System.out.print("Error! Password has to be 6 to 12 charters!");
			this.passwordString = "null";
		}
		this.passwordString = passwordString;
	}
	

	public ArrayList<String> getWaitList() {
		return waitList;
	}

	public void setWaitList(ArrayList<String> waitList) {
		this.waitList = waitList;
	}

	public ArrayList<String> getCheckoutList() {
		return checkoutList;
	}

	public void setCheckoutList(ArrayList<String> checkoutList) {
		this.checkoutList = checkoutList;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age2) {
		if(age2 >= 0 && age2 <= 100)
			this.age = age2;
		else {
			System.out.printf("Input %d is not a valid age!\n", age2);
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * the method take one input String as parameters and use the String to
	 * search if the item exist in database
	 * if exist return the item if not return null
	 * @param aName is type of String
	 * @return a Book Object
	 */
//	public Media searchItem(String aName) {
//		//TODO make Book class and add search function
//		
//		Media media = MP.search(aName);
//		return media;
//	}

	/**
	 * the method to allowed user checkout items if the user have not meet max checkout,
	 * and the user is not flagged
	 * @param aName is type of String
	 */
	public void checkoutItem(Media media) {
		//TODO make checkout function
		
		//Media media = searchItem(aName);
		Scanner input = new Scanner(System.in);
		if (media == null) {
			System.out.println("No books' with that title or IBSN");
		}
		if(!this.isAbleCheckout()) {
			System.out.println("This account can not checkout items!");
			return;
		}
		
		else if(media.getNumberOfCopy() > 0)
		{
			System.out.println(media.getNumberOfCopy());
			media.setNumberOfCopy(media.getNumberOfCopy()-1);	
			System.out.println(media.getNumberOfCopy());
			checkoutList.add(media.getName());
			checkoutList.add(date());
			this.checkouted++;	
		} else if (media.getNumberOfCopy() == 0){
			System.out.println("__________________________\n");
			System.out.println("This item is out of copies!");
			System.out.println("__________________________");
			System.out.println("Would you like to be added to the waitlist?\n1:Yes\n2:No");
			int ans = input.nextInt();
			if (ans == 1) {
				putlist(media);
			} else if (ans == 2){
				
			} else {
				return;
			}
		} 
		return;
	} 

	/**
	 * the method to allowed user return items
	 * @param aName is type of String
	 */
	public void returnItem(Media media) {
		//TODO make returnItem function
		//Media media = searchItem(aName);
		if(media == null)
			return;
		int index = this.checkoutList.indexOf(media.getName());
		int temp = comparDate(this.date(),this.checkoutList.get(index+1));
		if(temp > 0)
			this.setBalance(this.getBalance() + temp * 0.5);
		media.setNumberOfCopy(media.getNumberOfCopy()+1);
		checkoutList.remove(checkoutList.indexOf(media.getName())+1);
		checkoutList.remove(media.getName());
		this.checkouted--;	
	}

	/**
	 * the method to allowed user renew items if the item is not on hold
	 * @param aName is type of String
	 */
	public void renew(String aName) {
		//TODO make returnItem function
	}

	/**
	 * the method to check if the account is exist in database if exist return true
	 * else return false
	 * @return boolean type
	 */
	public boolean compareAccount() {
		//TODO
		return false;
	}

	/**
	 * the method send info of the account flag by email
	 */
	public void notifyFines() {
		//TODO
		System.out.printf("Notified User %s Account Fines by Email: %s\n", getId(),getEmail());
	}

	/**
	 * the method allowed use to pay fines
	 */
	protected void payFine(double pay) {
		//TODO
		double fine = this.getBalance();
		this.setBalance(fine+pay);
	}
	
	/**
	 * check if account able to checkout if yes return true else return false
	 * @return boolean type
	 */
	public boolean isAbleCheckout() {
		if(this.getBalance() < 0 && this.isFlagged() == true && this.checkouted < this.getMaxCheckout())
			return false;
		return true;
	}

	/**
	 * the method send a email to user if the state of item they hold is changed
	 */
	public void notifyHold() {
		System.out.printf("Notified User %s Hold Information by Email: %s\n", getId(),getEmail());
	}

	/**
	 * The method put user to the hold list to the item they requiring
	 * @param aName type of String
	 */
	public void putlist(Media media) {
		//TODO
		//MediaParser mParser = new MediaParser();
		//Media media =// MP.search(media);
		if(media == null)
			return;
		if(getWaitList() == null) {
			System.out.println("waitlist is null");
			return; 
		} 
		if(getWaitList().size() <= this.getMaxCheckout()) {
			media.addHoldList(this.getId());
			getWaitList().add(media.getName());
			
		}else {
			System.out.println("You can not hold any more items");
		}
	}

	/**
	 * The method print out the wait list
	 */
	public void printWaitList() {
		//TODO
		for(int i = 0; i < waitList.size(); i++) {
			System.out.printf("Title: %s\n",waitList.get(i));
		}
	}
	
	/**
	 * The method print out the wait list
	 */
	public void printCheckoutList() {
		//TODO
		for(int i = 0; i < checkoutList.size(); i+=2) {
			System.out.printf("Title: %s\tcheckout date: %s\n",checkoutList.get(i)
					,waitList.get(i+1));
		}
	}

	/**
	 * The method allow user to reset password
	 */
	public void resetPassword(String oldPassword, String newPassword) {
		//TODO
		if(this.getPasswordString().equals(oldPassword) && 6 <= newPassword.length() && newPassword.length() <= 12) {
			this.setPasswordString(newPassword);
		}else {
			System.out.println("The old password dose not match or the new password is not 6 to 12 character!\n"
					+ "The password is not reseted! If you do not remember your password ask librarian to reset!");
		}
	}

	/**
	 * reset password by librarians
	 * @param newPassword a 6 to 12 String
	 */
	protected void resetPassword(String newPassword) {
		if(newPassword.length() < 6 || newPassword.length() > 12) {
			System.out.println("Password is not reseted!");
			return;
		}
		this.setPasswordString(newPassword);
	}

	/**
	 * Override ToString
	 */
	public String toString() {
		return "ID: " + this.id + "\n Email: " +this.email + "\n Accont Type: " + this.type +
				"\nIs Account flagged: " + this.isFlagged + "\nMax Checkout: " + this.maxCheckout +
				"Account Balance: " +this.balance + "\nPassword: " +this.passwordString;
	}
	
	/**
	 * check if input is valid if is valid then add the new account to database
	 * else do not add account
	 */
	public boolean checkInput(){
		if(getId().equals("null") || getEmail().equals("null") || getType().equals("Unknown") ||
				getPasswordString().equals("null")) {
			System.out.println("Account Not created!!");
			return false;
		}else {
			System.out.println("Account created!!");
			return true;
			//addToDatabase();
		}
	}
	
	/**
	 * get date
	 * @return type of String in format YYYY-MM-DD
	 */
	protected String date() {
		Date date = new Date();   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = sdf.format(date);  		
		return dateNowStr;
	}
	
	/**
	 * Add an account to database
	 */
//	protected void addToDatabase() {
//		//TODO add Account to database
//	}
	
	/**
	 * find how many days 
	 * @param aDate
	 * @param bDate
	 * @return
	 */
	protected int comparDate(String aDate, String bDate) {
		String delimeter = "-";
		String[] adate; // in yyyy-mm-dd
		String[] bdate; // in yyyy-mm-dd
		int counter = 0;
		int[] temp = new int[3];
		
		adate = aDate.split(delimeter);
		bdate = bDate.split(delimeter);
		
		temp[0] = Integer.parseInt(adate[0]) - Integer.parseInt(bdate[0]);
		temp[1] = Integer.parseInt(adate[1]) - Integer.parseInt(bdate[1]);
		if(temp[1] < 0){
			temp[0] -= 0;
			temp[1] += 30;
		}
		temp[2] = Integer.parseInt(adate[2]) - Integer.parseInt(bdate[2]);
		if(temp[2] < 0){
			temp[1] -= 0;
			temp[2] += 30;
		}
		counter = temp[0] * 365 + temp[1] * 30 + temp[2];
		return counter;
	}

	protected void copy(Account account) {
		this.setId(account.getId());
		this.setEmail(account.getEmail());
		this.setName(account.getName());
		this.setType(account.getType());
		this.setFlagged(account.isFlagged());
		this.setMaxCheckout();
		this.setBalance(account.getBalance());
		this.setPasswordString(account.getPasswordString());
		this.setAge(account.getAge());
		this.setCheckouted(account.getCheckouted());
		this.setWaitList(account.getWaitList());
		this.setCheckoutList(account.getCheckoutList());
		
		
	}
	
	public boolean comparPassword(String input) {
		if(this.getPasswordString().equals(input))
			return true;
		return false;
	}

	public boolean comparID(String input) {
		if(this.getId().equals(input))
			return true;
		return false;
	}
	
	public String getName() {
		return name;
	}
	
}
