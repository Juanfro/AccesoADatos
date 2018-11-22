package miVentana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MiOtraVentana extends JFrame {
	public MiOtraVentana() {
		setLayout(null);
	}

	static JLabel etiqueta1;
	static JLabel etiqueta2;
	// static JButton miBoton;

	public static void main(String[] args) {
		// Se crea la ventana
		MiOtraVentana miFormulario1 = new MiOtraVentana();
		// Tamaño
		miFormulario1.setBounds(0, 0, 400, 550);
		miFormulario1.setVisible(true);

		// Sin redimensionamiento
		// miFormulario1.setResizable(false);
		// Posición en el medio
		miFormulario1.setLocationRelativeTo(null);

		/****************************************************/

		// Frame interno
		JInternalFrame internal = new JInternalFrame();
		internal.setTitle("Internal Frame");
		internal.setVisible(true);
		// Se crea un panel
		JPanel miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel, BoxLayout.PAGE_AXIS));
		// Añadir panel a internal
		internal.add(miPanel);
		internal.setSize(300, 200);
		internal.show();

		internal.setResizable(true);

		miFormulario1.add(internal);

		/************************************************************/
		// Añadir etiquetas

		etiqueta1 = new JLabel("Esto es un texto");
		// etiqueta1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		etiqueta2 = new JLabel("Esto es otro texto");
		// etiqueta2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		miPanel.add(etiqueta1);
		miPanel.add(etiqueta2);

		// Añadir Botón
		JButton miBoton = new JButton("No Pulsar");
		// miBoton.setText("Este es mi botón");
		miPanel.add(miBoton);

		// Cerrar miniventana
		miBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					internal.setClosed(true);
				} catch (PropertyVetoException e1) {

					e1.printStackTrace();
				}
			}
		});

	}

}
