import java.util.ArrayList;

/**
* To load data to ststem memory
*@author Zeliang Zhuo
*/
public class LoadAccountDatabase {
	
	/**
	 * Load data form database
	 * @param id
	 * @param email
	 * @param name
	 * @param type
	 * @param isFlagged
	 * @param maxCheckout
	 * @param balance
	 * @param passwordString
	 * @param age
	 * @return An Account 
	 */
	public Account Load(String id, String email, String name, String type, boolean isFlagged, long maxCheckout,
			double balance, String passwordString, long age,ArrayList<String> aWaitList, ArrayList<String> checList) {
		Account account = new Librarian(id, email, name, type, isFlagged, maxCheckout, balance, 
				passwordString, age, aWaitList, checList);
		switch (type) {
		case "Librarian":
			account = new Librarian(id, email, name, type, isFlagged, maxCheckout, balance, 
					passwordString, age, aWaitList, checList);
			break;
		case "Teacher":
			account = new Teacher(id, email, name, type, isFlagged, maxCheckout, balance,
					passwordString, age, aWaitList, checList);
			break;
		case "Child":
			account = new Child(id, email, name, type, isFlagged, maxCheckout, balance,
					passwordString, age, aWaitList, checList);
			break;
		case "AverageUser":
			account = new AverageUser(id, email, name, type, isFlagged, maxCheckout, balance, 
					passwordString, age, aWaitList, checList);
			break;
		default:
			break;
		}
		return account;
	}
}
