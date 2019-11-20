import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AccountTesting {

	@Test
	void test() {
		testJSONNotEmpty();
		get_set_Test();
		Test_ComparDate();
		Test_Account();
		Test_Account_2();
		Test_CheckInput();
		Test_ToString();
		Test_Date();
		Test_ResetPassword();
		Test_ResetPassword_2();
		Test_IsAbleToCheckout();
		Test_CheckInput_2();
		Test_Checkout();
		Test_Checkout_2();
		Test_Checkout_3();
		Test_putlist();
		Test_NotifyHold();
		Test_Renew();
		Test_ComperAccount();
		Test_ComperPassword();
		Test_ComperPassword_2();
		Test_ComperId();
		Test_ComperId_2();
		Test_PrintWaitList();
		Test_NotifyFines();
		Test_Pay();
		Test_Return();
		Test_PrintCheckout();
		Test_setAge();
		Test_ResetPassword_3();
		Test_ResetPassword_4();
		Test_SetType();
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
	
	public void Test_ComparDate() {
		Account account = new AverageUser("910502f", "legend@email.sc.edu", "Jsoh", "Librarian", false, 14,0 ,
				"mei", 19, null,null);
		
		String temp = account.date();
		String tempString = "2019-11-20";
		assertEquals(tempString, temp);
	}
	
	public void Test_Account() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		assertEquals("id", account.getId());
		assertEquals("email", account.getEmail());
		assertEquals("password", account.getPasswordString());
		assertEquals("name", account.getName());
	}
	
	public void Test_Account_2() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		Account temp = new AverageUser(account);
		temp.toString();
		
	}
	
	public void Test_CheckInput() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		boolean temp = account.checkInput();
		assertEquals(true, temp);
	}
	
	public void Test_CheckInput_2() {
		Account account = new AverageUser("", "email", "password", 18, "name");
		boolean temp = account.checkInput();
		assertEquals(false, temp);
	}
	
	public void Test_ToString() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		assertEquals("ID: " + account.id + "\n Email: " +account.email + "\n Accont Type: " + account.type +
				"\nIs Account flagged: " + account.isFlagged + "\nMax Checkout: " + account.maxCheckout +
				"Account Balance: " +account.balance + "\nPassword: " +account.passwordString + "\nAge: " + account.getAge()
				,account.toString());
	}
	
	public void Test_Date() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		String temp = "2019-11-20";
		//assertEquals("temp", account.date());
	}
	
	public void Test_ResetPassword() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		account.resetPassword("password1");
		assertEquals("password1",account.getPasswordString());
	}
	
	public void Test_ResetPassword_2() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		account.resetPassword("password2","password1");
		assertEquals("password",account.getPasswordString());
	}
	
	public void Test_ResetPassword_3() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		account.resetPassword("password2","password1111111111111111111");
		assertEquals("password",account.getPasswordString());
	}
	
	public void Test_ResetPassword_4() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		account.resetPassword("password1111111111111111111");
		assertEquals("password",account.getPasswordString());
	}
	
	public void Test_IsAbleToCheckout() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		boolean temp = account.isAbleCheckout();
		assertEquals(true, temp);
	}
	
	public void Test_Checkout() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		Media media = new BookItem("Title","1997","Genre",
				 "ISBN", 4," Pulisher"," Author",
				 2, true, 14,new ArrayList<String>(), "Book");
		
		account.checkoutItem(media);
		assertEquals(1, account.checkouted);
		//System.out.println(account.checkouted);
	}
	
	public void Test_Checkout_2() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		Media media = new BookItem("Title","1997","Genre",
				 "ISBN", 4," Pulisher"," Author",
				 2, true, 14,new ArrayList<String>(), "Book");
		account.setBalance(-20);
		account.checkoutItem(media);
		assertEquals(0, account.checkouted);
		//System.out.println(account.checkouted);
	}
	
	public void Test_Checkout_3() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		Media media = null;
		
		account.checkoutItem(media);
		assertEquals(0, account.checkouted);
		//System.out.println(account.checkouted);
	}
	
	public void Test_putlist() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		Media media = new BookItem("Title","1997","Genre",
				 "ISBN", 4," Pulisher"," Author",
				 2, true, 14,new ArrayList<String>(), "Book");
		account.putlist(media);
		assertEquals(0, media.holdlist.size());
	}
	
	public void Test_NotifyHold() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		account.notifyHold();
	}
	
	public void Test_Renew() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		Media media = new BookItem("Title","1997","Genre",
				 "ISBN", 4," Pulisher"," Author",
				 2, true, 14,new ArrayList<String>(), "Book");
		account.checkoutList.add(media.getName());
		account.checkoutList.add("2019-10-20");
		//account.printCheckoutList();
		account.renew(media);
	}
	
	public void Test_ComperAccount() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		Account account2 = new AverageUser("id", "email", "password", 18, "name");
		assertEquals(false,account.compareAccount());
	}
	
	public void Test_ComperPassword() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		boolean temp = account.comparPassword("password");
		assertEquals(true,temp);
	}
	
	public void Test_ComperPassword_2() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		boolean temp = account.comparPassword("password1");
		assertEquals(false,temp);
	}
	
	public void Test_ComperId() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		boolean temp = account.comparID("id");
		assertEquals(true,temp);
	}
	
	public void Test_ComperId_2() {
		Account account = new AverageUser("i1d", "email", "password", 18, "name");
		boolean temp = account.comparID("id");
		//assertEquals(false,temp);
	}
	
	public void Test_PrintWaitList() {
		Account account = new AverageUser("i1d", "email", "password", 18, "name");
		account.waitList.add("Book");
		account.printWaitList();
	}
	
	public void Test_NotifyFines() {
		Account account = new AverageUser("i1d", "email", "password", 18, "name");
		account.setBalance(-30);
		account.notifyFines();
	}
	
	public void Test_Pay() {
		Account account = new AverageUser("i1d", "email", "password", 18, "name");
		account.setBalance(-30);
		account.payFine(30);
	}
	
	public void Test_Return() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		Media media = new BookItem("Title","1997","Genre",
				 "ISBN", 4," Pulisher"," Author",
				 2, true, 14,new ArrayList<String>(), "Book");
		account.checkoutList.add("Title");
		account.checkoutList.add("2019-12-12");
		account.checkouted = 1;
		account.returnItem(media);
	}
	
	public void Test_PrintCheckout() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		account.checkoutList.add("Title");
		account.checkoutList.add("2019-12-12");
		account.checkoutList.add("Title1");
		account.checkoutList.add("2019-12-12");
		account.checkoutList.add("Title2");
		account.checkoutList.add("2019-12-12");
		account.checkouted = 3;
		account.printCheckoutList();

	}
	
	public void Test_setAge() {
		Account account = new AverageUser("id", "email", "password", 18, "name");
		account.setAge(200);
	}
	
	public void Test_SetType() {
		Account account = new AverageUser("id", "email", "password", 11, "name");
		account.setType();
	}
	
	

}

