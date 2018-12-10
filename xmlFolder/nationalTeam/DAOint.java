package nationalTeam;

public interface DAOint<T1, T2> {

	Player get(Integer numPlayer) throws DAOException;

	void save(Player player) throws DAOException;

	void delete(Player player) throws DAOException;

	void update(Player player) throws DAOException;

}
