package dueloNumeros;

import java.io.RandomAccessFile;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Jugador {

	List<Integer> numerosAleatorios = new ArrayList<>();
	String nombreJugador;
	boolean toyVivo;
	static RandomAccessFile ficheroJugador;

	/**
	 * Inicializa al jugador. <br>
	 * Llama a la inicialización del fichero
	 * 
	 * @param numMax  Valor máximo de los numeros
	 * @param cantNum Cantidad de numeros a generar
	 * @param nombre  Nombre del jugador
	 */
	public void init(int numMax, int cantNum, String nombre) {
		toyVivo = true;

		// Generar números
		List<Integer> numDisponibles = new ArrayList<>();
		for (int i = 0; i < numMax; i++) {
			numDisponibles.add(i + 1);
		}
		Collections.shuffle(numDisponibles);
		for (int i = 0; i < cantNum; i++) {
			numerosAleatorios.add(numDisponibles.get(i));
		}
		// System.out.println("DEBUG:Numeros jugador " + nombre +
		// Arrays.toString(numerosAleatorios.toArray()));// Debug Mostrar
		// numeros

		this.nombreJugador = nombre;

		initFichero();
	}

	/**
	 * Crea e inicializa el fichero del jugador
	 */
	public void initFichero() {

		String nombreFichero = this.nombreJugador + ".dat";
		try {
			ficheroJugador = new RandomAccessFile(nombreFichero, "rw");
			for (int i = 0; i < Partida.cantNum; i++) {
				ficheroJugador.seek(i * 4);
				int numAEscribir = this.numerosAleatorios.get(i);
				ficheroJugador.writeInt(numAEscribir);
			}
			// System.out.println("DEBUG: Fichero " + nombreFichero + " creado e
			// inicializado");//Debug
		} catch (Exception e) {
			e.printStackTrace();
		}

		// DEBUG leer fichero
		System.out.println("DEBUG fichero " + nombreFichero);
		try {
			for (int i = 0; i < Partida.cantNum; i++) {
				ficheroJugador.seek(i * 4);
				System.out.println(ficheroJugador.readInt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// END debug leer fichero
	}

	/**
	 * Finaliza al jugador
	 */

	public void fin() {
		try {
			ficheroJugador.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * El otro jugador trata de averiguar un n�mero
	 */
	public void recibeDisparo(int numero) {
		// FUNCIONA
		/*
		 * if (numerosAleatorios.contains(numero)) { System.out.println("Ouch!\n");
		 * 
		 * for (int i = 0; i < numerosAleatorios.size(); i++) { if
		 * (numerosAleatorios.get(i) == numero) { numerosAleatorios.set(i, -numero); } }
		 * } else { System.out.println("Fallaste\n"); }
		 */
		// FUNCIONA
		int indice = numerosAleatorios.indexOf(numero);
		try {
			if (indice != -1) {
				System.out.println("Ouch!\n");
				numerosAleatorios.set(indice, -numero);

				if (!tasVivo(numerosAleatorios)) {
					toyVivo = false;
					System.out.println(this.nombreJugador + " ha muerto");
				} else {
					System.out.println(this.nombreJugador + " sigue vivo ");
				}
			} else {
				System.out.println("Fallaste!\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra el estado actual de los números del jugador
	 */
	public void estado() {
		// System.out.println(this.numerosAleatorios.toString());//DEBUG
		// Numerosaleatorios

		for (Iterator<Integer> iterator = numerosAleatorios.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if (integer > 0) {
				System.out.print("?" + " ");
			} else {
				System.out.print(-integer + " ");
			}
		}
		System.out.println("");
	}

	/**
	 * Determina si al jugador le quedan números
	 * 
	 * @param numeros
	 */
	public static boolean tasVivo(List<Integer> numeros) {
		boolean toivivo = false;
		for (int numero : numeros) {
			if (numero > 0) {
				toivivo = true;
			}
		}

		return toivivo;

	}

}
