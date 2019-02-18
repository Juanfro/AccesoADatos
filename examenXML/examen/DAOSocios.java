package examen;

import java.util.List;

public interface DAOSocios {

	/**
	 * Obtener Socio que tenga el codigo
	 * 
	 * @param cod
	 * @return
	 */
	Socio get(int cod);

	/**
	 * Obtener todos los socios
	 * 
	 * @return
	 */
	List<Socio> getAll();

}
