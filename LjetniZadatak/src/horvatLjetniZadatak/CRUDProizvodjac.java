package horvatLjetniZadatak;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDProizvodjac {
	
	public static void create(Proizvodjac proizvodjac) {

		//create table proizvodjac (
		//sifra int not null primary key auto_increment,
		//naziv varchar(50) not null,
		//tipVozila varchar(50),
		//marka varchar(50) not null,
		//godinaProizvodnje datetime not null 
		//);
	try {
		PreparedStatement izraz = 
				Baza.getVeza().prepareStatement(
					"insert into proizvodjac"
					+ "(naziv,tipVozila,marka,godinaProizvodnje)"
					+ "values (?,?,?,?)"	);
		izraz.setString(1, proizvodjac.getNaziv());
		izraz.setString(2, proizvodjac.getTipVozila());
		izraz.setString(3, proizvodjac.getMarkaVozila());
		izraz.setString(4, proizvodjac.getDatumProizvodnje().toString());
		
       izraz.executeUpdate();
       
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}