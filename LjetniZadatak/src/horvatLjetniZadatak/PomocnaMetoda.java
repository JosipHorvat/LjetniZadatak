package horvatLjetniZadatak;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class PomocnaMetoda {
	
	public void  gitHubLink() {
		Desktop d = Desktop.getDesktop();
	try {
		d.browse(new URI ("https://github.com/JosipHorvat/LjetniZadatak"));
	} catch (IOException e) {
		
		e.printStackTrace();
	} catch (URISyntaxException e) {
		
		e.printStackTrace();
	}

	}
	
	public static boolean metodaZaBrisanje(String poruka) {
		while(true) {
		boolean obrisi = false;
		String brisanje = "da" ;
		String potvrdi = PomocnaMetoda.ucitajString(poruka).toLowerCase();
		if(potvrdi.matches(brisanje)) {
			obrisi = true;
		}
		return obrisi;
		}
	}
	
	public static int brojZnamenki(int broj) {
		int znamenke=0;
		while(broj>0) {
			broj=broj/10;
			znamenke++;
		}
		return znamenke;
	}
	
	//METODA SA TECAJA ZA ISPIS REDNIH BROJEVA SA PRAZNINAMA (001, 002, __3)
	public static String vodecePraznine(int broj) {
		String praznine="";
		while(broj>0) {
			broj=broj/10;
			praznine+=" ";
		}
		return praznine;
	}


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
	public static LocalDate lokalDatum(String poruka, LocalDate localDate) {
		while(true) {
	try {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(""
				+ "dd/MM/yyyy");
		LocalDate date;	
		return   date = LocalDate.parse(JOptionPane.showInputDialog(poruka,localDate));
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
	public static String ucitajString(String poruka,String trenutno) {
		String s;
		while(true) {
			s= JOptionPane.showInputDialog(poruka,trenutno).toLowerCase();
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
