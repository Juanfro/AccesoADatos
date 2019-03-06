package seleccionHibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

class FactoryDao {
	private static FactoryDao instance;
	Properties daoProps;

	String jugadorDao;
	String configFile = "ormFolder/seleccionHibernate/properties.xml";

	DaoSeleccion<Jugador> daoSeleccion;

	private FactoryDao() {
		setDaoType(configFile);
	}

	static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}

		return instance;
	}

	private void setDaoType(String configFile) {
		daoProps = new Properties();

		FileInputStream fis;
		try {
			fis = new FileInputStream(configFile);
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

	DaoSeleccion<Jugador> getDao() {

		DaoSeleccion<Jugador> dao = null;

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

			// dao = new JugadorXMLDao(config); // TODO Implementar
		} else if (jugadorDao.equals("Hibernate")) {

			SessionFactory sessionFactory;

			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.addAnnotatedClass(Jugador.class).buildSessionFactory(serviceRegistry);

			dao = new JugadorHibernateDao(sessionFactory);

		}

		return dao;
	}
}
