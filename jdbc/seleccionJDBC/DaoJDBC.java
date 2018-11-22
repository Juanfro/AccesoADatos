package seleccionJDBC;

import java.util.List;

/**
 * 
 * @author Juan Antonio Rodriguez
 *
 * @param <T>
 */

public interface DaoJDBC<T> {

	T get(int id);

	List<T> getAll();

	void save(T t);

	void delete(int num);

}
