package nationalTeam;

public class XMLConnection {
	
	public final static String URI = "xmlDB:exist://localhost:8080/exxist/xmlrpc";
	
	private static XMLConnection instance;
	
	
	
	
	xqs.setProperty("port", portNumber)
	
	cnx= xqs.getConnection(username, password);
	
	String driver = "org.exist.xmldb.DatabaseImpl";
	Class cl = Class.forName(driver);
	
	Database database = (Database) cl.newInstance();
	database.setProperty("create-database", true);
	DatabaseManager.registerDataBase(databsae);
	col = DtabaseManager.getCollection /*TODO*/;

}
