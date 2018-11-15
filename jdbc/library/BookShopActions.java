package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookShopActions {

	private static final String SELECT_BOOKS_QUERY = "select *from books order by title";// TODO
	private static final String SELECT_FIELDS_QUERY = "select *from libros limit 1";// TODO
	private Connection con;
	private Statement stmt = null;
	private ResultSet rSet = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * Constructor: inicializa conexión
	 * 
	 * @param conn
	 * @throws AccesoDatosException
	 */
	public BookShopActions(Connection conn) /* throws AccesoDatosException */ {
		conn = conn;
	}

	static void showCatalog() {

	}

	public void showCatalogInverse() {
		// Sentencia
		stmt = null;
		// Conjunto de Resultadors a obtener de la sentencia SQL

		rSet = null;

	}

	public String[] getBookAttributes() /* throws AccesoDatosException */ {

		String catalog = null;
		String schemaPatter = null;
		String tablePattern = null;
		// TODO

		return null;

	}

}
