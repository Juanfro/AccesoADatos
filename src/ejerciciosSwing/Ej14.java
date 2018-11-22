package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Ej14 extends JFrame {
	
	public Ej14() {
		setLayout(null);
		setTitle("Ejercicio14");
		setBounds(20, 20, 500, 800);
		setLocationRelativeTo(null);
	}
	
	static Ej14 miVentana = new Ej14();

	public static void main(String[] args) {
		
		ejercicio14();

		
		miVentana.setVisible(true);
	}

	/**
	 * 14. Disponer dos controles de tipo JTextArea, luego al presionar un bot�n
	 * verificar si tienen exactamente el mismo contenido.
	 */
	static void ejercicio14() {
		JTextArea area1 = new JTextArea("Area1");
		area1.setBounds(20, 20, 200, 100);
		area1.setVisible(true);
		
		JTextArea area2 = new JTextArea("Area2");
		area2.setBounds(20, 150, 200, 100);
		area2.setVisible(true);		

		miVentana.add(area1);
		miVentana.add(area2);

		JButton botonSonIguales = new JButton("Comprobar igualdad");
		botonSonIguales.setBounds(20, 260, 200, 30);
		botonSonIguales.setVisible(true);
		botonSonIguales.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String texto1 = area1.getText();
				String texto2 = area2.getText();
				if (texto1.equals(texto2)) {
					JOptionPane.showMessageDialog(miVentana, "Son Iguales", "Igualdad", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(miVentana, "No son Iguales", "Igualdad", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		miVentana.add(botonSonIguales);
	}

}
