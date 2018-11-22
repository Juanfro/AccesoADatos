package seleccionJDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class FactoryDao {

	private static FactoryDao instance;
	Properties daoProps;
	String playerDao;
	String configFile = "properties.xml";

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
	}

	public DaoJDBC getDao() {

		DaoJDBC dao = null;

		return dao;
	}
}
