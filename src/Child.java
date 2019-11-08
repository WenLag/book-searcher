 
public class Child extends AverageUser{

	public Child(String id, String email, String password, int age) {
		super(id, email, password, age);
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
			double balance, String passwordString, long age) {
		super(id, email, name, type, isFlagged, maxCheckout,
				balance, passwordString, age);
	}

	protected void setMaxCheckout() {
		this.maxCheckout = 15;
	}
	
	public Account ungreadAccount() {
		if(this.getAge() >= 18) {
			System.out.println("Account type ungread to averageUser!");
			AverageUser averageUser = new AverageUser(this);
			return averageUser;
		}
		System.out.println("Account type not ungread!");
		return this;
	}
}
