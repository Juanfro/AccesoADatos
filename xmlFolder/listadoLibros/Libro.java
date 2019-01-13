package listadoLibros;

import java.io.Serializable;
import java.time.LocalDate;

public class Libro implements Serializable {

	String id;
	String autor;
	String titulo;
	String genero;
	float precio;
	LocalDate fechaPublicacion;
	String descripcion;

	Libro(String id, String autor, String titulo, String genero, float precio, LocalDate fechaPublicacion,
			String descripcion) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.descripcion = descripcion;
	}

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

	float getPrecio() {
		return precio;
	}

	void setPrecio(float precio) {
		this.precio = precio;
	}

	LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	String getDescripcion() {
		return descripcion;
	}

	void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
