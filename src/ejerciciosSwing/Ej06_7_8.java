package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * <ol start="6">
 * <li>Confeccionar una ventana que contenga tres objetos de la clase JButton
 * con las etiquetas "1", "2" y "3". Al presionarse cambiar el título del JFrame
 * indicando cuál botón se presionó.</li>
 * 
 * <li>Disponer dos objetos de la clase JButton con las etiquetas: "varón" y
 * "mujer", al presionarse mostrar en la barra de t�tulos del JFrame la etiqueta
 * del botón presionado.</li>
 * <li>Confeccionar un programa que permita ingresar el nombre de usuario y
 * cuando se presione un botón mostrar el valor ingresado en la barra de t�tulos
 * del JFrame.</li>
 * </ol>
 * 
 * @author Juan
 *
 */
@SuppressWarnings("serial")
public class Ej06_7_8 extends JFrame {

	/**
	 * Constructor por defecto con título, tamaño, posición y layout
	 */
	public Ej06_7_8() {
		setLayout(null);
		setTitle("Ejercicio 6, 7 y 8");
		setBounds(20, 20, 500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	static Ej06_7_8 miVentana = new Ej06_7_8();

	public static void main(String[] args) {

		ejercicio6_7_8();

		miVentana.setVisible(true);

	}

	/**
	 * Confeccionar una ventana que contenga tres objetos de la clase JButton con
	 * las etiquetas "1", "2" y "3". Al presionarse cambiar el título del JFrame
	 * indicando cuál botón se presionó
	 */
	static void ejercicio6_7_8() {
		// Botones ej6
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");

		b1.setBounds(20, 20, 50, 30);
		b2.setBounds(75, 20, 50, 30);
		b3.setBounds(130, 20, 50, 30);

		b1.setVisible(true);
		b2.setVisible(true);
		b3.setVisible(true);

		// Botones ej7
		JButton bHombre = new JButton("Hombre");
		JButton bMujer = new JButton("Mujer");

		bHombre.setBounds(20, 60, 100, 30);
		bMujer.setBounds(125, 60, 100, 30);

		bHombre.setVisible(true);
		bMujer.setVisible(true);

		// Ejercicio8
		JLabel nombre = new JLabel("Nombre:");
		JTextField campoNombre = new JTextField();
		JButton aceptaNombre = new JButton("Aceptar");
		
		nombre.setBounds(20, 100, 100, 30);
		campoNombre.setBounds(105, 100, 100, 30);
		aceptaNombre.setBounds(210, 100, 100, 30);
		
		nombre.setVisible(true);
		campoNombre.setVisible(true);
		aceptaNombre.setVisible(true);
		
		
		

		// Añadir a la ventana

		miVentana.add(b1);
		miVentana.add(b2);
		miVentana.add(b3);
		miVentana.add(bHombre);
		miVentana.add(bMujer);
		miVentana.add(nombre);
		miVentana.add(campoNombre);
		miVentana.add(aceptaNombre);

		ActionListener eventoBoton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b1) {
					miVentana.setTitle("Boton 1");
				}
				if (e.getSource() == b2) {
					miVentana.setTitle("Boton 2");
				}
				if (e.getSource() == b3) {
					miVentana.setTitle("Boton 3");
				}
				if (e.getSource() == bHombre) {
					miVentana.setTitle(bHombre.getText());
				}
				if (e.getSource() == bMujer) {
					miVentana.setTitle(bMujer.getText());
				}
				if (e.getSource() == aceptaNombre) {
					miVentana.setTitle(campoNombre.getText());
				}

			}
		};
		
		//Añadir evento a los botones
		
		b1.addActionListener(eventoBoton);
		b2.addActionListener(eventoBoton);
		b3.addActionListener(eventoBoton);
		bHombre.addActionListener(eventoBoton);
		bMujer.addActionListener(eventoBoton);
		aceptaNombre.addActionListener(eventoBoton);
	}

}
