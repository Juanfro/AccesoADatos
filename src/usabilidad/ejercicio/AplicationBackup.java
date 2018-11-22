package usabilidad.ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Rectangle;

public class AplicationBackup {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicationBackup window = new AplicationBackup();
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
	public AplicationBackup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 651, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel catalogo = new JPanel();
		tabbedPane.addTab("Catálogo de Producto", null, catalogo, null);
		GridBagLayout gbl_catalogo = new GridBagLayout();
		gbl_catalogo.columnWidths = new int[] { 0, 0, 16, 0, 0, 0 };
		gbl_catalogo.rowHeights = new int[] { 0, 0, 0, 27, 0, 0, 0 };
		gbl_catalogo.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_catalogo.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		catalogo.setLayout(gbl_catalogo);

		JPanel options = new JPanel();
		GridBagConstraints gbc_options = new GridBagConstraints();
		gbc_options.insets = new Insets(0, 0, 5, 5);
		gbc_options.fill = GridBagConstraints.BOTH;
		gbc_options.gridx = 1;
		gbc_options.gridy = 2;
		catalogo.add(options, gbc_options);
		GridBagLayout gbl_options = new GridBagLayout();
		gbl_options.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_options.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_options.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_options.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		options.setLayout(gbl_options);

		JLabel lblRamo = new JLabel("Ramo");
		GridBagConstraints gbc_lblRamo = new GridBagConstraints();
		gbc_lblRamo.anchor = GridBagConstraints.WEST;
		gbc_lblRamo.insets = new Insets(0, 0, 5, 5);
		gbc_lblRamo.gridx = 1;
		gbc_lblRamo.gridy = 1;
		options.add(lblRamo, gbc_lblRamo);

		JComboBox selectRamo = new JComboBox();

		GridBagConstraints gbc_selectRamo = new GridBagConstraints();
		gbc_selectRamo.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectRamo.insets = new Insets(0, 0, 5, 5);
		gbc_selectRamo.gridx = 2;
		gbc_selectRamo.gridy = 1;
		options.add(selectRamo, gbc_selectRamo);
		selectRamo.setModel(new DefaultComboBoxModel(new String[] { "Vida", "Generales" }));

		JLabel lblSubramo = new JLabel("SubRamo");
		GridBagConstraints gbc_lblSubramo = new GridBagConstraints();
		gbc_lblSubramo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubramo.gridx = 1;
		gbc_lblSubramo.gridy = 2;
		options.add(lblSubramo, gbc_lblSubramo);

		JComboBox selectSubRamo = new JComboBox();
		GridBagConstraints gbc_selectSubRamo = new GridBagConstraints();
		gbc_selectSubRamo.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectSubRamo.insets = new Insets(0, 0, 5, 5);
		gbc_selectSubRamo.gridx = 2;
		gbc_selectSubRamo.gridy = 2;
		options.add(selectSubRamo, gbc_selectSubRamo);
		selectSubRamo.setModel(new DefaultComboBoxModel(new String[] { "Ahorro", "Mixto" }));

		JLabel lblCategora = new JLabel("Categoría");
		GridBagConstraints gbc_lblCategora = new GridBagConstraints();
		gbc_lblCategora.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategora.gridx = 1;
		gbc_lblCategora.gridy = 3;
		options.add(lblCategora, gbc_lblCategora);

		JComboBox SelectCategoria = new JComboBox();
		GridBagConstraints gbc_SelectCategoria = new GridBagConstraints();
		gbc_SelectCategoria.anchor = GridBagConstraints.EAST;
		gbc_SelectCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_SelectCategoria.gridx = 2;
		gbc_SelectCategoria.gridy = 3;
		options.add(SelectCategoria, gbc_SelectCategoria);
		SelectCategoria.setModel(new DefaultComboBoxModel(new String[] { "Ahorro Plus", "Ahorro Básico" }));

		// START LISTENER
		ItemListener ramoItemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// Ramo // Modelos subramo
				String[] subRamoVidaItems = { "Ahorro", "Mixto" };
				final DefaultComboBoxModel subRamoVida = new DefaultComboBoxModel<>(subRamoVidaItems);

				String[] subRamoGeneralesItems = { "RC" };
				final DefaultComboBoxModel subRamoGenerales = new DefaultComboBoxModel<>(subRamoGeneralesItems);

				String ramoElegido = (String) selectRamo.getSelectedItem();

