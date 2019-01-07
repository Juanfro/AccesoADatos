package listadoLibros;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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

	public static void main(String[] args) {

		String fichero = "bookstore.xml";

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(fichero);
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
				Element eTitulo = (Element) nNode;

				System.out.println("Titulo: " + eTitulo.getElementsByTagName("title").item(0).getTextContent());

			}

			System.out.println("FIN");

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

}
