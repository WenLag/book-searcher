import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AccountTesting {

	@Test
	void test() {
		testJSONNotEmpty();
		get_set_Test();
		
	}
	
	public void testJSONNotEmpty() {
		boolean fact;
		AccountParser AP = new AccountParser();
		ArrayList<Account> accounts = AP.parseAccount();
		if(accounts == null) {
			fact = false;
		} else {
			fact = true;
		}
		assertEquals(true,fact);
	}
	
	public void get_set_Test() {
		LoadAccountDatabase Lad = new LoadAccountDatabase();
		ArrayList<String> waitTest = null;
		ArrayList<String> checkTest = null;
		Account account = Lad.Load("910502f", "legend@email.sc.edu", "Jsoh", "Librarian", false, 14,0 ,
				"mei", 19, waitTest,checkTest);
		long age = account.getAge();
		String id = account.getId();
		String email = account.getEmail();
		String name = account.getName();
		String type = account.getType();
		boolean isFlagged = account.isFlagged();
		double balance = account.getBalance();
		ArrayList<String> waitlist = account.getWaitList();
		ArrayList<String> checklist = account.getCheckoutList();
		long maxCheckout = account.getMaxCheckout();
		assertEquals(19, age);
		assertEquals("910502f", id);
		assertEquals( "legend@email.sc.edu", email);
		assertEquals("Jsoh", name);
		assertEquals("Librarian", type);
		assertEquals(false, isFlagged);
		assertEquals(0, balance);
		assertEquals(14, maxCheckout);
		assertEquals("mei", account.getPasswordString());
		account.setAge(22);
		account.setId("1111");
		account.setEmail("new@email.com");
		account.setFlagged(true);
		account.setName("newname");
		account.setType("AverageUser");
		account.setBalance(15);
		account.setPasswordString("new");
		assertEquals(22, account.getAge());
		assertEquals("1111", account.getId());
		assertEquals( "new@email.com", account.getEmail());
		assertEquals("newname", account.getName());
		assertEquals("AverageUser", account.getType());
		assertEquals(true, account.isFlagged());
		assertEquals(15, account.getBalance());
		assertEquals("new", account.getPasswordString());
		account.setType("Child");
		assertEquals("Child", account.getType());
		account.setType("Teacher");
		assertEquals("Teacher", account.getType());
		account.setType("Librarian");
		assertEquals("Librarian", account.getType());
		account.setType("x");
		assertEquals("Unknown", account.getType());
	}

}
