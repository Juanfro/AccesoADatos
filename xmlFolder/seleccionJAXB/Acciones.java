package seleccionJAXB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Properties;

class Acciones {

	Connection con;
	Properties properties;

	String configFile = "xmlFolder/seleccionJAXB/properties.xml";

	/**
	 * Constructor
	 * 
	 * Lee la configuracion en properties.xml y crea la conexión
	 * 
	 * @throws SQLException
	 */
	public Acciones() throws SQLException {
		properties = new Properties();

		try {
			FileInputStream fis = new FileInputStream(configFile);
			properties.loadFromXML(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, String> config = new HashMap<String, String>();

		// Introducir datos en el mapa

		config.put("dbms", properties.getProperty("dbms"));
		config.put("dbName", properties.getProperty("database_name"));
		config.put("userName", properties.getProperty("user_name"));
		config.put("password", properties.getProperty("password"));
		config.put("serverName", properties.getProperty("server_name"));
		config.put("portNumber", properties.getProperty("port_number"));

		DBConnectionJAXB instance = DBConnectionJAXB.getInstance(config);
		con = instance.getConnection();
	}

	void DBtoXML() {
		System.out.println("DB to XML");
	}

	void XMLtoDB() {

	}

}
