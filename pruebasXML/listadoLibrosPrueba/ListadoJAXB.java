package listadoLibrosPrueba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class ListadoJAXB {

	Catalog catalog;
	List<Book> listaLibros;

	public static void main(String[] args) {

		try {
			ListadoJAXB listadoJAXB = new ListadoJAXB();

			JAXBContext context = JAXBContext.newInstance(Catalog.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			listadoJAXB.catalog = (Catalog) unmarshaller.unmarshal(new File("files/bookstore.xml"));

			listadoJAXB.listado();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void listado() {
		Book libroObjeto;
		listaLibros = new ArrayList<>();

		String id;
		// List<Author> authors;
		List<String> autores;
		String titulo;
		String genero;
		Float precio;
		String fecha_publicacion;
		String descripcion;

		int contadorLibro = 1;

		System.out.println("Editorial: " + catalog.getEditorial());
		System.out.println("Año: " + catalog.getYear());

		List<Book> libros = catalog.getLibros();

		// Empieza el listado
		for (Book book : libros) {
			System.out.println("\nLibro " + contadorLibro);

			// id
			id = book.getId();
			System.out.println("id: " + id);

			// Autores
			autores = book.getAuthors();
			if (autores.size() > 1) {
				System.out.println("Autores:");
				/*
				 * for (Author author : authors) { System.out.println("\t" +
				 * author.getNombre()); }
				 */
				for (String author : autores) {
					System.out.println("\t" + author);
				}
			} else {
				/*
				 * for (Author author : authors) { System.out.println("Autor:" +
				 * author.getNombre()); }
				 */
				for (String author : autores) {
					System.out.println("Autor:" + author);
				}
			}

			// Género
			genero = book.getGenre();
			if (genero != null) {
				System.out.println("Género:" + genero);
			}

			// Precio
			precio = book.getPrice();
			System.out.println("Precio: " + precio);

			// Fecha de publicación
			fecha_publicacion = book.getPublish_date();
			if (fecha_publicacion != null) {
				System.out.println("Fecha de publicación: " + fecha_publicacion);
			}

			// Descripción
			descripcion = book.getDescription();
			if (descripcion != null) {
				System.out.println("Descripción: " + descripcion);
			}

		}

	}

}
