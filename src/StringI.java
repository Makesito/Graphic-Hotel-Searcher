import java.util.Vector;

import javax.swing.JOptionPane;

public class StringI {
	
	Vector<String> text= new Vector<String>();
	

	public StringI(String[] text) {
		for(String elem:text) {
			this.text.add(elem);
		}
	}

	public String getText(int pos) {
		return text.elementAt(pos);
	}

	
}
