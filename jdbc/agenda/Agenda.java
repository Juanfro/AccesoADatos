package agenda;

import java.sql.Connection;
import java.util.Scanner;

/**
 * Aplicacion que permite realizar operaciones de inserción y consulta sobre los
 * registros de una agenda de contactos almacenada en la base de datos.<br>
 * La tabla de contactos tiene los siguientes campos:
 * <ul>
 * <li>Cod_contacto -> Int(11)(Clave primaria)</li>
 * <li>Nombre -> Varchar(80)</li>
 * <li>Telefono -> BigInt</li>
 * <li>Email -> Varchar(50)</li>
 * </ul>
 * 
 * La apicacion debe permitir añadir registros a la tabla con datos
 * suministrados por el usuario. La Aplicación usará el patrón DAO con una unica
 * operación "save" <br>
 * Por otro lado la aplicación permitirá al usuario realizar las siguientes
 * consultas.<br>
 * <br>
 * 
 * <ul>
 * <li>Mostrar todos los datos de los contactos que tienen un nombre
 * concreto</li>
 * <li>Actualizar todos los telefonos de todos los contactos añadiendo un
 * prefijo que se pasa como parámetro al método. Dicha modificación debe
 * implementarse como una transaccion</li>
 * 
 * </ul>
 * 
 * @author Juan Antonio Rodriguez
 *
 */

public class Agenda {

	static Connection con;
	static AccionesAgenda acciones;
	static DBConnection instanciaConexion;

	

	public static void main(String[] args) {
		Agenda myAgenda = new Agenda();

		try {
			instanciaConexion = DBConnection.getInstancia();

		} catch (Exception e) {
			e.printStackTrace();
		}
		con = instanciaConexion.getConnection();
		acciones = new AccionesAgenda(con);

		while (true) {
			myAgenda.gestionar();
		}
	}

	void gestionar() {
		System.out.println("\nElige operación a realizar");
		System.out.println("1 - Añadir Contacto");
		System.out.println("2 - Mostrar todos los datos de los contactos que tienen un nombre concreto");
		System.out.println("3 - Actualizar todos los telefonos de todos los contactos añadiendo unprefijo");

		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				acciones.guardarContacto();
				break;
			case 2:

				break;
			case 3:

				break;

			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
