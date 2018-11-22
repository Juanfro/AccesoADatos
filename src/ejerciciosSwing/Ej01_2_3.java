package ejerciciosSwing;

//import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;

/**
 * <ol>
 * <li>Confeccionar el programa "Hola Mundo" utilizando una interfaz gráfica de
 * usuario.</li>
 * <li>Crear una ventana. Luego no permitir que el operador modifique el tamaño
 * de la ventana.</li>
 * <li>Confeccionar una ventana que muestre el nombre de un programa en la parte
 * superior y su número de versión en la parte inferior. No permitir modificar
 * el tamaño de la ventana en tiempo de ejecución.</li>
 * 
 * </ol>
 * 
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej01_2_3 extends JFrame {

	/**
	 * Constructor por defecto con título, tamaño, posición y layout
	 */
	public Ej01_2_3() {
		setLayout(null);
		setTitle("Ejercicio 1");
		setBounds(20, 20, 500, 400);
		setLocationRelativeTo(null);
	}

	static Ej01_2_3 miVentana = new Ej01_2_3();

	public static void main(String[] args) {

		ejercicio1();
		ejercicio2();
		ejercicio3();

		miVentana.setVisible(true);
	}

	/**
	 * Confeccionar el programa "Hola Mundo" utilizando una interfaz gráfica de
	 * usuario.
	 */
	static void ejercicio1() {
		JLabel holaMundo = new JLabel("HolaMundo");
		holaMundo.setBounds(20, 20, 100, 30);
		holaMundo.setVisible(true);
		miVentana.add(holaMundo);
	}

	/**
	 * Crear una ventana. Luego no permitir que el operador modifique el tamaño de
	 * la ventana.
	 */
	static void ejercicio2() {
		miVentana.setResizable(false);
	}

	/**
	 * Confeccionar una ventana que muestre el nombre de un programa en la parte
	 * superior y su número de versión en la parte inferior. No permitir modificar
	 * el tamaño de la ventana en tiempo de ejecución.
	 */
	static void ejercicio3() {
		JLabel version = new JLabel("Versión 1.1");
		version.setBounds(20, 335, 100, 30);
		version.setSize(100, 30);
		version.setVisible(true);

		miVentana.add(version);
	}

}
