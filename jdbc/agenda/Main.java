package agenda;

/**
 * Aplicacion que permite realizar operaciones de inserción y consulta sobre los
 * registros de una agenda de contacttos almacenada en la base de datos.<br>
 * La tabla de contactos tiene los siguientes campos:
 * <ul>
 * <li>Cod_contacto -> Int(11)(Clave primaria)</li>
 * <li>Nombre -> Varchar(80)</li>
 * <li>Telefono -> BigInt</li>
 * <li>Email -> Varchar(50)</li>
 * </ul>
 * 
 * La apicacion debe permitir añadir registros a la tabla con datos
 * suministrados por el usuario. La Aplicación usará el patrón DAO co una unica
 * operación "save" <br>
 * Por otro lado la aplicación permitirá al usuario realizar las siguientes
 * consultas.<br>
 * <br>
 * 
 * <ul>
 * <li>Mostrar todos los datos de los contactos que tienen un nombre
 * concreto</li>
 * <li>Actualizar todos los telefonos de todos los contactos añadiendo un
 * prefijo que se pasa como parámetro al método. Dicha modificación debe
 * implementarse como una transaccion</li>
 * 
 * </ul>
 * 
 * @author Juan Antonio Rodriguez
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
