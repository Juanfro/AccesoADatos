package manipulacionObjetos;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import manipulacionObjetos.entity.Dept;
import manipulacionObjetos.entity.Emp;

/**
 * 
 * <ol>
 * <li>Utiliza el fichero scott.dml.sql para crear una base de datos en el
 * gestor MySQL y configura el uso de Hibernate en tu IDE de preferencia. Crear
 * los POJOS asociados a las tablas de la BBDD con sus anotaciones
 * correspondientes.</li>
 * 
 * <li>Realiza la funcionalidad que consiste en cargar y mostrar en pantalla
 * todos los empleados de un departamento con un identificador concreto que se
 * pasa como parámetro de entrada. Utiliza el método “load” del objeto “sesión”
 * de Hibernate.</li>
 * 
 * <li>Realiza la funcionalidad que consiste en crear un nuevo departamento con
 * los datos obtenidos de los parámetros de entrada y almacenarlo en la BBDD.
 * Utiliza el método “save” del objeto “session” de Hibernate.</li>
 * 
 * <li>Realiza la funcionalidad que consiste en borrar un empleado con un
 * identificador concreto que se pasa como parámetro de entrada.</li>
 * 
 * </ol>
 * 
 * 
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class ManipulacionMain {
	static boolean fin = false;

	private Transaction transaction;
	private Session session;

	public static void main(String[] args) {

		ManipulacionMain manipulacionMain = new ManipulacionMain();

		SessionFactory sessionFactory;

		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Dept.class).addAnnotatedClass(Emp.class)
				.buildSessionFactory(serviceRegistry);

		manipulacionMain.session = sessionFactory.openSession();

		while (!fin) {
			manipulacionMain.menu();
		}

	}

	void menu() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\nElige una opción");
		System.out.println(
				"1 - Mostrar en pantalla todos los empleados de un departamento con un identificador concreto");
		System.out.println(
				"2 - crear un nuevo departamento con los datos obtenidos de los parámetros de entrada y almacenarlo en la BBDD");
		System.out
				.println("3 - borrar un empleado con un identificador concreto que se pasa como parámetro de entrada");
		System.out.println("4 - FIN");

		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("Escribe un id de departamento");
			// int numDept = sc.nextInt();
			muestraEmpleados(10);
			break;
		case 2:
			System.out.println("\nCrear departamento");
			System.out.println("Nombre del departamento:");

			String nombreDept = sc.next();

			System.out.println("Localizacion del departamento:");

			String locationDept = sc.next();

			System.out.println("Codigo departamento:");

			Short codDept = sc.nextShort();

			crearDept(nombreDept, locationDept, codDept);

			break;
		case 3:
			System.out.println("\nBorrar Empleado");
			System.out.println("Escribe el id del empleado a borrar");

			Short idEmpl = sc.nextShort();

			borrarEmpl(idEmpl);

			break;
		case 4:
			fin();
			break;

		default:
			break;
		}
	}

	/**
	 * cargar y mostrar en pantalla todos los empleados de un departamento con un
	 * identificador concreto que se pasa como parámetro de entrada
	 * 
	 * @param numDept
	 */
	private void muestraEmpleados(int numDept) {

		// byte depnoByte = (byte) numDept;

		System.out.println("\nMostrar Empleados\n");
		transaction = session.beginTransaction();
		System.out.format("%-6s%-10s%-11s%-15s%-22s%-10s%-12s%-3s", "Nº", "Nombre", "Cargo", "Nº Manager",
				"Fecha de Contratación", "Salario", "Comisiones", "Nº Dept");
		System.out.println();

		Dept dept = /* (Dept) */ session.load(Dept.class, /* (short) */(short) numDept);

		// Set<Emp> empList = (Set<Emp>) dept.getEmpCollection();
		Collection<Emp> empList = dept.getEmpCollection();

		for (Emp emp : empList) {
			String empNo = String.valueOf(emp.getEmpno());
			String name = emp.getEname();
			String cargo = emp.getJob();

			Emp manager = emp.getMgr();
			String numManager = null;
			if (manager != null) {
				numManager = String.valueOf(manager.getEmpno());

			}

			String fechaContratacion = emp.getHiredate().toString();
			String salary = String.valueOf(emp.getSal());
			String comision = String.valueOf(emp.getComm());
			String numDepart = String.valueOf(emp.getDeptno().getDeptno());

			System.out.format("%-6s%-10s%-11s%-15s%-22s%-10s%-12s%-3s", empNo, name, cargo, /* manager, */ numManager,
					fechaContratacion, salary, comision, numDepart);
			System.out.println();
		}

		transaction.commit();

		session.close();

	}

	/**
	 * crear un nuevo departamento con los datos obtenidos de los parámetros de
	 * entrada y almacenarlo en la BBDD.
	 */
	private void crearDept(String nombreDept, String locationDept, short codDept) {
		Dept dept = new Dept(codDept);
		dept.setDname(nombreDept);
		dept.setLoc(locationDept);

		transaction = session.beginTransaction();
		session.save(dept);
		transaction.commit();

		session.close();
	}

	/**
	 * borrar un empleado con un identificador concreto que se pasa como parámetro
	 * de entrada
	 * 
	 * @param empID
	 */
	private void borrarEmpl(Short empID) {
		transaction = session.beginTransaction();

		Emp emp = session.load(Emp.class, empID);

		session.delete(emp);

		transaction.commit();

	}

	private void fin() {
		fin = true;

	}

}
