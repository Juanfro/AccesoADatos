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

public class Prueba {

	public static void main(String[] args) {

		String ruta = "texto1.txt";
		String rutaCopia = "texto1copy.txt";
		String rutaCopiaChar = "texto1copychar.txt";

		Prueba prueba = new Prueba();

		prueba.copiar(ruta, rutaCopia);
		prueba.copiaChar(ruta, rutaCopiaChar);

	}

	void copiar(String ruta, String rutaCopia) {
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(ruta));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(rutaCopia))) {
			int byteread;
			while ((byteread = in.read()) != -1) {
				if (Character.isLowerCase(byteread)) {
					byteread = Character.toUpperCase(byteread);
				}
				if (Character.isWhitespace(byteread)) {
					byteread = Character.LINE_SEPARATOR;
				}
				out.write(byteread);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void copiaChar(String ruta, String rutaCopiaChar) {
		try (BufferedReader inBufferedReader = new BufferedReader(new FileReader(ruta));
				BufferedWriter out = new BufferedWriter(new FileWriter(rutaCopiaChar))) {
			int byteread;
			while ((byteread = inBufferedReader.read()) != -1) {
				if (Character.isLowerCase(byteread)) {
					byteread = Character.toUpperCase(byteread);
				}
				if (Character.isWhitespace(byteread)) {
					byteread = Character.LINE_SEPARATOR;
				}
				out.write(byteread);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
