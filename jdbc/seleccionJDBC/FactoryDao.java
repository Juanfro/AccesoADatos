package seleccionJDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Properties;

public class FactoryDao {

	private static FactoryDao instance;
	Properties daoProps;
	String playerDao;
	String configFile = "jdbc/seleccionJDBC/properties.xml";

	DaoSeleccion<JugadorJDBC> daoSeleccion;

	private FactoryDao() {
		setDaoType(configFile);
	}

	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}

	private void setDaoType(String configFile) {
		daoProps = new Properties();
		try {
			FileInputStream fis = new FileInputStream(configFile);
			daoProps.loadFromXML(fis);
			playerDao = daoProps.getProperty("playerdao");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		daoSeleccion = getDao();
	}

	/**
	 * Lee
	 * 
	 * @return
	 */
	public DaoSeleccion<JugadorJDBC> getDao() {

		DaoSeleccion<JugadorJDBC> dao = null;

		if (playerDao.equals("JugadorJDBCDao")) {// DAO base de datos
			Map<String, String> config = new HashMap<String, String>();
			config.put("dbms", daoProps.getProperty("dbms"));
			config.put("dbName", daoProps.getProperty("database_name"));
			config.put("userName", daoProps.getProperty("user_name"));
			config.put("password", daoProps.getProperty("password"));
			config.put("serverName", daoProps.getProperty("server_name"));
			config.put("portNumber", daoProps.getProperty("port_number"));

			dao = new JugadorJDBCDao(config);

		} else if (playerDao.equals("JugadorRAFDao")) {// DAO random access file
			Map<String, String> config = new HashMap<String, String>();
			config.put("filename", daoProps.getProperty("filename"));

			dao = new JugadorRAFDao();
		}

		return dao;
	}
}
