package gesttionProductos;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "oferta")
@XmlType(propOrder = { "nombre" })
class Oferta {

	String nombre;

	public Oferta() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
