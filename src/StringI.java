import java.util.Vector;

import javax.swing.JOptionPane;

public class StringI {
	
	Vector<String> text= new Vector<String>();
	Vector<String> lenguages = new Vector<String>();
	

	public StringI(String[] text) {
		for(String elem:text) {
			this.text.add(elem);
		}
	}

	public String getText(int pos) {
		return text.elementAt(pos);
	}

	public int getLenguageNumber(String lenguage) {
		int cont = 0;
		for(String elem:this.lenguages) {
			if(elem.contains(lenguage)) return cont;
			cont++;
		}
		JOptionPane.showMessageDialog(null, "Lenguage not found", "Error",JOptionPane.ERROR_MESSAGE);
		return (Integer) null;
	}
	
}
