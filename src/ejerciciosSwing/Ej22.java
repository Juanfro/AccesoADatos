package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Disponer un control JLabel que muestre el siguiente mensaje: "Esta de acuerdo
 * con las normas del servicio?", luego un JCheckBox y finalmente un objeto de
 * tipo JButton desactivo. Cuando se tilde el JCheckBox debemos activar el
 * botón.
 * 
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej22 extends JFrame {

	public Ej22() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Ejercicio 22");
	}

	static Ej22 miVentana = new Ej22();

	public static void main(String[] args) {
		JLabel miTexto = new JLabel("Estoy de acuerdo con las normas del servicio");
		miTexto.setBounds(20, 20, 300, 30);
		miTexto.setVisible(true);
		miVentana.add(miTexto);
		// Checkbox
		JCheckBox checkAccept = new JCheckBox("Acepto");
		checkAccept.setBounds(20, 60, 100, 30);

		checkAccept.setVisible(true);
		miVentana.add(checkAccept);

		// Boton

		JButton miBoton = new JButton("Continuar");
		miBoton.setBounds(20, 100, 100, 30);
		miBoton.setEnabled(false);
		miBoton.setVisible(true);
		miVentana.add(miBoton);

		checkAccept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (checkAccept.isSelected()) {
					miBoton.setEnabled(true);
				} else {
					miBoton.setEnabled(false);
				}

			}
		});

		miVentana.setVisible(true);
	}
}
