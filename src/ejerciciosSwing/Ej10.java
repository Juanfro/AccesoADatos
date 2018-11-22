package ejerciciosSwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 10. Introducir el nombre de usuario y clave en controles de tipo JTextField.
 * Si se introducen las cadenas(usuario: juan, clave=abc123), mostrar en el
 * título del JFrame el mensaje "Correcto" en caso contrario, mostrar el mensaje
 * "Incorrecto".
 * 
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej10 extends JFrame {

	public Ej10() {
		setLayout(null);
	}

	static Ej10 miVentana = new Ej10();

	public static void main(String[] args) {
		miVentana.setTitle("Ejercicio10");
		miVentana.setBounds(20, 20, 500, 600);
		miVentana.setLocationRelativeTo(null);

		// miVentana.setVisible(true);

		chicha();
		miVentana.setVisible(true);

	}

	static void chicha() {
		JPanel miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel, BoxLayout.PAGE_AXIS));
		miPanel.setBounds(20, 20, 350, 450);
		miPanel.setBackground(Color.CYAN);

		JLabel lUsuario = new JLabel("Usuario:");
		lUsuario.setVisible(true);
		JTextField campoUsuario = new JTextField();
		JLabel lPwd = new JLabel("Contrase�a:");
		JPasswordField campoPwd = new JPasswordField();
		JButton bAcceso = new JButton("Acceder");

		bAcceso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String usuario = campoUsuario.getText();
				@SuppressWarnings("deprecation")
				String password = campoPwd.getText();
				if (usuario.equals("juan") && password.equals("abc123")) {
					dialogo(true);
					System.out.println("Pasa");
				} else {
					System.out.println("No pasa. Usuario introducido=" + usuario + " contrase�a empleada= " + password);
					dialogo(false);
				}
			}
		});

		miPanel.add(lUsuario);
		miPanel.add(campoUsuario);
		miPanel.add(lPwd);
		miPanel.add(campoPwd);
		miPanel.add(bAcceso);

		miPanel.setVisible(true);
		miVentana.add(miPanel);
	}

	static void dialogo(boolean pasaNopasa) {
		if (pasaNopasa == true) {
			// JOptionPane dialogoPasa = new JOptionPane();
			JOptionPane.showMessageDialog(miVentana, "Accediendo", "Acceso", JOptionPane.PLAIN_MESSAGE);
			System.out.println("Acceso pasa");
		} else {
			JOptionPane.showMessageDialog(miVentana, "Acceos denegado", "Acceso", JOptionPane.ERROR_MESSAGE);
			System.out.println("Acceso pasa");
		}

	}
}
