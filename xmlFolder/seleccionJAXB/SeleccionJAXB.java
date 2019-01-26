package seleccionJAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "seleccion")
class SeleccionJAXB {

	public SeleccionJAXB() {
	}

	private List<JugadorJAXB> jugadores = new ArrayList<JugadorJAXB>();

	List<JugadorJAXB> getJugadores() {
		return jugadores;
	}

	@XmlElementWrapper(name = "jugadores")
	@XmlElement(name = "jugador")
	void setJugadores(List<JugadorJAXB> jugadores) {
		this.jugadores = jugadores;
	}

}
