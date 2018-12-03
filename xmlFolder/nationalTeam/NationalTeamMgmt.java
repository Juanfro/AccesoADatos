package nationalTeam;

import java.util.HashMap;
import java.util.List;

public class NationalTeamMgmt {

	private DAO<Player, Integer> playerDao;
	private HashMap<Integer, Player> nationalTeam = new HashMap<>();

	public NationalTeamMgmt() throws NationalException {
		try {
			playerDao = FactoriaDao.getIstance().getDAO();
			List<Player> players = playerDao.getAll();
			for (Player player : players) {
				nationalTeam.put(player.getNumber(), player)
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new NationalException("Error: Unable to load players ");
		}
	}

	public HashMap<Integer, Player> getNationalTeam() {

	}

	public void addPlayer(Player player) throws NationalException {
		try {
			jPlayerDAO.save(player);
			nationalTeam.put(player, getNumber(), player);
		} catch (DAOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Player deletePlayer(Integer number) throws NationalException {

	}

	public void updatePlayer(Player player) throws NationalException {

	}

	public Player getPlayerByNUmber(Integer number) {

	}

}
