package dueloNumeros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Escribe un programa Java que implemente un juego muy sencillo en el que dos
 * jugadores tienen que acertar los números aleatorios generados para su
 * oponente. <br>
 * El programa genera 5 números aleatorios distintos del 1 al 10 para cada
 * jugador y además de guardarlos en sendas colecciones los guarda en dos
 * ficheros binarios con los nombres de jugador1.dat y jugador2.dat. <br>
 * <br>
 * El juego inicia un bucle de turnos en el que cada jugador intenta adivinar
 * uno de los números de su rival. Si el jugador acierta el número, el programa
 * le informa del acierto y elimina el número del archivo del contrincante. <br>
 * El juego termina cuando un jugador acierta todos los números y el fichero del
 * rival se ha quedado vacío. <br>
 * <ul>
 * <li>Diseño clase Juego y Jugador</li>
 * <li>Utiliza la librería java.io (Clase RandomAccessFile)</li>
 * <li>Manejo de excepciones</li>
 * <li>Algoritmo iterativo</li>
 * </ul>
 * 
 * 
 * <ol>
 * <li>Añade la funcionalidad de preguntar al usuario si quiere jugar una nueva
 * partida para iniciar un nuevo juego.</li>
 * </ol>
 * 
 * @author Juan
 *
 */
public class Partida {
	static List<Jugador> jugadores = new ArrayList<>();
	static int numMax = 10;// El número más alto
	static int cantNum = 5;// Cantidad de números
	// static int turno;
	static int turnoActual;

	public static void main(String[] args) {
		init();
		try {
			juega();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa la partida
	 */
	public static void init() {
		// Crear Jugadores
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		System.out.println("***** Jugadores creados *****");

		jugadores.clear();

		jugadores.add(jugador1);
		jugadores.add(jugador2);

		// Turno
		turnoActual = 0;

		// Inicializar jugadores
		jugador1.init(numMax, cantNum, "Jugador1");
		jugador2.init(numMax, cantNum, "Jugador2");

		System.out.println("***** Ficheros creados *****\n");

		// turno = 1;

	}

	/**
	 * Funcionamiento de la partida
	 */
	public static void juega() {

		Scanner scDisparo = new Scanner(System.in);
		Scanner scSeguir = new Scanner(System.in);

		while (!hayGanador()) {
			mostrarEstado();
			// disparo();
			disparar(scDisparo);
		}

		seguirJugando(scSeguir);
		scDisparo.close();
		scSeguir.close();
	}

	/**
	 * El jugador actual intenta adivinar un numero de su oponente
	 */
	/*
	 * static void disparo() {
	 * 
	 * int disparo; System.out.println("\nTurno del jugador: " + turno + ": ");
	 * System.out.println("Adivina un número de tu oponente: ");
	 * 
	 * Scanner sc = new Scanner(System.in); disparo = Integer.parseInt(sc.next());
	 * // sc.close();// PORQUE?
	 * 
	 * try { switch (turno) { case 1:// Turno del jugador1
	 * jugadores.get(1).recibeDisparo(disparo); cambioTurno(); // turno = 2; break;
	 * 
	 * case 2:// Turno del jugador2 jugadores.get(0).recibeDisparo(disparo);
	 * cambioTurno();// turno = 1; break;
	 * 
	 * default: System.out.println("Zasca"); throw new
	 * Exception("Excepción Turno Incorrecto");
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); } finally {
	 * 
	 * }
	 * 
	 * // mostrarEstado();// DEBUG }
	 */

	/**
	 * El jugador activo envía un disparo al jugador inactivo
	 * 
	 * @param sc
	 */
	static void disparar(Scanner sc) {
		int disparo;
		System.out.println("\nTurno del jugador: " + (turnoActual + 1) + ": ");
		System.out.println("Adivina un número de tu oponente: ");

		disparo = Integer.parseInt(sc.next());

		jugadores.get(siguienteTurno()).recibeDisparo(disparo);// El jugador no activo recibe el disparo

		turnoActual = siguienteTurno();
	}

	/**
	 * Cambia el turno de jugador
	 */
	static int siguienteTurno() {
		return (turnoActual + 1) % 2;
	}

	/**
	 * Cambia el turno
	 */
	/*
	 * public static void cambioTurno() { if (turno == 1) { turno = 2; } else if
	 * (turno == 2) { turno = 1; } }
	 */

	/**
	 * Muestra el estado de los jugadores
	 */
	static void mostrarEstado() {

		System.out.println("\nEstado del jugador1");
		jugadores.get(0).estado();
		System.out.println("Estado del jugador2");
		jugadores.get(1).estado();
	}

	/**
	 * Termina la partida
	 */
	public static void fin() {
		for (Jugador jugador : jugadores) {
			jugador.fin();
		}
	}

	static boolean hayGanador() {
		boolean haylo = false;

		if (jugadores.get(0).toyVivo && jugadores.get(1).toyVivo) {
			haylo = false;
		} else {
			haylo = true;
		}

		return haylo;
	}

	static void seguirJugando(Scanner scSeguir) {

		System.out.println("\n\nElige una opción:");
		System.out.println("Pulsa \"1\" para jugar otra partida");
		System.out.println("Pulsa \"2\" para cerrar el programa.");

		int option = Integer.parseInt(scSeguir.next());

		if (option == 1) {
			init();
			juega();
		} else if (option == 2) {
			fin();
		} else {
			System.out.println("Opción no válida");
			seguirJugando(scSeguir);
		}

	}

}
