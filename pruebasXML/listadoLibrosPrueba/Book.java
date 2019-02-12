package listadoLibrosPrueba;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "authors", "title", "genre", "price", "publish_date", "description" })
class Book {

	String id;
	List<String> authors;
	String title;
	String genre;
	Float price;
	String publish_date;
	String description;

	public Book() {
	}

	public Book(String id, List<String> autores, String title, String genero, Float precio, String fecha_publicacion,
			String descripcion) {
		super();
		this.id = id;
		this.authors = autores;
		this.title = title;
		this.genre = genero;
		this.price = precio;
		this.publish_date = fecha_publicacion;
		this.description = descripcion;
	}

	@XmlAttribute(name = "id")
	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	List<String> getAuthors() {
		return authors;
	}

	@XmlElementWrapper(name = "authors")
	@XmlElement(name = "author")
	void setAuthors(List<String> autores) {
		this.authors = autores;
	}

	String getTitle() {
		return title;
	}

	@XmlElement
	void setTitle(String titulo) {
		this.title = titulo;
	}

	String getGenre() {
		return genre;
	}

	@XmlElement
	void setGenre(String genero) {
		this.genre = genero;
	}

	Float getPrice() {
		return price;
	}

	@XmlElement
	void setPrice(Float precio) {
		this.price = precio;
	}

	String getPublish_date() {
		return publish_date;
	}

	@XmlElement
	void setPublish_date(String fecha_publicacion) {
		this.publish_date = fecha_publicacion;
	}

	public String getDescription() {
		return description;
	}

	// @XmlElement
	public void setDescription(String descripcion) {
		this.description = descripcion;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", autores=" + authors + ", titulo=" + title + ", genero=" + genre + ", precio="
				+ price + ", fecha_publicacion=" + publish_date + ", descripcion=" + description + "]";
	}

}
