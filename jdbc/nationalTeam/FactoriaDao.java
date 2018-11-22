package nationalTeam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.management.InstanceAlreadyExistsException;

import seleccion.PlayerDao;

public class FactoriaDao {
	
	private static FactoriaDao instance;
	Properties DaoProps;
	
	

	public static FactoriaDao getInstance() {// Devuleve un objeto de su misma clase
		if (instance == null) {
			instance = new FactoriaDao();
		}

		return instance;
	}

	private FactoriaDao() {
		try {
			setDaoType(PropertiesFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setDaoType(String configfile) throws IOException /* TODO */ {
		DaoProps = new Properties();
		DaoProps.loadFromXML(Files.newInputStream(Paths.get(configFile), options));
		playerDao = DaoProps.getProperty("playerdao");
	}

	public Dao getDao() throws DAOException {
		Dao dao = null;

		if (playerDao.equals("PlayerJDBCDao")) {
			try {
				Map<String, String> config = new HashMap<String, String>();
				config.put("dbms", DaoProps.getProperty("dbms"));
				config.put("dbName", DaoProps.getProperty("database_name"));
				config.put("userName", DaoProps.getProperty("user_name"));
				config.put("password", DaoProps.getProperty("password"));
				//TODO
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (playerDao.equals("PlayerRAFDao")) {
			try {
				Map<String, String> config = new HashMap<String, String>();
				config.put("fileName", value);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
