package nationalTeam;

import java.sql.ResultSet;
import java.util.List;

public class PlayerJDBCDao implements Dao<Player, Integer> {

	private Player makePlayer(ResultSet rs) throws DAOException {
		Player player = null;

		try {
			int number = rs.getInt("number");
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String name = rs.getString("name");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public public PlayerJDBCDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Player get(Integer numPlayer) throws DAOException {

		return player;
	}

	@Override
	public List<Player> getAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Player t) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Player t) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Player t) throws DAOException {
		// TODO Auto-generated method stub

	}

}
