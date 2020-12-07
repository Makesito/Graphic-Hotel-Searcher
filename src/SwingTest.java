import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class SwingTest {

	@Test
	void test() throws IOException {
		SwingMenus start = new SwingMenus();
		start.MainMenu();
		start.UserFrame();
		start.HotelFrame(new Room("4Seasons","Deluxe"));
		start.RestaurantFrame(new Restaurant("Pepe's"), 60);

	}
}
