package nationalTeam;

import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XUpdateQueryService;

//import com.sun.java.util.jar.pack.Attribute.Layout.Element;

public class PlayerXMLDAO implements DAOint<Player, Integer> {

	private Player makePlayer(XMLSequence xqs) throws DAOException {
		PlayerXMLDAO player;
		
		String name;
		
		try {
			Object playerDOM;
		if(playerDOM.getElementsByTagName("name").getLength()!=0) {
			name= parseInt(playerDOM.getElementsByTagName("nombre").item(0).)/*TODO*/;
		}
		
		//surname
		
		//position
		
		position = Player.Position.valueOf(PositionString);
		player = new PlayerXMLDAO(number, name, surname, position);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Player get(Integer numPlayer) throws DAOException {
		Player player = null;

		try {

		} catch (XQEException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return player;
	}

	@Override
	public void save (Player player) throws DAOException{
		
		
		try {
			String xupdate //
				= "<xupdate:modifications version=\"1.0\" "//
				+ "xmlns:xupdate=\"http://www.xmldb.org/xupdate\">"//
				+ "<xupdate:append select=\"national_team/players\">"//
				+ "<xupdate:Element name =\"player\">"//
				+ "<number>" + player.getNumber() + "</number>"//
				+ "<name>" + player.getName() + "</name>"//
				+ "<surname>" + player.getSurname() + "</surname>"//
				+ "<position>" + player.getPosition + "</position>"//
				+ "</xupdate:element>"//
				+ "</xupdate:append>"//
				+ "</xupdate:modifications>";
			
/*
<xupdate:modifications version="1.0" xmlns:xupdate="http://www.xmldb.org/xupdate">
	<xupdate:append select="national_team/players">
		<xupdate:Element name ="player">
			<number>15</number>
			<name>JugadorXML</name>
			<surname>Apellido</surname>
			<position>DELANTERO</position>
		</xupdate:Element>
	</xupdate:append>
</xupdate:modifications>
* 
*/

			XUpdateQueryService xuqService =
					(XUpdateQueryService)
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void delete (Player player) throws DAOException{
		
		try {
			String xupdate //
			= "<xupdate:modifications version=\"1.0\" "//
			+ "xmlns:xupdate=\"http://www.xmldb.org/xupdate\">"//
		} catch (XMLDBException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Player player) throws DAOException{
		try {
			String xupdate //
			= "<xupdate:modifications version=\"1.0\" "//
			+ "xmlns:xupdate=\"http://www.xmldb.org/xupdate\">"//
			+ "<update:replace select=\"\"national_team/players\
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
