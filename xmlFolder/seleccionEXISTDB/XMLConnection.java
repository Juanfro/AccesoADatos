package seleccionEXISTDB;

import java.util.Map;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;

class XMLConnection {

	public static final String URI = "xmlDB:exist://localhost:8080/exist/xmlrpc";

	private static XMLConnection instance;
	private Collection col;

	private XMLConnection(Map<String, String> config) {
		String driver = "org.exist.xmldb.DatabaseImpl";
		Class cl;
		try {
			cl = Class.forName(driver);
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);
			col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/seleccion", "admin",
					"admin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (XMLDBException e) {
			e.printStackTrace();
		}

	}

	Collection getColletcion() {
		return col;
	}

	 static XMLConnection getInstance(Map<String, String> config) {
		if (instance == null) {
			instance = new XMLConnection(config);
		}
		return instance;
	}

}
