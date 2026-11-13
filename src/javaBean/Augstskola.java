package javaBean;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Augstskola {

	public static void main(String[] args) {
		String izvelne, fNosaukums = "studenti.ser";
		String[] darbibas = {"Jauns students", "Noņemt studentu",
				"Meklēt studentu", "Studentu saraksts", "Kārtot",
				"Budžeta vietas", "Stipendijas", "Aizvērt programmu"};
		String[] programmas = {"Uznēmējdarbība un vadīšana",
				"Datorsistēmas",
				"Mehatronika",
				"Elektrotehnoloģiju datorvadība"};
		Integer[] kurss = {1, 2, 3, 4, 5};
		String[] atbilde = {"Jā", "Nē"};
		
		// Vēlāk pieliksiet ievades datu pārbaudi veseliem skaitļiem
		int studSk = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Cik studentus uzglabāsi?", "Studentu skaits",
						JOptionPane.INFORMATION_MESSAGE));
		
			if(studSk < 1)
			JOptionPane.showMessageDialog(null, "Nevar uzglabāt mazāk nekā 1 studentu", "Kļūda",
					JOptionPane.WARNING_MESSAGE);
		
		
		
		
		Students[] studentuMasivs = new Students[studSk];
		Students persona = null;
		// Vēlāk izsauksim deserializāciju
		int indekss = 0;
		
		do {
			izvelne = (String) JOptionPane.showInputDialog(null,
					"Izvēlies darbību", "Izvēlne", JOptionPane.QUESTION_MESSAGE,
					null, darbibas, darbibas[0]);
			
					if(izvelne == null)
						izvelne = darbibas[darbibas.length-1];
					
				switch(izvelne) {
				case "Jauns students":
					persona = new Students();
					String vards = Metodes.virknesParbaude(
							"Ievadi studenta vārdu", "Pēteris");
					if(vards == null)
						break;
					persona.iestatitVards(vards);
					
					String uzvards = Metodes.virknesParbaude(
							"Ievadi studenta uzvārdu", "Ozols");
					if(uzvards == null)
						break;
					persona.iestatitUzvards(uzvards);
					
					String pk = Metodes.burtciparuParbaude(
							"Ievadi studenta personas kodu", "000000-00000");
					if(pk == null)
						break;
					persona.iestatitPersKods(pk);
					
					String talr = Metodes.talrunaParbaude(
							"Ievadi tālruņa numuru", "23345319");
					if(talr == null)
						break;
					persona.iestatitTalr(talr);
					
					String studProg = (String) JOptionPane.showInputDialog(null,
							"Izvēlies studiju programmu", "Izvēlne",
							JOptionPane.QUESTION_MESSAGE, null,
							programmas, programmas[0]);
					if(studProg == null)
						break;
					persona.iestatitStudProg(studProg);
					
					
					persona.iestatitAplNr(Metodes.generetNr("Ievadi apliecības numuru", "PA0000000"));
					
					Integer cipars = (Integer) JOptionPane.showInputDialog(
							null, "Izvēlies kursu", "Izvēlne",
							JOptionPane.QUESTION_MESSAGE, null, kurss, kurss[0]);
					if(cipars == null)
						break;
					persona.iestatitKurss(cipars);
					
					if(JOptionPane.showInputDialog(null,
							"Vai jāmaksā par studijām?", "Valsts finansējums",
							JOptionPane.QUESTION_MESSAGE, null,
							atbilde, atbilde[0]).equals("Jā")) {
							persona.iestatitValstsFin(false);
					} else {
						persona.iestatitValstsFin(true);
					}
					
					if(JOptionPane.showInputDialog(null,
							"Vai saņem stipendiju?", "Stipendija",
							JOptionPane.QUESTION_MESSAGE, null,
							atbilde, atbilde[0]).equals("Jā")) {
						persona.iestatitSanemStip(true);
					} else {
						persona.iestatitSanemStip(false);
					}
						
					if(indekss < studentuMasivs.length) {
					    studentuMasivs[indekss] = persona;
					    indekss++;
					    
					} else {
						JOptionPane.showMessageDialog(null,
						"Masīvā nav brīvu vietu!", "Brīdinājums",
						JOptionPane.ERROR_MESSAGE);
						break;
					}
					break;
					
				case "Noņemt studentu":
					int kuruDzest = Metodes.meklet(studentuMasivs,
							JOptionPane.showInputDialog("Ievadi apliecības Nr."));
					if(kuruDzest != -1) {
						studentuMasivs[kuruDzest] = null;
						JOptionPane.showMessageDialog(null,
								"Students dzēst!", "Paziņojums",
								JOptionPane.WARNING_MESSAGE);
					}
					break;
					
				case "Meklēt studentu":
					int kuruAtrast = Metodes.meklet(studentuMasivs,
							JOptionPane.showInputDialog("Ievadi apliecības Nr."));
					if(kuruAtrast != -1) {
						JOptionPane.showMessageDialog(null, 
						"Students: " + studentuMasivs[kuruAtrast].dabutVards() + " "
						+ studentuMasivs[kuruAtrast].dabutUzvards() 
						+ "\nStudenta apliecības nr.: " + studentuMasivs[kuruAtrast].dabutAplNr()
						+ "\nTālrunis: " + studentuMasivs[kuruAtrast].dabutTalr() 
						+ "\nPersonas k.: " + studentuMasivs[kuruAtrast].dabutPersKods()
						+ "\nStudiju programma: " + studentuMasivs[kuruAtrast].dabutStudProg() 
						+ " kurss: " + studentuMasivs[kuruAtrast].dabutKurss()
						+ "\nValsts finansējums: " + studentuMasivs[kuruAtrast].irValstsFin()
						+ "\nSaņem stipendiju: " + studentuMasivs[kuruAtrast].irSanemStip());
					}
					break;
					
				case "Studentu saraksts":
					String str = "Studentu saraksts:\n" + "_".repeat(20) + "\n";
					for(int i = 0; i < studentuMasivs.length; i++) {
						if(studentuMasivs[i] != null) {
						str += "Students: " + studentuMasivs[i].dabutVards() + " "
						       + studentuMasivs[i].dabutUzvards() 
						       + "\nStudenta apliecības nr.: " + studentuMasivs[i].dabutAplNr()
						       + "\nTālrunis: " + studentuMasivs[i].dabutTalr() 
						       + "\nPersonas k.: " + studentuMasivs[i].dabutPersKods()
						       + "\nStudiju programma: " + studentuMasivs[i].dabutStudProg() 
						       + " kurss: " + studentuMasivs[i].dabutKurss()
					           + "\nValsts finansējums: " + studentuMasivs[i].irValstsFin()
						       + "\nSaņem stipendiju: " + studentuMasivs[i].irSanemStip()
						       + "\n" + "_".repeat(20) + "\n";
						}
					}
					
					JTextArea ta = new JTextArea(str, 10, 40);
					ta.setEditable(false);
					JScrollPane sp = new JScrollPane(ta); 
					JOptionPane.showMessageDialog(null, sp, "Saraksts",
							JOptionPane.PLAIN_MESSAGE);	
					break;
					
				case "Budžeta vietas":
				    String budzets = "Studenti budžeta vietās:\n"
				            + "_".repeat(20) + "\n";

				    int budzetaSkaits = 0;

				    for(int i = 0; i < studentuMasivs.length; i++) {
				        if(studentuMasivs[i] != null &&
				                studentuMasivs[i].irValstsFin()) {

				            budzets += studentuMasivs[i].dabutVards() + " "
				                    + studentuMasivs[i].dabutUzvards()
				                    + "\nStudiju programma: "
				                    + studentuMasivs[i].dabutStudProg()
				                    + "\nKurss: "
				                    + studentuMasivs[i].dabutKurss()
				                    + "\nApliecības Nr.: "
				                    + studentuMasivs[i].dabutAplNr()
				                    + "\n" + "_".repeat(20) + "\n";

				            budzetaSkaits++;
				        }
				    }

				    budzets += "\nKopā budžeta studenti: " + budzetaSkaits;

				    JTextArea budzetaTa = new JTextArea(budzets, 10, 40);
				    budzetaTa.setEditable(false);
				    JScrollPane budzetaSp = new JScrollPane(budzetaTa);

				    JOptionPane.showMessageDialog(null, budzetaSp,
				            "Budžeta vietas", JOptionPane.INFORMATION_MESSAGE);
				    break;


				case "Stipendijas":
				    String stipendija = "Studenti, kuri saņem stipendiju:\n"
				            + "_".repeat(20) + "\n";

				    int stipendijuSkaits = 0;

				    for(int i = 0; i < studentuMasivs.length; i++) {
				        if(studentuMasivs[i] != null &&
				                studentuMasivs[i].irSanemStip()) {

				            stipendija += studentuMasivs[i].dabutVards() + " "
				                    + studentuMasivs[i].dabutUzvards()
				                    + "\nStudiju programma: "
				                    + studentuMasivs[i].dabutStudProg()
				                    + "\nKurss: "
				                    + studentuMasivs[i].dabutKurss()
				                    + "\nApliecības Nr.: "
				                    + studentuMasivs[i].dabutAplNr()
				                    + "\n" + "_".repeat(20) + "\n";

				            stipendijuSkaits++;
				        }
				    }

				    stipendija += "\nKopā stipendiju saņēmēji: " + stipendijuSkaits;

				    JTextArea stipendijuTa = new JTextArea(stipendija, 10, 40);
				    stipendijuTa.setEditable(false);
				    JScrollPane stipendijuSp = new JScrollPane(stipendijuTa);

				    JOptionPane.showMessageDialog(null, stipendijuSp,
				            "Stipendijas", JOptionPane.INFORMATION_MESSAGE);
				    break;
				
				case "Aizvērt programmu":
					JOptionPane.showMessageDialog(null, "Programma tika apturēta!",
							"Uz tikšanos!", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				
		} while(!izvelne.equals(darbibas[darbibas.length-1])); // "Aizvērt programmu"
	}
}
