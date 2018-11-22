package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * Mediante dos controles de tipo JTextField permitir introducir dos números. Crear un menú
que contenga una opción que redimensione el JFrame con los valores introducidos por
teclado. Finalmente disponer otra opción que finalice el programa.
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej20 extends JFrame{
	
	public Ej20() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Ejercicio 20");
	}
	
	static Ej20 miVentana = new Ej20();
	

	public static void main(String[] args) {
		
		JLabel labelAncho = new JLabel("Ancho:");
		labelAncho.setBounds(20, 10, 100, 30);
		labelAncho.setVisible(true);
		
		JLabel labelAlto = new JLabel("Alto:");
		labelAlto.setBounds(20, 90, 100, 30);
		labelAlto.setVisible(true);
		
		miVentana.add(labelAncho);
		miVentana.add(labelAlto);

		JTextField ancho = new JTextField();
		JTextField alto = new JTextField();
		
		ancho.setBounds(20, 50, 100, 30);		
		ancho.setVisible(true);
		
		alto.setBounds(20, 130, 100, 30);
		alto.setVisible(true);
		
		miVentana.add(ancho);
		miVentana.add(alto);
		
		JButton miJButton = new JButton("Cambiar Tamaño");
		miJButton.setBounds(20, 170, 200, 30);
		miJButton.setVisible(true);
		miJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int valAncho = Integer.parseInt(ancho.getText());
				int valAlto= Integer.parseInt(alto.getText());
				
				miVentana.setSize(valAncho, valAlto);
			}
		});
		miVentana.add(miJButton);
		
		
		
		miVentana.setVisible(true);
	}

}
