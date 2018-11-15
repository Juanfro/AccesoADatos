package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Escribe un programa en Java que permita a usuario indicar en la consola las
 * rutas a un fichero de texto de entrada y otro de salida. El programa lee el
 * texto del fichero de entrada y genera un fichero de salida en el que se han
 * cambiado todas las letras a may�sculas y cada palabra aparece en una l�nea.
 * <br><br>
 * Implementa el ejercicio del enunciado usando la clase �Files� (java.nio).
 * 
 * @author Juan
 *
 */
public class LeerEscribirNio {

	public static void main(String[] args) {
		
		Path ruta = Paths.get("C:\\Archivos\\texto1.txt");
		Path rutaCopia =Paths.get("C:\\Archivos\\texto1CopiarNio.txt"); 
		
		copiarNio(ruta, rutaCopia);
		
	}
	
	public static void copiarNio(Path ruta, Path rutaCopia) {
		try (BufferedReader in = Files.newBufferedReader(ruta);
				BufferedWriter out = Files.newBufferedWriter(rutaCopia,StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE )){
			int charRead;
			while ((charRead= in.read()) != -1) {
				//System.out.println(Character.valueOf((char) byteread));
				if (Character.isLowerCase(charRead)) {
					charRead = Character.toUpperCase(charRead);
				}
				if(Character.isWhitespace(charRead)) {
					
					//System.out.println("Es un espacio");
					charRead= Character.LINE_SEPARATOR;
				}
				out.write(charRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
