package javaBean;

import java.util.Random;
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
		} while(!Pattern.matches("^[0-9]{6}-[0-9]{5}$", virkne));
		
		return virkne;
	}
	
	static String talrunaParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			
			virkne = virkne.trim();
		} while(!Pattern.matches("^[2, 6]{1}[0-9]{7}$", virkne));
		
		return virkne;
	}
	
	static String generetNr(String zinojums, String noklusejums) {
	 
	    Random rand = new Random();
	    int min = 65, max = 90 , skaits = 5, randSk;
	    StringBuilder sb = new StringBuilder(skaits);
	    for(int i = 0; i < skaits; i++){
	    randSk = rand.nextInt(max - min) + min;
	     sb.append((char)randSk);
	     }
	     String aplNr = sb.toString();
	     JOptionPane.showMessageDialog(null,
	    		  "Piešķirts apliecības nr: "
	    		  + aplNr, 
	    		  "Paziņojums",
	    		  JOptionPane.INFORMATION_MESSAGE);
	     return aplNr;
	     
	     /*static String generetNr(String zinojums, String noklusejums) {
    	   String virkne;
           Random rand = new Random();

		   // Generate a random valid ID (2 uppercase letters + 7 digits)
		   char burts1 = (char) ('A' + rand.nextInt(26));
		   char burts2 = (char) ('A' + rand.nextInt(26));
		   int cipari = 1000000 + rand.nextInt(9000000);
		   String nejausaisNr = "" + burts1 + burts2 + cipari;
		
		   // Use the random ID if noklusejums is null, empty, or the placeholder "PA0000000"
		   String ieteikums = (noklusejums == null || noklusejums.isEmpty() || noklusejums.equals("PA0000000")) 
		           ? nejausaisNr 
		           : noklusejums;
		
		   do {
		       virkne = JOptionPane.showInputDialog(zinojums, ieteikums);
		
		       if (virkne == null) {
		           return null;
		       }
		
		       virkne = virkne.trim();
		   } while (!Pattern.matches("^[A-Z]{2}[0-9]{7}$", virkne));
		
		   return virkne;
	}*/
		     
	}
	
	static int meklet(Students[] studentuMasivs, String aplNr) {
		for(int i = 0; i < studentuMasivs.length; i++) {
			if(studentuMasivs[i] != null &&
					studentuMasivs[i].dabutAplNr().equalsIgnoreCase(aplNr)) {
				return i;
			}
		}
		
		JOptionPane.showMessageDialog(null,
				"Students ar Apliecības nr.: " + aplNr + " netika atrasts!",
				"Brīdinājums", JOptionPane.WARNING_MESSAGE);
		return -1;
	}
}

