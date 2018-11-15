package gestionAlumnos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Escribe una aplicación que lea registros de alumnos de un fichero de texto,
 * utilice dicha información para crear objetos de la clase Alumno y grabe
 * dichos objetos a un fichero binario.<br>
 * El programa solicitará la ruta tanto del fichero de entrada como del fichero
 * de salida por consola.<br>
 * El fichero de texto recogerá la información de cada alumno en registors con
 * el siguiente formato:<br>
 * 
 * <ul style = "list-style: none">
 * <li>Número de expediente</li>
 * <li>Nombre y apellidos. Separados por el caracter separador "|"</li>
 * <li>Fecha de nacimiento</li>
 * <li>Dirección completa</li>
 * <li>Telefono</li>
 * </ul>
 * 
 * <br>
 * 
 * Ejemplo de fichero:<br>
 * <br>
 * 
 * 3345 <br>
 * Juan | Pérez | Rodríguez <br>
 * 19-4-2000 <br>
 * c/Mayor 4 5º Izqda <br>
 * 912334567 <br>
 * 
 * 4357 <br>
 * Luis | García| Carrión <br>
 * 21-3-1998 <br>
 * c/Peral 18 <br>
 * 609883456 <br>
 * 
 * @author Juan
 *
 */
public class GestionMain {

	Scanner sc = new Scanner(System.in);
	List<Student> estudiantes = new ArrayList<Student>();

	public static void main(String[] args) {
		GestionMain gestionMain = new GestionMain();
		gestionMain.leerFichero();
		gestionMain.escribirFichero();
		gestionMain.leerBinario();
	}

	void leerFichero() {
		System.out.println("Fichero de entrada:");

		String rutaEntrada = sc.nextLine();
		rutaEntrada = "Registry.txt";

		File ficheroEntrada = new File(rutaEntrada);

		// Leer el fichero de entrada

		System.out.println(" \nLEYENDO EL FICHERO \n ");

		try (FileReader fr = new FileReader(ficheroEntrada); //
				BufferedReader br = new BufferedReader(fr);) {

			String[] datos = { "expediente", "nombre", "fechaNacimiento", "address", "phone" };
			int contador = 0;
			String stringRead;

			int numEstudent = 1;
			int expediente = 0;
			String nombre = null;
			String fecha = null;
			String address = null;
			String phone = null;

			while ((stringRead = br.readLine()) != null) {

				switch (contador % 5) {
				case 0:
					System.out.println("Estudiante " + numEstudent);
					numEstudent++;
					expediente = Integer.parseInt(stringRead);
					break;
				case 1:
					nombre = stringRead;
					break;
				case 2:
					fecha = stringRead;
					break;
				case 3:
					address = stringRead;
					break;
				case 4:
					phone = stringRead;
					Student student = new Student(expediente, nombre, fecha, address, phone);
					estudiantes.add(student);
					break;
				default:
					break;
				}
				System.out.println((datos[(contador % 5)]) + ": " + stringRead);
				contador++;
			}

			System.out.println("FIN");
			for (Student student : estudiantes) {

				System.out.println(student.toString());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void escribirFichero() {
		System.out.println("\nRuta del fichero binario: ");

		String ruta = sc.nextLine();
		ruta = "binario.dat";

		File ficheroSalida = new File(ruta);

		System.out.println("\nESCRIBIENDO AL FICHERO BINARIO\n");

		try {
			// DataOutputStream os = new DataOutputStream(new
			// FileOutputStream(ficheroSalida));
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroSalida));
			for (Student student : estudiantes) {
				os.writeObject(student);
			}
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void leerBinario() {

		List<Student> studentList = new ArrayList<Student>();

		System.out.println("\nLEYENDO FICHERO BINARIO\n");

		try (FileInputStream fis = new FileInputStream("binario.dat");
				ObjectInputStream is = new ObjectInputStream(fis);) {
			while (fis.available() > 0) {
				Student student = (Student) is.readObject();
				if (student != null) {
					studentList.add(student);
				}
			}
			for (Student student : studentList) {
				System.out.println("\nESTUDIANTE");
				System.out.println(student.toString());
			}
		}

		/*
		 * try (ObjectInputStream is = new ObjectInputStream(new
		 * FileInputStream("binario.dat"));) { studentList=(List<Student>)
		 * is.readObject(); is.close(); }
		 */ catch (Exception e) {
			e.printStackTrace();
		}
	}

}
