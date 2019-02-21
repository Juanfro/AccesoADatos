package manipulacionObjetos;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class ManipulacionMain {

	public static void main(String[] args) {

		SessionFactory sf = (SessionFactory) new Configuration().configure().buildSessionFactory();
		Session session = ((org.hibernate.SessionFactory) sf).openSession();

	}

}
