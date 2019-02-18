package manipulacionObjetos;

import com.mysql.cj.xdevapi.SessionFactory;

public class ManipulacionMain {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

	}

}
