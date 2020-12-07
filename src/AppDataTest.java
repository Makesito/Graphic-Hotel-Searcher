import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class AppDataTest {

	@Test
	void test() throws IOException {
		
		Room a3 = new Room("4Seasons","Deluxe");
		AppData data = new AppData();
		data.newItem(a3);
		data.getRooms();
		data.getRestaurants();
	}

}
