package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Permitir introducir dos números en controles de tipo JTextField y mediante
 * dos controles de tipo JRadioButton permitir seleccionar si queremos sumarlos
 * o restarlos. Al presionar un botón mostrar en el título del JFrame el
 * resultado de la operación.
 * 
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej25 extends JFrame {

	public Ej25() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Ejercicio 25");
	}

	static Ej25 miVentana = new Ej25();

	public static void main(String[] args) {
		JLabel labelN1 = new JLabel("Numero");
		labelN1.setBounds(20, 20, 100, 30);
		labelN1.setVisible(true);
		miVentana.add(labelN1);

		JLabel labelN2 = new JLabel("Otro Numero");
		labelN2.setBounds(20, 100, 100, 30);
		labelN2.setVisible(true);
		miVentana.add(labelN2);

		JTextField num1 = new JTextField();
		num1.setBounds(20, 60, 80, 30);
		num1.setVisible(true);
		miVentana.add(num1);

		JTextField num2 = new JTextField();
		num2.setBounds(20, 140, 80, 30);
		num2.setVisible(true);
		miVentana.add(num2);

		// Radiobuttons

		JRadioButton suma = new JRadioButton("Sumar");
		suma.setBounds(20, 180, 100, 30);
		suma.setVisible(true);
		suma.setSelected(true);
		miVentana.add(suma);

		JRadioButton resta = new JRadioButton("Restar");
		resta.setBounds(20, 220, 100, 30);
		resta.setVisible(true);
		miVentana.add(resta);

		ButtonGroup miGrupo = new ButtonGroup();
		miGrupo.add(suma);
		miGrupo.add(resta);

		// Boton
		JButton miBoton = new JButton("Abra Cadabra");
		miBoton.setBounds(20, 260, 150, 30);
		miBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int valNum1 = Integer.parseInt(num1.getText());
				int valNum2 = Integer.parseInt(num2.getText());
				int valSuma = valNum1+valNum2;
				int valResta = valNum1-valNum2;
				
				
				if(suma.isSelected()) {
					miVentana.setTitle(Integer.toString(valSuma));
				}else if(resta.isSelected()) {
					miVentana.setTitle(Integer.toString(valResta));
				}
			}
		});

		miBoton.setVisible(true);
		miVentana.add(miBoton);

		miVentana.setVisible(true);
	}

}
