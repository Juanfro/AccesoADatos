package seleccionJAXB;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <p>
 * Escribe un programa que lea los jugadores de la selección de la base de datos
 * y los exporte a un fichero XML.
 * </p>
 * 
 * <ul>
 * <li>Utiliza la librería JAXB</li>
 * </ul>
 * 
 * <ol>
 * <li>Extiende la funcionalidad para que el programa utilice los datos de un
 * fichero XML con jugadores para incorporar nuevos jugadores a la selección en
 * la BBDD. Los datos provenientes del fichero XML van a sobrescribir los
 * jugadores de la base de datos que tengan el mismo dorsal.</li>
 * <li>Además, añade la funcionalidad necesaria para que el usuario pueda
 * exportar l a información de los jugadores de la base de datos a un fichero
 * XML.</li>
 * <ol>
 * 
 * 
 * @author Juan Antonio Rodríguez
 *
 */
class SeleccionJAXBMain {

	static boolean fin;
	static SeleccionJAXBMain seleccion;
	static Acciones acciones;

	public static void main(String[] args) {
		fin = false;
		seleccion = new SeleccionJAXBMain();
		try {
			acciones = new Acciones();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		while (!fin) {
			seleccion.gestionar();
		}

	}

	void gestionar() {
		System.out.println("Elige una opción:");

		System.out.println("1 - Exportar datos de la base de datos a fichero XML");
		System.out.println("2 - Exportar datos de fichero XML a la base de datos");
		System.out.println("3 - Salir");

		try {
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
			case 1:// BD>>>XML
				crearXML();
				break;
			case 2:// XML>>>BD
				leerXML();
				break;
			case 3: // SALIR
				fin = true;
				break;

			default:
				System.out.println("\nOpcion inválida");
				gestionar();
				break;
			}

		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lee los jugadores de la selección de la base de datos y los exporta a un
	 * fichero XML
	 */
	private void crearXML() {
		System.out.println("Crear XML");
		acciones.DBtoXML();
	}

	private void leerXML() {
		System.out.println("Leer XML");

	}

}
