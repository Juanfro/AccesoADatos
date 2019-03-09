package oficinaNeodatis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 * Escribe un pequeño programa que muestre en pantalla un listado en el que
 * figuren los datos de todos los empleados/as y el número de direcciones
 * asociadas a cada uno de ellos/as.
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class OficinaMain {

	static ODB odb;

	public static void main(String[] args) {

		odb = ODBFactory.open("oficina.neodatis");

		OficinaMain oficina = new OficinaMain();

		oficina.muestraEmpleados();

	}

	private void muestraEmpleados() {
		Objects<Empleado> empleados = odb.getObjects(Empleado.class);

		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();

			System.out.println("\nEmpleado " + empleado.getIdEmpleado());
			System.out.println("Nombre: " + empleado.getNombre());
			System.out.println("Fecha: " + empleado.getFechaNacimiento().toString());

			if (empleado.getJefe() != null) {
				System.out.print("Jefe: ");
				System.out.println(empleado.getJefe().getNombre());
			}

			// System.out.print("Direcciones: ");
			// System.out.println(empleado.getDirecciones());

			List<Direccion> direcciones = empleado.getDirecciones();

			for (Direccion direccion : direcciones) {
				System.out.println(direccion.getCalle());
			}

			odb.getValues(new ValuesCriteriaQuery(Direccion.class).count("nb direcciones"));

		}

	}

}
