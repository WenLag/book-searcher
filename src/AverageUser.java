import java.util.ArrayList;

public class AverageUser extends Account{

	private final String TEACHER = "AABBCC";
	private final String LIBRARAN = "AABBDD";
	
	public AverageUser(String id, String email, String password, long age) {
		super(id, email, password, age);
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
	
	public Account ungradeAccount() {
		if(this.getAge() < 18) {
			System.out.println("Account type ungread to Child!");
			Child child = new Child(this);
			return child;
		}
		System.out.println("Account type not ungread!");
		return this;
	}
	
	public Account ungreadAccount(String aCode) {
		if(aCode.equals(TEACHER)) {
			System.out.println("Account type ungread to teacher!");
			Teacher teacher = new Teacher(this);
			return teacher;
		}
		if(aCode.equals(LIBRARAN)) {
			System.out.println("Account type ungread to librarian!");
			Librarian librarian = new Librarian(this);
			return librarian;
		}
		System.out.println("Account type not ungread!");
		return this;
	}

}
