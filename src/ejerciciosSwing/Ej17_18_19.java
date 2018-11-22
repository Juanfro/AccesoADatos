package ejerciciosSwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ej17_18_19 extends JFrame {

	public Ej17_18_19() {
		setLayout(null);
	}

	static Ej17_18_19 miVentana = new Ej17_18_19();
	static JPanel miPanel = new JPanel();

	public static void main(String[] args) {
		miVentana.setTitle("Ejercicio 17");
		miVentana.setBounds(0, 0, 400, 600);
		miVentana.setLocationRelativeTo(null);
		miVentana.setBackground(Color.CYAN);

		miPanel.setLayout(new BoxLayout(miPanel, BoxLayout.PAGE_AXIS));
		miPanel.setBackground(Color.LIGHT_GRAY);
		miPanel.setBounds(50, 50, 200, 300);

		ejercicio17();

		miPanel.setVisible(true);
		miVentana.add(miPanel);
		

		// ejercicio18();

		ejercicio19();

		miVentana.setVisible(true);
	}

	/**
	 * 17. Realizar un programa que solicite el nombre de una persona y que permita
	 * un pa�s mediante el control JComboBox. Al presionar un bot�n, mostrar en la
	 * barra del t�tulo del JFrame el nombre y el pa�s seleccionado.
	 */
	static void ejercicio17() {
		JLabel labelNombre = new JLabel("Nombre:");
		miPanel.add(labelNombre);
		JTextField nombrePersona = new JTextField();
		nombrePersona.setBounds(5, 5, 200, 300);
		miPanel.add(nombrePersona);

		String paises[] = new String[] { "España", "Ejpaña", "Spain", "Jpain" };
		JComboBox<String> pais = new JComboBox<String>(paises);
		miPanel.add(pais);

		JButton miBoton = new JButton("Ej17");
		miBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreP = nombrePersona.getText();
				String nombrePais = (String) pais.getSelectedItem();

				miVentana.setTitle(nombreP + " " + nombrePais);
			}
		});
		miPanel.add(miBoton);
	}

	/**
	 * 18. Desarrollar un menú de opciones que contenga tres opciones que permita
	 * cambiar el color de fondo del JFrame a los colores: verde, verde y azul.
	 */
	static void ejercicio18() {
		JMenuBar miMenuBar;
		JMenu miMenu;
		JMenuItem rojo, verde, azul;

		miMenuBar = new JMenuBar();
		miVentana.setJMenuBar(miMenuBar);

		miMenu = new JMenu("Colores");
		miMenuBar.add(miMenu);

		rojo = new JMenuItem("rojo");
		verde = new JMenuItem("verde");
		azul = new JMenuItem("azul");

		ActionListener miEvento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == rojo) {
					miVentana.setBackground(Color.RED);
				}
				if (e.getSource() == verde) {
					miVentana.setBackground(Color.GREEN);
				}
				if (e.getSource() == azul) {
					miVentana.setBackground(Color.BLUE);
				}
			}
		};

		rojo.addActionListener(miEvento);
		verde.addActionListener(miEvento);
		azul.addActionListener(miEvento);

		miMenu.add(rojo);
		miMenu.add(verde);
		miMenu.add(azul);

		miVentana.add(miMenuBar);
	}

	/**
	 * Desarrollar un programa con un menú de opciones que contenga además del JMenu
	 * de la barra otros dos objetos de la clase JMenu que dependan del primero. Uno
	 * debe mostrar dos JMenuItem que permitan modificar el tamaño del JFrame y el
	 * segundo también debe mostrar dos JMenuItem que permitan cambiar el color de
	 * fondo.
	 */
	static void ejercicio19() {
		JMenuBar miMenuBar;
		JMenu colores, size;
		JMenuItem rojo, verde, azul, small, medium, large;

		miMenuBar = new JMenuBar();

		colores = new JMenu("Colores");
		size = new JMenu("Tamaño");
		miMenuBar.add(colores);
		miMenuBar.add(size);

		// Colores
		rojo = new JMenuItem("rojo");
		verde = new JMenuItem("verde");
		azul = new JMenuItem("azul");

		ActionListener cambiaColor = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rojo) {
					miVentana.setBackground(Color.RED);
				}
				if (e.getSource() == verde) {
					miVentana.setBackground(Color.GREEN);
				}
				if (e.getSource() == azul) {
					miVentana.setBackground(Color.BLUE);
				}
			}
		};

		rojo.addActionListener(cambiaColor);
		verde.addActionListener(cambiaColor);
		azul.addActionListener(cambiaColor);

		// Tamaño
		small = new JMenuItem("small");
		medium = new JMenuItem("medium");
		large = new JMenuItem("large");

		ActionListener cambiaSize = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == small) {
					miVentana.setBounds(0, 0, 200, 200);
				}
				if (e.getSource() == medium) {
					miVentana.setBounds(0, 0, 400, 400);
				}
				if (e.getSource() == large) {
					miVentana.setBounds(0, 0, 600, 600);
				}

				miVentana.setLocationRelativeTo(null);
			}
		};

		small.addActionListener(cambiaSize);
		medium.addActionListener(cambiaSize);
		large.addActionListener(cambiaSize);

		colores.add(rojo);
		colores.add(verde);
		colores.add(azul);

		size.add(small);
		size.add(medium);
		size.add(large);

		miVentana.setJMenuBar(miMenuBar);

		miVentana.add(miMenuBar);
	}

}
