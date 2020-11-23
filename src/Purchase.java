import java.util.Vector;

interface PurchaseI<Stuff>{
	
	public String getUser();
	public Vector<Stuff> getTotal();
	public double getTotalSpend();
	
}


public class Purchase implements PurchaseI{
	
	private Room room;
	private String user;
	private Vector<Room> total = new Vector<Room>();
	
	public Purchase(String user) {
		this.user = user;
	}
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
		total.add(this.room);
	}
	
	public String getUser() {
		return user;
	}
	
	public Vector<Room> getTotal() {
		return total;
		
	}
	
	public double getTotalSpend() {
		double vuelta = 0;
		for(Room elem:total) {
			vuelta += elem.getPrice();
		}
		return vuelta;
	}
	
}
