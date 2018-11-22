package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 * Disponer tres objetos de la clase JCheckBox con nombres de navegadores web.
 * Cuando se presione un botón mostrar en el título del JFrame los programas
 * seleccionados.
 * 
 * @author alumno
 *
 */
@SuppressWarnings("serial")
public class Ej23 extends JFrame {

	public Ej23() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Ejercicio 23");
	}

	static Ej23 miVentana = new Ej23();

	public static void main(String[] args) {
		//Navegadores
		JCheckBox chrome = new JCheckBox("Chrome");
		chrome.setBounds(20, 20, 100, 30);
		chrome.setVisible(true);
		miVentana.add(chrome);

		JCheckBox firefox = new JCheckBox("Firefox");
		firefox.setBounds(20, 60, 100, 30);
		firefox.setVisible(true);
		miVentana.add(firefox);

		JCheckBox opera = new JCheckBox("Opera");
		opera.setBounds(20, 100, 100, 30);
		opera.setVisible(true);
		miVentana.add(opera);
		
		JButton miButton = new JButton("TACHÁN");
		miButton.setBounds(20, 140, 100, 30);
		miButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] titulo = {"", "", ""};
				
				if (chrome.isSelected()) {
					titulo[0]= "Chrome ";
				}else {
					titulo[0]="";
				}
				
				if (firefox.isSelected()) {
					titulo[1]= "Firefox ";
				}else {
					titulo[1]="";
				}
				
				if (opera.isSelected()) {
					titulo[2]= "Opera";
				}else {
					titulo[2]="";
				}
				
				miVentana.setTitle(titulo[0] + titulo[1] +titulo[2]);
			}
		});
		miButton.setVisible(true);
		miVentana.add(miButton);
		
		//Boton
		
		

		miVentana.setVisible(true);
	}

}
