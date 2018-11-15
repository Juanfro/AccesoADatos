package nationalTeam;

import java.util.Scanner;

/*
 Implementar NationalTeam wit jdbc
 Incorporar excepciones
 Factoria. Sin leer propiedades 
 Incorporar lectura de propiedades de un fichero de configuración
 	
 * */
public class NationalTeam {

	private static Dao<Player, Integer> playerDao;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String response;

		try { // Singleton
			playerDao = FactoriaDao.getInstance().getDao();

			System.out.println("Wellcome Mister");
			System.out.println("The current national team is:");
			showNationalTeam();

			do {

			} while (true/* TODO */);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void showNationalTeam() {
		// TODO Auto-generated method stub

	}

}