				switch (ramoElegido) {
				case "Vida":
					selectSubRamo.setModel(subRamoVida);
					break;
				case "Generales":
					selectSubRamo.setModel(subRamoGenerales);
					break;

				default:
					break;
				}
			}
		};
		ActionListener ramoActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ramo // Modelos subramo
				String[] subRamoVidaItems = { "Ahorro", "Mixto" };
				final DefaultComboBoxModel subRamoVida = new DefaultComboBoxModel<>(subRamoVidaItems);

				String[] subRamoGeneralesItems = { "RC" };
				final DefaultComboBoxModel subRamoGenerales = new DefaultComboBoxModel<>(subRamoGeneralesItems);

				String ramoElegido = (String) selectRamo.getSelectedItem();

				switch (ramoElegido) {
				case "Vida":
					selectSubRamo.setModel(subRamoVida);
					break;
				case "Generales":
					selectSubRamo.setModel(subRamoGenerales);
					break;

				default:
					break;
				}

				// Categoria
				// SubRamo // Modelos categoria
				String[] categoriaVidaAhorroItems = { "Ahorro Plus", "Ahorro Básico" };
				final DefaultComboBoxModel categoriaVidaAhorro = new DefaultComboBoxModel<>(categoriaVidaAhorroItems);
				String[] categoriaVidaMixtoItems = { "Mixto Plus", "Mixto Básico" };
				final DefaultComboBoxModel categoriaVidaMixto = new DefaultComboBoxModel<>(categoriaVidaMixtoItems);
				String[] categoriaGeneralesRCItems = { "RC General", "RC Mercancías Peligrosas" };
				final DefaultComboBoxModel categoriaGeneralesRC = new DefaultComboBoxModel<>(categoriaGeneralesRCItems);

				String subRamoElegido = (String) selectSubRamo.getSelectedItem();

				switch (subRamoElegido) {
				case "Ahorro":
					SelectCategoria.setModel(categoriaVidaAhorro);
					break;
				case "Mixto":
					SelectCategoria.setModel(categoriaVidaMixto);
					break;
				case "RC":
					SelectCategoria.setModel(categoriaGeneralesRC);
					break;

				default:
					break;
				}

			}
		};

		ItemListener subRamoItemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// SubRamo // Modelos categoria
				String[] categoriaVidaAhorroItems = { "Ahorro Plus", "Ahorro Básico" };
				final DefaultComboBoxModel categoriaVidaAhorro = new DefaultComboBoxModel<>(categoriaVidaAhorroItems);
				String[] categoriaVidaMixtoItems = { "Mixto Plus", "Mixto Básico" };
				final DefaultComboBoxModel categoriaVidaMixto = new DefaultComboBoxModel<>(categoriaVidaMixtoItems);
				String[] categoriaGeneralesRCItems = { "RC General", "RC Mercancías Peligrosas" };
				final DefaultComboBoxModel categoriaGeneralesRC = new DefaultComboBoxModel<>(categoriaGeneralesRCItems);

				String subRamoElegido = (String) selectSubRamo.getSelectedItem();

				switch (subRamoElegido) {
				case "Ahorro":
					SelectCategoria.setModel(categoriaVidaAhorro);
					break;
				case "Mixto":
					SelectCategoria.setModel(categoriaVidaMixto);
					break;
				case "RC":
					SelectCategoria.setModel(categoriaGeneralesRC);
					break;

				default:
					break;
				}
			}
		};

		ActionListener subRamoActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// SubRamo // Modelos categoria
				String[] categoriaVidaAhorroItems = { "Ahorro Plus", "Ahorro Básico" };
				final DefaultComboBoxModel categoriaVidaAhorro = new DefaultComboBoxModel<>(categoriaVidaAhorroItems);
				String[] categoriaVidaMixtoItems = { "Mixto Plus", "Mixto Básico" };
				final DefaultComboBoxModel categoriaVidaMixto = new DefaultComboBoxModel<>(categoriaVidaMixtoItems);
				String[] categoriaGeneralesRCItems = { "RC General", "RC Mercancías Peligrosas" };
				final DefaultComboBoxModel categoriaGeneralesRC = new DefaultComboBoxModel<>(categoriaGeneralesRCItems);

				String subRamoElegido = (String) selectSubRamo.getSelectedItem();

				switch (subRamoElegido) {
				case "Ahorro":
					SelectCategoria.setModel(categoriaVidaAhorro);
					break;
				case "Mixto":
					SelectCategoria.setModel(categoriaVidaMixto);
					break;
				case "RC":
					SelectCategoria.setModel(categoriaGeneralesRC);
					break;

				default:
					break;
				}
			}
		};
		// Add listener
		// selectRamo.addItemListener(ramoItemListener);
		selectRamo.addActionListener(ramoActionListener);
		selectSubRamo.addItemListener(subRamoItemListener);
		selectSubRamo.addActionListener(subRamoActionListener);

		// END Listener

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.fill = GridBagConstraints.VERTICAL;
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.gridx = 2;
		gbc_separator_2.gridy = 2;
		catalogo.add(separator_2, gbc_separator_2);

		JPanel advancedSearch = new JPanel();
		GridBagConstraints gbc_advancedSearch = new GridBagConstraints();
		gbc_advancedSearch.insets = new Insets(0, 0, 5, 5);
		gbc_advancedSearch.fill = GridBagConstraints.BOTH;
		gbc_advancedSearch.gridx = 3;
		gbc_advancedSearch.gridy = 2;
		catalogo.add(advancedSearch, gbc_advancedSearch);
		GridBagLayout gbl_advancedSearch = new GridBagLayout();
		gbl_advancedSearch.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_advancedSearch.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_advancedSearch.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_advancedSearch.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		advancedSearch.setLayout(gbl_advancedSearch);

		JLabel lblBusquedaAvanzada = new JLabel("Busqueda Avanzada");
		GridBagConstraints gbc_lblBusquedaAvanzada = new GridBagConstraints();
		gbc_lblBusquedaAvanzada.anchor = GridBagConstraints.WEST;
		gbc_lblBusquedaAvanzada.insets = new Insets(0, 0, 5, 5);
		gbc_lblBusquedaAvanzada.gridx = 1;
		gbc_lblBusquedaAvanzada.gridy = 0;
		advancedSearch.add(lblBusquedaAvanzada, gbc_lblBusquedaAvanzada);

		JLabel lblNewLabel = new JLabel("Fecha");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		advancedSearch.add(lblNewLabel, gbc_lblNewLabel);

		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 1;
		advancedSearch.add(dateChooser, gbc_dateChooser);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		advancedSearch.add(lblNombre, gbc_lblNombre);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		advancedSearch.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTipo.anchor = GridBagConstraints.WEST;
		gbc_lblTipo.gridx = 1;
		gbc_lblTipo.gridy = 3;
		advancedSearch.add(lblTipo, gbc_lblTipo);

		txtTipo = new JTextField();
		GridBagConstraints gbc_txtTipo = new GridBagConstraints();
		gbc_txtTipo.insets = new Insets(0, 0, 0, 5);
		gbc_txtTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipo.gridx = 2;
		gbc_txtTipo.gridy = 3;
		advancedSearch.add(txtTipo, gbc_txtTipo);
		txtTipo.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 3;
		catalogo.add(separator_1, gbc_separator_1);

		JPanel buttons = new JPanel();
		GridBagConstraints gbc_buttons = new GridBagConstraints();
		gbc_buttons.gridwidth = 3;
		gbc_buttons.insets = new Insets(0, 0, 5, 5);
		gbc_buttons.fill = GridBagConstraints.BOTH;
		gbc_buttons.gridx = 1;
		gbc_buttons.gridy = 4;
		catalogo.add(buttons, gbc_buttons);
		GridBagLayout gbl_buttons = new GridBagLayout();
		gbl_buttons.columnWidths = new int[] { 0, 89, 0, 0 };
		gbl_buttons.rowHeights = new int[] { 0, 23, 0, 0, 0, 0 };
		gbl_buttons.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_buttons.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		buttons.setLayout(gbl_buttons);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setMinimumSize(new Dimension(113, 23));
		btnBuscar.setMaximumSize(new Dimension(113, 23));
		btnBuscar.setPreferredSize(new Dimension(127, 23));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 1;
		buttons.add(btnBuscar, gbc_btnBuscar);

		JButton btnInforme = new JButton("Generar Informe");
		GridBagConstraints gbc_btnInforme = new GridBagConstraints();
		gbc_btnInforme.insets = new Insets(0, 0, 5, 5);
		gbc_btnInforme.gridx = 1;
		gbc_btnInforme.gridy = 2;
		buttons.add(btnInforme, gbc_btnInforme);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimpiar.setBounds(new Rectangle(0, 0, 113, 0));
		btnLimpiar.setMinimumSize(new Dimension(113, 23));
		btnLimpiar.setMaximumSize(new Dimension(113, 23));
		btnLimpiar.setPreferredSize(new Dimension(127, 23));
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 1;
		gbc_btnLimpiar.gridy = 3;
		buttons.add(btnLimpiar, gbc_btnLimpiar);

		JPanel gAgrupaciones = new JPanel();
		tabbedPane.addTab("Gestión de Agrupaciones", null, gAgrupaciones, null);
		GridBagLayout gbl_gAgrupaciones = new GridBagLayout();
		gbl_gAgrupaciones.columnWidths = new int[] { 0 };
		gbl_gAgrupaciones.rowHeights = new int[] { 0 };
		gbl_gAgrupaciones.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_gAgrupaciones.rowWeights = new double[] { Double.MIN_VALUE };
		gAgrupaciones.setLayout(gbl_gAgrupaciones);

		JPanel gNormativas = new JPanel();
		tabbedPane.addTab("Gestión de Normativas", null, gNormativas, null);
		GridBagLayout gbl_gNormativas = new GridBagLayout();
		gbl_gNormativas.columnWidths = new int[] { 0 };
		gbl_gNormativas.rowHeights = new int[] { 0 };
		gbl_gNormativas.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_gNormativas.rowWeights = new double[] { Double.MIN_VALUE };
		gNormativas.setLayout(gbl_gNormativas);

		JPanel gFicheros = new JPanel();
		tabbedPane.addTab("Gestión de Ficheros", null, gFicheros, null);
		GridBagLayout gbl_gFicheros = new GridBagLayout();
		gbl_gFicheros.columnWidths = new int[] { 0 };
		gbl_gFicheros.rowHeights = new int[] { 0 };
		gbl_gFicheros.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_gFicheros.rowWeights = new double[] { Double.MIN_VALUE };
		gFicheros.setLayout(gbl_gFicheros);
	}

}
