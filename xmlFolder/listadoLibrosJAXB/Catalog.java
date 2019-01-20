package listadoLibrosJAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "catalog")
@XmlType(propOrder = { "editorial", "year", "books" })
class Catalog {
	private List<Libro> books = new ArrayList<>();
	int year;
	String editorial;

	public Catalog() {

	}

	// EDITORIAL
	String getEditorial() {
		return editorial;
	}

	@XmlElement(name = "editorial")
	void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	// YEAR
	int getYear() {
		return year;
	}

	@XmlElement(name = "year")
	void setYear(int year) {
		this.year = year;
	}

	// BOOKS
	List<Libro> getBooks() {
		return books;
	}

	@XmlElementWrapper(name = "books")
	@XmlElement(name = "book")
	void setBooks(List<Libro> books) {
		this.books = books;
	}

}
