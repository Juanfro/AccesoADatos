package usabilidad.ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class CambioPwd {

	private JFrame ventanaCambioPWD;
	private JTextField campoNewPWD;
	private JPasswordField campoConfirm;
	private JLabel alertNoMatch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambioPwd window = new CambioPwd();
					window.ventanaCambioPWD.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CambioPwd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaCambioPWD = new JFrame();
		ventanaCambioPWD.setBounds(100, 100, 343, 217);
		ventanaCambioPWD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		ventanaCambioPWD.getContentPane().setLayout(gridBagLayout);

		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña");
		GridBagConstraints gbc_lblNuevaContrasea = new GridBagConstraints();
		gbc_lblNuevaContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblNuevaContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaContrasea.gridx = 1;
		gbc_lblNuevaContrasea.gridy = 1;
		ventanaCambioPWD.getContentPane().add(lblNuevaContrasea, gbc_lblNuevaContrasea);

		campoNewPWD = new JTextField();
		GridBagConstraints gbc_campoNewPWD = new GridBagConstraints();
		gbc_campoNewPWD.insets = new Insets(0, 0, 5, 5);
		gbc_campoNewPWD.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNewPWD.gridx = 2;
		gbc_campoNewPWD.gridy = 1;
		ventanaCambioPWD.getContentPane().add(campoNewPWD, gbc_campoNewPWD);
		campoNewPWD.setColumns(10);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña");
		GridBagConstraints gbc_lblConfirmarContrasea = new GridBagConstraints();
		gbc_lblConfirmarContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmarContrasea.gridx = 1;
		gbc_lblConfirmarContrasea.gridy = 2;
		ventanaCambioPWD.getContentPane().add(lblConfirmarContrasea, gbc_lblConfirmarContrasea);

		campoConfirm = new JPasswordField();
		GridBagConstraints gbc_campoConfirm = new GridBagConstraints();
		gbc_campoConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_campoConfirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoConfirm.gridx = 2;
		gbc_campoConfirm.gridy = 2;
		ventanaCambioPWD.getContentPane().add(campoConfirm, gbc_campoConfirm);

		alertNoMatch = new JLabel("Las contraseñas no coinciden");
		alertNoMatch.setForeground(Color.RED);
		GridBagConstraints gbc_alertNoMatch = new GridBagConstraints();
		gbc_alertNoMatch.insets = new Insets(0, 0, 5, 5);
		gbc_alertNoMatch.gridx = 1;
		gbc_alertNoMatch.gridy = 3;
		ventanaCambioPWD.getContentPane().add(alertNoMatch, gbc_alertNoMatch);

		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioSesion.main(null);
				ventanaCambioPWD.dispose();
			}
		});
		GridBagConstraints gbc_btnCambiar = new GridBagConstraints();
		gbc_btnCambiar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCambiar.anchor = GridBagConstraints.SOUTH;
		gbc_btnCambiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiar.gridx = 2;
		gbc_btnCambiar.gridy = 3;
		ventanaCambioPWD.getContentPane().add(btnCambiar, gbc_btnCambiar);

		// Añadir listener

		campoNewPWD.addKeyListener(coinciden);
		campoConfirm.addKeyListener(coinciden);
	}

	// Listener para la alerta de coincidencia

	/*
	 * ActionListener coinciden = new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { String pwd =
	 * campoNewPWD.getText(); char[] confirmPwd = campoConfirm.getPassword(); String
	 * stringConfirmPwd = new String(confirmPwd);
	 * 
	 * if (pwd.equals(stringConfirmPwd)) { alertNoMatch.setVisible(false);
	 * System.out.println("Coinciden"); } else { System.out.println("No coinciden");
	 * }
	 * 
	 * } };
	 */

	KeyListener coinciden = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// System.out.println("Keytyped");
			// tecla();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// System.out.println("keyreleased");
			tecla();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// System.out.println("keypressed");
			// tecla();
		}
	};

	void tecla() {
		String pwd = campoNewPWD.getText();
		char[] confirmPwd = campoConfirm.getPassword();
		String stringConfirmPwd = new String(confirmPwd);

		if (pwd.equals(stringConfirmPwd)) {
			alertNoMatch.setVisible(false);
			System.out.println("Coinciden");
		} else {
			alertNoMatch.setVisible(true);
			System.out.println("No coinciden");
		}
	}

}
