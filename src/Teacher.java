
public class Teacher extends Account{

	public Teacher(String id, String email, String password, int age) {
		super(id, email, password, age);
		// TODO Auto-generated constructor stub
		this.setMaxCheckout();
	}
	
	public Teacher(String id, String email, String name, String type, boolean isFlagged, long maxCheckout,
			double balance, String passwordString, int age) {
		super(id, email, name, type, isFlagged, maxCheckout,
				balance, passwordString, age);
	}
	
	protected void setMaxCheckout() {
		this.maxCheckout = 50;
	}
	

}
