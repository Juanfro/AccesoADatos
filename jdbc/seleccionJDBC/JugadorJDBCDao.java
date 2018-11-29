package seleccionJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JugadorJDBCDao implements DaoSeleccion<JugadorJDBC> {

	private static final String SELECT_TODOS_JUGADORES = "select * from jugador order by dorsal";//TODO falta la sentencia SQL
	Connection con;
	DBConnectionSeleccion instance;

	public JugadorJDBCDao(Map<String, String> config) {
		try {
			instance = DBConnectionSeleccion.getInstance(config);
			con = instance.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public JugadorJDBC get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JugadorJDBC> getAll() {
		
		List<JugadorJDBC> listaJugadores = new ArrayList<JugadorJDBC>();

		try {
			Statement statement = con.createStatement();
			ResultSet resultSet =statement.executeQuery(SELECT_TODOS_JUGADORES);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaJugadores;
	}

	@Override
	public void save(JugadorJDBC t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub

	}

}
