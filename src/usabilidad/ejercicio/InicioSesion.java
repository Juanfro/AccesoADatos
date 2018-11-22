package usabilidad.ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion {

	private JFrame ventanaInicioSesion;
	private JTextField textField;
	private JTextField textField_1;
	private JButton recuperar;
	private JButton conectarBoton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion window = new InicioSesion();
					window.ventanaInicioSesion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaInicioSesion = new JFrame();
		ventanaInicioSesion.setTitle("Inicio de Sesión");
		ventanaInicioSesion.setBounds(100, 100, 411, 228);
		ventanaInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 34, 0, 107, 49, 0 };
		gridBagLayout.rowHeights = new int[] { 36, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		ventanaInicioSesion.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		ventanaInicioSesion.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		ventanaInicioSesion.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		ventanaInicioSesion.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		ventanaInicioSesion.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		recuperar = new JButton("<html><u>Recuperar contraseña</u></html>");
		recuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pregunta pregunta = new Pregunta();
				pregunta.main(null);
				ventanaInicioSesion.dispose();
			}
		});
		recuperar.setForeground(Color.BLUE);
		recuperar.setContentAreaFilled(false);
		recuperar.setFocusPainted(false);
		recuperar.setBorderPainted(false);
		recuperar.setBorder(null);
		GridBagConstraints gbc_recuperar = new GridBagConstraints();
		gbc_recuperar.insets = new Insets(0, 0, 5, 5);
		gbc_recuperar.gridx = 2;
		gbc_recuperar.gridy = 3;
		ventanaInicioSesion.getContentPane().add(recuperar, gbc_recuperar);

		conectarBoton = new JButton("Conectar");
		conectarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplication aplication = new Aplication();
				aplication.main(null);
				ventanaInicioSesion.dispose();

			}
		});
		GridBagConstraints gbc_conectarBoton = new GridBagConstraints();
		gbc_conectarBoton.gridwidth = 2;
		gbc_conectarBoton.insets = new Insets(0, 0, 5, 5);
		gbc_conectarBoton.gridx = 1;
		gbc_conectarBoton.gridy = 4;
		ventanaInicioSesion.getContentPane().add(conectarBoton, gbc_conectarBoton);
	}

}
