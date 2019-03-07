package examenHibernate;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.DataException;
import org.hibernate.query.Query;

/**
 * Escribe una aplicación Java que utilice la librería Hibernate y la base de
 * datos de un instituto para implementar las siguientes funcionalidades:
 * <ul>
 * <li>Generación a partir de las tablas de la base de datos de las clases de
 * entidad con las anotaciones correspondientes.</li>
 * <li>Inserción de un nuevo alumno al que le da clase el profesor P03.</li>
 * <li>Obtención de los datos del profesor ‘P01’ incluyendo los nombres de los
 * alumnos a los que le da clase.</li>
 * <li>Listado del número de alumnos a los que da clase cada profesor</li>
 * </ul>
 * 
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class InstitutoMain {
	private static SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
	private static Session session;
	private Transaction transaction;

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean fin = false;

		InstitutoMain instituto = new InstitutoMain();

		while (!fin) {
			instituto.gestionar();
		}

	}

	private void gestionar() {

		System.out.println("\nElige una opción");

		System.out.println("1 - Inserción de un nuevo alumno al que le da clase el profesor P03");
		System.out.println("2 - Obtención de los datos del profesor ‘P01’ "
				+ "incluyendo los nombres de los alumnos a los que le da clase");
		System.out.println("3 - Listado del número de alumnos a los que da clase cada profesor");

		int option = sc.nextInt();

		switch (option) {
		case 1:
			insertaAlumno();
			break;
		case 2:
			datosProfesorP01();
			break;
		case 3:
			listadoAlumnos();
			break;

		default:
			break;
		}

	}

	private void insertaAlumno() {
		// Crear Alumno
		Alumno alumno = new Alumno();
		try {
			// Abrir session
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			System.out.println( // Separador
					"\n__________________________________________________________________________________________________________\n");

			System.out.println("Inserción de un nuevo alumno " + "al que le da clase el profesor P03");

			// Asignarle el profesor
			Profe profe = session.load(Profe.class, "P03");
			alumno.setCodprof(profe);
			alumno.setDni("111");
			alumno.setNombreA("AlumnoEx");
			alumno.setDireccionA("Calle 123");

			// Persistir
			session.save(alumno);
			transaction.commit();

			System.out.println("Alumno " + alumno.getNombreA() + " insertado con exito");
		} catch (HibernateException e) {
			System.out.println("Error de hibernate");
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} catch (PersistenceException e) {// Si la clave primaria ya está en uso saltará una excepción de persistencia.
			System.out.println("\nClave primaria \"" + alumno.getDni() + "\" duplicada");
			if (transaction != null) {
				transaction.rollback();
			}
			// e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void datosProfesorP01() {
		// Abrir session
		session = sessionFactory.openSession();

		System.out.println( // Separador
				"\n__________________________________________________________________________________________________________\n");

		System.out.println("\nObtención de los datos del profesor ‘P01’ "
				+ "incluyendo los nombres de los alumnos a los que le da clase");

		try {
			Profe profe = session.load(Profe.class, "P01");

			// Datos del profesor
			String codp = profe.getCodp();
			String nombre = profe.getNombreP();
			Integer edad = profe.getEdad();

			System.out.println("\nDatos del profesor");
			// System.out.println("\nCodp: " + codp + " | Nombre: " + nombre + " | Edad: " +
			// edad);
			System.out.println("Codp: " + codp);
			System.out.println("Nombre: " + nombre);
			System.out.println("Edad: " + edad);

			// Alumnos a los que da clase
			System.out.println("\nDa clase a:");

			String queryLista = "FROM Alumno Alumno WHERE Alumno.codprof='P01'";
			Query<?> query = session.createQuery(queryLista);

			ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) query.list();

			for (Alumno alumno : listaAlumnos) {
				System.out.println("\t" + alumno.getNombreA());
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void listadoAlumnos() {

		// Abrir session
		session = sessionFactory.openSession();

		System.out.println( // Separador
				"\n__________________________________________________________________________________________________________\n");

		System.out.println("Listado del número de alumnos a los que da clase cada profesor");

		try {
			// Obtener profesores
			String queryGetProfesores = "FROM Profe Profe";
			Query<?> query = session.createQuery(queryGetProfesores);
			ArrayList<Profe> listaProfe = (ArrayList<Profe>) query.list();

			// Obtener alumnos de cada profesor

			// Lista profesores
			for (Profe profe : listaProfe) {

				String codP = profe.getCodp();

				System.out.println("\nProfesor: " + profe.getNombreP());

				// Lista de alumnos
				String queryGetALumnos = "FROM Alumno Alumno WHERE Alumno.codprof='" + codP + "'";

				Query<?> query2 = session.createQuery(queryGetALumnos);

				ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) query2.list();

				for (Alumno alumno : listaAlumnos) {
					System.out.println("\t" + alumno.getNombreA());
				} // foreach Alumno
				if (listaAlumnos.size() == 0) {
					System.out.println("No tiene alumnos");
				}

			} // foreach Profe
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}// listadoAlumnos

}
