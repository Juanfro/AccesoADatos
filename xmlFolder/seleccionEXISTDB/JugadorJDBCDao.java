package seleccionEXISTDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import seleccionJDBC.DBConnectionSeleccion;
import seleccionJDBC.JugadorJDBC.PositionJDBC;

public class JugadorJDBCDao implements DaoSeleccion<JugadorXML> {

	private static final String SELECT_TODOS_JUGADORES = "select * from jugador order by dorsal";
	private static final String INSERT_PLAYER = "INSERT INTO jugador (dorsal, nombre, posicion) VALUES (?, ?, ?)";
	private static final String DELETE_PLAYER = "DELETE FROM jugador WHERE dorsal=? ";

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
	public JugadorXML get(int id) {
		return null;
	}

	@Override
	public List<JugadorXML> getAll() {

		List<JugadorXML> listaJugadores = new ArrayList<JugadorXML>();
		JugadorXML jugador;
		int dorsal;
		String nombre;
		seleccionEXISTDB.JugadorXML.PositionJDBC posicion;

		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_TODOS_JUGADORES);

			while (resultSet.next()) {
				dorsal = resultSet.getInt("dorsal");
				nombre = resultSet.getString("nombre");

				posicion = seleccionEXISTDB.JugadorXML.PositionJDBC.valueOf(resultSet.getString("posicion").toUpperCase());
				jugador = new JugadorXML(dorsal, nombre, posicion);

				listaJugadores.add(jugador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaJugadores;
	}

	@Override
	public void save(JugadorXML jugador) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_PLAYER);

			preparedStatement.setInt(1, jugador.getDorsal());
			preparedStatement.setString(2, jugador.getNombre());
			preparedStatement.setString(3, jugador.getPosition().name());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int num) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement(DELETE_PLAYER);
			preparedStatement.setInt(1, num);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
