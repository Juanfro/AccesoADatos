package seleccionHibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

class JugadorHibernateDao implements DaoSeleccion<Jugador> {

	private Session session;
	private SessionFactory sessionFactory;
	private Transaction transaction;

	public JugadorHibernateDao(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
		this.session = sessionFactory.openSession();
		this.transaction = null;

	}

	@Override
	public Jugador get(int num) {

		Jugador jugador = null;

		try {

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Jugador Jugador WHERE Jugador.dorsalm = :dorsal";
			Query query = session.createQuery(hql);
			query.setParameter("dorsal", num);

			jugador = (Jugador) query.uniqueResult();

			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();

			e.printStackTrace();

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}

		return jugador;
	}

	@Override
	public List<Jugador> getAll() {

		List<Jugador> jugadorList = null;

		try {

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Jugador";
			Query query = session.createQuery(hql);
			jugadorList = query.list();

			transaction.commit();

		} catch (HibernateException e) {

			if (transaction != null)
				transaction.rollback();

			e.printStackTrace();

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}

		return jugadorList;
	}

	@Override
	public void save(Jugador j) {

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(j);
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int num) {
		try {

			Jugador jugador = get(num);

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.delete(jugador);

			transaction.commit();

		} catch (HibernateException e) {

			if (transaction != null)
				transaction.rollback();

			e.printStackTrace();

		} finally {

			try {

				session.close();

			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}
	}

}
