import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.*;

public class SwingMenus {

	static int leng = 0;
	Purchase buying = null;
	public AppData data = new AppData();

	public void MainMenu() {

		ImageIcon img = new ImageIcon("../Practica3/img/icon.png");
		String[] ops = new String[] {"English","Español"};

		int lengop = JOptionPane.showOptionDialog(null, "Choose your prefer lenguage", "Lenguage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, img, ops,ops[0]);
		if(lengop == JOptionPane.YES_OPTION) leng = 0;
		if(lengop == JOptionPane.NO_OPTION) leng = 1;


		StringI a0 = new StringI(new String[]{"The Best Hotel Searcher:","El mejor buscador de hoteles:"});
		JFrame x = new JFrame(a0.getText(leng));

		StringI a1 = new StringI(new String[]{"Where are you going?","¿A dónde vas?"});
		JTextField place = new JTextField(a1.getText(leng));
		place.setBounds(20,200,200,50);

		StringI a2 = new StringI(new String[]{"Date? yyyy-mm-dd","¿Fecha? aaaa-mm-dd"});
		JTextField day = new JTextField(a2.getText(leng));
		day.setBounds(240,200,200,50);

		StringI a3 = new StringI(new String[]{"How many?","¿Cuantos?"});
		JTextField people = new JTextField(a3.getText(leng));
		people.setBounds(460,200,200,50);

		JButton logo = new JButton(img);
		logo.setBounds(0,0,280,120);
		logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Toolkit.getDefaultToolkit().beep();
			}
		});

		LocalDate ahora = LocalDate.now();
		JTextField clock = new JTextField( ahora.toString());
		clock.setBounds(400, 0, 120, 40);
		clock.setFont(new Font("Serif", Font.BOLD, 20));
		clock.setForeground(Color.black);
		clock.setOpaque(false);
		clock.setEditable(false);

		JButton go = new JButton(new ImageIcon("../Practica3/img/searchicon.png"));
		go.setBounds(650,300,50,50);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(buying == null) {
						StringI a0 = new StringI(new String[]{"You must log in first","Debes de iniciar sesión obligatoriamente"});
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, a0.getText(leng),"User Error",JOptionPane.ERROR_MESSAGE);
						throw new Exception();
					}
					else {
						for(Room elem : data.getRooms()) {
							if(place.getText().contains(elem.getCity())) {
								if(Integer.parseInt(people.getText().trim()) <= elem.getCapability()) {
									boolean confirmation = false;
									for(LocalDate element:elem.getBusy()) {
										LocalDate inTime = LocalDate.parse(day.getText());
										if(inTime==element){
											confirmation = true;
										}
									}
									if(confirmation==false) {
										buying.setRoom(elem);
										HotelFrame(buying.getRoom());
										int resta = JOptionPane.showConfirmDialog(null, "Fancy a restaurant?", "Restaurant", JOptionPane.YES_NO_OPTION);
										if(resta == JOptionPane.YES_OPTION){
											for(Restaurant elemento : data.getRestaurants()) {
												if(elemento.getCity().equals(elem.getCity())) {
													RestaurantFrame(elemento,elem.getDistance_center());
												}
											}
										}
									}
								}
							}
						}
					}
				}

				catch(Exception e1){}
			}
		});

		StringI a4 = new StringI(new String[]{"Register / Log in","Registrarse / Acceder"});
		JButton account = new JButton(a4.getText(leng));
		account.setBounds(580,0,200,50);
		account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFrame();
			}
		});


		x.setSize(800,600);
		x.setIconImage(img.getImage());
		x.setLayout(new BorderLayout());
		x.setContentPane(new JLabel(new ImageIcon("../Practica3/img/background.jpg")));
		x.add(logo);
		x.add(people);
		x.add(day);
		x.add(place);
		x.add(go);
		x.add(account);
		x.setVisible(true);
		x.add(clock);
	}

	public static void HotelFrame(Room in) {
		JFrame x = new JFrame(in.getName() + " " + in.getSub_name());

		ImageIcon img = new ImageIcon("../Practica3/img/icon.png");
		
		StringI a0 = new StringI(new String[]{"We've found your perfect hotel:    " + in.getName() + in.getSub_name() + " room ","Hemos encontrado tu hotel perfecto:    " + in.getName()+" habitación " + in.getSub_name() });
		JLabel name = new JLabel(a0.getText(leng));
		name.setBounds(20, 0, 800, 50);
		name.setFont(new Font("Serif", Font.BOLD, 20));
		name.setForeground(Color.white);

		StringI a1 = new StringI(new String[]{ "For only " + in.getPrice() + " $ the night","Por tan solo " + in.getPrice() + " $ la noche" });
		JLabel price = new JLabel(a1.getText(leng));
		price.setBounds(20, 50, 500, 50);
		price.setFont(new Font("Serif", Font.BOLD, 20));
		price.setForeground(Color.white);

		StringI a2 = new StringI(new String[]{ "Average reviews at "+ in.get_score(),"Media de opiniones: "+ in.get_score()});
		JLabel stars = new JLabel(a2.getText(leng));
		stars.setBounds(20, 100, 500, 50);
		stars.setFont(new Font("Serif", Font.BOLD, 20));
		stars.setForeground(Color.white);
		
		
		StringI a3 = new StringI(new String[]{"High quality client description: " ,"Descripción de cliente de alta calidad: "});
		JLabel description = new JLabel(a3.getText(leng));
		description.setBounds(20, 150, 500, 50);
		description.setFont(new Font("Serif", Font.BOLD, 20));
		description.setForeground(Color.white);

		JLabel description1 = new JLabel(in.getDescription());
		description1.setBounds(20, 200, 500, 50);
		description1.setFont(new Font("Serif", Font.BOLD, 20));
		description1.setForeground(Color.white);

		x.setSize(800,600);
		x.setIconImage(img.getImage());
		x.setLayout(new BorderLayout());
		x.setContentPane(new JLabel(new ImageIcon("../Practica3/hotels/" + in.getName() + ".jpg")));
		x.add(name);
		x.add(price);
		x.add(stars);
		x.add(description);
		x.add(description1);
		x.setVisible(true);
	}

	public static void RestaurantFrame(Restaurant in,int dist) {
		JFrame x = new JFrame(in.getName());

		ImageIcon img = new ImageIcon("../Practica3/img/icon.png");
		

		StringI a0 = new StringI(new String[]{"We've found your perfect restaurant:  " + in.getName(),"Hemos encontrado el restaurante perfecto:  " + in.getName()});
		JLabel name = new JLabel(a0.getText(leng));
		name.setBounds(20, 0, 500, 50);
		name.setFont(new Font("Serif", Font.BOLD, 20));
		name.setForeground(Color.black);


		StringI a1 = new StringI(new String[]{ "Average reviews at "+ in.get_score(),"Media de opiniones: "+ in.get_score()});
		JLabel stars = new JLabel(a1.getText(leng));
		stars.setBounds(20, 100, 500, 50);
		stars.setFont(new Font("Serif", Font.BOLD, 20));
		stars.setForeground(Color.black);

		StringI a3 = new StringI(new String[]{"High quality client description: " ,"Descripción de cliente de alta calidad: "});
		JLabel description = new JLabel(a3.getText(leng));
		description.setBounds(20, 150, 500, 50);
		description.setFont(new Font("Serif", Font.BOLD, 20));
		description.setForeground(Color.black);

		JLabel description1 = new JLabel(in.getDescription());
		description1.setBounds(20, 175, 500, 50);
		description1.setFont(new Font("Serif", Font.BOLD, 20));
		description1.setForeground(Color.black);
		
		int distancehr = (Math.max(in.distance_center, dist) - Math.min(in.distance_center, dist));
		
		
		StringI a4 = new StringI(new String[]{"Only at " + distancehr + " meters of your place." ,"Solo " + (in.distance_center - dist) + " metros de tu hotel."});
		JLabel distance = new JLabel(a4.getText(leng));
		distance.setBounds(20, 230, 500, 50);
		distance.setFont(new Font("Serif", Font.BOLD, 20));
		distance.setForeground(Color.black);

		x.setSize(800,600);
		x.setIconImage(img.getImage());
		x.setLayout(new BorderLayout());
		x.setContentPane(new JLabel(new ImageIcon("../Practica3/restaurants/" + in.getName() + ".jpg")));
		x.add(name);
		x.add(stars);
		x.add(description);
		x.add(description1);
		x.add(distance);
		x.setVisible(true);
	}

	public void UserFrame() {
		ImageIcon img = new ImageIcon("../Practica3/img/usericon.jpg");

		StringI a0 = new StringI(new String[]{"LogIn","Acceder"});
		JFrame x = new JFrame(a0.getText(leng));

		StringI a1 = new StringI(new String[]{"User","Usuario"});
		JTextField user = new JTextField(a1.getText(leng));
		user.setBounds(20, 50, 200, 30);

		JPasswordField pass = new JPasswordField("Password");
		pass.setBounds(20,110,200,30);

		StringI a2 = new StringI(new String[]{"Register","Registrarse"});
		JButton register = new JButton(a2.getText(leng));
		register.setBounds(10, 170, 120, 50);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringI a1 = new StringI(new String[]{"Introduce new user name","Introduzca su nuevo nombre de usuario"});
				String new_user = JOptionPane.showInputDialog(null, a1.getText(leng), "New user", JOptionPane.INFORMATION_MESSAGE);
				StringI a2 = new StringI(new String[]{"Introduce password","Introduzca su nueva contraseña"});
				String new_pass = JOptionPane.showInputDialog(null, a2.getText(leng), "New user", JOptionPane.INFORMATION_MESSAGE);


				try {
					FileWriter fw = new FileWriter("../Practica3/data/users.txt",  true);
					PrintWriter txtout = new PrintWriter(fw);
					txtout.println("\n" + new_user + " " + new_pass);
					txtout.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton go = new JButton(new ImageIcon("../Practica3/img/searchicon.png"));
		go.setBounds(190,170,50,50);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File txtin = new File("../Practica3/data/users.txt");
				try {
					boolean acces = false;
					Scanner datatxt = new Scanner(txtin);
					while(datatxt.hasNext()) {
						if(datatxt.next().contains(user.getText())) {
							if(datatxt.next().contains(pass.getText())) {
								buying = new Purchase(user.getText());
								acces = true;
								StringI a1 = new StringI(new String[]{"Succesfull Log in "+ buying.getUser() + " Congratulations","Acceso correcto "+ buying.getUser() + " enhorabuena"});
								StringI a2 = new StringI(new String[]{ "Congratulations","Enhorabuena"});
								JOptionPane.showMessageDialog(null, a1.getText(leng), a2.getText(leng),JOptionPane.INFORMATION_MESSAGE);
								x.setVisible(false);
							}
						}

					}
					StringI a1 = new StringI(new String[]{"User or password incorrect","Usuario o contraseña incorrectos"});
					if(!acces)JOptionPane.showMessageDialog(null, a1.getText(leng), "Error",JOptionPane.ERROR_MESSAGE);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		x.setIconImage(img.getImage());
		x.setSize(300,300);
		x.setLayout(new BorderLayout());
		x.setContentPane(new JLabel(new ImageIcon("../Practica3/img/background1.jpg")));
		x.add(user);
		x.add(pass);
		x.add(go);
		x.add(register);
		x.setVisible(true);
	}

}
