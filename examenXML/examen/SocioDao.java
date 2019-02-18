package examen;

import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import org.w3c.dom.Element;

import net.xqj.exist.ExistXQDataSource;

public class SocioDao implements DAOSocios {

	XQConnection connection;

	/**
	 * Constructor. <br>
	 * Aquí se inicializa la conexión
	 */
	public SocioDao() {

		XQDataSource xqs = new ExistXQDataSource();
		try {
			xqs.setProperty("serverName", "localhost");
			xqs.setProperty("port", "8080");
			connection = xqs.getConnection();

		} catch (XQException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Obtener un socio según su codigo
	 * 
	 */
	@Override
	public Socio get(int cod) {

		String queryGetByCod10 = //
				"for $socio in /SOCIOS_GIM/fila_socios\r\n"//
						+ "    where $socio/COD =" + cod + "\r\n"//
						+ "    return $socio";

		System.out.println("\nSocio con codigo " + cod + ":");

		try {
			XQExpression xqExpression = connection.createExpression();
			XQSequence xqSequence = xqExpression.executeQuery(queryGetByCod10);

			while (xqSequence.next()) {
				System.out.println(xqSequence.getItemAsString(null));

			}

		} catch (XQException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Socio> getAll() {
		System.out.println("\nMOSTRANDO TODOS LOS SOCIOS:");

		String queryGetAll = //
				"for $socio in /SOCIOS_GIM/fila_socios\r\n" //
						+ "return $socio";

		// String queryGetAll = "for $socio in /SOCIOS_GIM/fila_socios\r\n" + " return
		// $socio/NOMBRE/text()";

		try {

			XQExpression xqExpression = connection.createExpression();
			XQSequence xqSequence = xqExpression.executeQuery(queryGetAll);

			while (xqSequence.next()) {
				System.out.println(xqSequence.getItemAsString(null));

			}

		} catch (XQException e) {
			e.printStackTrace();
		}
		return null;
	}

}
