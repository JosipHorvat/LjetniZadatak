package horvatLjetniZadatak;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

import javax.swing.JOptionPane;

public class PomocnaMetoda {


	// RANDOM BOOLEAN 
	public static boolean randomBoolean() {
		Random rand = new Random();
		
	
	return rand.nextBoolean();
	}

	
	// Random datumi
	public static int randomIntIzmedju(int start, int kraj) {
		return start + (int) Math.round(Math.random() * (kraj - start));
	}

	
	public static LocalDate randomDatum(int pocetnaGodina, int krajGodine) {
		int dan = randomIntIzmedju(1, 28 );
		int mjesec = randomIntIzmedju(1, 12);

		
		int godina = randomIntIzmedju(pocetnaGodina, krajGodine);
	return LocalDate.of(godina, mjesec, dan);
	}
	
	
	//METODA ZA DATUME
	public static LocalDate lokalDatum(String poruka) {
		while(true) {
	try {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(""
				+ "dd/MM/yyyy");
		LocalDate date;	
		return   date = LocalDate.parse(JOptionPane.showInputDialog(poruka),dateFormat);
	}catch(DateTimeParseException e) {
		JOptionPane.showMessageDialog(null, "Krivi unos, pokusaj ponovno!");
	}
	}

		
	}
	//METODA ZA BROJEVE
	public static int ucitajBroj(String poruka) {
		while(true) {
			try {
				return Integer.parseInt(
						JOptionPane.showInputDialog(poruka));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Krivi unos");
			}
		}
	}
// METODA ZA STRING   //NEMA EXCEPTION ZA CANCEL I X NA JOP
	public static String ucitajString(String poruka) {
		String s;
		while(true) {
			s= JOptionPane.showInputDialog(poruka).toLowerCase();
			if(s.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Obavezan unos");
			continue;
			}
			return s;
		}
		
	}
	
	// METODA ZA BOOLEAN
	public static boolean zabranjeno(String poruka) {
		String zabranjeno;
		boolean daIliNe = false;
		while(true) {
			zabranjeno = JOptionPane.showInputDialog(poruka);
			if (!zabranjeno.trim().toLowerCase().equals("da")
				|| !zabranjeno.trim().toLowerCase().equals("ne") ) {
				break;
			}
		}
		if (zabranjeno == "da") {
			daIliNe= true;
			if(zabranjeno == "ne"){
				daIliNe =false;
			}
			
		}
		return daIliNe;
		}
}// kraj
