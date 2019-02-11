package listadoLibros;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * <h1>Listado de libros</h1>
 * 
 * <p>
 * Escribe un programa Java que recorra y muestre en pantalla el contenido del
 * fichero bookstore.xml con información sobre los libros de la biblioteca.
 * </p>
 * <ul>
 * <li>Utiliza la librería de “parsing” Java DOM for XML</li>
 * <li>Manejo de excepciones</li>
 * </ul>
 * <ol>
 * <li>Extiende la funcionalidad para que la aplicación compruebe que el fichero
 * XML utilizado para leer los datos está bien formado utilizando un “XML
 * schema”, bookstore.xsd</li>
 * <li>Extiende la funcionalidad para que la aplicación utilice la información
 * de los libros (Books) en XML para crear objetos de la clase Book y
 * escribirlos en un fichero binario.</li>
 * <li>Realiza la funcionalidad de la sección anterior utilizando la librería
 * JAXB</li>
 * </ol>
 *
 * 
 * @author Juan Antonio Rodríguez
 *
 */
class ListadoLibros {

	String fichero = "files/bookstore.xml";
	String schemaName = "files/bookstore.xsd";
	String ficheroBinario = "files/libros.dat";

	Document document;

	public static void main(String[] args) {

		ListadoLibros listadoLibros = new ListadoLibros();

		// Inicializar
		listadoLibros.init();

		// Listado de libros
		listadoLibros.listado();

		// Validación
		try {
			try {
				listadoLibros.validation();
				System.out.println("Valida");
			} catch (SAXException | IOException e) {
				System.out.println("Error");
				System.out.println("No valida");
				e.printStackTrace();
			}

		} catch (IllegalArgumentException e) {
			System.out.println("No valida - IllegalArgumentException");
		}

		listadoLibros.crearLibros();

	}

	void init() {

		System.out.println("Inicializando\n\n");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(fichero);
			document.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void listado() {

		System.out.println("\nLISTADO DE LIBROS\n");

		System.out.print("Elemento raiz: ");

		// Elemento de raiz
		System.out.println(document.getDocumentElement().getNodeName() + "\n");

		// LISTA de LIBROS

		NodeList nodes = document.getElementsByTagName("book");

		for (int i = 0; i < nodes.getLength(); i++) {
			Node nNode = nodes.item(i);
			System.out.println("LIBRO " + (i + 1));

			// System.out.println(nNode.getNodeName());
			Element elementLibro = (Element) nNode;

			// ID
			NamedNodeMap atributos = nNode.getAttributes();

			System.out.println("ID: " + atributos.item(0).getTextContent());

			System.out.println("Titulo: " + elementLibro.getElementsByTagName("title").item(0).getTextContent());

			System.out.println("Autor: " + elementLibro.getElementsByTagName("author").item(0).getTextContent());

			NodeList genero = elementLibro.getElementsByTagName("genre");
			if (genero.getLength() > 0) {
				System.out.println("Género: " + elementLibro.getElementsByTagName("genre").item(0).getTextContent());
			}

			System.out.println("Precio: " + elementLibro.getElementsByTagName("price").item(0).getTextContent());

			NodeList fecha = elementLibro.getElementsByTagName("publish_date");
			if (fecha.getLength() > 0) {
				System.out.println("Fecha publicación: " + fecha.item(0).getTextContent());
			}

			NodeList description = elementLibro.getElementsByTagName("description");
			if (description.getLength() > 0) {
				System.out.println("Descripción: " + description.item(0).getTextContent());
			}

			System.out.println();

		}
	}

	void validation() throws IllegalArgumentException, SAXException, IOException {
		Schema schema = null;

		try {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language);
			schema = factory.newSchema(new File(schemaName));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Validator validator = schema.newValidator();

		validator.validate(new DOMSource(document));

	}

	/**
	 * Utiliza la información de los libros (Books) en XML para crear objetos de la
	 * clase Book y escribirlos en un fichero binario
	 */
	void crearLibros() {

		String id = null;
		String autor = null;
		String titulo;
		String genero;
		float precio;
		LocalDate fechaPublicacion;
		String descripcion;

		Libro unLibro;

		List<Libro> libros = new ArrayList<Libro>();

		System.out.println("\nEscribir datos en el fichero \"libros.dat\"");

		NodeList nodes = document.getElementsByTagName("book");

		for (int i = 0; i < nodes.getLength(); i++) {
			Node nNode = nodes.item(i);
			System.out.println("Leyendo libro" + (i + 1));
			Element elementoLibro = (Element) nNode;

			NamedNodeMap atributos = nNode.getAttributes();

			if (atributos.getLength() > 0) {
				id = atributos.getNamedItem("id").getTextContent();
			}
			// id = atributos.item(0).getTextContent();

			NodeList nodoAutor = elementoLibro.getElementsByTagName("Autor");
			if (nodoAutor.getLength() > 0) {
				autor = nodoAutor.item(0).getTextContent();
			} // autor =
				// elementoLibro.getElementsByTagName("author").item(0).getTextContent();

			NodeList nodoTitulo = elementoLibro.getElementsByTagName("title");
			titulo = (nodoTitulo.getLength() > 0) ? nodoTitulo.item(0).getTextContent() : null;
			// titulo =
			// elementoLibro.getElementsByTagName("titulo").item(0).getTextContent();

			NodeList nodoGenero = elementoLibro.getElementsByTagName("genre");
			genero = (nodoGenero.getLength() > 0) ? nodoGenero.item(0).getTextContent() : null;
			// genero =
			// elementoLibro.getElementsByTagName("genre").item(0).getTextContent();

			NodeList nodoPrecio = elementoLibro.getElementsByTagName("price");
			precio = (nodoPrecio.getLength() > 0) ? Float.parseFloat(nodoPrecio.item(0).getTextContent()) : null;
			// precio =
			// Float.parseFloat(elementoLibro.getElementsByTagName("price").item(0).getTextContent());

			NodeList nodoFechaPublicacion = elementoLibro.getElementsByTagName("publish_date");
			fechaPublicacion = (nodoFechaPublicacion.getLength() > 0)
					? LocalDate.parse(nodoFechaPublicacion.item(0).getTextContent())
					: null;

			// fechaPublicacion =
			// LocalDate.parse(elementoLibro.getElementsByTagName("publish_date").item(0).getTextContent());

			NodeList nodoDescripcion = elementoLibro.getElementsByTagName("description");
			descripcion = (nodoDescripcion.getLength() > 0) ? nodoDescripcion.item(0).getTextContent() : null;
			// descripcion =
			// elementoLibro.getElementsByTagName("description").item(0).getTextContent();

			unLibro = new Libro(id, autor, titulo, genero, precio, fechaPublicacion, descripcion);

			libros.add(unLibro);

			System.out.println("Objeto Libro " + (i + 1) + " creado");

		}

		escribirFichero(libros);

	}

	void escribirFichero(List<Libro> listaLibros) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroBinario))) {
			for (Libro libro : listaLibros) {
				os.writeObject(libro);
			}
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
