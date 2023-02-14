package carteleraElorrieta.vista;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import carteleraElorrieta.bbdd.gestor.GestorBBDD;
import carteleraElorrieta.bbdd.pojos.Cine;
import carteleraElorrieta.bbdd.pojos.Emision;
import carteleraElorrieta.bbdd.pojos.Pelicula;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.UIManager;

public class VentanasCartelera {
	private ArrayList<String> emisionesConfirmadas = new ArrayList<>();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanasCartelera window = new VentanasCartelera();
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
	public VentanasCartelera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(250, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelResumenCompra = new JPanel();
		panelResumenCompra.setBackground(Color.WHITE);
		panelResumenCompra.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelResumenCompra);
		panelResumenCompra.setVisible(false);
		panelResumenCompra.setLayout(null);

		JLabel labelResumenDeCompra = new JLabel("RESUMEN DE COMPRA");
		labelResumenDeCompra.setBounds(248, 11, 260, 39);
		labelResumenDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelResumenCompra.add(labelResumenDeCompra);

		JScrollPane scrollPaneResumenCompra = new JScrollPane();
		scrollPaneResumenCompra.setBounds(10, 61, 764, 261);
		panelResumenCompra.add(scrollPaneResumenCompra);

		JTable tablaResumenCompra = new JTable();
		scrollPaneResumenCompra.setViewportView(tablaResumenCompra);
		Object[] columnasTablaResumenCompra = { "Horario", "Precio", "Sala", "Pelicula" };

		DefaultTableModel modeloTablaResumen = new DefaultTableModel();
		modeloTablaResumen.setColumnIdentifiers(columnasTablaResumenCompra);
		tablaResumenCompra.setModel(modeloTablaResumen);

