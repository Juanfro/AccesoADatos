package ejercico1;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
Escribe un programa Java que lea la ruta 
de un directorio y muestre en pantalla el listado 
de ficheros que cuelgan de él.

    • Utiliza la librería java.io (Clase File)
    • Manejo de excepciones
    • Algoritmo iterativo y/o recursivo
    • Utiliza la librería java.nio (Clase Path, Paths y Files), método walkFileTree y clase SimpleFileVisitor
    • Uso de colecciones y estructuras funcionales como forEach


    1. Completa el ejercicio realizando una gestión adecuada 
    	de excepciones.
    2. Extiende la funcionalidad del ejercicio mostrando 
    	la lista de ficheros del directorio 
    	y de sus sucesivos subdirectorios.
    3. Implementa la funcionalidad del punto 1 
    	utilizando la clase “Files” de la librería java.nio*/

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

		// Llamar a la función filenames usando fichero como parámetro
		listFileNames(fichero);

		try {
			// Ruta
			System.out.println("La ruta es:");
			System.out.println(ruta + "\n");

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

	// START MIO

	public static void miListado(File f) {

	}

	// END MIO

	// Start PROFESOR////////////////////////////////////////////////
	public static void listFileNames(File f) {
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
	// END PROFESOR////////////////////////////////////////////////
}
