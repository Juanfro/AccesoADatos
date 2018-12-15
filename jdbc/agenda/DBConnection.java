package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnection {

	private static DBConnection instancia;
	private Connection cnx;
	private String url = "jdbc:mysql://localhost:3306/agenda?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String userName = "root";
	private String password = "";

	private DBConnection() throws SQLException {
		try {
			cnx = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Database Connection failed");
		} finally {
			try {
				if (cnx != null) {
					// cnx.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Patron Singleton para conexión. Si ya hay una conexión disponible la
	 * devuelve, si no la hay o si está cerrada crea una nueva.
	 * 
	 * @return Instancia de DBConnection con Conexión a la base de datos
	 * @throws SQLException
	 */
	public static DBConnection getInstancia() throws SQLException {
		if (instancia == null) {
			instancia = new DBConnection();
		} else if (instancia.getConnection().isClosed()) {
			instancia = new DBConnection();
		}

		return instancia;
	}

	/**
	 * Getter de la conexión
	 * 
	 * @return conexión a la base de datos
	 */
	public Connection getConnection() {
		return cnx;
	}

	public void close() {
		instancia = null;
	}

}
