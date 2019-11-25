import java.util.ArrayList;

/**
 * Teacher Class
 * @author Zeliang Zhuo
 */
public class Teacher extends Account{

	public Teacher(String id, String email, String password, int age, String name) {
		super(id, email, password, age, name);
		// TODO Auto-generated constructor stub
		this.setMaxCheckout();
	}
	
	public Teacher(Account account) {
		// TODO Auto-generated constructor stub
		super(account);
	}
	
	public Account upgradeAccount(String aCode) {
		return this;
	}
	
	/**
	 * Load data from database
	 */
	public Teacher(String id, String email, String name, String type, boolean isFlagged, long maxCheckout,
			double balance, String passwordString, long age,ArrayList<String> aWaitList, ArrayList<String> checList) {
		super(id, email, name, type, isFlagged, maxCheckout,
				balance, passwordString, age, aWaitList, checList);
	}
	
	protected void setMaxCheckout() {
		this.maxCheckout = 50;
	}
	

}
