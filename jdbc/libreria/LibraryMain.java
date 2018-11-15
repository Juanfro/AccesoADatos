package libreria;

/**
 * <h1>GESTIÓN DE UNA librería</h1>
 * <p>
 * Se trata de escribir un programa Java que ofrezca una serie de
 * funcionalidades necesarias para la gestión de una librería. Los datos
 * relevantes de la librería están almacenados en la base de datos libros.
 * Asegúrate que creas la base de datos suministrada en tu SGBD MySQL local.
 * </p>
 * <p>
 * El programa ofrecerá las siguientes posibilidades:
 * </p>
 * 
 * <ol>
 * <li>
 * <p>
 * Ver catálogo inverso: Este método muestra el catálogo de libros en orden
 * inverso al alfabético. Debes utilizar la siguiente consulta:
 * </p>
 * <p>
 * private static final String SELECT_BOOKS_QUERY = "select * from books order
 * by title asc"; *
 * </p>
 * 
 * <p>
 * Resuélvelo utilizando un tipo adecuado de Resultset.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * Actualiza número de copias: Este método recibe un Hashmap que contiene el
 * nuevo número de copias para cada isbn. Este nuevo número de copias se lo
 * tienes que sumar al actual. Resuélvelo creando una sentencia preparada a
 * partir de la consulta del apartado anterior utilizando el tipo de ResultSet
 * adecuado.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * Rellena precio: Este método recibe un float indicando el precio por página de
 * cada libro. Este método debe consultar las páginas de cada libro, multiplicar
 * por el precio por página y rellenar la columna precio de cada libro.
 * Resuélvelo creando una sentencia preparada a partir de la consulta del
 * apartado anterior utilizando el tipo de ResultSet adecuado.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * Recupera los campos de la tabla de libros. Este método muestra la lista de
 * atributos de la tabla libros de la base de datos. Utiliza la clase
 * DataBaseMetadata para consultar los campos de una tabla de la base de datos.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * Aplica descuento: Este método recibe un valor que representa un porcentaje de
 * descuento y se lo aplica a todos los precios de la BBDD. Todas las
 * operaciones de actualización de precio de los libros tienen que ser una
 * transaccón
 * </p>
 * </li>
 * 
 * </ol>
 * 
 * <ul>
 * <li>Configura el uso del driver MySQL</li>
 * <li>Programa el singleton de conexión a la BBDD (Clase DriverManager y
 * Connection)</li>
 * <li>Utiliza la librería java.sql (Clases PreparedStatement, ResultSet,
 * ResultSetMetadata, SQLException, Statement, DataBaseMetadata)</li>
 * <li>Uso de Transacciones BBDD</li>
 * </ul>
 * 
 * @author Juan Antonio
 *
 */
public class LibraryMain {

	public static void main(String[] args) {

	}

}
