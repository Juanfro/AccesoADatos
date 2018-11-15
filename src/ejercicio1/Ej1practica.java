package ejercicio1;

import java.io.File;

public class Ej1practica {

	public static void main(String[] args) {

		String ruta = ".";

		File fichero = new File(ruta);

		System.out.println("La ruta es:" + fichero.getAbsolutePath());

		listado(fichero);

		System.out.println("\nLISTADO RECURSIVO");
		listadoRecursivo(fichero);
	}

	static void listado(File file) {
		System.out.println("Listado simple");

		System.out.println("El directorio tiene estos ficheros y directorios");

		String[] ficheros = new String[file.list().length];

		ficheros = file.list();

		for (String fichero : ficheros) {
			System.out.println(fichero);
		}

		System.out.println("******************************************");
	}

	static void listadoRecursivo(File file) {
		File[] contenido = new File[file.list().length];
		contenido = file.listFiles();

		for (File elemento : contenido) {
			if (elemento.isFile()) {
				System.out.println(elemento.getAbsolutePath());
			} else if (elemento.isDirectory()) {
				listadoRecursivo(elemento);
			}
		}
	}

}
