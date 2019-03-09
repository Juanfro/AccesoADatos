package partidosNeodatis;

import java.util.List;

public class Equipo {

	// Atributos

	private String nombre;
	private List<Jugador> listaJugadores;

	public Equipo() {
	}

	public Equipo(String nombre, List<Jugador> listaJugadores) {

		this.nombre = nombre;
		this.listaJugadores = listaJugadores;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listaJugadores=" + listaJugadores + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

}
