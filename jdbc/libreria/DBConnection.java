package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static DBConnection instance;
	private Connection cnx;
	// private String url = "jdbc:mysql://localhost:3306/libreria";
	private String url = "jdbc:mysql://localhost:3306/libreria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String username = "root";
	private String password = "";

	private DBConnection() throws SQLException {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url, username, password);
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

	public static DBConnection getInstance() throws SQLException {

		if (instance == null) {
			instance = new DBConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}

		return instance;
	}

	public Connection getConnection() {
		return cnx;
	}

	public void close() {
		instance = null;
	}

}
