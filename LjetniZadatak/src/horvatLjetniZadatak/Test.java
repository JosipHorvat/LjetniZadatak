package horvatLjetniZadatak;
import java.awt.Desktop;
import java.net.URI;


public class Test {

	public static void main(String[] args) throws Exception{
		
//		Desktop d = Desktop.getDesktop();
//		d.browse(new URI ("https://github.com/JosipHorvat/LjetniZadatak"));
		String da;
		String ne = "ne";
		 da =PomocnaMetoda.ucitajString("unesi da").toLowerCase();
		 if (da.matches(ne)) {
			 System.out.println("dobro");
		 
		 }
		 
	}
}
