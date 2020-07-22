package horvatLjetniZadatak;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	//sifra int not null primary key auto_increment,
			//naziv varchar(50) not null,
			//tipVozila varchar(50),
			//marka varchar(50) not null,
			//godinaProizvodnje datetime not null 
			//);
	
	public static List<Proizvodjac> read(){
		List<Proizvodjac> proizvodjaci = new ArrayList<Proizvodjac>();
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(
					"select * from proizvodjac order by naziv");
			ResultSet rs = izraz.executeQuery();
			while(rs.next()) {
				proizvodjaci.add(
						new Proizvodjac(
								rs.getInt("sifra"),
								rs.getString("naziv"),
								rs.getString("tipVozila"),
								rs.getString("marka"),
								rs.getDate("godinaProizvodnje").toLocalDate()
								)
						);
			}
			rs.close();
			izraz.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return	 proizvodjaci;
			
		
	}
	public static Proizvodjac getProizvodjac(int redniBroj) {
		int rb = 0;
		for (Proizvodjac p : read()) {
			if(++rb== redniBroj) {
				return p;
			}
			
		}
		return null;
	}

	public static void update(Proizvodjac proizvodjac) {
		// TODO Auto-generated method stub
		// Napisati metodu za update  novog proizvodjaca! 
		// OVDJE MORAM PREPAREDSTATEMENT = BAZA GET  VEZA 
		// I EXECUTE UPDATE
	}
}