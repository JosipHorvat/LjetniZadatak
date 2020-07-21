package horvatLjetniZadatak;

import java.time.LocalDate;

public class Proizvodjac {
	//create table proizvodjac (
	//sifra int not null primary key auto_increment,
	//naziv varchar(50) not null,
	//tipVozila varchar(50),
	//marka varchar(50) not null,
	//godinaProizvodnje datetime not null 
	//);

	private int sifra;
	private String naziv;
	private String tipVozila;
	private String markaVozila;
	private LocalDate datumProizvodnje;
	
	Proizvodjac(){
		
	}

	public Proizvodjac(int sifra, String naziv, String tipVozila, String markaVozila, LocalDate datumProizvodnje) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.tipVozila = tipVozila;
		this.markaVozila = markaVozila;
		this.datumProizvodnje = datumProizvodnje;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(String tipVozila) {
		this.tipVozila = tipVozila;
	}

	public String getMarkaVozila() {
		return markaVozila;
	}

	public void setMarkaVozila(String markaVozila) {
		this.markaVozila = markaVozila;
	}

	public LocalDate getDatumProizvodnje() {
		return datumProizvodnje;
	}

	public void setDatumProizvodnje(LocalDate datumProizvodnje) {
		this.datumProizvodnje = datumProizvodnje;
	}
	
	
}


