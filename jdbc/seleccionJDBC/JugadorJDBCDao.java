package seleccionJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import seleccionJDBC.JugadorJDBC.PositionJDBC;

public class JugadorJDBCDao implements DaoSeleccion<JugadorJDBC> {

	private static final String SELECT_TODOS_JUGADORES = "select * from jugador order by dorsal";// TODO falta la
																									// sentencia SQL
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
		JugadorJDBC jugador;
		int dorsal;
		String nombre;
		PositionJDBC posicion;
		;

		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_TODOS_JUGADORES);

			while (resultSet.next()) {
				dorsal = resultSet.getInt("dorsal");
				nombre = resultSet.getString("nombre");
				
				
				posicion = PositionJDBC.valueOf(resultSet.getString("posicion").toUpperCase());
				jugador = new JugadorJDBC(dorsal, nombre, posicion);
				
				listaJugadores.add(jugador);
			}
		} catch (SQLException e) {
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
