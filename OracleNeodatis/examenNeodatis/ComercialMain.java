package examenNeodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

/**
 * Utilizando la BBDDOO Neodatis. <br>
 * 
 * <ul>
 * <li>Crea las clases que definen Ventas y Líneas de Venta</li>
 * <li>Crea dos objetos de venta asociadas con dos y tres líneas de venta
 * respectivamente</li>
 * <li>Crea un método en la clase de venta que calcule el importe total de la
 * venta. Muestra dicha funcionalidad con un pequeño programa que invoca el
 * métodos a todas las ventas almacenadas en la BBDDOO que acabas de crear</li>
 * </ul>
 * 
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class ComercialMain {

	static ODB odb;

	public static void main(String[] args) {

		// Abrir BD
		odb = ODBFactory.open("comercial.neodatis");

		ComercialMain comercial = new ComercialMain();

		comercial.muestraImporte();

		// Cerrar BD. Hace commit de los cambios que no se hayan guardado (uncommitted)
		odb.close();

	}

	/**
	 * Calcule el importe total de la venta. Muestra dicha funcionalidad con un
	 * pequeño programa que invoca el métodos a todas las ventas almacenadas en la
	 * BBDDOO
	 */
	private void muestraImporte() {
		// Obtener ventas de la BD
		Objects<Venta> ventas = odb.getObjects(Venta.class);

		while (ventas.hasNext()) {
			Venta venta = ventas.next();

			venta.importeTotal();
		}

	}

}
