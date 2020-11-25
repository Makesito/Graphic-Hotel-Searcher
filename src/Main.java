import java.io.IOException;

public class Main {

	public static void main (String[] args) throws IOException {
		
		SwingMenus start = new SwingMenus();
		Room x = new Room("4Seasons","Deluxe");
		start.data.newItem(x);
		start.data.newItem(new Restaurant("Pepe's"));
		start.MainMenu();
		
		//Hotel a1 = new Hotel("4Seasons");
		//Room a11 = new Room("4Seasons","Deluxe");
	}

}
