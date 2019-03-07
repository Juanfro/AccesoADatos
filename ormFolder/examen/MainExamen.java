package examen;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MainExamen {

	private static SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
	private static Session session;
	private Transaction transaction;

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean fin = false;

		MainExamen examen = new MainExamen();

		while (!fin) {
			examen.gestionar();
		}

	}

	private void gestionar() {
		System.out.println("Elige una opción");

		System.out.println("1 - Crear Departamento");
		System.out.println("2 - Ver Datos de Empleado");
		System.out.println("3 - Listar empleados del departamento RESEARCH");

		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			createDept();
			break;
		case 2:
			datosEmpl();
			break;
		case 3:
			listEmpl();
			break;

		default:
			break;
		}
	}

	private void createDept() {

		// Abrir session
		session = sessionFactory.openSession();

		System.out.println("\n CREAR Departamento\n");

		// Crear Departamento

		System.out.println("Número del departamento:");
		short numDept = sc.nextShort();

		System.out.println("Nombre departamento:");
		String nombreDept = sc.next();

		System.out.println("ubicacción departamento:");
		String locationDept = sc.next();

		Dept dept = new Dept(numDept);
		dept.setDname(nombreDept);
		dept.setLoc(locationDept);

		// Guardar cambios
		transaction = session.beginTransaction();
		session.save(dept);

		transaction.commit();

		session.close();

	}

	private void datosEmpl() {

		// Abrir session
		session = sessionFactory.openSession();

		System.out.println("\nMostrar datos de un empleado");

		System.out.println("Escribe el número de empleado");

		short numEmpl = sc.nextShort();

		// Obtener empleado
		Emp emp = session.load(Emp.class, numEmpl);

		short empno = emp.getEmpno();
		String ename = emp.getEname();
		String job = emp.getJob();
		String manager = emp.getMgr().getEname();
		String fecha = emp.getHiredate().toString();
		BigDecimal salary = emp.getSal();
		String dept = emp.getDeptno().getDname();

		// DATOS
		System.out.println(
				empno + " | " + ename + " | " + job + " | " + manager + " | " + fecha + " | " + salary + " | " + dept);

		System.out.println();

	}

	private void listEmpl() {
		// Abrir session
		session = sessionFactory.openSession();

		System.out.println("\nMostrar empleados del departamento RESEARCH	");

		// Obtener dept

		Query query = session.createQuery("FROM Dept Dept WHERE dname ='RESEARCH'");

		Dept dept = (Dept) query.uniqueResult();

		Set<Emp> empList = dept.getEmpSet();

		for (Emp emp : empList) {
			System.out.println(emp.getEname());
		}

	}

}
