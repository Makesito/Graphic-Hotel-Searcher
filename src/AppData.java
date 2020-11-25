import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JOptionPane;


public class AppData{
	
	private Vector<Room> rooms = new Vector<Room>();
	private Vector<Restaurant> restaurants = new Vector<Restaurant>();

	
	public Vector<Room> getRooms(){
		return rooms;
	}

	public void newItem(Room in) {
		rooms.add(in);
	}
	
	public Vector<Restaurant> getRestaurants(){
		return restaurants;
	}
	
	public void newItem (Restaurant in) {
		restaurants.add(in);
	}
	
}
