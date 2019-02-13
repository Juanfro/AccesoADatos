package gesttionProductos;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "producto")
@XmlType(propOrder = { "codigo", "nombre", "categoria", "ofertas" })
class Producto {

	private int codigo;
	private String nombre;
	private String categoria;
	private List<String> ofertas;

	// Constructor vacío
	public Producto() {
	}

	// Setters & Getters

	// Codigo
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	// Nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Categoria
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	// Ofertas
	@XmlElementWrapper(name = "ofertas")
	@XmlElement(name = "oferta")
	public List<String> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<String> ofertas) {
		this.ofertas = ofertas;
	}

}
