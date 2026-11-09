package javaBean;

import javax.swing.JOptionPane;

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
					
					// masiva nevar -1 izmera
					// ļauj ievadīt personas kodu tada formata
					
					
					break;
				}
					
		} while(!izvelne.equals(darbibas[darbibas.length-1])); // "Aizvērt programmu"
	}
}
