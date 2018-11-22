package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 * Desarrollar un programa que muestre 3 objetos de la clase JRadioButton que
 * permitan configurar el ancho y alto del JFrame.
 * 
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej24 extends JFrame {

	public Ej24() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Ejercicio 24");
	}

	static Ej24 miVentana = new Ej24();

	public static void main(String[] args) {
		JRadioButton small = new JRadioButton("640*480");
		small.setBounds(20, 20, 100, 30);
		small.setVisible(true);
		miVentana.add(small);

		JRadioButton medium = new JRadioButton("800*600");
		medium.setBounds(20, 60, 100, 30);
		medium.setVisible(true);
		miVentana.add(medium);

		JRadioButton large = new JRadioButton("1024*768");
		large.setBounds(20, 100, 100, 30);
		large.setVisible(true);
		miVentana.add(large);

		ButtonGroup miGrupo = new ButtonGroup();
		miGrupo.add(small);
		miGrupo.add(medium);
		miGrupo.add(large);

		ActionListener cambioTamaño = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == small) {
					miVentana.setSize(640, 480);
				}

				if (e.getSource() == medium) {
					miVentana.setSize(800, 600);
				}

				if (e.getSource() == large) {
					miVentana.setSize(1024, 768);
				}

				miVentana.setLocationRelativeTo(null);
			}
		};

		small.addActionListener(cambioTamaño);
		medium.addActionListener(cambioTamaño);
		large.addActionListener(cambioTamaño);

		miVentana.setVisible(true);
	}

}
