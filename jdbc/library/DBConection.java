package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {

	private static DBConection instance;
	private Connection cnx;
	private String url = "jdbc:mysql://localhost:3306/bookshop";
	private String username = "root";
	private String password = "";

	private DBConection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");// Driver
			cnx = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Database Connection failed: ");
		}
	}

	public Connection getConnection() {
		return cnx;
	}

	public static DBConection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConection();
		}

		return instance;
	}

	public void close() {
		instance = null;
	}

}
