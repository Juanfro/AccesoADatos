package listadoLibrosJAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "catalog")
@XmlType(propOrder= {"editorial", "year", "books"})
class Catalog {
	private List<Libro> libros = new ArrayList<>();
	int year;
	String editorial;

	public Catalog() {
		// TODO Auto-generated constructor stub
	}

	@XmlElementWrapper(name = "books")
	@XmlElement(name = "books")
	List<Libro> getLibros() {
		return libros;
	}

	void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	int getYear() {
		return year;
	}

	void setYear(int year) {
		this.year = year;
	}

	String getEditorial() {
		return editorial;
	}

	void setEditorial(String editorial) {
		this.editorial = editorial;
	}

}
