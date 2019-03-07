package examenHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {

	private static Configuration configuration;
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.addAnnotatedClass(Alumno.class).addAnnotatedClass(Aula.class)
				.addAnnotatedClass(Profe.class).buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}

}
