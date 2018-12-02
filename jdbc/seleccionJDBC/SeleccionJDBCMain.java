package seleccionJDBC;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import seleccionJDBC.JugadorJDBC.PositionJDBC;

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
		System.out.println("Bienvenido Seleccionador");
		listadoJugadores();
	}

	private void listadoJugadores() {
		List<JugadorJDBC> listaJugadores = jugadorDao.getAll();

		Iterator<JugadorJDBC> iterator = listaJugadores.iterator();

		while (iterator.hasNext()) {
			// JugadorJDBC jugadorJDBC = (JugadorJDBC) iterator.next();

			JugadorJDBC jugador = iterator.next();
			System.out.println(jugador.toString());

		}

	}

	@SuppressWarnings("resource")
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
				addPlayer();// Añadir jugador
				break;

			case 2:
				deletePlayer();// Borrar Jugador
				break;

			case 3:
				fin();// Salir
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

		int dorsal;
		String nombre;
		PositionJDBC position;

		Scanner scNewJugador = new Scanner(System.in);

		System.out.println("\nAÑADIR JUGADOR:\n");

		// Dorsal
		System.out.println("Dorsal del jugador:");
		dorsal = Integer.parseInt(scNewJugador.nextLine());

		// Nombre
		System.out.println("Nombre del jugador:");
		nombre = scNewJugador.nextLine();

		// Posición
		System.out.println("Elige la posición del jugador:");
		System.out.println("1 - PORTERO");
		System.out.println("2 - DEFENSA");
		System.out.println("3 - MEDIO");
		System.out.println("4 - DELANTERO");

		int opcion = scNewJugador.nextInt();
		position = null;

		switch (opcion) {
		case 1:
			position = PositionJDBC.PORTERO;
			break;
		case 2:
			position = PositionJDBC.DEFENSA;
			break;
		case 3:
			position = PositionJDBC.MEDIO;
			break;
		case 4:
			position = PositionJDBC.DELANTERO;
			break;

		default:
			break;
		}

		JugadorJDBC jugador = new JugadorJDBC(dorsal, nombre, position);
		jugadorDao.save(jugador);

		System.out.println("Jugador añadido. Dorsal: " + dorsal + " | Nombre: " + nombre + " | Posición: " + position);

	}

	private void deletePlayer() {
		Scanner scDelete = new Scanner(System.in);
		int numDorsal;

		System.out.println("\nBORRAR JUGADOR\n");

		System.out.println("Escribe el número de dorsal del jugador a borrar:");
		numDorsal = scDelete.nextInt();

		jugadorDao.delete(numDorsal);

		System.out.println("Jugador " + numDorsal + " borrado");

	}

	private void fin() {
		fin=true;
		
		listadoJugadores();
		System.out.println("A por ellos OEOEOE!!");

	}

}
