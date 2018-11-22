package miVentana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Input de texto.<br>
 * Botón que la pulsar ponga el texto en un label o en otra ventana.
 * 
 * Dos campos de texto con numeros. SUmarlos al pulsar un boton.
 * 
 * @author alumno
 *
 */

@SuppressWarnings("serial")
public class EnviarTexto extends JFrame {

	static EnviarTexto miVentana = new EnviarTexto();

	public EnviarTexto() {
		setLayout(null);
	}

	public static void main(String[] args) {
		addStuff();
		sumaNum();
	}

	public static void addStuff() {

		miVentana.setBounds(100, 100, 500, 500);
		miVentana.setLocationRelativeTo(null);

		// Text Input
		JTextField miTexto = new JTextField();

		miTexto.setBounds(20, 20, 50, 30);
		miTexto.setSize(100, 50);
		miTexto.setText("Default");

		// Añadir a la ventana
		miVentana.add(miTexto);

		// Etiqueta
		JLabel miEtiqueta = new JLabel("No hay texto");
		miEtiqueta.setBounds(20, 100, 400, 30);
		// miEtiqueta.setText("Lorem imsum tal y cual y pascual");
		// Añadir a la ventana
		miVentana.add(miEtiqueta);

		// Botón
		JButton miBoton = new JButton("ZASCA");
		miBoton.setBounds(20, 150, 100, 30);
		miVentana.add(miBoton);
		// Evento

		miBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miEtiqueta.setText(miTexto.getText());
			}
		});

		// Hacer Visible
		miTexto.setVisible(true);
		miVentana.setVisible(true);
		miEtiqueta.setVisible(true);
		miBoton.setVisible(true);
	}

	public static void sumaNum() {
		// Inputs
		JTextField num1 = new JTextField();
		num1.setBounds(20, 200, 100, 30);
		miVentana.add(num1);

		JTextField num2 = new JTextField();
		num2.setBounds(20, 250, 100, 30);
		miVentana.add(num2);

		// Resultado
		JLabel resultado = new JLabel("Suma dos números");
		resultado.setBounds(20, 300, 200, 30);
		miVentana.add(resultado);

		// Botón
		JButton butonSuma = new JButton("SUMA");
		butonSuma.setBounds(20, 350, 100, 30);
		miVentana.add(butonSuma);
		// Evento
		butonSuma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(num1.getText());
				int n2 = Integer.parseInt(num2.getText());
				int res = n1 + n2;
				resultado.setText(Integer.toString(res));
			}
		});

		num1.setVisible(true);
		num2.setVisible(true);
		resultado.setVisible(true);
		butonSuma.setVisible(true);
	}

}
