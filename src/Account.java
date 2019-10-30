/**
 * Account class 
 * An abstract class
 * @author Zeling Zhuo
 */
public class Account {
	
	// Account info, attributes
	protected String id;
	protected String email;
	protected String type;
	protected boolean isFaged;
	protected int maxCheckout;
	protected double balance;
	protected String Name;
	
	
	public Account() {

	public Account(String id, String email, String type) {
		this.setId(id);
		this.setEmail(email);
		this.setType(type);
		this.setMaxCheckout();
		this.setBalance(0);
		this.setFaged(false);
		
		if(getId() == "" || getEmail() == "" || getType() == "") {
			System.out.print("Account Not created!!");
		}else {
			System.out.print("Account created!!");
			//TODO add account to database
		}

		
	}
	// Accesses 
	
	public String getName() {
		return Name;
	}
	//TODO add constraints for setters 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		//TODO id format
		if(id.length() != 7) {
			System.out.print("Error!! ID has to be 7 numbers");
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
			System.out.print("No email entered!");
			this.email = "";
			return;
		}
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
			System.out.print("Error! Unknown Account Type!");
			this.type = "Unknown";
		}
	}
	public boolean isFaged() {
		return isFaged;
	}
	public void setFaged(boolean isFaged) {
		this.isFaged = isFaged;
	}
	public int getMaxCheckout() {
		return maxCheckout;
	}
	public void setMaxCheckout() {
		String type = this.getType();
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
			System.out.print("Error! Max Checkout Not Seted! Unknown Type of Account!");
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
	/**
	 * An abstract method, to allowed use to checkout item
	 */
	public void checkout() {
		
	}

	public void checkout();

	
	/**
	 * the method take one input String as parameters and use the String to 
	 * search if the item exist in database
	 * if exist return the item if not return null
	 * @param aName is type of String 
	 * @return a Book Object
	 */
	public Book searchItem(String aName) {
		
		return null;
		//TODO make Book class and add search function
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
		System.out.printf("Notified User %s by Email: %s", getId(),getEmail());
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
		System.out.printf("Notified User %s by Email: %s", getId(),getEmail());
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
	public void resetPassword() {
		//TODO
	}
}
