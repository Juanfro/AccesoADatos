package listadoLibrosJAXB;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "authors", "title", "genre", "price", "publish_date", "description" })
class Libro extends MarshalClass {

	private String id;
	private String autor;
	private String titulo;
	private String genero;
	private Float precio;
	private String fechaPublicacion;
	private String descripcion;

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute(name="id")
	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	String getAutor() {
		return autor;
	}

	void setAutor(String autor) {
		this.autor = autor;
	}

	String getTitulo() {
		return titulo;
	}

	void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	String getGenero() {
		return genero;
	}

	void setGenero(String genero) {
		this.genero = genero;
	}

	Float getPrecio() {
		return precio;
	}

	void setPrecio(Float precio) {
		this.precio = precio;
	}

	String getFechaPublicacion() {
		return fechaPublicacion;
	}

	void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	String getDescripcion() {
		return descripcion;
	}

	void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
