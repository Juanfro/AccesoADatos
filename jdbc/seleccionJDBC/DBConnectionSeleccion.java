package seleccionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DBConnectionSeleccion {

	private static DBConnectionSeleccion instance;
	private Connection cnx;

	/**
	 * Constructor privado
	 * 
	 * @param config Mapa con los datos d ela conexxión
	 * @throws SQLException
	 */
	private DBConnectionSeleccion(Map<String, String> config) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dbms = config.get("dbms");
			String dbName = config.get("dbName");
			String userName = config.get("userName");
			String password = config.get("password");
			String serverName = config.get("serverName");
			Integer portNumber = Integer.parseInt(config.get("portNumber"));

			String url = "jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/" + dbName;

			cnx = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return cnx;
	}

	public static DBConnectionSeleccion getInstance(Map<String, String> config) throws SQLException {

		if (instance == null) {
			instance = new DBConnectionSeleccion(config);
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnectionSeleccion(config);
		}

		return instance;

	}

}
