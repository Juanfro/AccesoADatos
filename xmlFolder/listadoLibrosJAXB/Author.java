package listadoLibrosJAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "author")
@XmlType(propOrder = { "nombre" })
class Author {

	String nombre;

	public Author() {
	}

	public String getNombre() {
		return nombre;
	}

	@XmlElement(name = "nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
