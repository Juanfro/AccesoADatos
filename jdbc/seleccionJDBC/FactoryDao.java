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
	/**
	 * Tipo de DAO que se va a utilizar
	 */
	String playerDao;
	String configFile = "jdbc/seleccionJDBC/properties.xml";

	DaoSeleccion<JugadorJDBC> daoSeleccion;

	/**
	 * Constructor privado
	 */
	private FactoryDao() {
		setDaoType(configFile);
	}

	/**
	 * Método singleton. devuelve una sola instancia de FactoryDao
	 * 
	 * @return instancia de FactoryDao
	 */
	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}

	/**
	 * Determina el tipo de DAO que se va a utilizar partiendo de un parámetro en un
	 * fichero XML
	 * 
	 * @param configFile Fichero XML de configuración
	 */
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
	 * Lee el parametro playerDao y devuelve el DAO correspondiente
	 * 
	 * @return DAO a uilizar
	 *
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
