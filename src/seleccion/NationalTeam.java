package seleccion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import seleccion.Player.Position;

/**
 * Escribe un programa Java que ayude a Luis Enrique a conformar su lista de
 * seleccionados para el siguiente partido del combinado nacional. <br>
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
 * @author Juan
 *
 */

public class NationalTeam {

	static boolean fin;
	static PlayerDao playerDao = new PlayerDao();

	public static void main(String[] args) {

		fin = false;

		bienVenido();

		while (!fin) {
			manageTeam();
		}

		// DEBUG

		// CREAR Jugadores
		/*
		 * Player player0 = new Player(0, "Seleccionador", Player.Position.GOALKEEPER);
		 * playerDao.save(player0); Player player1 = new Player(1, "Jugador Portero",
		 * Player.Position.GOALKEEPER); playerDao.save(player1); Player player2 = new
		 * Player(2, "Jugador Defensa", Player.Position.DEFENDER);
		 * playerDao.save(player2); Player player3 = new Player(3, "Jugador Centro",
		 * Player.Position.MID_FIELDER); playerDao.save(player3); Player player4 = new
		 * Player(4, "Jugador Delantero", Player.Position.FORWARD);
		 * playerDao.save(player4);
		 */

		// Recuperar Jugadores
		/*
		 * Player debugPlayer0 = playerDao.get(0); Player debugPlayer1 =
		 * playerDao.get(1); Player debugPlayer2 = playerDao.get(2); Player debugPlayer3
		 * = playerDao.get(3); Player debugPlayer4 = playerDao.get(4);
		 * 
		 * System.out.println("Dorsal: " + debugPlayer0.getNumber() + " - Nombre: " +
		 * debugPlayer0.getName() + " - Posicion: " + debugPlayer0.getPosition());
		 * System.out.println("Dorsal: " + debugPlayer1.getNumber() + " - Nombre: " +
		 * debugPlayer1.getName() + " - Posicion: " + debugPlayer1.getPosition());
		 * System.out.println("Dorsal: " + debugPlayer2.getNumber() + " - Nombre: " +
		 * debugPlayer2.getName() + " - Posicion: " + debugPlayer2.getPosition());
		 * System.out.println("Dorsal: " + debugPlayer3.getNumber() + " - Nombre: " +
		 * debugPlayer3.getName() + " - Posicion: " + debugPlayer3.getPosition());
		 * System.out.println("Dorsal: " + debugPlayer4.getNumber() + " - Nombre: " +
		 * debugPlayer4.getName() + " - Posicion: " + debugPlayer4.getPosition());
		 */
		// END DEBUG
	}

	/**
	 * mensaje inicial
	 */
	static void bienVenido() {
		System.out.println("Bienvenido Seleccionador");
		listadoJugadores();
	}

	static void manageTeam() {
		System.out.println("\nIntroduzca operación a realizar");
		System.out.println("1. Añadir Jugador");
		System.out.println("2. Borrar Jugador");
		System.out.println("3. Salir");

		try {

			@SuppressWarnings("resource")
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
				manageTeam();
				break;
			}
		} catch (InputMismatchException e) {
			// e.printStackTrace();
			System.out.println("\nOpcion inválida. Debes escribir un número");
			manageTeam();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Muestra todos los jugadores
	 */
	static void listadoJugadores() {

		/*
		 * try { if (!lista.isEmpty()) {
		 * System.out.println("\nLa lista de jugadores actual es la siguiente");
		 * 
		 * for (Player player : lista) { System.out.println(player.getNumber() + ".\t" +
		 * player.getName() + "\t\t" + player.getPosition()); } } else {
		 * System.out.println("No hay jugadores"); } } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

		try {
			List<Player> lista = new ArrayList<Player>();

			lista = playerDao.getAll();

			if (!lista.isEmpty()) {
				System.out.println("\nLa lista de jugadores actual es: ");
				for (Player player : lista) {
					System.out.println(player.getNumber() + ".\t" + player.getName() + "\t\t\t" + player.getPosition());
				}
			} else {
				System.out.println("No hay jugadores");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Añadir un nuevo jugador
	 */
	static void addPlayer() {

		try {
			System.out.println("\nAÑADIR JUGADOR NUEVO:\n");

			@SuppressWarnings("resource")
			Scanner scNewPlayer = new Scanner(System.in);

			// Dorsal
			System.out.println("Dorsal del jugador:");
			// int number = scNewPlayer.nextInt();
			int number = Integer.parseInt(scNewPlayer.nextLine());

			// scNewPlayer.nextLine();

			// Nombre
			System.out.println("Nombre del jugador:");
			String name = scNewPlayer.nextLine();

			// Posición
			System.out.println("Elige la posición del jugador:");
			System.out.println("1 - GOALKEEPER");
			System.out.println("2 - DEFENDER");
			System.out.println("3 - MID_FIELDER");
			System.out.println("4 - FORWARD");

			int optionPosition = scNewPlayer.nextInt();
			Position position = null;

			switch (optionPosition) {
			case 1:
				position = Player.Position.GOALKEEPER;
				System.out.println("Posición: " + position);
				break;
			case 2:
				position = Player.Position.DEFENDER;
				System.out.println("Posición: " + position);
				break;
			case 3:
				position = Player.Position.MID_FIELDER;
				System.out.println("Posición: " + position);
				break;
			case 4:
				position = Player.Position.FORWARD;
				System.out.println("Posición: " + position);
				break;

			default:
				break;
			}

			System.out.println("Nuevo jugador - Dorsal: " + number + " - Nombre: " + name + " - Posición: " + position);

			Player newPlayer = new Player(number, name, position);
			playerDao.save(newPlayer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Borrar un jugador
	 */
	static void deletePlayer() {
		
		Scanner scBorrar = new Scanner(System.in);
		int number;
		
		System.out.println("\nBORRAR JUGADOR:\n");
		System.out.println("Escribe el número de dorsal del jugador a borrar:");
		
		number = scBorrar.nextInt();
		playerDao.delete(number);
		// TODO Borrar jugador
	}

	static void fin() {
		fin = true;

		listadoJugadores();

		System.out.println("\nA por ellos OEOEOE!!");
	}

}
