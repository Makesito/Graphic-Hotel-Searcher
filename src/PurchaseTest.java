import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class PurchaseTest {

	@Test
	void test() throws IOException {
		Room a3 = new Room("4Seasons","Deluxe");
		Purchase buying = new Purchase("Pepe");
		buying.setRoom(a3);
		assertEquals(buying.getTotalSpend(),50D);
		
	}

}
