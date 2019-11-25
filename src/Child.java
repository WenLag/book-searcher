import java.util.ArrayList;
/**
 * Child Class
 * @author Zeliang Zhuo
 */
public class Child extends AverageUser{

	public Child(String id, String email, String password, int age, String name) {
		super(id, email, password, age, name);
		// TODO Auto-generated constructor stub
		this.setMaxCheckout();
	}
	
	public Child(Account account) {
		// TODO Auto-generated constructor stub
		super(account);
	}
	
	/**
	 * Load data from database
	 */
	public Child(String id, String email, String name, String type, boolean isFlagged, long maxCheckout,
			double balance, String passwordString, long age,ArrayList<String> aWaitList, ArrayList<String> checList) {
		super(id, email, name, type, isFlagged, maxCheckout, balance, 
				passwordString, age, aWaitList,checList);
	}

	protected void setMaxCheckout() {
		this.maxCheckout = 15;
	}
	
	/**
	 * if age is not under 18 change type to averageUser
	 * @return Account type
	 */
	public Account ungreadAccount() {
		if(this.getAge() >= 18) {
			System.out.println("Account type upgradeAccount to averageUser!");
			AverageUser averageUser = new AverageUser(this);
			return averageUser;
		}
		System.out.println("Account type not upgradeAccount!");
		return this;
	}
}
