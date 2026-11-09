package javaBean;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Metodes {
	static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			
			virkne = virkne.trim();
		} while(!Pattern.matches("^[\\p{L} ]+$", virkne));
		
		return virkne;
	}
	
	static String burtciparuParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			
			virkne = virkne.trim();
		} while(!Pattern.matches("^[[0-9]{6}-[0-9]{5}$", virkne));
		
		return virkne;
	}
}
