package ejercicio2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Escribe un programa en Java que permita a usuario indicar en la consola las
 * rutas a un fichero de texto de entrada y otro de salida. El programa lee el
 * texto del fichero de entrada y genera un fichero de salida en el que se han
 * cambiado todas las letras a mayúsculas y cada palabra aparece en una línea.
 * <hr>
 *  Utiliza la librería java.io (Clase BufferedReader, BufferedWriter y
 * Scanner) <br>
 *  Manejo de excepciones <br>
 *  Utiliza la librería java.io (Clase BufferedInputStream y
 * BufferedOutputStream) <br>
 *  Utiliza la librería java.nio (Clase Files)
 * <hr>
 * 1. Completa el ejercicio realizando una gestión adecuada de excepciones. <br>
 * 2. Localiza un fichero con extensión “.jpg” y escribe un programa que realice
 * una copia de dicho fichero binario usando “Streams”. (java.io) <br>
 * 3. Implementa el ejercicio del enunciado usando la clase “Files” (java.nio).
 * 
 * @author Juan
 * 
 *
 */

public class LeerEscribir {

	public static void main(String[] args) {
		System.out.println("Escribe la ruta de un fichero");

		// Ruta del fichero
		Scanner sc = new Scanner(System.in);
		String ruta = sc.nextLine();

		// Ruta de la copia
		System.out.println("Escribe la ruta del nuevo fichero");
		String rutaCopia = sc.nextLine();

		sc.close();

		ruta = "C:\\Archivos\\texto1.txt";
		rutaCopia = "C:\\Archivos\\texto1Copia.txt";
		String rutaCopiaChar = "C:\\Archivos\\texto1CopiaChar.txt";

		copiar(ruta, rutaCopia);
		copiaChar(ruta, rutaCopiaChar);
		copiaImagen();

	}

	public static void copiar(String ruta, String rutaCopia) {
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(ruta));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(rutaCopia))) {
			int byteread;
			while ((byteread = in.read()) != -1) {
				// Convertir a mayuscula
				if (Character.isLowerCase(byteread)) {
					byteread = Character.toUpperCase(byteread);
				}
				if (Character.isWhitespace(byteread)) {
					byteread = Character.LINE_SEPARATOR;// No funciona en notepad
				}
				out.write(byteread);
			}

		} catch (Exception e) {
		}
	}

	public static void copiaChar(String ruta, String rutaCopiaChar) {
		try (BufferedReader in = new BufferedReader(new FileReader(ruta));
				BufferedWriter out = new BufferedWriter(new FileWriter(rutaCopiaChar))) {
			int charRead;
			while ((charRead = in.read()) != -1) {
				if (Character.isLowerCase(charRead)) {
					charRead = Character.toUpperCase(charRead);
				}
				if (Character.isWhitespace(charRead)) {
					charRead = Character.LINE_SEPARATOR;
				}
				out.write(charRead);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Localiza un fichero con extensión “.jpg” y escribe un programa que realice
	 * una copia de dicho fichero binario usando “Streams”. (java.io)
	 */
	public static void copiaImagen() {
		String ruta = "C:\\Archivos\\sc.jpg";
		String rutaCopia = "C:\\Archivos\\Copia_sc.jpg";

		FileInputStream in = null;
		FileOutputStream out = null;

		// Archivo
		File fileIn = new File(ruta);
		System.out.println("El fichero " + fileIn.getName() + " ocupa " + fileIn.length() + " bytes");

		try {
			in = new FileInputStream(ruta);
			out = new FileOutputStream(rutaCopia);

			int byteRead;
			while ((byteRead = in.read()) != -1) {
				out.write(byteRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
