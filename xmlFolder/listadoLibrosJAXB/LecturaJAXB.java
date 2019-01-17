package listadoLibrosJAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

class LecturaJAXB {

	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(Catalog.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Catalog catalog = (Catalog) unmarshaller.unmarshal(new File("files/bookstore.xml"));
			
			System.out.println("Editorial:" + catalog.getEditorial().toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
	void 

}