		JPanel panelSeleccionEmision = new JPanel();
		panelSeleccionEmision.setBackground(Color.WHITE);
		panelSeleccionEmision.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelSeleccionEmision);
		panelSeleccionEmision.setLayout(null);
		panelSeleccionEmision.setVisible(false);

		JPanel panelEleccionPelicula = new JPanel();
		panelEleccionPelicula.setBackground(Color.WHITE);
		panelEleccionPelicula.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelEleccionPelicula);
		panelEleccionPelicula.setLayout(null);

		JPanel panelSeleccionCine = new JPanel();
		panelSeleccionCine.setBackground(UIManager.getColor("Button.highlight"));
		panelSeleccionCine.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelSeleccionCine);
		panelSeleccionCine.setLayout(null);
		panelSeleccionCine.setVisible(false);

		JComboBox<String> comboBoxPeliculas = new JComboBox<String>();
		comboBoxPeliculas.setBounds(174, 122, 432, 22);
		panelEleccionPelicula.add(comboBoxPeliculas);

		JLabel lblNewLabelPelicula = new JLabel("SELECCIONA LA PELICULA QUE QUIERAS VER");
		lblNewLabelPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelPelicula.setBounds(163, 44, 510, 22);
		panelEleccionPelicula.add(lblNewLabelPelicula);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 189, 736, 231);
		panelSeleccionEmision.add(scrollPane);

		JTable tablaEmisionesCompletas = new JTable();
		tablaEmisionesCompletas.setDefaultEditor(Object.class, null);
		tablaEmisionesCompletas.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPane.setViewportView(tablaEmisionesCompletas);
		Object[] columnasTablaEmisiones = { "Horario", "Precio", "Sala", "Pelicula" };

		DefaultTableModel eModel = new DefaultTableModel();
		eModel.setColumnIdentifiers(columnasTablaEmisiones);
		tablaEmisionesCompletas.setModel(eModel);

		JComboBox<Date> comboBoxEmision = new JComboBox<Date>();
		comboBoxEmision.setBounds(215, 80, 306, 29);
		panelSeleccionEmision.add(comboBoxEmision);
		JButton botonAceptarEleccionPeliculas = new JButton("Aceptar");

		JComboBox<String> comboBoxEleccionCine = new JComboBox<String>();
		comboBoxEleccionCine.setBounds(233, 100, 299, 22);
		panelSeleccionCine.add(comboBoxEleccionCine);

		botonAceptarEleccionPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostrarPantallaElecionEmision(panelEleccionPelicula, panelSeleccionEmision);
				elegirPelicula(comboBoxEmision, comboBoxPeliculas, comboBoxEleccionCine.getSelectedItem().toString());
				tablaEmisionesCompletas.removeAll();
				eModel.setRowCount(0);
			}

		});
		botonAceptarEleccionPeliculas.setBounds(442, 222, 138, 23);
		panelEleccionPelicula.add(botonAceptarEleccionPeliculas);

		JButton botonVolverAEleccionCine = new JButton("Atras");
		botonVolverAEleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAEleccionCine(panelEleccionPelicula, panelSeleccionCine, panelSeleccionEmision);
			}

		});
		botonVolverAEleccionCine.setBounds(171, 222, 101, 23);
		panelEleccionPelicula.add(botonVolverAEleccionCine);
		panelEleccionPelicula.setVisible(false);

		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelBienvenida);
		panelBienvenida.setLayout(new BorderLayout(0, 0));

		JLabel LabelFotoBienvenida = new JLabel("");
		panelBienvenida.add(LabelFotoBienvenida, BorderLayout.CENTER);
		addImage(panelBienvenida, LabelFotoBienvenida, 0);

		JButton buttonSalirEleccionCine = new JButton("Salir");
		buttonSalirEleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarFinalizarSesion(panelResumenCompra, panelSeleccionCine, tablaResumenCompra,
						modeloTablaResumen, tablaEmisionesCompletas, eModel);
			}

		});
		buttonSalirEleccionCine.setBounds(244, 223, 89, 23);
		panelSeleccionCine.add(buttonSalirEleccionCine);

		JButton ButtonContinuarEleccionCine = new JButton("Continuar");
		ButtonContinuarEleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionCine.setVisible(false);
				panelEleccionPelicula.setVisible(true);

				elegirCine(comboBoxEleccionCine, comboBoxPeliculas);

			}

		});

		ButtonContinuarEleccionCine.setBounds(443, 223, 89, 23);
		panelSeleccionCine.add(ButtonContinuarEleccionCine);

		panelBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarEleccionCine();
			}

			private void mostrarEleccionCine() {
				panelBienvenida.setVisible(false);
				panelSeleccionCine.setVisible(true);
				añadirCinesComboBox(comboBoxEleccionCine);

			}

		});

		JLabel lblNewLabelEmision = new JLabel("SELECCIONA LA SESION A LA QUE QUIERES IR");
		lblNewLabelEmision.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelEmision.setBounds(181, 22, 445, 29);
		panelSeleccionEmision.add(lblNewLabelEmision);

		JButton ButtonCancelarEmision = new JButton("Cancelar");
		ButtonCancelarEmision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAEleccionPeliculas(panelEleccionPelicula, panelSeleccionEmision);
			}

		});
		ButtonCancelarEmision.setBounds(215, 141, 89, 23);
		panelSeleccionEmision.add(ButtonCancelarEmision);

		JButton ButtonSeleccionarEmision = new JButton("Seleccionar");
		ButtonSeleccionarEmision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				elegirFecha(comboBoxEmision, tablaEmisionesCompletas, eModel,
						comboBoxPeliculas.getSelectedItem().toString(),
						comboBoxEleccionCine.getSelectedItem().toString());
			}
		});
		ButtonSeleccionarEmision.setBounds(388, 141, 115, 23);
		panelSeleccionEmision.add(ButtonSeleccionarEmision);

		JButton botonAceptarEmisionCompleta = new JButton("Aceptar");
		botonAceptarEmisionCompleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emisionElegidaPopUp(eModel, tablaEmisionesCompletas, panelSeleccionEmision);
			}

			private int emisionElegida(DefaultTableModel eModel, JTable tablaEmisionesCompletas) {

				JFrame frame = new JFrame();
				String[] options = new String[2];
				options[0] = "Cancelar";
				options[1] = "Confirmar";
				String[] datosSeleccionados = new String[4];
				volverAEleccionCine(panelEleccionPelicula, panelSeleccionCine, panelSeleccionEmision);

				String fechaSeleccionada = "";
				for (int i = 0; i < 4; i++) {
					fechaSeleccionada = (String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), i)
							+ " " + fechaSeleccionada;

				}
				emisionesConfirmadas.add(fechaSeleccionada.substring(0, fechaSeleccionada.length() - 1));

			

				int ret = JOptionPane.showOptionDialog(frame.getContentPane(), emisionesConfirmadas.get(0),
						"Esta es la emision que usted ha elegido", 0, JOptionPane.INFORMATION_MESSAGE, null, options,
						null);

				return ret;


			}

			private void emisionElegidaPopUp(DefaultTableModel eModel, JTable tablaEmisionesCompletas,
					JPanel panelSeleccionEmision) {

				int ret = emisionElegida(eModel, tablaEmisionesCompletas);

				if (ret == 1) {
					volverAEleccionCine(panelEleccionPelicula, panelSeleccionCine, panelSeleccionEmision);
					
					for (int i = 0; i < 4; i++) {
						String hola= (String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), i);
					emisionesConfirmadas.add(hola);

					}
				}
			}

		});

		botonAceptarEmisionCompleta.setBounds(341, 447, 89, 23);
		panelSeleccionEmision.add(botonAceptarEmisionCompleta);

	}

	private void addImage(JPanel panel, JLabel label, int i) {
		String[] imagePaths = { "img/logocine.png", "img/cineBilbao.png", "img/cineMadrid.png", "img/cinePamplona.png",
				"img/imagenSalir.png" };
		ImageIcon icon = new ImageIcon(imagePaths[i]);
		Image img = icon.getImage();
		Image resizedImg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
		icon.setImage(resizedImg);
		label.setIcon(icon);
	}

	public void elegirCine(JComboBox<String> comboBoxEleccionCine, JComboBox<String> comboBoxPeliculas) {
		String cineSeleccionado = comboBoxEleccionCine.getSelectedItem().toString();
		resetComboPeliculas(comboBoxPeliculas);
		añadirPeliculasComboBox(comboBoxPeliculas, cineSeleccionado);

	}

	public void elegirPelicula(JComboBox<Date> comboBoxEmision, JComboBox<String> comboBoxPeliculas,
			String cineSeleccionado) {
		String peliculaSeleccionada = comboBoxPeliculas.getSelectedItem().toString();
		resetComboEmisiones(comboBoxEmision);
		añadirEmisionesComboBox(comboBoxEmision, peliculaSeleccionada, cineSeleccionado);

	}

	public void elegirFecha(JComboBox<Date> comboBoxEmision, JTable tablaEmisionesCompletas, DefaultTableModel model,
			String peliculaSeleccionada, String cineSeleccionado) {
		String fechaSeleccionada = comboBoxEmision.getSelectedItem().toString();
		añadirEmisionCompletaTabla(tablaEmisionesCompletas, model, fechaSeleccionada, peliculaSeleccionada,
				cineSeleccionado);
	}

	private void añadirPeliculasComboBox(JComboBox<String> comboBoxPeliculas, String cineSeleccionado) {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Pelicula> peliculas = gestorBBDD.sacarPeliculasPorCine(cineSeleccionado);
		for (int i = 0; i < peliculas.size(); i++) {
			comboBoxPeliculas.addItem(peliculas.get(i).getNombre());
		}

	}

	private void mostrarPantallaElecionEmision(JPanel panelEleccionPelicula, JPanel panelSeleccionEmision) {
		panelEleccionPelicula.setVisible(false);
		panelSeleccionEmision.setVisible(true);

	}

	private void volverAEleccionCine(JPanel panelEleccionPelicula, JPanel panelSeleccionCine,
			JPanel panelSeleccionEmision) {
		panelEleccionPelicula.setVisible(false);
		panelSeleccionEmision.setVisible(false);
		panelSeleccionCine.setVisible(true);

	}

	private void volverAEleccionPeliculas(JPanel panelEleccionPelicula, JPanel panelSeleccionEmision) {

		panelSeleccionEmision.setVisible(false);
		panelEleccionPelicula.setVisible(true);

	}

	private void resetComboPeliculas(JComboBox<String> comboBoxPeliculas) {
		comboBoxPeliculas.removeAllItems();
	}

	private void resetComboEmisiones(JComboBox<Date> comboBoxEmision) {
		comboBoxEmision.removeAllItems();

	}

	private void añadirEmisionesComboBox(JComboBox<Date> comboBoxEmision, String peliculaSeleccionada,
			String cineSeleccionado) {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = gestorBBDD.sacarEmisionesPorPeliculas(peliculaSeleccionada, cineSeleccionado);
		for (int i = 0; i < emisiones.size(); i++) {
			comboBoxEmision.addItem(emisiones.get(i).getFecha());
		}

	}

	private void añadirCinesComboBox(JComboBox<String> comboBoxEleccionCine) {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Cine> cines = gestorBBDD.sacarTodosLosCiness();
		for (int i = 0; i < cines.size(); i++) {
			comboBoxEleccionCine.addItem(cines.get(i).getNombre());
		}

	}

	private void añadirEmisionCompletaTabla(JTable tablaEmisionesCompletas, DefaultTableModel eModel,
			String fechaSeleccionada, String peliculaSeleccionada, String cineSeleccionado) {

		GestorBBDD gestorBBDD = new GestorBBDD();

		ArrayList<Emision> emisiones = gestorBBDD.sacarEmisionesPorFecha(fechaSeleccionada, peliculaSeleccionada,
				cineSeleccionado);

		tablaEmisionesCompletas.removeAll();
		eModel.setRowCount(0);

		for (int i = 0; i < emisiones.size(); i++) {
			Emision emision = emisiones.get(i);
			String hora = emision.getHorario().toString();
			String precio = "" + emision.getPrecio();
			String sala = emision.getSala().getNombre();
			String pelicula = peliculaSeleccionada;
			eModel.addRow(new String[] { hora, precio, sala, pelicula });
		}

	}

	private void añadirResumenCompraTabla(JTable tablaResumenCompra, DefaultTableModel modeloTablaResumen, JTable tablaEmisionesCompletas,DefaultTableModel eModel) {
		
		
		tablaResumenCompra.removeAll();
		modeloTablaResumen.setRowCount(0);
		if(tablaEmisionesCompletas.getSelectedRow()> -1) {
			String hora = (String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), 0);
			String precio = (String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), 1);
			String sala = (String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), 2);
			String pelicula = (String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), 3);
			modeloTablaResumen.addRow(new String[] { hora, precio, sala, pelicula });
		}

	}

	private void comprobarFinalizarSesion(JPanel panelResumenCompra, JPanel panelSeleccionCine,
			JTable tablaResumenCompra, DefaultTableModel modeloTablaResumen, JTable tablaEmisionesCompletas, DefaultTableModel eModel) {
		if (emisionesConfirmadas.isEmpty()) {
			frame.dispose();

		} else {
			panelSeleccionCine.setVisible(false);
			panelResumenCompra.setVisible(true);
			añadirResumenCompraTabla(tablaResumenCompra, modeloTablaResumen, tablaEmisionesCompletas, eModel);
		}
	}
}
