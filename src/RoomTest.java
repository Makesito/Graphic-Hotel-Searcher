import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void test() throws IOException {
		Room a1 = new Room("4Seasons","Deluxe");
		System.out.println(a1.get_score());
		assertEquals(a1.getCapability(),4);
		assertEquals(a1.get_score(),6.3f);
		assertEquals(a1.getCity(),"Madrid");
		assertEquals(a1.isWifi(),true);
		
	}

}
