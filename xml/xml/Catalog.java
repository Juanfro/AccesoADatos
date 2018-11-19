package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "catalog")
public class Catalog {

	ArrayList<Book> books;
	int year;
	String editorial;

	public ArrayList<Book> getBooks() {
		return books;
	}

	@XmlElementWrapper(name = "books")
	@XmlElement(name = "book")
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public int getYear() {
		return year;
	}
	@XmlElement(name="anyo")
	public void setYear(int year) {
		this.year = year;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

}
