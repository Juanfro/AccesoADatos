package seleccionJAXB;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "jugador")
class JugadorJAXB implements Serializable {

	public JugadorJAXB() {
	}

	public static enum PositionJAXB {
		PORTERO, DEFENSA, MEDIO, DELANTERO
	}

	private int dorsal;
	private String nombre;
	private PositionJAXB position;

	public JugadorJAXB(int dorsal, String nombre, PositionJAXB position) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.position = position;
	}

	public int getDorsal() {
		return dorsal;
	}

	@XmlElement(name = "dorsal")
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	@XmlElement(name = "nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PositionJAXB getPosition() {
		return position;
	}

	@XmlElement(name = "posicion")
	public void setPosition(PositionJAXB position) {
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
