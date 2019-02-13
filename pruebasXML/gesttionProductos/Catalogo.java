package gesttionProductos;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "catalogo")
@XmlType(propOrder = { "productos" })
class Catalogo {

	private List<Producto> productos;

	public Catalogo() {
	}

	@XmlElementWrapper(name = "productos")
	@XmlElement(name = "producto")
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
