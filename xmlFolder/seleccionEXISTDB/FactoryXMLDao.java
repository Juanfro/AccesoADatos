package seleccionEXISTDB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Properties;

class FactoryXMLDao {

	private static FactoryXMLDao instance;
	Properties daoProps;

	String jugadorDao;
	String configFile = "xmlFolder/seleccionEXISTDB/properties.xml";

	DaoSeleccion<JugadorXML> daoSeleccion;

	/**
	 * Constructor privado
	 */
	private FactoryXMLDao() {
		setDaoType(configFile);
	}

	static FactoryXMLDao getInstance() {
		if (instance == null) {
			instance = new FactoryXMLDao();
		}
		return instance;

	}

	private void setDaoType(String configFile) {
		daoProps = new Properties();

		try {
			FileInputStream fis = new FileInputStream(configFile);
			daoProps.loadFromXML(fis);
			jugadorDao = daoProps.getProperty("playerdao");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		daoSeleccion = getDao();

	}

	 DaoSeleccion<JugadorXML> getDao() {

		DaoSeleccion<JugadorXML> dao = null;

		if (jugadorDao.equals("JugadorJDBCDao")) {// DAO base de datos
			Map<String, String> config = new HashMap<String, String>();
			config.put("dbms", daoProps.getProperty("dbms"));
			config.put("dbName", daoProps.getProperty("database_name"));
			config.put("userName", daoProps.getProperty("user_name"));
			config.put("password", daoProps.getProperty("password"));
			config.put("serverName", daoProps.getProperty("server_name"));
			config.put("portNumber", daoProps.getProperty("port_number"));

			// dao = new JugadorJDBCDao(config); // TODO Implementar

		} else if (jugadorDao.equals("JugadorRAFDao")) {// DAO random access file
			Map<String, String> config = new HashMap<String, String>();
			config.put("filename", daoProps.getProperty("filename"));

			// dao = new JugadorRAFDao();// TODO Implementar
		} else if (jugadorDao.equals("JugadorXMLDao")) {

			Map<String, String> config = new HashMap<String, String>();
			config.put("dbms", daoProps.getProperty("exist_dbms"));
			config.put("dbName", daoProps.getProperty("exist_database_name"));
			config.put("userName", daoProps.getProperty("exist_user_name"));
			config.put("password", daoProps.getProperty("exist_password"));
			config.put("serverName", daoProps.getProperty("server_name"));
			config.put("portNumber", daoProps.getProperty("exist_port_number"));

			dao = new JugadorXMLDao(config);
		}

		return dao;
	}

}
