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

public class Aplication {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplication window = new Aplication();
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
	public Aplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 651, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel catalogo = new JPanel();
		tabbedPane.addTab("Catálogo de Producto", null, catalogo, null);
		GridBagLayout gbl_catalogo = new GridBagLayout();
		gbl_catalogo.columnWidths = new int[] { 0, 189, 0, 0, 0 };
		gbl_catalogo.rowHeights = new int[] { 0, 118, 27, 169, 45, 0, 0, 0 };
		gbl_catalogo.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_catalogo.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		catalogo.setLayout(gbl_catalogo);

		JPanel options = new JPanel();
		GridBagConstraints gbc_options = new GridBagConstraints();
		gbc_options.anchor = GridBagConstraints.NORTH;
		gbc_options.gridwidth = 2;
		gbc_options.insets = new Insets(0, 0, 5, 5);
		gbc_options.fill = GridBagConstraints.HORIZONTAL;
		gbc_options.gridx = 1;
		gbc_options.gridy = 1;
		catalogo.add(options, gbc_options);
		GridBagLayout gbl_options = new GridBagLayout();
		gbl_options.columnWidths = new int[] { 0, 0, 0 };
		gbl_options.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_options.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_options.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		options.setLayout(gbl_options);

		JLabel lblRamo = new JLabel("Ramo");
		GridBagConstraints gbc_lblRamo = new GridBagConstraints();
		gbc_lblRamo.anchor = GridBagConstraints.WEST;
		gbc_lblRamo.insets = new Insets(0, 0, 5, 5);
		gbc_lblRamo.gridx = 0;
		gbc_lblRamo.gridy = 1;
		options.add(lblRamo, gbc_lblRamo);

		JComboBox selectRamo = new JComboBox();

		GridBagConstraints gbc_selectRamo = new GridBagConstraints();
		gbc_selectRamo.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectRamo.insets = new Insets(0, 0, 5, 0);
		gbc_selectRamo.gridx = 1;
		gbc_selectRamo.gridy = 1;
		options.add(selectRamo, gbc_selectRamo);
		selectRamo.setModel(new DefaultComboBoxModel(new String[] { "Vida", "Generales" }));

		JLabel lblSubramo = new JLabel("SubRamo");
		GridBagConstraints gbc_lblSubramo = new GridBagConstraints();
		gbc_lblSubramo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubramo.gridx = 0;
		gbc_lblSubramo.gridy = 2;
		options.add(lblSubramo, gbc_lblSubramo);

		JComboBox selectSubRamo = new JComboBox();
		GridBagConstraints gbc_selectSubRamo = new GridBagConstraints();
		gbc_selectSubRamo.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectSubRamo.insets = new Insets(0, 0, 5, 0);
		gbc_selectSubRamo.gridx = 1;
		gbc_selectSubRamo.gridy = 2;
		options.add(selectSubRamo, gbc_selectSubRamo);
		selectSubRamo.setModel(new DefaultComboBoxModel(new String[] { "Ahorro", "Mixto" }));

		JLabel lblCategora = new JLabel("Categoría");
		GridBagConstraints gbc_lblCategora = new GridBagConstraints();
		gbc_lblCategora.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategora.gridx = 0;
		gbc_lblCategora.gridy = 3;
		options.add(lblCategora, gbc_lblCategora);

		JComboBox SelectCategoria = new JComboBox();
		GridBagConstraints gbc_SelectCategoria = new GridBagConstraints();
		gbc_SelectCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_SelectCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_SelectCategoria.gridx = 1;
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

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 2;
		catalogo.add(separator_1, gbc_separator_1);

		JButton btnAvanzada = new JButton("Búsqueda Avanzada");
		GridBagConstraints gbc_btnAvanzada = new GridBagConstraints();
		gbc_btnAvanzada.anchor = GridBagConstraints.WEST;
		gbc_btnAvanzada.insets = new Insets(0, 0, 5, 5);
		gbc_btnAvanzada.gridx = 1;
		gbc_btnAvanzada.gridy = 3;
		catalogo.add(btnAvanzada, gbc_btnAvanzada);

		btnAvanzada.setPreferredSize(new Dimension(149, 23));
		btnAvanzada.setMinimumSize(new Dimension(149, 23));

		JPanel panelAvanzada = new JPanel();
		GridBagConstraints gbc_panelAvanzada = new GridBagConstraints();
		gbc_panelAvanzada.insets = new Insets(0, 0, 5, 5);
		gbc_panelAvanzada.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelAvanzada.gridx = 2;
		gbc_panelAvanzada.gridy = 3;
		catalogo.add(panelAvanzada, gbc_panelAvanzada);
		GridBagLayout gbl_panelAvanzada = new GridBagLayout();
		gbl_panelAvanzada.columnWidths = new int[] { 119, 0, 0, 0, 0 };
		gbl_panelAvanzada.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelAvanzada.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelAvanzada.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelAvanzada.setLayout(gbl_panelAvanzada);

		JLabel label = new JLabel("Busqueda Avanzada");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 3;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panelAvanzada.add(label, gbc_label);

