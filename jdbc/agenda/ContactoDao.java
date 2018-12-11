package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ContactoDao implements DaoAgenda<Contacto> {

	// INSERT INTO `contacto` (`cod_contacto`, `nombre`, `telefono`, `email`)
	// VALUES ('4', 'Manolo', '654789231', 'mano@lo.com');
	private static final String INSERT_CONTACTO = "INSERT INTO contacto (cod_contacto, nombre, telefono, email) VALUES (?,?,?,?)";

	@Override
	public void save(Contacto cont, Connection c) {
		try {
			PreparedStatement preparedStatement = c.prepareStatement(INSERT_CONTACTO);

			preparedStatement.setInt(1, cont.getCodContacto());
			preparedStatement.setString(2, cont.getNombre());
			preparedStatement.setLong(3, cont.getTelefono());
			preparedStatement.setString(4, cont.getEmail());

			preparedStatement.executeUpdate();

			// c.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
