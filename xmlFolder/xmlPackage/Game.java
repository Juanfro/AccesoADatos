package xmlPackage;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.NameList;

public class Game {

	public static void main(String[] args) {
		Schema schema = null;

		try {
			String language = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language);
			schema = factory.newSchema(new File("xml/bookstore.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Get the DOM Builder Factory

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Get the dom builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);

			if (nNode) {

			}
		}
	}

}
