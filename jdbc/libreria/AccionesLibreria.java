package libreria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccionesLibreria {

	private Connection connection;
	private static final String SELECT_BOOKS_QUERY = "select * from libros order by titulo asc";

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
		System.out.println("Ver catálogo inverso");
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(SELECT_BOOKS_QUERY);

			while (result.next()) {
				System.out.println("Titulo:" + result.getString("titulo") + " | Autor: " + result.getString("autor")
						+ " | Editorial: " + result.getString("editorial"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void actualizaNumeroCopias() {

	}

	void rellenaPrecio() {

	}

	void recuperaCampos() {

	}

	void aplicaDescuento() {

	}

}
