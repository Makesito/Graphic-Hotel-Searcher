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
	
	public void DefineLenguages(String[] in) {
		
		Vector<String> vuelta = new Vector<String>();
		
		for(String elem:in) {
		
			elem = (elem.isEmpty()) ? "empty" : elem;
			vuelta.add(elem);
		}
	}

	public Vector<String> GetLenguages(){
		return this.lenguages;
	}
}
