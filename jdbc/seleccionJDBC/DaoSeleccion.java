package seleccionJDBC;

import java.util.List;

/**
 * 
 * @author Juan Antonio Rodriguez
 *
 * @param <T>
 */

public interface DaoSeleccion<T> {

	T get(int id);

	/**
	 * Obtener todos los jugadores
	 * @return Lista de los jugadores
	 */
	List<T> getAll();

	void save(T t);

	void delete(int num);

}
