package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 * Desarrollar un programa que muestre 3 objetos de la clase JCheckBox con
 * etiquetas de tres idiomas. Cuando se lo selecciona mostrar en el título del
 * JFrame todos los JCheckBox seleccionados hasta el momento.
 * 
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej21 extends JFrame {

	public Ej21() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Ejercicio 21");
	}
	
	static Ej21 miVentana = new Ej21();
	
	public static void main(String[] args) {
		JCheckBox english = new JCheckBox("Inglés");
		JCheckBox french = new JCheckBox("Francés");
		JCheckBox german = new JCheckBox("Alemán");
		
		english.setBounds(20, 20, 100, 30);
		french.setBounds(20, 60, 100, 30);
		german.setBounds(20, 100, 100, 30);
		
		ActionListener idiomas = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("entra en el evento");
				String[] titulo = {"","",""};
				
				if(english.isSelected()) {
					titulo[0]= "Ingles ";
				}else {
					titulo[0]= "";
				}
				if(french.isSelected()) {
					titulo[1]= "Francés ";
				}else {
					titulo[1]= "";
				}
				if(german.isSelected()) {
					titulo[2]= "Aleman";
				}else {
					titulo[2]= "";
				}
				
				miVentana.setTitle(titulo[0] + titulo[1] + titulo[2]);
			}
		};
		
		english.addActionListener(idiomas);
		french.addActionListener(idiomas);
		german.addActionListener(idiomas);
		
		english.setVisible(true);
		french.setVisible(true);
		german.setVisible(true);
		
		miVentana.add(english);
		miVentana.add(french);
		miVentana.add(german);
		
		
		
		miVentana.setVisible(true);
	}

}
