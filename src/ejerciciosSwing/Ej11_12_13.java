package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * <ol start ="11">
 * <li>Desarrollar un programa que permita introducir una dirección de mail en
 * un control de tipo JTextField y el cuerpo del mail en un control de tipo
 * JTextArea.</li>
 * <li>Desarrollar un programa que permita introducir una dirección de mail en
 * un control de tipo JTextField y el cuerpo del mail en un control de tipo
 * JTextArea.</li>
 * 
 * <li>Desarrollar un programa que permita introducir en un control de tipo
 * JTextArea una carta. Luego al presionar un botón mostrar un mensaje si la
 * carta contiene el String "argentina"</li>
 * </ol>
 * 
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej11_12_13 extends JFrame {

	public Ej11_12_13() {
		setLayout(null);
		setTitle("Ejercicio11 y 12");
		setBounds(20, 20, 500, 800);
		setLocationRelativeTo(null);
	}

	static Ej11_12_13 miVentana = new Ej11_12_13();

	public static void main(String[] args) {

		ejercicio11();
		// ejercicio14();
		// ejercicio15();
		// ejercicio16();

		miVentana.setVisible(true);
	}

	/**
	 * Desarrollar un programa que permita introducir una direcci�n de mail en un
	 * control de tipo JTextField y el cuerpo del mail en un control de tipo
	 * JTextArea.
	 */
	static void ejercicio11() {

		JLabel etCorreo = new JLabel("Correo Electrónico:");
		etCorreo.setBounds(20, 20, 200, 30);
		etCorreo.setVisible(true);

		JTextField campoCorreo = new JTextField();
		campoCorreo.setBounds(205, 20, 150, 30);
		campoCorreo.setVisible(true);

		JLabel etCuerpo = new JLabel("Contenido:");
		etCuerpo.setBounds(20, 60, 150, 30);
		etCuerpo.setVisible(true);

		JTextArea campoCuerpo = new JTextArea();

		JScrollPane scrollCuerpo = new JScrollPane(campoCuerpo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollCuerpo.setBounds(20, 100, 250, 200);

		scrollCuerpo.setVisible(true);

		miVentana.add(etCorreo);
		miVentana.add(campoCorreo);
		miVentana.add(etCuerpo);

		miVentana.add(scrollCuerpo);

		ejercicio13(campoCuerpo);

	}

	/**
	 * Desarrollar un programa que permita introducir en un control de tipo
	 * JTextArea una carta. Luego al presionar un botón mostrar un mensaje si la
	 * carta contiene el String "argentina".
	 * 
	 * @param cuerpoCorreo JTextArea en el que se busca la palabra
	 */
	static void ejercicio13(JTextArea cuerpoCorreo) {
		// Ej13
		JButton botonBuscar = new JButton("Buscar argentina");
		botonBuscar.setBounds(20, 305, 150, 30);
		botonBuscar.setVisible(true);
		botonBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String palabraBuscar = "argentina";
				String contenidoABuscar = cuerpoCorreo.getText().toLowerCase();
				int indice = contenidoABuscar.indexOf(palabraBuscar);

				if (indice != -1) {
					JOptionPane.showMessageDialog(miVentana, "Palabra Encontrada", "Se ha encontrado la palabra",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(miVentana, "Palabra No Encontrada", "No se ha encontrado la palabra",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		miVentana.add(botonBuscar);
	}

}
