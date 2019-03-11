package examenNeodatis;

import java.util.ArrayList;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 * Crea dos objetos de venta asociadas con dos y tres líneas de venta
 * respectivamente.
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class ComercialCrearVentas {

	static ODB odb;

	public static void main(String[] args) {

		// Abrir BD
		odb = ODBFactory.open("comercial.neodatis");

		Venta venta1, venta2;
		LineaVenta linea1, linea2, linea3, linea4, linea5;

		// Venta 1. Tiene dos Lineas de Venta.

		// Crear Venta
		venta1 = new Venta(1, 123, new Date(), new ArrayList<LineaVenta>());

		// Crear LineasVenta
		linea1 = new LineaVenta(1, 11, "Patatas", 2, 5, venta1);
		linea2 = new LineaVenta(2, 22, "Huevos", 1, 12, venta1);

		// Asignar LineasVenta a la Venta
		venta1.getLineasVenta().add(linea1);
		venta1.getLineasVenta().add(linea2);

		// Guardar venta1 en BD. Hace commit de los cambios sin guardar
		odb.store(venta1);

		// Venta 2. Tiene tres líneas de venta

		// Crear Venta
		venta2 = new Venta(2, 456, new Date(), new ArrayList<LineaVenta>());

		// Crear LineasVenta
		linea3 = new LineaVenta(3, 33, "Aceite", 6, 1, venta2);
		linea4 = new LineaVenta(4, 44, "Sal", 1, 1, venta2);
		linea5 = new LineaVenta(5, 55, "Jamón", 12, 2, venta2);

		// Asignaer LineasVenta a la venta
		venta2.getLineasVenta().add(linea3);
		venta2.getLineasVenta().add(linea4);
		venta2.getLineasVenta().add(linea5);

		// Guardar venta2 en BD
		odb.store(venta2);

		// Cerrar BD. Hace commit de los cambios sin guardar
		odb.close();
	}

}
