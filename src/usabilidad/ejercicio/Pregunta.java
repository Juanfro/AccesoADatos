package usabilidad.ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pregunta {

	private JFrame ventanaPregunta;
	private JTextField fieldRespuesta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregunta window = new Pregunta();
					window.ventanaPregunta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pregunta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaPregunta = new JFrame();
		ventanaPregunta.setBounds(100, 100, 450, 300);
		ventanaPregunta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {25, 60, 30, 30, 2};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 2};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		ventanaPregunta.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPreguntaSecreta = new JLabel("Pregunta secreta:");
		lblPreguntaSecreta.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblPreguntaSecreta = new GridBagConstraints();
		gbc_lblPreguntaSecreta.anchor = GridBagConstraints.NORTH;
		gbc_lblPreguntaSecreta.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPreguntaSecreta.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreguntaSecreta.gridx = 1;
		gbc_lblPreguntaSecreta.gridy = 1;
		ventanaPregunta.getContentPane().add(lblPreguntaSecreta, gbc_lblPreguntaSecreta);
		
		JLabel lblcmoSeEscribe = new JLabel("¿Cómo se escribe Luna Llena sin un espacio en medio?");
		GridBagConstraints gbc_lblcmoSeEscribe = new GridBagConstraints();
		gbc_lblcmoSeEscribe.gridwidth = 2;
		gbc_lblcmoSeEscribe.anchor = GridBagConstraints.WEST;
		gbc_lblcmoSeEscribe.insets = new Insets(0, 0, 5, 5);
		gbc_lblcmoSeEscribe.gridx = 1;
		gbc_lblcmoSeEscribe.gridy = 2;
		ventanaPregunta.getContentPane().add(lblcmoSeEscribe, gbc_lblcmoSeEscribe);
		
		fieldRespuesta = new JTextField();
		GridBagConstraints gbc_fieldRespuesta = new GridBagConstraints();
		gbc_fieldRespuesta.gridwidth = 2;
		gbc_fieldRespuesta.insets = new Insets(0, 0, 5, 5);
		gbc_fieldRespuesta.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldRespuesta.gridx = 1;
		gbc_fieldRespuesta.gridy = 3;
		ventanaPregunta.getContentPane().add(fieldRespuesta, gbc_fieldRespuesta);
		fieldRespuesta.setColumns(10);
		
		JButton btnNewButton = new JButton("Cambiar Contraseña");
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		ventanaPregunta.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JLabel incorrect = new JLabel("Respuesta incorrecta");
		incorrect.setVisible(false);
		incorrect.setForeground(Color.RED);
		GridBagConstraints gbc_incorrect = new GridBagConstraints();
		gbc_incorrect.anchor = GridBagConstraints.WEST;
		gbc_incorrect.insets = new Insets(0, 0, 0, 5);
		gbc_incorrect.gridx = 1;
		gbc_incorrect.gridy = 5;
		ventanaPregunta.getContentPane().add(incorrect, gbc_incorrect);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respuesta = fieldRespuesta.getText();
				
				if (respuesta.equals("LunaLlena")) {
					CambioPwd cambioPwd = new CambioPwd();
					cambioPwd.main(null);
					ventanaPregunta.dispose();
				}else {
					incorrect.setVisible(true);
				}
			}
		});
	}

}
