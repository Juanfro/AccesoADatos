package ejerciciosSwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * 
 * <ol start="4">
 * <li>Crear tres objetos de la clase JLabel, ubicarlos uno debajo de otro y
 * mostrar nombres de colores.</li>
 * <li>Desarrollar una ventana que muestre un botón. Cuando se presione
 * finalizar la ejecución del programa Java.</li>
 * </ol>
 */
@SuppressWarnings("serial")
public class Ej04_5 extends JFrame {

	/**
	 * Constructor por defecto con título, tamaño, posición y layout
	 */
	public Ej04_5() {
		setLayout(null);
		setTitle("Ejercicios 4 y 5");
		setBounds(20, 20, 500, 400);
		setLocationRelativeTo(null);
	}

	static Ej04_5 miVentana = new Ej04_5();

	public static void main(String[] args) {

		ejercicio4();
		ejercicio5();

		miVentana.setVisible(true);
		miVentana.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Crear tres objetos de la clase JLabel, ubicarlos uno debajo de otro y mostrar
	 * nombres de colores.
	 */
	public static void ejercicio4() {

		// Etiquetas
		JLabel rojo = new JLabel("Rojo");
		rojo.setBounds(20, 20, 100, 30);
		rojo.setForeground(Color.red);
		rojo.setVisible(true);
		miVentana.add(rojo);

		JLabel verde = new JLabel("Verde");
		verde.setBounds(20, 60, 100, 30);
		verde.setForeground(Color.green);
		verde.setVisible(true);
		miVentana.add(verde);

		JLabel azul = new JLabel("Azul");
		azul.setBounds(20, 100, 100, 30);
		azul.setForeground(Color.blue);
		azul.setVisible(true);
		miVentana.add(azul);

	}

	/**
	 * Confeccionar una ventana que muestre un botón. Cuando se presione finalizar
	 * la ejecución del programa Java.
	 */
	public static void ejercicio5() {
		// Añadir botón
		JButton botCierre = new JButton("Cerrar");
		botCierre.setBounds(20, 140, 100, 30);
		botCierre.setVisible(true);
		miVentana.add(botCierre);
		// Evento de cierre
		botCierre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miVentana.dispose();//Cierra la ventana
				//System.exit(0);// Cierra el programa
			}
		});

	}

	/**
	 * 6. Confeccionar una ventana que contenga tres objetos de la clase JButton con
	 * las etiquetas "1", "2" y "3". Al presionarse cambiar el t�tulo del JFrame
	 * indicando cu�l bot�n se presion�. <br>
	 * 7. Disponer dos objetos de la clase JButton con las etiquetas: "var�n" y
	 * "mujer", al presionarse mostrar en la barra de t�tulos del JFrame la etiqueta
	 * del bot�n presionado.<br>
	 * 8. Confeccionar un programa que permita ingresar el nombre de usuario y
	 * cuando se presione un bot�n mostrar el valor ingresado en la barra de t�tulos
	 * del JFrame. <br>
	 * 9. Confeccionar un programa que permita introducir dos n�meros en controles
	 * de tipo JTextField, luego sumar los dos valores introducidos y mostrar la
	 * suma en la barra del t�tulo del control JFrame.
	 * 
	 * @param otroPanel Panel de origen
	 */
	public static void tresBotones(JPanel otroPanel) {
		// Botones
		JButton b1 = new JButton("Bot�n 1");
		JButton b2 = new JButton("Bot�n 1");
		JButton b3 = new JButton("Bot�n 1");
		JButton bHombre = new JButton("Hombre");
		JButton bMujer = new JButton("Mujer");
		JLabel nombre = new JLabel("Nombre:");
		JTextField campoNombre = new JTextField();
		JButton aceptaNombre = new JButton("Aceptar");
		

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

		b1.addActionListener(eventoBoton);
		b2.addActionListener(eventoBoton);
		b3.addActionListener(eventoBoton);
		bHombre.addActionListener(eventoBoton);
		bMujer.addActionListener(eventoBoton);
		aceptaNombre.addActionListener(eventoBoton);

		otroPanel.add(b1);
		otroPanel.add(b2);
		otroPanel.add(b3);
		otroPanel.add(new JSeparator());
		otroPanel.add(bHombre);
		otroPanel.add(bMujer);
		otroPanel.add(new JSeparator());
		otroPanel.add(nombre);
		otroPanel.add(campoNombre);
		otroPanel.add(aceptaNombre);
		otroPanel.add(new JSeparator());


	}

}
