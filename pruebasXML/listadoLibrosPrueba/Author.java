package listadoLibrosPrueba;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "author")
@XmlType(propOrder = { "nombre" })
class Author {

	String name;

	public Author() {
	}

	String getName() {
		return name;
	}

	@XmlElement(name = "nombre")
	void setName(String name) {
		this.name = name;
	}

}
