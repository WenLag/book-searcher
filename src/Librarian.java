
public class Librarian extends Account{

	private Librarian(String id, String email, String password, int age) {
		super(id, email, password,age);
		this.setMaxCheckout();
	}
	
	/**
	 * Load data from database
	 */
	public Librarian(String id, String email, String name, String type, boolean isFlagged, long maxCheckout,
			double balance, String passwordString, long age) {
		
		super(id, email, name, type, isFlagged, maxCheckout,
				balance, passwordString, age);
		
	}
	
	protected void setMaxCheckout() {
		this.maxCheckout = 999999;
	}
	
	protected void addItem() {
		//TODO
	}
	
	protected void removeItem() {
		//TODO
	}
	
	protected void updateItme() {
		//TODO
	}
	
	protected void accessAcount(Account account) {
		//TODO
	}
	
	protected void addAccount() {
		//TODO
	}
	
	protected void romeAccount() {
		//TODO
	}
	
}
