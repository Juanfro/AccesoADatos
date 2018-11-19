package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BookListingJAXBActions {

	Catalog catalog;

	public BookListingJAXBActions() {

	}

	public void listCatalog() throws Exception{
		try {
			File file = new File("xml/bookstore.xml");
			JAXBContext jc = JAXBContext.newInstance(Catalog.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
			catalog = (Catalog) unmarshaller.unmarshal(file);
			
			catalog.getBooks().stream().foreac
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCatalogObj() {
		catalog = new Catalog();
		Book book1 = new Book();
		book1.setId("bk201");
		book1.setTitle("El quijote");
		book1.setGenre("Classics");
		book1.setPrice(30);
		book1.setPublishDate(new Date());
		book1.setAuthors(new ArrayList<String>(Arrays.asList("Miguel de Cervantes")));
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book1);
		catalog.setBooks(books);
		catalog.setYear(2018);
		catalog.setEditorial("Santillana");

	}

	public void showCatalogXML() {
		try {
			JAXBContext jc = JAXBContext.newInstance(Catalog.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(catalog, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
