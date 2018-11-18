package libreria;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class AccionesLibreria {

	private Connection connection;
	// private static final String SELECT_BOOKS_QUERY = "select * from libros order
	// by titulo asc";
	private static final String SELECT_BOOKS_QUERY = "select * from libros order by titulo desc";
	private static final String SELECT_BOOKS_QUERY_PREPARED = "UPDATE libros SET copias=? WHERE libros.isbn=?";
	// private static final String ADD_PRECIO = "ALTER TABLE libros ADD precio
	// float";
	private static final String UPDATE_PRECIO = "UPDATE libros SET precio =? WHERE libros.isbn=?";

	public AccionesLibreria(Connection connection) {

		this.connection = connection;
	}

	/**
	 * Ver catálogo inverso: Este método muestra el catálogo de libros en orden
	 * inverso al alfabético.<br>
	 * Debes utilizar la siguiente consulta: <br>
	 * private static final String SELECT_BOOKS_QUERY = "select * from books order
	 * by title asc";
	 */
	void mostrarCatalogoInverso() {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(SELECT_BOOKS_QUERY);

			while (result.next()) {
				System.out.println("Titulo: " + result.getString("titulo") + " | Autor: " + result.getString("autor")
						+ " | Editorial: " + result.getString("editorial") + " | ISBN: " + result.getInt("isbn")
						+ " | Copias: " + result.getInt("copias") + " | Número de páginas: " + result.getInt("paginas")
						+ " | Preci5o: " + result.getFloat("precio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza número de copias: <br>
	 * Este método recibe un Hashmap que contiene el nuevo número de copias para
	 * cada isbn.<br>
	 * Este nuevo número de copias se lo tienes que sumar al actual. Resuélvelo
	 * creando una sentencia preparada a partir de la consulta del apartado anterior
	 * utilizando el tipo de ResultSet adecuado.
	 */
	@SuppressWarnings("unused")
	void actualizaNumeroCopias(HashMap<Integer, Integer> hashMap) {
		// UPDATE 'libros' SET 'copias'=? WHERE 'libros'.'isbn'=?
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_QUERY_PREPARED);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_BOOKS_QUERY);

			while (resultSet.next()) {
				int numCopias = hashMap.get(resultSet.getInt("isbn"));
				preparedStatement.setInt(1, hashMap.get(resultSet.getInt("isbn")));
				int isbn = resultSet.getInt("isbn");
				preparedStatement.setInt(2, resultSet.getInt("isbn"));

				int rowsAffected = preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este método recibe un float indicando el precio por página de cada libro.<br>
	 * Este método debe consultar las páginas de cada libro, multiplicar por el
	 * precio por página y rellenar la columna precio de cada libro. <br>
	 * Resuélvelo creando una sentencia preparada a partir de la consulta del
	 * apartado anterior utilizando el tipo de ResultSet adecuado.
	 */
	void rellenaPrecio(float precioPagina) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRECIO);
			// "UPDATE libros SET precio =? WHERE libros.isbn=?"

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_BOOKS_QUERY);

			while (resultSet.next()) {
				float precioLibro = resultSet.getInt("paginas") * precioPagina;
				int isbn = resultSet.getInt("isbn");
				preparedStatement.setFloat(1, precioLibro);
				preparedStatement.setInt(2, isbn);

				int rowsAffected = preparedStatement.executeUpdate();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este método muestra la lista de atributos de la tabla libros de la base de
	 * datos. Utiliza la clase DataBaseMetadata para consultar los campos de una
	 * tabla de la base de datos.
	 */
	void recuperaCampos() {
		try {
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			ResultSet resultSet = databaseMetaData.getColumns(null, null, "libros", null);

			while (resultSet.next()) {
				String nombreColumna = resultSet.getString(4);
				String tipoColumna = resultSet.getString(5);

				System.out.println("Atributo: " + nombreColumna + " | Tipo: " + tipoColumna);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Recibe un valor que representa un porcentaje de descuento y se lo aplica a
	 * todos los precios de la BBDD. <br>
	 * Todas las operaciones de actualización de precio de los libros tienen que ser
	 * una transaccón
	 */
	void aplicaDescuento(float descuento) {
		try {
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRECIO);
			// "UPDATE libros SET precio =? WHERE libros.isbn=?"

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_BOOKS_QUERY);

			while (resultSet.next()) {
				float precioDescuento = resultSet.getFloat("precio") * descuento;
				int isbn = resultSet.getInt("isbn");
				preparedStatement.setFloat(1, precioDescuento);
				preparedStatement.setFloat(2, isbn);

				int rowsAffected = preparedStatement.executeUpdate();

			}

			connection.commit();

		} catch (Exception e) {

		}
	}

}
