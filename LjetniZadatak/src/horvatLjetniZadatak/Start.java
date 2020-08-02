package horvatLjetniZadatak;

import java.util.List;

import javax.swing.JOptionPane;

public class Start {

	public Start() {
		izbornik();
		Baza.zatvoriVezu();
	}
	
	private void izbornik() {
		System.out.println("1. Unesi novog proizvodjaca:");
		System.out.println("2. Izlistaj sve proizvodjace:");
		System.out.println("3. Promjena podataka proizvodjaca:");
		System.out.println("4. Obrisi proizvodjaca:");
		System.out.println("5. Link na GitHub za ovaj projekt:");
		System.out.println("6. IZLAZ");
		System.out.println("********************************");
		akcija();
	}
	private void akcija() {
		switch(PomocnaMetoda.ucitajBroj("Odaberite broj za zeljenu akciju:")) {
		
		case 1: 
			CRUDProizvodjac.create(new Proizvodjac(1,
					PomocnaMetoda.ucitajString("Unesi naziv proizvodjaca:"),
					PomocnaMetoda.ucitajString("Unesi vrstu  vozila (motocikl,automobil,kamion..)"),
					PomocnaMetoda.ucitajString("Unesi marku vozila"),
					PomocnaMetoda.lokalDatum("Unesi datum proizvodnje")));
				izbornik();	
				break;
		case 3: 
			promjenaProizvodjaca();
		case 2:
			pregledProizvodjaca();
			izbornik();
			break;
		case 4:
			obrisiProizvodjaca();
			break;
		case 5: 
		PomocnaMetoda pm = new PomocnaMetoda();
		   pm.gitHubLink();
		   izbornik();
			break;
		case 6: 
			System.out.println("Hvala i dovidjenja.");
			return;
			
		default:
			System.out.println("Ne postojeca akcija!");
		}		
					
			
		
		
	}

	private void promjenaProizvodjaca() {
		
		Proizvodjac proizvodjac = odaberiProizvodjaca("Unesi redni broj proizvodjaca kojeg zelite mijenjati:");
		if(proizvodjac== null) {
			JOptionPane.showMessageDialog(null, "Neispravan redni broj!");
			return;
		}
		proizvodjac.setNaziv(PomocnaMetoda.ucitajString("Unesi naziv ptoizvodjaca:", proizvodjac.getNaziv()));
		proizvodjac.setTipVozila(PomocnaMetoda.ucitajString("Promjeni tip vozila:", proizvodjac.getTipVozila()));
		proizvodjac.setMarkaVozila(PomocnaMetoda.ucitajString("Promijeni marku vozila:", proizvodjac.getMarkaVozila()));
		proizvodjac.setDatumProizvodnje(PomocnaMetoda.lokalDatum("Promijeni datum proizvodnje: ", proizvodjac.getDatumProizvodnje()));
  
		CRUDProizvodjac.update(proizvodjac);
	}
	private Proizvodjac odaberiProizvodjaca(String poruka) {
		pregledProizvodjaca();
		int redniBroj = PomocnaMetoda.ucitajBroj(poruka);
		
		return CRUDProizvodjac.getProizvodjac(redniBroj);
	}

	private void pregledProizvodjaca() {
	
		List<Proizvodjac> proizvodjaci = CRUDProizvodjac.read();
		String redniBroj;
		for(int i=0; i<proizvodjaci.size(); i++) {
			redniBroj=PomocnaMetoda.vodecePraznine(proizvodjaci.size())+(i+1);
			redniBroj= redniBroj.substring(redniBroj.length()-PomocnaMetoda.brojZnamenki(proizvodjaci.size()));
			System.out.println(redniBroj + ". " + "\n"+ proizvodjaci.get(i) );
			System.out.println("**********************************");
		}
		
		
	}
	private void obrisiProizvodjaca() {
		Proizvodjac proizvodjac = odaberiProizvodjaca("Unesi redni broj Proizvodjaca kojeg zelite obrisati");
		if(proizvodjac==null) {
			JOptionPane.showMessageDialog(null, "Neispravan redni broj");
		}
//		String brisanje = "da";
//		String potvrdi = PomocnaMetoda.ucitajString("Za potvrdu brisanja upisi DA, otkazi bilo sto").toLowerCase();
//		if(brisanje.matches(potvrdi)) {
//			CRUDProizvodjac.delete(proizvodjac.getSifra());		
//		}
		if(PomocnaMetoda.metodaZaBrisanje("Za potvrdu brisanja upisi DA, otkazi bilo sto")==true) {
			CRUDProizvodjac.delete(proizvodjac.getSifra());	
		}
	
		izbornik();
	}
	
	public static void main(String[] args) {
		new Start();
		
		
	}// zavrsiti pravilno string bilder za proizvodjaca!!
}
