package listadoLibrosJAXB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

class LecturaJAXB {

	Catalog catalog;
	List<Libro> listaLibros;

	public static void main(String[] args) {

		try {

			LecturaJAXB lecturaJAXB = new LecturaJAXB();
			JAXBContext context = JAXBContext.newInstance(Catalog.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			lecturaJAXB.catalog = (Catalog) unmarshaller.unmarshal(new File("files/bookstore.xml"));

			lecturaJAXB.listado();
			lecturaJAXB.escribirFichero();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	void listado() {

		Libro libroObjeto;
		listaLibros = new ArrayList<>();

		String id;
		// List<Author> authors;
		List<String> authors;
		String title;
		String genre;
		Float price;
		String publish_date;
		String description;

		int cont = 1;

		System.out.println("Editorial: " + catalog.getEditorial());
		System.out.println("Año: " + catalog.getYear());

		List<Libro> libros = catalog.getBooks();

		for (Libro libro : libros) {

			System.out.println("\nLibro " + cont);

			// id
			id = libro.getId();
			System.out.println("id: " + id);

			// Título
			title = libro.getTitle();
			System.out.println("Titulo: " + title);

			// Autores
			authors = libro.getAuthors();
			if (authors.size() > 1) {
				System.out.println("Autores:");
				/*
				 * for (Author author : authors) { System.out.println("\t" +
				 * author.getNombre()); }
				 */
				for (String author : authors) {
					System.out.println("\t" + author);
				}
			} else {
				/*
				 * for (Author author : authors) { System.out.println("Autor:" +
				 * author.getNombre()); }
				 */
				for (String author : authors) {
					System.out.println("Autor:" + author);
				}
			}

			// Género
			genre = libro.getGenre();
			if (genre != null) {
				System.out.println("Género:" + genre);
			}

			// Precio
			price = libro.getPrice();
			System.out.println("Precio: " + price);

			// Fecha de publicación
			publish_date = libro.getPublish_date();
			if (publish_date != null) {
				System.out.println("Fecha de publicación: " + publish_date);
			}

			// Descripción
			description = libro.getDescription();
			if (description != null) {
				System.out.println("Descripción: " + description);
			}

			libroObjeto = new Libro(id, authors, title, genre, price, publish_date, description);
			listaLibros.add(libroObjeto);

			cont++;

		}
	}

	void escribirFichero() {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/librosJAXB.dat"))) {
			for (Libro libro : listaLibros) {
				os.writeObject(libro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
