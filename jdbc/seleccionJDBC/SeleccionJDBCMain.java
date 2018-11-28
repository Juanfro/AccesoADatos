package seleccionJDBC;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Escribe un programa que realice la misma funcionalidad que el ejercicio del
 * mismo nombre en la batería de programas anterior, pero utilizando una base de
 * datos relacional como mecanismo de persistencia.
 * 
 * <ul>
 * <li>Diseño clases del patrón DAO</li>
 * <li>Manejo de excepciones</li>
 * <li>Uso de fichero externo de configuración</li>
 * <li>Uso de patrón factoría.</li>
 * </ul>
 * 
 * 
 * <h1>Seleccion</h1> Escribe un programa Java que ayude a Luis Enrique a
 * conformar su lista de seleccionados para el siguiente partido del combinado
 * nacional. <br>
 * El programa permitirá al usuario listar, añadir y borrar jugadores de la
 * lista de elegidos. <br>
 * Cuando la aplicación se inicia lee la lista de jugadores de un fichero
 * binario con la lista de objetos serializados, llamado jugadores.dat, tal y
 * como se quedó al final de la ejecución anterior.<br>
 * La lista de objetos se carga en memoria y se aplican las operaciones según
 * las va solicitando el usuario.<br>
 * Cuando el usuario decide cerrar el programa la lista de jugadores se vuelve a
 * serializar y se vuelcan de nuevo al fichero.<br>
 * Es importante tener en cuenta que solamente se lee y se graban los datos al
 * fichero de jugadores cuando se inicia y finaliza la ejecución del programa.
 * 
 * 
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class SeleccionJDBCMain {

	static boolean fin;
	static SeleccionJDBCMain seleccion;

	private static DaoSeleccion<JugadorJDBC> jugadorDao;

	public static void main(String[] args) {

		fin = false;

		seleccion = new SeleccionJDBCMain();

		try {

			jugadorDao = FactoryDao.getInstance().getDao();

			seleccion.bienVenido();

			while (!fin) {
				seleccion.gestionar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void bienVenido() {
		System.out.println("Bienvenido Seleccionador"); // TODO ¿Se puede escribir el nombre en el xml?
		listadoJugadores();
	}

	private void listadoJugadores() {
		// TODO Auto-generated method stub
		
	}

	void gestionar() {

		System.out.println("\nIntroduzca operación a realizar");
		System.out.println("1. Añadir Jugador");
		System.out.println("2. Borrar Jugador");
		System.out.println("3. Salir");

		try {
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();

			switch (option) {
			case 1:
				addPlayer();
				break;

			case 2:
				deletePlayer();
				break;

			case 3:
				fin();
				break;

			default:
				System.out.println("\nOpcion inválida");
				gestionar();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("\nOpcion inválida. Debes escribir un número");
			gestionar();
		}

	}

	private void addPlayer() {
		// TODO Auto-generated method stub

	}

	private void deletePlayer() {
		// TODO Auto-generated method stub

	}

	private void fin() {
		// TODO Auto-generated method stub

	}

}
