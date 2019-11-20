import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChildTest {

	@Test
	void test() {
		childTest();
		childUpgrade();
	}
	Child child = new Child("id", "email", "name", "Child", false, 9999, 0, "password", 18, null, null);
	public void childTest() {
		child.setMaxCheckout();
		long maxcheckout = child.getMaxCheckout();
		assertEquals(15, maxcheckout);
	}
	
	public void childUpgrade() {
		
		
		child.ungradeAccount();
		String type = child.getType();
		System.out.println(type);
		assertEquals("Childr", type);
	}

}
