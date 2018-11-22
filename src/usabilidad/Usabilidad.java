package usabilidad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class Usabilidad {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usabilidad window = new Usabilidad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Usabilidad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 11, 166, 95);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(0, 3, 70, 14);
		panel_1.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(0, 28, 70, 14);
		panel_1.add(lblApellidos);
		lblApellidos.setVerticalAlignment(SwingConstants.TOP);
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(0, 53, 70, 14);
		panel_1.add(lblEmail);
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(0, 78, 70, 14);
		panel_1.add(lblTelefono);
		lblTelefono.setVerticalAlignment(SwingConstants.TOP);
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField = new JTextField();
		textField.setBounds(60, 0, 106, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(60, 25, 106, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(60, 50, 106, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(60, 75, 106, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(206, 11, 2, 201);
		frame.getContentPane().add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(214, 11, 210, 123);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Intereses");
		lblNewLabel_1.setBounds(4, 0, 122, 14);
		panel_2.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Deportes");
		chckbxNewCheckBox.setBounds(0, 33, 97, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxFormacin = new JCheckBox("Formación");
		chckbxFormacin.setBounds(99, 33, 97, 23);
		panel_2.add(chckbxFormacin);
		
		JCheckBox chckbxCultura = new JCheckBox("Cultura");
		chckbxCultura.setBounds(0, 59, 97, 23);
		panel_2.add(chckbxCultura);
		
		JCheckBox chckbxViajes = new JCheckBox("Viajes");
		chckbxViajes.setBounds(99, 59, 97, 23);
		panel_2.add(chckbxViajes);
		
		JCheckBox chckbxOcio = new JCheckBox("Ocio");
		chckbxOcio.setBounds(0, 85, 97, 23);
		panel_2.add(chckbxOcio);
		
		JCheckBox chckbxOtros = new JCheckBox("Otros");
		chckbxOtros.setBounds(99, 85, 97, 23);
		panel_2.add(chckbxOtros);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 135, 166, 49);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo");
		lblNewLabel_2.setBounds(0, 4, 46, 14);
		panel.add(lblNewLabel_2);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(57, 0, 109, 23);
		panel.add(rdbtnHombre);
		buttonGroup.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(57, 26, 109, 23);
		panel.add(rdbtnMujer);
		buttonGroup.add(rdbtnMujer);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(127, 227, 168, 23);
		frame.getContentPane().add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("<html>He leido y aceptado los Términos y Condiciones de uso</html>");
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(214, 135, 214, 37);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnnoHeLeido = new JRadioButton("<html>No he leido y aceptado los Términos y Condiciones de uso</html>");
		buttonGroup_1.add(rdbtnnoHeLeido);
		rdbtnnoHeLeido.setSelected(true);
		rdbtnnoHeLeido.setBounds(214, 175, 214, 37);
		frame.getContentPane().add(rdbtnnoHeLeido);
	}
}
