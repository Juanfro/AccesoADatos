package examen;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * <h1>Usando el fichero XML socios_gim.xml:</h1>
 * <ul>
 * <li>Recorre la secuencia de socios e imprime en pantalla aquellos con cuota
 * mayor a 100€.<br>
 * Utiliza lalibrería JAX-B</li>
 * <li>Implementa un patrón DAO con los métodos "get" y "getAll" para recuperar
 * socios.<br>
 * EL fichero socios_gim.xml tiene que estar cargado en existdb. <br>
 * Utilizar el API XQJ.<br>
 * Demuestra la funcionalidad del DAO realizando una aplicación que recupere
 * todos los empleados de la BD y que recupere los empleados con identificador
 * 10 y 15</li>
 * </ul>
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class MainExamen {

	Socios_gim socios_gim;
	String fichero = "socios_gim.xml";

	public static void main(String[] args) {
		MainExamen examen = new MainExamen();

		examen.leerSociosJAXB();
		examen.leerSociosEXIST();

	}

	/**
	 * Recorre la secuencia de socios e imprime en pantalla aquellos con cuota mayor
	 * a 100€.
	 */
	private void leerSociosJAXB() {

		System.out.println("\nLeer Socios con JAX-B\n");
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Socios_gim.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			socios_gim = (Socios_gim) unmarshaller.unmarshal(new File(fichero));

			// Lista de socios
			List<Socio> socios = socios_gim.getSocios();

			for (Socio socio : socios) {
				if (socio.getCuota_fija() > 100) {
					System.out.println(socio.toString());
				}
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void leerSociosEXIST() {

		SocioDao socioDao = new SocioDao();

		socioDao.get(10);// Recuperar socio con cod=10
		socioDao.get(15);// Recuperar socio con cod=15
		socioDao.getAll();

	}

}
