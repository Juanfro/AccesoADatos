package listadoLibrosPrueba;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "catalog")
@XmlType(propOrder = { "editorial", "year", "libros" })
public class Catalog {

	String editorial;
	int year;
	private List<Book> books = new ArrayList<>();

	public Catalog() {
	}

	@XmlElement(name = "editorial")
	String getEditorial() {
		return editorial;
	}

	void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@XmlElement(name = "year")
	int getYear() {
		return year;
	}

	void setYear(int year) {
		this.year = year;
	}

	@XmlElementWrapper(name = "books")
	@XmlElement(name = "book")
	List<Book> getLibros() {
		return books;
	}

	void setLibros(List<Book> books) {
		this.books = books;
	}

}
