import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class SearcherTest {

	@Test
	void test() throws IOException {
		StringI a1 = new StringI(new String[]{"Introduce new user name","Introduzca su nuevo nombre de usuario"});
		a1.getText(0);
		SwingMenus start = new SwingMenus();
		start.MainMenu();
		start.UserFrame();
		start.HotelFrame(new Room("4Seasons","Deluxe"));
		Restaurant a4 = new Restaurant("Pepe's");
		start.RestaurantFrame(new Restaurant("Pepe's"), 60);
		Hotel a2 = new Hotel("4Seasons");
		Room a3 = new Room("4Seasons","Deluxe");
		a2.getCity();
		a2.getDescription();
		a2.getDistance_center();
		a2.getName();
		a2.isPool();
		a3.get_score();
		a3.getBusy();
		a3.getCapability();
		a3.getSub_name();
		Purchase buying = new Purchase("Pepe");
		AppData data = new AppData();
		buying.setRoom(a3);
		buying.getUser();
		buying.getRoom();
		buying.getTotal();
		buying.getTotalSpend();
		data.newItem(a3);
		data.getRooms();
		data.newRestaurant(a4);
		data.getRestaurants();
	}

}
