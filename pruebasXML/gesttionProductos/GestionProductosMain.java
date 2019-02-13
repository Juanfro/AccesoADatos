package gesttionProductos;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Escribe una aplicación que utilice el fichero XML productos.xml para
 * implementar la funcionalidad siguiente:
 * <ul>
 * <li>Recorra la secuencia de productos y los imprima en una consola. Utiliza
 * la librería JAX-B para realizar esta funcionalidad</li>
 * <li>Utiliza en la librería de conexión XQJ para recuperar y mostrar en
 * pantalla el listado de productos con un precio mayor o igual a 100. para
 * realizar esta aplicación debes haber cargado el fichero productos.xml en la
 * base de datos existdb</li>
 * </ul>
 * 
 * @author Juan Antonio Rodríguez
 *
 */
class GestionProductosMain {

	Catalogo catalogo;

	String fichero = "productos.xml";

	public static void main(String[] args) {
		GestionProductosMain gestion = new GestionProductosMain();
		gestion.leerXML();

	}

	void leerXML() {

		int codigo;
		String nombre;
		String categoria;
		List<String> ofertas;

		try {
			JAXBContext context = JAXBContext.newInstance(Catalogo.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			catalogo = (Catalogo) unmarshaller.unmarshal(new File(fichero));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		List<Producto> productos = catalogo.getProductos();
		int cont = 1;
		for (Producto producto : productos) {
			System.out.println("\nproducto " + cont);

			// Codigo
			codigo = producto.getCodigo();
			System.out.println("Codigo: " + codigo);
			// Nombre
			nombre = producto.getNombre();
			System.out.println("Nombre: " + nombre);

			// Categoria
			categoria = producto.getCategoria();
			System.out.println("Categoria: " + categoria);

			// Ofertas
			ofertas = producto.getOfertas();

			if ( ofertas != null && ofertas.size() > 1 ) {
				System.out.println("Ofertas: ");
				for (String oferta : ofertas) {
					System.out.println("\t" + oferta);
				}
			} else if ( ofertas != null && ofertas.size() > 0 ) {
				for (String oferta : ofertas) {
					System.out.println("\t" + oferta);
				}
			}

		}

	}

}