		JLabel lbFechaAlta = new JLabel("Fecha de Alta");
		GridBagConstraints gbc_lbFechaAlta = new GridBagConstraints();
		gbc_lbFechaAlta.anchor = GridBagConstraints.WEST;
		gbc_lbFechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lbFechaAlta.gridx = 0;
		gbc_lbFechaAlta.gridy = 1;
		panelAvanzada.add(lbFechaAlta, gbc_lbFechaAlta);

		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 1;
		panelAvanzada.add(dateChooser, gbc_dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 1;
		panelAvanzada.add(dateChooser_1, gbc_dateChooser_1);

		JLabel lblFechaDeBaja = new JLabel("Fecha de Baja");
		GridBagConstraints gbc_lblFechaDeBaja = new GridBagConstraints();
		gbc_lblFechaDeBaja.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeBaja.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeBaja.gridx = 0;
		gbc_lblFechaDeBaja.gridy = 2;
		panelAvanzada.add(lblFechaDeBaja, gbc_lblFechaDeBaja);

		JDateChooser dateChooser_2 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_2 = new GridBagConstraints();
		gbc_dateChooser_2.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_2.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_2.gridx = 1;
		gbc_dateChooser_2.gridy = 2;
		panelAvanzada.add(dateChooser_2, gbc_dateChooser_2);

		JDateChooser dateChooser_3 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_3 = new GridBagConstraints();
		gbc_dateChooser_3.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_3.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_3.gridx = 2;
		gbc_dateChooser_3.gridy = 2;
		panelAvanzada.add(dateChooser_3, gbc_dateChooser_3);

		JLabel lblFechaDeCancelacin = new JLabel("Fecha de Cancelación");
		GridBagConstraints gbc_lblFechaDeCancelacin = new GridBagConstraints();
		gbc_lblFechaDeCancelacin.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeCancelacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeCancelacin.gridx = 0;
		gbc_lblFechaDeCancelacin.gridy = 3;
		panelAvanzada.add(lblFechaDeCancelacin, gbc_lblFechaDeCancelacin);

		JDateChooser dateChooser_4 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_4 = new GridBagConstraints();
		gbc_dateChooser_4.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_4.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_4.gridx = 1;
		gbc_dateChooser_4.gridy = 3;
		panelAvanzada.add(dateChooser_4, gbc_dateChooser_4);

		JDateChooser dateChooser_5 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_5 = new GridBagConstraints();
		gbc_dateChooser_5.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_5.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_5.gridx = 2;
		gbc_dateChooser_5.gridy = 3;
		panelAvanzada.add(dateChooser_5, gbc_dateChooser_5);

		JLabel label_2 = new JLabel("Nombre");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 4;
		panelAvanzada.add(label_2, gbc_label_2);

		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		panelAvanzada.add(textField, gbc_textField);

		JLabel label_3 = new JLabel("Tipo");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 5;
		panelAvanzada.add(label_3, gbc_label_3);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		panelAvanzada.add(textField_1, gbc_textField_1);

		// Evento para Busqueda Avanzada
		btnAvanzada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (panelAvanzada.isVisible()) {
					panelAvanzada.setVisible(false);
				} else if (!panelAvanzada.isVisible()) {
					panelAvanzada.setVisible(true);
				}

			}
		});

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.GRAY);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 4;
		catalogo.add(separator, gbc_separator);

		JPanel panelButtons = new JPanel();
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.gridwidth = 2;
		gbc_panelButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelButtons.fill = GridBagConstraints.BOTH;
		gbc_panelButtons.gridx = 1;
		gbc_panelButtons.gridy = 5;
		catalogo.add(panelButtons, gbc_panelButtons);
		GridBagLayout gbl_panelButtons = new GridBagLayout();
		gbl_panelButtons.columnWidths = new int[] { 89, 0, 0, 0 };
		gbl_panelButtons.rowHeights = new int[] { 0, 23, 0, 0 };
		gbl_panelButtons.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelButtons.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panelButtons.setLayout(gbl_panelButtons);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setMinimumSize(new Dimension(149, 23));
		btnBuscar.setMaximumSize(new Dimension(149, 23));
		btnBuscar.setPreferredSize(new Dimension(149, 23));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 1;
		panelButtons.add(btnBuscar, gbc_btnBuscar);

		JButton btnInforme = new JButton("Generar Informe");
		btnInforme.setPreferredSize(new Dimension(149, 23));
		btnInforme.setMaximumSize(new Dimension(149, 23));
		GridBagConstraints gbc_btnInforme = new GridBagConstraints();
		gbc_btnInforme.insets = new Insets(0, 0, 5, 5);
		gbc_btnInforme.gridx = 1;
		gbc_btnInforme.gridy = 1;
		panelButtons.add(btnInforme, gbc_btnInforme);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimpiar.setBounds(new Rectangle(0, 0, 113, 0));
		btnLimpiar.setMinimumSize(new Dimension(149, 23));
		btnLimpiar.setMaximumSize(new Dimension(149, 23));
		btnLimpiar.setPreferredSize(new Dimension(149, 23));
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 0);
		gbc_btnLimpiar.gridx = 2;
		gbc_btnLimpiar.gridy = 1;
		panelButtons.add(btnLimpiar, gbc_btnLimpiar);

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
