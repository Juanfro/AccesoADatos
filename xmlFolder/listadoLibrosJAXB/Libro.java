package listadoLibrosJAXB;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "authors", "title", "genre", "price", "publish_date", "description" })
class Libro /* extends MarshalClass */ implements Serializable {

	private String id;
	private List<String> authors;
	private String title;
	private String genre;
	private Float price;
	private String publish_date;
	private String description;

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(String id, List<String> authors, String title, String genre, Float price, String publish_date,
			String description) {

		this.id = id;
		this.authors = authors;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.publish_date = publish_date;
		this.description = description;
	}

	@XmlAttribute(name = "id")
	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	public List<String> getAuthors() {
		return authors;
	}

	@XmlElementWrapper(name = "authors")
	@XmlElement(name = "author")
	/*
	 * public void setAuthors(List<Author> authors) { this.authors = authors; }
	 */
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
