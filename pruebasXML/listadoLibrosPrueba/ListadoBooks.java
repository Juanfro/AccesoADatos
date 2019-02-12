package listadoLibrosPrueba;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
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

public class ListadoBooks {

	String fichero = "files/bookstore.xml";
	String schemaName = "files/bookstore.xsd";
	String ficheroBinario = "files/libros.dat";

	Document document;

	public static void main(String[] args) {

		ListadoBooks listadoBooks = new ListadoBooks();

		// inicializar
		listadoBooks.init();

		listadoBooks.listado();

	}

	/**
	 * Inicializar document usando el fichero XML
	 */
	private void init() {

		System.out.println("Iniciando...");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(fichero); // Parsear el XML a un DOM Document
			document.getDocumentElement().normalize(); // Normalizar document
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Recorre y muestre en pantalla el contenido del fichero bookstore.xml con
	 * información sobre los libros de la biblioteca.
	 */
	private void listado() {
		System.out.println("\nListado de libros\n");

		System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());

		// Libros:

		NodeList nodes = document.getElementsByTagName("book");

		for (int i = 0; i < nodes.getLength(); i++) {
			Node nodeBook = nodes.item(i);
			System.out.println("\nLibro " + (i + 1));

			Element elementLibro = (Element) nodeBook;

			// id (atributo)
			System.out.println(elementLibro.getAttribute("id"));

			// Titulo
			System.out.println("Titulo: " + elementLibro.getElementsByTagName("title").item(0).getTextContent());

			// Autor/es
			NodeList autores = elementLibro.getElementsByTagName("author");
			for (int j = 0; j < autores.getLength(); j++) {
				String autor = autores.item(j).getTextContent();
				System.out.println("Autor: " + autor);
			}

			// Género
			NodeList genero = elementLibro.getElementsByTagName("genre");
			if (genero.getLength() > 0) {
				System.out.println("Género: " + genero.item(0).getTextContent());
			}

			// precio
			System.out.println("precio: " + elementLibro.getElementsByTagName("price").item(0).getTextContent());

			// Fecha
			NodeList fecha = elementLibro.getElementsByTagName("publish_date");
			if (fecha.getLength() > 0) {
				System.out.println("Fecha publicación: " + fecha.item(0).getTextContent());
			}

			// Descripción
			NodeList description = elementLibro.getElementsByTagName("description");
			if (description.getLength() > 0) {
				System.out.println("Descripción: " + description.item(0).getTextContent());
			}

		}

	}

}
