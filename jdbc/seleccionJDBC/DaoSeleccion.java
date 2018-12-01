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
	 * 
	 * @return Lista de los jugadores
	 */
	List<T> getAll();

	/**
	 * Añadir un jugador
	 * 
	 * @param t
	 */
	void save(T t);

	
	/**
	 * Borrar Un jugador
	 * @param num Numero del dorsal del jugador a borrar
	 */
	void delete(int num);

}
