package nationalTeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DBConnection {

	private static DBConnection instance;
	private Connection cnx;

	private DBConnection(Map<String, String> config) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");// Driver
			String dbms = config.get("dbms");
			String dbName = config.get("dbName");
			String userName = config.get("userName");
			String password = config.get("password");
			String serverName = config.get("serverName");
			Integer portNumber = Integer.parseInt(config.get("portNumber"));

			cnx = DriverManager.getConnection("jdbc:" + dbms + "://", userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Connection getCOnnection() {
		return cnx;
	}

	public static DBConnection getInstance(Map<String, String> config) throws SQLException {
		if (instance == null) {
			instance = new DBConnection(config);
		} else if (instance.getCOnnection().isClosed()) {
			instance = new DBConnection(config);
		}

		return instance;
	}

}
