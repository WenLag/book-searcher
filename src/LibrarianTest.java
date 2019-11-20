import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class LibrarianTest {

	@Test
	void test() {
		Librarian();
		upgradeAccTest();
	}
	Librarian lb = new Librarian("id", "email", "name", "Librarian", false, 9999, 0, "password", 20, null, null);
	public void Librarian() {
		
		lb.setMaxCheckout();
		long newMaxCheckout = lb.getMaxCheckout();
		assertEquals(999999, newMaxCheckout);
	}
		
	public void upgradeAccTest() {
		lb.ungreadAccount("AABBDD");
		String typechange = lb.getType();
		assertEquals("Librarian", typechange);
	}

}
