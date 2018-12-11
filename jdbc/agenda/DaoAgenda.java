package agenda;

import java.sql.Connection;

interface DaoAgenda<T> {
	void save(T t, Connection c);
}
