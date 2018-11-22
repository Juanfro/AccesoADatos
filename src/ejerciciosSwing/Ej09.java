package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Confeccionar un programa que permita introducir dos números en controles de
 * tipo JTextField, luego sumar los dos valores introducidos y mostrar la suma
 * en la barra del título del control JFrame.
 * 
 * @author Juan
 *
 */
@SuppressWarnings("serial")
public class Ej09 extends JFrame {

	public Ej09() {
		setLayout(null);
		setTitle("Ejercicio 9");
		setBounds(20, 20, 500, 400);
		setLocationRelativeTo(null);
	}

	static Ej09 miVentana = new Ej09();

	public static void main(String[] args) {

		ejercicio9();

		miVentana.setVisible(true);

	}

	static void ejercicio9() {

		JTextField num1 = new JTextField();
		JTextField num2 = new JTextField();
		JButton bSuma = new JButton("Sumar");

		num1.setBounds(20, 20, 100, 30);
		num2.setBounds(125, 20, 100, 30);
		bSuma.setBounds(20, 60, 100, 30);

		num1.setVisible(true);
		num2.setVisible(true);
		bSuma.setVisible(true);

		ActionListener sumar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == bSuma) {
					int res = Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());
					miVentana.setTitle(Integer.toString(res));
				}

			}
		};

		bSuma.addActionListener(sumar);

		miVentana.add(num1);
		miVentana.add(num2);
		miVentana.add(bSuma);

	}

}
