/**
 * Account class
 * An abstract class
 * @author Zeling Zhuo
 */
public class Account {

	// Account info, attributes
	protected String id;
	protected String email;
	protected String name;
	protected String type;
	protected boolean isFlagged;
	protected long maxCheckout;
	protected double balance;
	protected String passwordString;
	


	public Account(String id, String email, String type, String password) {
		this.setId(id);
		this.setEmail(email);
		this.setType(type);
		this.setMaxCheckout();
		this.setBalance(0);
		this.setFlagged(false);
		this.setPasswordString(password);

		if(getId().equals("null") || getEmail().equals("null") || getType().equals("Unknown") ||
				getPasswordString().equals("null")) {
			System.out.println("Account Not created!!");
		}else {
			System.out.println("Account created!!");
			//TODO add account to database
		}
	}

	/**
	 * Load data from database
	 * @param id
	 * @param email
	 * @param type
	 * @param isFaged
	 * @param maxCheckout
	 * @param balance
	 * @param passwordString
	 */
	public Account(String id, String email, String type, long maxCheckout,
			String passwordString, String Name) {
		this.id = id;
		this.name = Name;
		this.email = email;
		this.type = type;
		this.isFlagged = isFlagged;
		this.maxCheckout = maxCheckout;
		this.balance = balance;
		this.passwordString = passwordString;
	}

	// Accesses
	//TODO add constraints for setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		//TODO id format
		if(id.length() != 7) {
			System.out.println("Error!! ID has to be 7 numbers");
			this.id = "";
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
	public void setFlagged(boolean isFaged) {
		this.isFlagged = isFaged;
	}
	public long getMaxCheckout() {
		return maxCheckout;
	}
	public void setMaxCheckout() {
		String type = this.getType();
		//Set maxCheckout base on account type
		switch (type) {
		case "Librarian":
			this.maxCheckout = 99999;
			break;
		case "Teacher":
			this.maxCheckout = 25;
			break;
		case "Child":
			this.maxCheckout = 4;
			break;
		case "AverageUser":
			this.maxCheckout = 15;
			break;
		default:
			System.out.println("Error! Max Checkout Not Seted! Unknown Type of Account!");
			this.maxCheckout = 0;
			break;
		}

	}

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

	/**
	 * An abstract method, to allowed use to checkout item
	 */
	public void checkout(String aName) {
		//TODO
	}

	/**
	 * the method take one input String as parameters and use the String to
	 * search if the item exist in database
	 * if exist return the item if not return null
	 * @param aName is type of String
	 * @return a Book Object
	 */
	public media searchItem(String aName) {
		//TODO make Book class and add search function
		return null;
	}

	/**
	 * the method to allowed user checkout items if the user have not meet max checkout,
	 * the item is not already checked out, the item is not on hold and the user is not faged
	 * @param aName is type of String
	 */
	public void checkoutItem(String aName) {
		//TODO make checkout function
	}

	/**
	 * the method to allowed user return items
	 * @param aName is type of String
	 */
	public void returnItem(String aName) {
		//TODO make returnItem function
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
	 * the method send a email to user if the state of item they hold is changed
	 */
	public void notifyHold() {
		System.out.printf("Notified User %s Hold Information by Email: %s\n", getId(),getEmail());
	}

	/**
	 * The method put user to the hold list to the item they requiring
	 * @param aName type of String
	 */
	public void putlist(String aName) {
		//TODO
	}

	/**
	 * The method print out the wait list
	 */
	public void displaywaitlist() {
		//TODO
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

	public String toString() {
		return "ID: " + this.id + "\n Email: " +this.email + "\n Accont Type: " + this.type +
				"\nIs Account flagged: " + this.isFlagged + "\nMax Checkout: " + this.maxCheckout +
				"Account Balance: " +this.balance + "\nPassword: " +this.passwordString;
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
