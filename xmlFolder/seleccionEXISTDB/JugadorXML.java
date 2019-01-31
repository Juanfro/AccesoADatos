package seleccionEXISTDB;

import java.io.Serializable;

@SuppressWarnings("serial")
class JugadorXML implements Serializable {
	public static enum PositionJDBC {
		PORTERO, DEFENSA, MEDIO, DELANTERO
	}

	private int dorsal;
	private String nombre;
	private PositionJDBC position;

	public JugadorXML(int dorsal, String nombre, PositionJDBC position) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.position = position;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PositionJDBC getPosition() {
		return position;
	}

	public void setPosition(PositionJDBC position) {
		this.position = position;
	}

	@Override
	public String toString() {

		String toString = String.format("%-9s %-48s %-30s", "Dorsal: " + dorsal, " | Nombre: " + nombre,
				" | Posición: " + position);
		// return "Dorsal:" + dorsal + " | Nombre:" + nombre + " | Posición:" + position
		// + "";
		return toString;
	}
}
