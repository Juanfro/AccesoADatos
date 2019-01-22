package seleccionJAXB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

class DBConnectionJAXB {

	private static DBConnectionJAXB instance;
	private Connection cnx;

	private DBConnectionJAXB(Map<String, String> config) {
		try {
			String dbms = config.get("dbms");
			String dbName = config.get("dbName");
			String userName = config.get("userName");
			String password = config.get("pasword");
			String serverName = config.get("serverName");
			Integer portNumber = Integer.parseInt(config.get("portNumber"));

			String url = "jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/" + dbName
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			cnx = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return cnx;
	}

	static DBConnectionJAXB getInstance(Map<String, String> config) throws SQLException {
		if (instance == null) {
			instance = new DBConnectionJAXB(config);
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnectionJAXB(config);
		}

		return instance;
	}

}
