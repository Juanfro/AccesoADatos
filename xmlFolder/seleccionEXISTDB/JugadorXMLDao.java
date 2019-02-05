package seleccionEXISTDB;

import java.util.List;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XQueryService;

class JugadorXMLDao implements DaoSeleccion<JugadorXML> {

	@Override
	public JugadorXML get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JugadorXML> getAll() {

		try {

			String driver = "org.exist.xmldb.DatabaseImpl";
			Class cl = Class.forName(driver);
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);
			Collection col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/seleccion",
					"admin", "admin");

			String query = //
					"for $jugador in /seleccion/jugadores/jugador\r\n" + //
							"return $jugador/nombre//text()";
			XQueryService service = (XQueryService) col.getService("XQueryService", "1.0");
			service.setProperty("indent", "yes");
			ResourceSet result = service.query(query);
			ResourceIterator i = result.getIterator();
			while (i.hasMoreResources()) {
				Resource r = i.nextResource();
				String value = (String) r.getContent();
				System.out.println(value);
			}

		} catch (XMLDBException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void save(JugadorXML t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub

	}

}
