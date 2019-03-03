package consultasHQL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import consultasHQL.entity.Dept;
import consultasHQL.entity.Emp;

/**
 * <ol>
 * <li>Realiza una consulta con “createQuery” para obtener los datos del
 * departamento 20 y visualiza también el apellido de sus empleados.</li>
 * <li>Realiza una consulta que visualice los empleados cuyo número de
 * departamento sea 10 y el oficio sea “DIRECTOR”</li>
 * <li>Utiliza “executeUpdate” para incrementar un 20% el salario del empleado
 * con apellido GIL.</li>
 * <li>Utiliza “executeUpdate” para eliminar los empleados del departamento
 * 20.</li>
 * <li>Realiza una consulta con “joins” que muestre el listado de los empleados
 * del departamento “SALES” con un salario mayor o igual a 1500 euros.</li>
 * <li>Realiza una consulta de resumen que muestre la media de los salarios de
 * los empleados de cada departamento.</li>
 * </ol>
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class Consultas {
	static boolean fin = false;

	private Transaction transaction;
	private Session session;

	public static void main(String[] args) {
		Consultas consultas = new Consultas();

		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.addAnnotatedClass(Dept.class).addAnnotatedClass(Emp.class)
				.buildSessionFactory(serviceRegistry);

		consultas.session = sessionFactory.openSession();

		while (!fin) {
			consultas.usandoHQL();
		}

	}

	private void usandoHQL() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nElige Una Opción:");
		System.out
				.println("1 - obtener los datos del departamento 20 y visualiza también el apellido de sus empleados");
		System.out.println("2 - empleados cuyo número de departamento sea 10 y el oficio sea “DIRECTOR”");
		System.out.println("3 - incrementar un 20% el salario del empleado con apellido GIL");
		System.out.println("4 - eliminar los empleados del departamento 20");
		System.out.println(
				"5 - listado de los empleados del departamento “SALES” con un salario mayor o igual a 1500 euros");
		System.out.println("6 - media de los salarios de los empleados de cada departamento");
		System.out.println("7 - FIN");

		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			datosDept20();
			break;
		case 2:
			empDept10Director();
			break;
		case 3:
			aumentoSalarioGil();
			break;
		case 4:
			deleteEmplDept55();
			break;
		case 5:
			listEmpRicos();
			break;
		case 6:
			mediaSalaries();
			break;
		case 7:
			fin();
			break;

		default:
			break;
		}
	}

	/**
	 * Realiza una consulta de resumen que muestre la media de los salarios de los
	 * empleados de cada departamento.
	 */
	private void mediaSalaries() {

		transaction = session.beginTransaction();

		String queryDepts = "FROM Dept Dept";
		String queryEmpls = "SELECT avg(Emp.sal) FROM Emp Emp WHERE Emp.deptno.deptno = :deptNo";

		Query query = session.createQuery(queryDepts);
		List<Dept> lisDepts = query.list();

		System.out.format("%-6s%-15s%-20s", "Nº", "Nombre", "Media de Salario");
		System.out.println();

		lisDepts.forEach(dept -> {
			Query query2 = session.createQuery(queryEmpls);
			query2.setParameter("deptNo", dept.getDeptno());
			List<Double> listEmpl = query2.list();

			System.out.format("%-6s%-15s%15s", dept.getDeptno(), dept.getDname(), String.valueOf(listEmpl.get(0)));
			System.out.println();

		});

		System.out.println();

		transaction.commit();

		session.close();

	}

	/**
	 * Realiza una consulta con “joins” que muestre el listado de los empleados del
	 * departamento “SALES” con un salario mayor o igual a 1500 euros.
	 */
	private void listEmpRicos() {

		transaction = session.beginTransaction();
		String queryHQL = "FROM Emp Emp INNER JOIN Emp.deptno dept WHERE dept.dname = 'SALES' AND Emp.sal >= '1500'";

		Query query = session.createQuery(queryHQL);

		List<?> list = query.list();

		System.out.format("%-6s%-10s%-11s%-11s%-22s%-10s%-12s%-12s", "Nº", "Nombre", "Cargo", "Nº Manager",
				"Fecha de Contratación", "Salario", "Comisiones", "Departamento");
		System.out.println("");

		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i);
			Emp emp = (Emp) row[0];
			Dept dept = (Dept) row[1];

			String empNo = String.valueOf(emp.getEmpno());
			String name = emp.getEname();
			String job = emp.getJob();

			Emp mngr = emp.getMgr();
			String mngrNo = null;
			if (mngr != null)
				mngrNo = String.valueOf(emp.getMgr().getEmpno());

			String hireDate = emp.getHiredate().toString();
			String salary = String.valueOf(emp.getSal());
			String comm = String.valueOf(emp.getComm());
			String deptName = dept.getDname();

			System.out.format("%-6s%-10s%-11s%-11s%-22s%-10s%-12s%-12s", empNo, name, job, mngrNo, hireDate, salary,
					comm, deptName);
			System.out.println();

		}

		System.out.println();

		transaction.commit();

		session.close();
	}

	/**
	 * Utiliza “executeUpdate” para eliminar los empleados del departamento 55.
	 */
	private void deleteEmplDept55() {
		transaction = session.beginTransaction();
		String queryHQL = "DELETE Emp Emp WHERE Emp.deptno = 55";

		Query query = session.createQuery(queryHQL);

		query.executeUpdate();

		transaction.commit();

		session.close();

	}

	/**
	 * Utiliza “executeUpdate” para incrementar un 20% el salario del empleado con
	 * apellido GIL
	 */
	private void aumentoSalarioGil() {
		transaction = session.beginTransaction();
		String queryGET = "FROM Emp Emp WHERE Emp.ename ='JAMES'";
		String queryUPDATE = "UPDATE Emp Emp SET Emp.sal = :updateSal WHERE Emp.ename ='JAMES' ";

		// Get Salary and increase it
		Query query = session.createQuery(queryGET);
		Emp emp = (Emp) query.uniqueResult();
		BigDecimal empSal = emp.getSal();
		double updatedSal = empSal.doubleValue() * 1.20;
		empSal = BigDecimal.valueOf(updatedSal);

		// Update
		query = session.createQuery(queryUPDATE);
		query.setParameter("updateSal", empSal);
		query.executeUpdate();

		transaction.commit();

		System.out.println("Salary increased");

		session.close();

	}

	/**
	 * Realiza una consulta que visualice los empleados cuyo número de departamento
	 * sea 10 y el oficio sea “DIRECTOR”
	 */
	private void empDept10Director() {
		transaction = session.beginTransaction();
		String queryHQL = "FROM Emp Emp WHERE Emp.deptno = 10 AND Emp.job='DIRECTOR'";
		// String queryHQL = "FROM Emp Emp ";
		Query query = session.createQuery(queryHQL);

		ArrayList<Emp> empList = (ArrayList<Emp>) query.list();

		System.out.println();
		System.out.format("%-6s%-10s%-11s%-11s%-22s%-10s%-12s%-3s", "Nº", "Nombre", "Cargo", "Nº Manager",
				"Fecha de Contratación", "Salario", "Comisiones", "Nº Dept");
		System.out.println();

		empList.forEach(emp -> {
			String empNo = String.valueOf(emp.getEmpno());
			String name = emp.getEname();
			String job = emp.getJob();

			Emp mngr = emp.getMgr();
			String mngrNo = null;
			if (mngr != null)
				mngrNo = String.valueOf(emp.getMgr().getEmpno());

			String hireDate = emp.getHiredate().toString();
			String salary = String.valueOf(emp.getSal());
			String comm = String.valueOf(emp.getComm());
			String deptNo = String.valueOf(emp.getDeptno().getDeptno());

			System.out.format("%-6s%-10s%-11s%-11s%-22s%-10s%-12s%-3s", empNo, name, job, mngrNo, hireDate, salary,
					comm, deptNo);
			System.out.println();
		});

		System.out.println();

		transaction.commit();

		session.close();

	}

	/**
	 * Realiza una consulta con “createQuery” para obtener los datos del
	 * departamento 20 y visualiza también el apellido de sus empleados.
	 */
	private void datosDept20() {
		transaction = session.beginTransaction();
		String queryHQL = "FROM Dept Dept WHERE Dept.deptno = 20";
		Query query = session.createQuery(queryHQL);
		Dept dept = (Dept) query.uniqueResult();

		System.out.format("%-6s%-10s%-10s%-10s", "Nº", "Nombre", "Localicación", "Empleados");
		System.out.println();

		String deptno = String.valueOf(dept.getDeptno());
		String name = dept.getDname();
		String location = dept.getLoc();

		Set<Emp> empList = dept.getEmpSet();

		empList.forEach(emp -> {
			System.out.format("%-6s%-10s%-10s%-10s", deptno, name, location, emp.getEname());
			System.out.println();
		});

		System.out.println();

		transaction.commit();

		session.close();

	}

	private void fin() {
		fin = true;
	}

}
