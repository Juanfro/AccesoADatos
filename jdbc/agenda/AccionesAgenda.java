package agenda;

import java.sql.Connection;
import java.util.Scanner;

class AccionesAgenda {

	private Connection conexion;
	private static ContactoDao contactoDao;

	public AccionesAgenda(Connection con) {
		this.conexion = con;
		contactoDao = new ContactoDao();
	}

	void guardarContacto() {
		int codContacto;
		String nombre;
		long telefono;
		String email;

		Scanner scGuardar = new Scanner(System.in);

		System.out.println("\nCrear contacto nuevo\n");

		System.out.println("Codigo del contacto:");
		codContacto = scGuardar.nextInt();

		System.out.println("Nombre del Contacto:");
		nombre = scGuardar.next();

		System.out.println("Telefono del contacto:");
		telefono = Long.valueOf(scGuardar.nextInt());

		System.out.println("Email del contacto:");
		email = scGuardar.next();

		Contacto cont = new Contacto(codContacto, nombre, telefono, email);

		contactoDao.save(cont, conexion);
	}

	void mostrarDatosContacto() {

	}

	void prefijo() {

	}

}
