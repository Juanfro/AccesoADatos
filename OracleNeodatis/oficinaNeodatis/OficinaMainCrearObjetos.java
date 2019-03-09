package oficinaNeodatis;

import java.util.ArrayList;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 * 
 * <ul>
 * <li>Crea las clases que definen Empleados y Direcciones.</li>
 * <li>Crea dos objetos de empleado/a asociados con dos y tres direcciones
 * respectivamente.</li>
 * </ul>
 * 
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class OficinaMainCrearObjetos {
	static ODB odb;

	public static void main(String[] args) {

		odb = ODBFactory.open("oficina.neodatis");

		Empleado emp1, emp2;
		Direccion dir1, dir2, dir3, dir4, dir5;

		// Empleado 1

		emp1 = new Empleado(1, "Empleado1", new Date(), null, new ArrayList<Empleado>(), new ArrayList<Direccion>());

		dir1 = new Direccion(1, "calle primera", "28822", "Coslá", "Madrí", emp1);
		dir2 = new Direccion(2, "calle segunda", "28820", "San Frenando", "Madrí", emp1);

		emp1.getDirecciones().add(dir1);
		emp1.getDirecciones().add(dir2);

		odb.store(emp1);

		// Empleado 2

		emp2 = new Empleado(2, "Empleado2", new Date(), emp1, new ArrayList<Empleado>(), new ArrayList<Direccion>());

		dir3 = new Direccion(3, "calle tercera", "26600", "Mejorada", "Huesca", emp2);
		dir4 = new Direccion(4, "calle cuarta", "26500", "Velilla", "Zaragoza", emp2);
		dir5 = new Direccion(5, "calle quinta", "26600", "Alcobendas", "Teruel", emp2);

		emp2.getDirecciones().add(dir3);
		emp2.getDirecciones().add(dir4);
		emp2.getDirecciones().add(dir5);

		odb.store(emp2);

		odb.close();

	}

}
