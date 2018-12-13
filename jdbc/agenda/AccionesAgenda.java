package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class AccionesAgenda {

	private Connection conexion;
	private static ContactoDao contactoDao;

	private static final String SELECT_DATOS_USUARIO = "SELECT * FROM contacto WHERE nombre = ?";
	private static final String SELECT_USUARIOS = "SELECT * FROM contacto";
	private static final String UPDATE_PREFIJO = "UPDATE contacto SET telefono =? WHERE cod_contacto =?";

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
		scGuardar.nextLine();//Consumir NewLine
		System.out.println("Nombre del Contacto:");
		nombre = scGuardar.nextLine();

		System.out.println("Telefono del contacto:");
		telefono = Long.valueOf(scGuardar.nextInt());

		System.out.println("Email del contacto:");
		email = scGuardar.next();

		Contacto cont = new Contacto(codContacto, nombre, telefono, email);

		contactoDao.save(cont, conexion);
	}

	/**
	 * Muestra todos los datos de los contactos que tienen un nombre concreto
	 */
	void mostrarDatosContacto() {
		// SELECT * FROM contactp WHERE nombre = ?

		String nombreRecibido;
		int codContacto;
		String nombre;
		long telefono;
		String email;

		System.out.println("\nMostrar datos de contacto\n");

		System.out.println("Nombre del contacto:");

		Scanner scContacto = new Scanner(System.in);

		nombreRecibido = scContacto.next();

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_DATOS_USUARIO);

			preparedStatement.setString(1, nombreRecibido);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				codContacto = resultSet.getInt("cod_contacto");
				nombre = resultSet.getString("nombre");
				telefono = resultSet.getLong("telefono");
				email = resultSet.getString("email");

				System.out.println("Datos de contacto: "//
						+ "\nCodigo de Contacto: " + codContacto//
						+ "\nNombre: " + nombre //
						+ "\nTeléfono: " + telefono//
						+ "\neMail: " + email);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Actualiza todos los telefonos de todos los contactos añadiendo un prefijo que
	 * se pasa como parámetro al método. Dicha modificación debe implementarse como
	 * una transaccion
	 */
	void prefijo(long prefijo) {

		try {
			conexion.setAutoCommit(false);

			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_USUARIOS);

			PreparedStatement preparedStatement = conexion.prepareStatement(UPDATE_PREFIJO);
			// "UPDATE contacto SET telefono =? WHERE cod_contacto =?"

			while (resultSet.next()) {
				long telefono = resultSet.getLong("telefono");
				String telefonoConPrefijo = String.valueOf(prefijo) + String.valueOf(telefono);
				telefono = Long.parseLong(telefonoConPrefijo);

				int codContacto = resultSet.getInt("cod_contacto");

				preparedStatement.setLong(1, telefono);
				preparedStatement.setInt(2, codContacto);

				preparedStatement.executeUpdate();
			}

			conexion.commit();
			conexion.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
