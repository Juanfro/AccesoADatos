package miVentana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Crear Ventana con. Tres botones.
 * 
 * Cada uno da un saludo diferente en la etiqueta
 */

@SuppressWarnings("serial")
public class Botones extends JFrame {

	public Botones() {
		setLayout(null);
	}

	static JButton bmorning;
	static JButton bafternoon;
	static JButton bnight;

	public static void main(String[] args) {

		/*
		 * Botones miVentana = new Botones();
		 * 
		 * miVentana.setBounds(20, 20, 400, 500); miVentana.setVisible(true);
		 * miVentana.setLocationRelativeTo(null);
		 * 
		 * // BOTONES bmorning = new JButton("Mañana"); bmorning.setBounds(50, 50, 100,
		 * 30); bafternoon = new JButton("Tarde"); bafternoon.setBounds(50, 100, 100,
		 * 30); bnight = new JButton("Noche"); bnight.setBounds(50, 150, 100, 30);
		 * 
		 * // JPanel miPanel = new JPanel(); miVentana.add(bmorning);
		 * miVentana.add(bafternoon); miVentana.add(bnight);
		 */

		addButtons();

	}

	public static void addButtons() {
		JFrame ventanaBotones = new JFrame("Ejemplo Botones");
		ventanaBotones.setVisible(true);
		ventanaBotones.setBounds(100, 100, 400, 500);
		ventanaBotones.setLayout(null);

		/*
		 * JPanel miPanel = new JPanel(); miPanel.setLayout(null);
		 * miPanel.setVisible(true);
		 */

		// BOTONES
		bmorning = new JButton("Mañana");
		bmorning.setBounds(50, 50, 100, 30);
		bafternoon = new JButton("Tarde");
		bafternoon.setBounds(50, 100, 100, 30);
		bnight = new JButton("Noche");
		bnight.setBounds(50, 150, 100, 30);
		// AÑADIR BOTONES
		ventanaBotones.add(bmorning);
		ventanaBotones.add(bafternoon);
		ventanaBotones.add(bnight);

		// Etiqueta
		JLabel etiqueta = new JLabel("Texto Aquí");
		etiqueta.setBounds(50, 200, 100, 30);

		etiqueta.setVisible(true);
		ventanaBotones.add(etiqueta);

		// Eventos de los botones

		bmorning.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				etiqueta.setText("Buenos días");
			}
		});

		bafternoon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				etiqueta.setText("Buenas Tardes");
			}
		});

		bnight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				etiqueta.setText("Buenas noches");
			}
		});
	}

}
