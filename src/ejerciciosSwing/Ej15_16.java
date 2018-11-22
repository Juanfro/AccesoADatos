package ejerciciosSwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * Cargar en un JComboBox los nombres de varios colores. Al seleccionar alguno
 * mostrar en la barra de título del JFrame el String seleccionado.
 * 
 * @author Juan
 *
 */

@SuppressWarnings("serial")
public class Ej15_16 extends JFrame {

	public Ej15_16() {
		setLayout(null);
		setTitle("Ejercicio 15 y 16");
		setBounds(20, 20, 500, 800);
		setLocationRelativeTo(null);
	}

	static Ej15_16 miVentana = new Ej15_16();

	public static void main(String[] args) {
		ejercicio15();
		ejercicio16();

		miVentana.setVisible(true);

	}

	/**
	 * Cargar en un JComboBox los nombres de varios colores. Al seleccionar alguno
	 * mostrar en la barra de título del JFrame el String seleccionado.
	 */
	static void ejercicio15() {
		String opcionesColores[] = { "Rojo", "Verde", "Amarillo", "Azul" };
		JComboBox<String> colores = new JComboBox<String>(opcionesColores);
		colores.setBounds(20, 20, 200, 30);
		colores.setVisible(true);
		colores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String colorElegido = (String) colores.getSelectedItem();
				miVentana.setTitle(colorElegido);
			}
		});

		miVentana.add(colores);
	}

	/**
	 * Disponer tres controles de tipo JComboBox con valores entre 0 y 255 (cada uno
	 * representa la cantidad de rojo, verde y azul). Luego al presionar un botón
	 * pintar el mismo con el color que se genera combinando los valores de los
	 * JComboBox.
	 */
	static void ejercicio16() {

		String valoresErre[] = new String[256];
		for (int i = 0; i < valoresErre.length; i++) {
			valoresErre[i] = Integer.toString(i);
		}
		JComboBox<String> erre = new JComboBox<String>(valoresErre);
		erre.setBounds(20, 60, 200, 30);
		erre.setVisible(true);

		String valoresGe[] = new String[256];
		for (int i = 0; i < valoresErre.length; i++) {
			valoresGe[i] = Integer.toString(i);
		}
		JComboBox<String> ge = new JComboBox<String>(valoresErre);
		ge.setBounds(20, 100, 200, 30);
		ge.setVisible(true);

		String valoresBe[] = new String[256];
		for (int i = 0; i < valoresErre.length; i++) {
			valoresBe[i] = Integer.toString(i);
		}
		JComboBox<String> be = new JComboBox<String>(valoresErre);
		be.setBounds(20, 140, 200, 30);
		be.setVisible(true);

		// Boton

		JButton erregebe = new JButton("Cambiar Color");
		erregebe.setBounds(250, 180, 150, 30);
		erregebe.setVisible(true);
		erregebe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int r = Integer.parseInt((String) erre.getSelectedItem());
				int g = Integer.parseInt((String) ge.getSelectedItem());
				int b = Integer.parseInt((String) be.getSelectedItem());

				System.out.println("Rojo:" + r + " Verde: " + g + " Azul: " + b);

				erregebe.setBackground(new Color(r, g, b));
			}
		});

		// Extra
		ActionListener alVuelo = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int r = Integer.parseInt((String) erre.getSelectedItem());
				int g = Integer.parseInt((String) ge.getSelectedItem());
				int b = Integer.parseInt((String) be.getSelectedItem());

				erregebe.setBackground(new Color(r, g, b));
			}
		};

		erre.addActionListener(alVuelo);
		ge.addActionListener(alVuelo);
		be.addActionListener(alVuelo);

		miVentana.add(erregebe);
		miVentana.add(erre);
		miVentana.add(ge);
		miVentana.add(be);
	}

}
