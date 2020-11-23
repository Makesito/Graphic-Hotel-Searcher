import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Room extends Hotel{

	private String sub_name;
	private double price;
	private float average_score;
	private boolean smoke;
	private Vector<Integer> reviews = new Vector<Integer>();
	private Vector<LocalDate> busy = new Vector<LocalDate>();
	private int capability;
	private String image;
	
	
	public Room(String nameH,String nameR) throws IOException {
		super(nameH);
		File txtin = new File("../Practica3/hotels/" + nameH + nameR + ".txt");

		if(!txtin.exists()) {
			PrintWriter txtout = new PrintWriter("../Practica3/hotels/" + nameH + nameR + ".txt");
			this.sub_name = nameR;
			txtout.println("name " + nameR);
			txtout.println("price ");
			txtout.println("smoke ");
			txtout.println("capability ");
			JOptionPane.showMessageDialog(null,"Please fullfil the " + nameH + " " + nameR + " hotel room txt file to proceed","Missing Data",JOptionPane.ERROR_MESSAGE);
			txtout.close();

			PrintWriter txtout1 = new PrintWriter("../Practica3/hotels/" + nameH + nameR + "Comments.txt");
			PrintWriter txtout2 = new PrintWriter("../Practica3/hotels/" + nameH + nameR + "Busy.txt");
			PrintWriter txtout3 = new PrintWriter("../Practica3/hotels/" + nameH + nameR + "Image.txt");
			txtout1.close();
			txtout2.close();
			txtout3.close();
		}

		else {
			Scanner datatxt = new Scanner(txtin);
			while(datatxt.hasNext()) {
				if(datatxt.next().contains("name")) this.sub_name = datatxt.next();
				if(datatxt.next().contains("price")) this.price = datatxt.nextFloat();
				if(datatxt.next().contains("smoke")) if(datatxt.next().contains("true"))this.smoke = true; else this.smoke = false;
				if(datatxt.next().contains("capability")) this.capability = datatxt.nextInt();
			}
			datatxt.close();


			File txtin1 = new File("../Practica3/hotels/" + nameH + nameR + "Comments.txt");
			Scanner datatxt1 = new Scanner(txtin1);
			while(datatxt1.hasNext()) {
				int in = datatxt1.nextInt();
				this.reviews.add(in);
				}
			datatxt1.close();
			this.average_score = this.get_score();

			File txtin2 = new File("../Practica3/hotels/" + nameH + nameR + "Busy.txt");
			Scanner datatxt2 = new Scanner(txtin2);
			while(datatxt2.hasNext()) {
				LocalDate inTime = LocalDate.parse(datatxt2.next());
				this.busy.add(inTime);
			}
			datatxt2.close();
			
		}
	}
	
	public float get_score() {
		float ret = 0;
		int count = 0;
		for(int elem:this.reviews) {
			ret += elem;
			count++;
		}
		return ret/count;
	}

	public String getSub_name() {
		return sub_name;
	}

	public double getPrice() {
		return price;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public int getCapability() {
		return capability;
	}

	public String getImage() {
		return image;
	}

	public Vector<LocalDate> getBusy() {
		return busy;
	}

	
}
