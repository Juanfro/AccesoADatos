package seleccionJAXB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import seleccionJAXB.JugadorJAXB.PositionJAXB;
import seleccionJDBC.JugadorJDBC.PositionJDBC;

class Acciones {

	Connection con;
	Properties properties;

	Map<String, String> config;
	String configFile = "xmlFolder/seleccionJAXB/properties.xml";

	JugadorJAXB jugadorJAXB;
	int dorsal;
	String nombre;
	PositionJAXB posicion;

	private static final String SELECT_TODOS_JUGADORES = "select * from jugador order by dorsal";

	/**
	 * Constructor
	 * 
	 * Lee la configuracion en properties.xml y crea la conexión
	 * 
	 * @throws SQLException
	 */
	Acciones() throws SQLException {
		properties = new Properties();

		try {
			FileInputStream fis = new FileInputStream(configFile);
			properties.loadFromXML(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		config = new HashMap<String, String>();

		// Introducir datos en el mapa

		config.put("dbms", properties.getProperty("dbms"));
		config.put("dbName", properties.getProperty("database_name"));
		config.put("userName", properties.getProperty("user_name"));
		config.put("password", properties.getProperty("password"));
		config.put("serverName", properties.getProperty("server_name"));
		config.put("portNumber", properties.getProperty("port_number"));

		DBConnectionJAXB instance = DBConnectionJAXB.getInstance(config);
		con = instance.getConnection();
	}

	void DBtoXML() {
		System.out.println("DB to XML");

		List<JugadorJAXB> listaJugadores = new ArrayList<JugadorJAXB>();

		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_TODOS_JUGADORES);

			while (resultSet.next()) {
				dorsal = resultSet.getInt("dorsal");
				nombre = resultSet.getString("nombre");
				posicion = PositionJAXB.valueOf(resultSet.getString("posicion").toUpperCase());

				jugadorJAXB = new JugadorJAXB(dorsal, nombre, posicion);

				listaJugadores.add(jugadorJAXB);

			}

			JAXBContext context = JAXBContext.newInstance(SeleccionJAXB.class);

			Marshaller marshaller = context.createMarshaller();

			SeleccionJAXB seleccionJAXB = new SeleccionJAXB();

			seleccionJAXB.setJugadores(listaJugadores);

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(seleccionJAXB, System.out);
			marshaller.marshal(seleccionJAXB, new File("seleccionFile.xml"));
			marshaller.marshal(seleccionJAXB, new FileWriter("seleccion.xml"));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void XMLtoDB() {

		System.out.println("XML to DB");

		List<JugadorJAXB> jugadores;

		final String INSERT_JUGADOR = "INSERT INTO jugador (dorsal, nombre, posicion) VALUES (?, ?, ?)";
		final String UPDATE_JUGADOR = "UPDATE jugador SET dorsal = ?, nombre = ?, posicion = ? WHERE jugador.dorsal = ?";
		final String SELECT_BY_DORSAL = "SELECT * from jugador WHERE jugador.dorsal = ?";

		try {
			JAXBContext context = JAXBContext.newInstance(SeleccionJAXB.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			SeleccionJAXB seleccionJAXB = (SeleccionJAXB) unmarshaller.unmarshal(new File("seleccion.xml"));
			System.out.println(seleccionJAXB.getJugadores().toString());

			jugadores = seleccionJAXB.getJugadores(); // Lista de jugadores del XML

			for (JugadorJAXB jugador : jugadores) {

				dorsal = jugador.getDorsal();
				nombre = jugador.getNombre();
				posicion = jugador.getPosition();

				// jugadorJAXB = new JugadorJAXB(dorsal, nombre, posicion);

				// SELECT * from jugador WHERE jugador.dorsal = ?
				PreparedStatement preparedStatement = con.prepareStatement(SELECT_BY_DORSAL);
				preparedStatement.setInt(1, dorsal);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (!resultSet.next()) { // Jugador no existe -> INSERTAR
					System.out.println("Jugador no existe. Insertando");

					PreparedStatement preparedInsert = con.prepareStatement(INSERT_JUGADOR);
					preparedInsert.setInt(1, dorsal);
					preparedInsert.setString(2, nombre);
					preparedInsert.setString(3, posicion.toString().toUpperCase());
					preparedInsert.executeUpdate();

				} else { // Jugador si Existe ->ACTUALIZAR
					System.out.println("Jugador existe. Actualizando");
					PreparedStatement preparedUpdate = con.prepareStatement(UPDATE_JUGADOR);
					preparedUpdate.setInt(1, dorsal);
					preparedUpdate.setString(2, nombre);
					preparedUpdate.setString(3, posicion.toString().toUpperCase());
					preparedUpdate.setInt(4, dorsal);
					preparedUpdate.executeUpdate();
				}
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
