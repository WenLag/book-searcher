import java.util.ArrayList;
/**
 * AverageUser Class
 * @author Zeliang Zhuo
 */
public class AverageUser extends Account{

	private final String TEACHER = "AABBCC"; //upgrade Account code
	private final String LIBRARAN = "AABBDD"; // upgrade Account code
	
	public AverageUser(String id, String email, String password, long age, String name) {
		super(id, email, password, age, name);
		// TODO Auto-generated constructor stub
		this.setMaxCheckout();
	}
	
	public AverageUser(Account account) {
		// TODO Auto-generated constructor stub
		super(account);
	}
	
	/**
	 * Load data from database
	 */
	public AverageUser(String id, String email, String name, String type, boolean isFlagged, long maxCheckout,
			double balance, String passwordString, long age,ArrayList<String> aWaitList, ArrayList<String> checList) {
		super(id, email, name, type, isFlagged, maxCheckout,
				balance, passwordString, age, aWaitList, checList);
	}
	
	protected void setMaxCheckout() {
		this.maxCheckout = 25;
	}
	
	/**
	 * if age is under 18 change type to child
	 * @return Child Account or this
	 */
	public Account upgradeAccount() {
		if(this.getAge() < 18) {
			System.out.println("Account type upgradeAccount to Child!");
			Child child = new Child(this);
			child.setMaxCheckout();
			return child;
		}
		System.out.println("Account type not upgradeAccount!");
		return this;
	}
	
	/**
	 * Upgrade Account
	 * @return Account type
	 */
	public Account upgradeAccount(String aCode) {
		if(aCode.equals(TEACHER)) {
			System.out.println("Account type upgradeAccount to teacher!");
			Teacher teacher = new Teacher(this);
			teacher.setMaxCheckout();
			return teacher;
		}
		if(aCode.equals(LIBRARAN)) {
			System.out.println("Account type upgradeAccount to librarian!");
			Librarian librarian = new Librarian(this);
			librarian.setMaxCheckout();
			return librarian;
		}
		System.out.println("Account type not upgradeAccount!");
		return this;
	}

}
