package partidosNeodatis;

import java.util.ArrayList;
import java.util.Date;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 * Inserta objetos en la base de datos correspondientes a jugadores, equipos y
 * partidos. Añade al menos 3 equipos de 4 jugadores cada uno y los partidos
 * resultantes de sus emparejamientos.
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class MainRellenarDatos {
	static ODB odb;

	public static void main(String[] args) {

		odb = ODBFactory.open("partidos.neodatis");

		Jugador j1, j2, j3, j4;

		Equipo e1, e2, e3;

		// Equipo Cosmos
		e1 = new Equipo("Cosmos", new ArrayList<Jugador>());

		// Crear jugadores
		j1 = new Jugador("JugadorCosmos1", 1989, e1);
		j2 = new Jugador("JugadorCosmos2", 1999, e1);
		j3 = new Jugador("JugadorCosmos3", 1979, e1);
		j4 = new Jugador("JugadorCosmos4", 2000, e1);

		// Añadir jugadores al equipo
		e1.getListaJugadores().add(j1);
		e1.getListaJugadores().add(j2);
		e1.getListaJugadores().add(j3);
		e1.getListaJugadores().add(j4);

		// Guardar jugadores
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);

		// ------------------------------------------------
		// Equipo Valleaguado
		e2 = new Equipo("Valleaguado", new ArrayList<Jugador>());

		j1 = new Jugador("JugadorValleaguado1", 2001, e2);
		j2 = new Jugador("JugadorValleaguado2", 2001, e2);
		j3 = new Jugador("JugadorValleaguado3", 2000, e2);
		j4 = new Jugador("JugadorValleaguado4", 1995, e2);

		e2.getListaJugadores().add(j1);
		e2.getListaJugadores().add(j2);
		e2.getListaJugadores().add(j3);
		e2.getListaJugadores().add(j4);

		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);

		// ------------------------------------------------
		// Equipo Spurs
		e3 = new Equipo("Spurs", new ArrayList<Jugador>());

		j1 = new Jugador("JugadorSpurs1", 1994, e3);
		j2 = new Jugador("JugadorSpurs2", 1993, e3);
		j3 = new Jugador("JugadorSpurs3", 1992, e3);
		j4 = new Jugador("JugadorSpurs4", 1991, e3);

		e3.getListaJugadores().add(j1);
		e3.getListaJugadores().add(j2);
		e3.getListaJugadores().add(j3);
		e3.getListaJugadores().add(j4);

		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);

		// *******************************************

		// PARTIDOS

		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();

		listaEquipos.add(e1);
		listaEquipos.add(e2);
		listaEquipos.add(e3);

		for (Equipo local : listaEquipos) {
			int golesLocal = (int) (Math.random() * 5);

			for (Equipo visitante : listaEquipos) {
				if (local != visitante) {
					int golesVisitante = (int) (Math.random() * 5);
					Partido partido = new Partido(new Date(), local, visitante, golesLocal, golesVisitante);
					odb.store(partido);
					System.out.println(partido.toString());
				}
			}
		}

		odb.close();

	}

}
