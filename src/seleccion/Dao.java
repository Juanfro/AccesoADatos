package seleccion;

import java.util.List;

/**
 * 
 * @author alumno
 *
 * @param <T>
 */
public interface Dao<T> {

	/**
	 * Obtener un jugador
	 * @param id Dorsal del jugador
	 * @return El jugador con el dorsal indicado
	 */
	T get(int id);// Read

	/**
	 * Mostrar todos los jugadores
	 * 
	 * @return
	 */
	List<T> getAll();// Read

	/**
	 * Crear/Guardar jugador
	 * 
	 * @param t Jugador a crear
	 */
	void save(T t);// Create

	//void update(T t);// Update

	/**
	 * Borrar jugador
	 * 
	 * @param num
	 */
	void delete(int num);// Delete

}
