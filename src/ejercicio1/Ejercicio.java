package ejercicio1;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Escribe un programa Java que lea la ruta de un directorio y muestre en
 * pantalla el listado de ficheros que cuelgan de él. <br>
 * <ul>
 * <li>Utiliza la librería java.io (Clase File)</li>
 * <li>Manejo de excepciones</li>
 * <li>Algoritmo iterativo y/o recursivo</li>
 * <li>Utiliza la librería java.nio (Clase Path, Paths y Files), método
 * walkFileTree y clase SimpleFileVisitor</li>
 * <li>Uso de colecciones y estructuras funcionales como forEach</li>
 * <ul>
 * <ol>
 * <li>Completa el ejercicio realizando una gestión adecuada de
 * excepciones.</li>
 * <li>Extiende la funcionalidad del ejercicio mostrando la lista de ficheros
 * del directorio y de sus sucesivos subdirectorios.</li>
 * <li>Implementa la funcionalidad del punto 1 utilizando la clase “Files” de la
 * librería java.nio</li>
 * <ol>
 */

public class Ejercicio {

	public static void main(String[] args) {
		System.out.println("Escribe una ruta:\n");

		// Obtener ruta
		Scanner sc = new Scanner(System.in);
		String ruta = sc.nextLine();
		ruta = "C:\\Archivos";// DEBUG:Ruta predeterminada
		sc.close();

		// Manejo de ficheros
		File fichero = new File(ruta);
		// Ruta
		System.out.println("La ruta es:");
		System.out.println(ruta + "\n");

		// Primer Apartado

		listado(fichero);
		System.out.println("-------------------------");

		System.out.println("Listado recursivo");

		listadoRecursivo(fichero);
		System.out.println("-------------------------");

		// Llamar a la función filenames usando fichero como parámetro
		// listFileNames(fichero);

	}

	public static void listado(File fichero) {

		System.out.println("Listado básico");

		try {
			// Archivos
			System.out.println("Tiene estos arhivos:");

			File[] contenido = new File[fichero.list().length];
			contenido = fichero.listFiles();

			for (File file : contenido) {
				if (file.isFile()) {
					System.out.println(file.getName());
				}
			}

			// Carpetas
			System.out.println("Y estas carpetas: ");

			for (File file : contenido) {
				if (file.isDirectory()) {
					System.out.println(file.getName());
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

	}

	public static void listadoRecursivo(File fichero) {

		File[] contenido = new File[fichero.list().length]; // Nuevo Array con archivos/directorios
		contenido = fichero.listFiles();

		for (File file : contenido) {
			if (file.isFile()) {
				System.out.println(file.getAbsoluteFile());
			} else {
				System.out.println(file.getAbsoluteFile());
				// System.out.print("\t");
				listadoRecursivo(file);
			}
		}

	}

	// Start PROFESOR////////////////////////////////////////////////

	public static void listFileNames(File f) {

		System.out.println("Solución Profesor:\n");

		Deque<File> nodes = new ArrayDeque<>(Arrays.asList(f));
		while (!(nodes.isEmpty())) {
			File node = nodes.pop();
			List<File> files = Arrays.asList(node.listFiles());
			files.sort(Comparator.comparing(File::getAbsoluteFile));// Ordenar
			files.forEach((file) -> {
				if (file.isFile()) {
					System.out.println(file.getAbsoluteFile());
				} else {
					nodes.addLast(file);
				}
			});
		}
	}

	//////////////////////////////////////////////////////////////////

	public static void listFileNamesRecursive(File f) {

	}

	// END PROFESOR////////////////////////////////////////////////
}