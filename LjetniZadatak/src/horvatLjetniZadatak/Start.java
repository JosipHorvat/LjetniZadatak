package horvatLjetniZadatak;

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
		System.out.println("5. IZLAZ");
		akcija();
	}
	private void akcija() {
		switch(PomocnaMetoda.ucitajBroj("Odaberite broj za zeljenu akciju:")) {
		
		case 1: 
			CRUDProizvodjac.create(new Proizvodjac(1,
					PomocnaMetoda.ucitajString("Unesi naziv vozila:"),
					PomocnaMetoda.ucitajString("Unesi tip vozila"),
					PomocnaMetoda.ucitajString("Unesi marku vozila"),
					PomocnaMetoda.lokalDatum("Unesi datum proizvodnje")));
				izbornik();	
					
					
			
			break;
		case 2:
			pregledProizvodjaca();
			izbornik();
			break;
		}
	}

	private void pregledProizvodjaca() {
	
		
	}
	public static void main(String[] args) {
		new Start();
	}
}
