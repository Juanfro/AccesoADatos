package seleccionEXISTDB;

import java.util.List;

interface DaoSeleccion<T> {

	T get(int id); // No se usa

	/**
	 * Obtener todos los jugadores
	 * 
	 * @return Lista de jugadores
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
	 * 
	 * @param num Numero del dorsal del jugador a borrar
	 */
	void delete(int num);

}
