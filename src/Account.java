/**
 * Account class 
 * An abstract class
 * @author Zeling Zhuo
 */
public abstract class Account {
	
	// Account info, attributes
	protected String id;
	protected String email;
	protected String type;
	protected boolean isFaged;
	protected int maxCheckout;
	protected double balance;
	
	// Accesses 
	
	//TODO add constraints for setters 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public void setMaxCheckout(int maxCheckout) {
		this.maxCheckout = maxCheckout;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * An abstract method, to allowed use to checkout item
	 */
	public abstract void checkout();
	
	/**
	 * the method take one input String as parameters and use the String to 
	 * search if the item exist in database
	 * if exist return the item if not return null
	 * @param aName is type of String 
	 * @return a Book Object
	 */
	public Book searchItem(String aName) {
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
	}
	
	/**
	 * the method allowed use to pay fines 
	 */
	public void payFine() {
		//TODO
	}
	
	/**
	 * the method send a email to user if the state of item they hold is changed
	 */
	public void notifyHold() {
		//TODO
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
