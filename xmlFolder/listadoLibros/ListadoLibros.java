package listadoLibros;

import java.io.File;
import java.io.IOException;

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

	String fichero = "bookstore.xml";
	String schemaName = "bookstore.xsd";

	Document document;

	public static void main(String[] args) {

		ListadoLibros listadoLibros = new ListadoLibros();

		listadoLibros.listado();
		try {
			try {
				listadoLibros.validation();
				System.out.println("Valida");
			} catch (SAXException | IOException e) {
				System.out.println("Error");
				System.out.println("No valida");
				//e.printStackTrace();
			}

		} catch (IllegalArgumentException e) {
			System.out.println("No valida - IllegalArgumentException");
		}

	}

	void listado() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			document = builder.parse(fichero);
			document.getDocumentElement().normalize();

			// Element rootElement = document.getDocumentElement();

			// NodeList nodes = rootElement.getChildNodes();

			System.out.print("Elemento raiz: ");

			System.out.println(document.getDocumentElement().getNodeName());

			// LISTA de LIBROS

			NodeList nodes = document.getElementsByTagName("book");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node nNode = nodes.item(i);
				System.out.println("LIBRO " + (i + 1));
				// System.out.println(nNode.getNodeName());
				Element elementLibro = (Element) nNode;

				System.out.println("Titulo: " + elementLibro.getElementsByTagName("title").item(0).getTextContent());

				System.out.println("Autor: " + elementLibro.getElementsByTagName("author").item(0).getTextContent());

				NodeList genero = elementLibro.getElementsByTagName("genre");
				if (genero.getLength() > 0) {
					System.out
							.println("Género: " + elementLibro.getElementsByTagName("genre").item(0).getTextContent());
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

			// System.out.println("FIN");

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
