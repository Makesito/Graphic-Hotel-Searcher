import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

interface Negocio {
	public String getName();


	public int getDistance_center();


	public String getDescription();


	public String getCity();
}

public class Hotel implements Negocio{

	private String name;
	private int distance_center;
	private String description = "";
	private String city;
	private boolean pool;
	private boolean wifi;

	public Hotel(String nameH) throws IOException{

		File txtin = new File("../Practica3/hotels/" + nameH + ".txt");

		if(!txtin.exists()) {

			PrintWriter txtout = new PrintWriter("../Practica3/hotels/" + nameH + ".txt");
			PrintWriter txtout1 = new PrintWriter("../Practica3/hotels/" + nameH + "Description.txt");
			this.name = nameH;
			txtout.println("name " + nameH);
			txtout.println("distance ");
			txtout.println("pool ");
			txtout.println("city ");
			txtout.println("wifi ");
			JOptionPane.showMessageDialog(null,"Please fullfil the " + nameH + " hotel txt file to proceed","Missing Data",JOptionPane.ERROR_MESSAGE);
			txtout.close();
			txtout1.close();
		}

		else {

			Scanner datatxt = new Scanner(txtin);
			while(datatxt.hasNext()) {
				if(datatxt.next().contains("name")) this.name = datatxt.next();
				if(datatxt.next().contains("distance")) this.distance_center = datatxt.nextInt();
				if(datatxt.next().contains("pool")) if(datatxt.next().contains("true"))this.pool = true; else this.pool = false;
				if(datatxt.next().contains("city")) this.city = datatxt.next();
				if(datatxt.next().contains("wifi")) if(datatxt.next().contains("true"))this.wifi = true; else this.wifi = false;
			}
			datatxt.close();
			File txtin1 = new File("../Practica3/hotels/" + nameH + "Description.txt");
			Scanner datatxt1 = new Scanner(txtin1);
			while(datatxt1.hasNext()) {
				if(this.description.endsWith("."))this.description += "\n";
				this.description += " " + datatxt1.next();
			}
			datatxt1.close();
		}
	}

	public String getName() {
		return name;
	}


	public int getDistance_center() {
		return distance_center;
	}


	public String getDescription() {
		return description;
	}


	public String getCity() {
		return city;
	}


	public boolean isPool() {
		return pool;
	}


	public boolean isWifi() {
		return wifi;
	}
}

class Restaurant implements Negocio{
	
	String name;
	int distance_center;
	String description = " ";
	String city;
	boolean michelin;
	private Vector<Integer> reviews = new Vector<Integer>();
	private float average_score = this.get_score();
	
	public Restaurant(String name) throws FileNotFoundException {
		
	File txtin = new File("../Practica3/restaurants/" + name + ".txt");

	if(!txtin.exists()) {

		PrintWriter txtout = new PrintWriter("../Practica3/restaurants/" + name + ".txt");
		PrintWriter txtout1 = new PrintWriter("../Practica3/restaurants/" + name + "Description.txt");
		PrintWriter txtout2 = new PrintWriter("../Practica3/restaurants/" + name + "Comments.txt");
		this.name = name;
		txtout.println("name " + name);
		txtout.println("distance ");
		txtout.println("city ");
		JOptionPane.showMessageDialog(null,"Please fullfil the " + name + " restaurant txt file to proceed","Missing Data",JOptionPane.ERROR_MESSAGE);
		txtout.close();
		txtout1.close();
	}

	else {

		Scanner datatxt = new Scanner(txtin);
		while(datatxt.hasNext()) {
			if(datatxt.next().contains("name")) this.name = datatxt.next();
			if(datatxt.next().contains("distance")) this.distance_center = datatxt.nextInt();
			if(datatxt.next().contains("city")) this.city = datatxt.next();
		}
		datatxt.close();
		File txtin1 = new File("../Practica3/restaurants/" + name + "Description.txt");
		Scanner datatxt1 = new Scanner(txtin1);
		while(datatxt1.hasNext()) {
			this.description += " " + datatxt1.next();
		}
		datatxt1.close();
		
		File txtin2 = new File("../Practica3/restaurants/" + name + "Comments.txt");
		Scanner datatxt2 = new Scanner(txtin2);
		while(datatxt2.hasNext()) {
			int in = datatxt2.nextInt();
			this.reviews.add(in);
			}
		datatxt1.close();
		this.average_score = this.get_score();
	}
}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getDistance_center() {
		return this.distance_center;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getCity() {
		return this.city;
	}
	
	float get_score() {
		float ret = 0;
		int count = 0;
		for(int elem:this.reviews) {
			ret += elem;
			count++;
		}
		return ret/count;
	}

	public float getAverage_score() {
		return average_score;
	}
	
	
	
}
