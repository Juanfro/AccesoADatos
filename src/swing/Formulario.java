package swing;

import javax.swing.*;

@SuppressWarnings("serial")
public class Formulario extends JFrame {
	public Formulario() {
		setLayout(null);
	}
	
	public static void main(String[] args) {
		Formulario miFormulario1 = new Formulario();
		miFormulario1.setBounds(0, 0, 400, 550);
		miFormulario1.setVisible(true);
	}
}
