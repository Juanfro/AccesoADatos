package partidosNeodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

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
		System.out.println("\n Jugadores mayores de 25");
		IQuery query = new CriteriaQuery(Jugador.class, Where.lt("fechaNacimiento", 1994));
		Objects<Jugador> jugadores = odb.getObjects(query);

		while (jugadores.hasNext()) {
			Jugador jugador = jugadores.next();

			System.out.println(jugador.toString());
		}
	}

	/**
	 * Muestra la tabla clasificatoria de la competición.
	 */
	private void clasificacion() {

		System.out.println("\nClasificación");
		Objects<Partido> listaPartidos = odb.getObjects(Partido.class);

	}

}
