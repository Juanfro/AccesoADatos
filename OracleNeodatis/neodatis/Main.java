package neodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

/**
 * 
 * <ul>
 * <li>Extrae y muestra en pantalla un listado con los partidos que se han
 * jugado, mostrando el nombre de los equipos, el resultado y la fecha en la que
 * se jugó el partido.</li>
 * <li>Muestra los jugadores que tengan más de 25 años.</li>
 * <li>Muestra la tabla clasificatoria de la competición.</li>
 * </ul>
 * 
 * 
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class Main {
	static ODB odb;

	public static void main(String[] args) {

		odb = ODBFactory.open("partidos.neodatis");

		Main main = new Main();

		main.mostrarPartidos();

		main.mayores25();

		main.clasificacion();

		odb.close();

	}

	/**
	 * Extrae y muestra en pantalla un listado con los partidos que se han jugado,
	 * mostrando el nombre de los equipos, el resultado y la fecha en la que se jugó
	 * el partido.
	 */
	private void mostrarPartidos() {
		System.out.println("\nListado de partidos:");
		Objects<Partido> partidos = odb.getObjects(Partido.class);

		while (partidos.hasNext()) {
			Partido partido = partidos.next();
			System.out.printf("Jornada: %35s %17s %1d - %1d %-17s ", partido.getFechapartido().toString(),
					partido.getLocal().getNombre(), partido.getGolesLocal(), partido.getGolesVisitante(),
					partido.getVisitante().getNombre());
			System.out.println();

		}

	}

	/**
	 * Muestra los jugadores que tengan más de 25 años
	 */
	private void mayores25() {

	}

	/**
	 * Muestra la tabla clasificatoria de la competición.
	 */
	private void clasificacion() {

	}

}
