package carteleraElorrieta.vista;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import carteleraElorrieta.bbdd.gestor.GestorBBDD;
import carteleraElorrieta.bbdd.pojos.Cine;
import carteleraElorrieta.bbdd.pojos.Cliente;
import carteleraElorrieta.bbdd.pojos.Emision;
import carteleraElorrieta.bbdd.pojos.Entrada;
import carteleraElorrieta.bbdd.pojos.Pelicula;
import carteleraElorrieta.bbdd.pojos.Sala;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.time.LocalTime;

import java.util.ArrayList;
import java.util.Date;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.UIManager;

public class VentanasCartelera {
	private ArrayList<Emision> emisionesConfirmadas = new ArrayList<Emision>();
	// frame principal
	private JFrame frame;
	// paneles
	JPanel panelFacturaEntrada = null;
	JPanel panelFichero = null;
	JPanel panelLogin = null;
	JPanel panelSeleccionCine = null;
	JPanel panelResgistro = null;
	JPanel panelResumenCompra = null;
	JPanel panelBienvenida = null;
	JPanel panelSeleccionEmision = null;
	JPanel panelEleccionPelicula = null;
	// combobox
	JComboBox<String> comboBoxPeliculas = null;
	JComboBox<Date> comboBoxEmision = null;
	JComboBox<String> comboBoxEleccionCine = null;

	JTable tablaResumenCompra = null;
	JTable tablaEmisionesCompletas = null;
	DefaultTableModel eModel=null;
	JTextField textFieldDniRegistro = null;
	JTextField textFieldDniLogin=null;
	String fechaSeleccionada = null;
	String peliculaSeleccionada = null;
	String cineSeleccionado = null;

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

		panelFacturaEntrada = new JPanel();
		panelFacturaEntrada.setBackground(Color.WHITE);
		panelFacturaEntrada.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelFacturaEntrada);
		panelFacturaEntrada.setLayout(null);

		JButton botonVolverBienvenida = new JButton("Volver Pagina Principal");
		botonVolverBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonVolverBienvenida.setBounds(127, 422, 159, 23);
		panelFacturaEntrada.add(botonVolverBienvenida);
		panelFacturaEntrada.setVisible(false);

		panelFichero = new JPanel();
		panelFichero.setBackground(Color.WHITE);
		panelFichero.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelFichero);
		panelFichero.setLayout(null);
		panelFichero.setVisible(false);

		JLabel labelFactura = new JLabel("FACTURA DE COMPRA");
		labelFactura.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelFactura.setBounds(224, 11, 354, 52);
		panelFichero.add(labelFactura);

		JButton botonGenerarFactura = new JButton("GENERAR FACTURA");
		botonGenerarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente=new Cliente();
				Entrada entradaParaRegistrar = new Entrada();
				for (int i = 0; i < emisionesConfirmadas.size(); i++) {
					Emision emision =emisionesConfirmadas.get(i);
					cliente.setDni( textFieldDniLogin.getText());
					entradaParaRegistrar.setEmision(emision);
					entradaParaRegistrar.setCliente(cliente);
					añadirEntradaBBDD(entradaParaRegistrar);
				}


				

				

				
				panelFichero.setVisible(false);
				panelFacturaEntrada.setVisible(true);

			}

			private void añadirEntradaBBDD(Entrada entradaParaRegistrar) {

				GestorBBDD gestorBBDD = new GestorBBDD();

				gestorBBDD.insertarEntradaCliente(entradaParaRegistrar);

			}
		});
		botonGenerarFactura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonGenerarFactura.setBounds(74, 151, 258, 219);
		panelFichero.add(botonGenerarFactura);

		JButton botonVolverAlMenuFactura = new JButton("Volver al menu");
		botonVolverAlMenuFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFichero.setVisible(false);
				panelSeleccionCine.setVisible(true);
				emisionesConfirmadas.clear();
			}
		});
		botonVolverAlMenuFactura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonVolverAlMenuFactura.setBounds(452, 151, 267, 219);
		panelFichero.add(botonVolverAlMenuFactura);

		panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		panelLogin.setVisible(false);

		panelResgistro = new JPanel();
		panelResgistro.setBackground(Color.WHITE);
		panelResgistro.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelResgistro);
		panelResgistro.setLayout(null);
		panelResgistro.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(72, 50, 86, 14);
		panelLogin.add(lblNewLabel_1);

	 textFieldDniLogin = new JTextField();
		textFieldDniLogin.setBounds(72, 86, 86, 20);
		panelLogin.add(textFieldDniLogin);
		textFieldDniLogin.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(72, 136, 86, 14);
		panelLogin.add(lblNewLabel_2);

		JTextField textFieldContraseñaLogin = new JTextField();
		textFieldContraseñaLogin.setBounds(72, 175, 86, 20);
		panelLogin.add(textFieldContraseñaLogin);
		textFieldContraseñaLogin.setColumns(10);

		panelSeleccionCine = new JPanel();
		panelSeleccionCine.setBackground(UIManager.getColor("Button.highlight"));
		panelSeleccionCine.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelSeleccionCine);
		panelSeleccionCine.setLayout(null);
		panelSeleccionCine.setVisible(false);

		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarLoginCliente(textFieldDniLogin, textFieldContraseñaLogin);
			}
		});
		btnNewButton_1.setBounds(72, 263, 89, 23);
		panelLogin.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelSeleccionCine.setVisible(true);
				emisionesConfirmadas.clear();
			}
		});
		btnNewButton_2.setBounds(239, 263, 89, 23);
		panelLogin.add(btnNewButton_2);

		JButton botonParaRegistrarteLogIn = new JButton("Si no tienes cuenta registrate aqui");
		botonParaRegistrarteLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaRegistro();
			}

		});
		botonParaRegistrarteLogIn.setBounds(453, 28, 294, 58);
		panelLogin.add(botonParaRegistrarteLogIn);

		JTextField jTextNombreRegistro = new JTextField();
		jTextNombreRegistro.setBounds(185, 79, 86, 20);
		panelResgistro.add(jTextNombreRegistro);
		jTextNombreRegistro.setColumns(10);

		JLabel jLabelLogin = new JLabel();
		jLabelLogin.setText("Nombre");
		jLabelLogin.setBounds(103, 79, 57, 20);
		panelResgistro.add(jLabelLogin);

		JLabel jLabelPass = new JLabel();
		jLabelPass.setText("Apellidos");
		jLabelPass.setBounds(103, 126, 73, 20);
		panelResgistro.add(jLabelPass);

		JTextField passwordRegistro = new JTextField();
		passwordRegistro.setBounds(185, 217, 86, 20);
		panelResgistro.add(passwordRegistro);

		JLabel jLabelPass_1 = new JLabel();
		jLabelPass_1.setText("Contraseña");
		jLabelPass_1.setBounds(103, 217, 73, 20);
		panelResgistro.add(jLabelPass_1);

		JLabel jLabelLogin_1 = new JLabel();
		jLabelLogin_1.setText("DNI");
		jLabelLogin_1.setBounds(103, 170, 57, 20);
		panelResgistro.add(jLabelLogin_1);

		textFieldDniRegistro = new JTextField();
		textFieldDniRegistro.setColumns(10);
		textFieldDniRegistro.setBounds(185, 170, 86, 20);
		panelResgistro.add(textFieldDniRegistro);

		JTextField textFieldSexoRegistro = new JTextField();
		textFieldSexoRegistro.setBounds(185, 264, 86, 20);
		panelResgistro.add(textFieldSexoRegistro);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 11, 106, 40);
		panelResgistro.add(lblNewLabel);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(233, 374, 89, 23);
		panelResgistro.add(btnCancelar);

		JLabel jLabelPass_1_1 = new JLabel();
		jLabelPass_1_1.setText("Sexo");
		jLabelPass_1_1.setBounds(103, 266, 73, 20);
		panelResgistro.add(jLabelPass_1_1);

		JTextField jTextApellidosRegistro = new JTextField();
		jTextApellidosRegistro.setColumns(10);
		jTextApellidosRegistro.setBounds(185, 126, 86, 20);
		panelResgistro.add(jTextApellidosRegistro);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombreCliente = jTextNombreRegistro.getText();
				String apellidosCliente = jTextApellidosRegistro.getText();
				String dniCliente = textFieldDniRegistro.getText();
				String contraseñaCliente = passwordRegistro.getText();
				String sexoCliente = textFieldSexoRegistro.getText();

				Cliente clienteParaRegistrar = new Cliente();
				clienteParaRegistrar.setNombre(nombreCliente);
				clienteParaRegistrar.setApellidos(apellidosCliente);
				clienteParaRegistrar.setDni(dniCliente);
				clienteParaRegistrar.setContraseña(contraseñaCliente);
				clienteParaRegistrar.setSexo(sexoCliente);

				anadirCliente(clienteParaRegistrar);
			}
		});
		btnNewButton.setBounds(66, 374, 89, 23);
		panelResgistro.add(btnNewButton);

		panelResumenCompra = new JPanel();
		panelResumenCompra.setBackground(Color.WHITE);
		panelResumenCompra.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelResumenCompra);
		panelResumenCompra.setVisible(false);
		panelResumenCompra.setLayout(null);

		JButton botonVolverALogInDesdeRegistro = new JButton("Volver al log in para finalziar la compra");
		botonVolverALogInDesdeRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continuarALogin();
			}
		});
		botonVolverALogInDesdeRegistro.setBounds(442, 11, 321, 64);
		panelResgistro.add(botonVolverALogInDesdeRegistro);

		JLabel labelResumenCompra = new JLabel("RESUMEN DE LA COMPRA");
		labelResumenCompra.setBounds(239, 30, 298, 35);
		labelResumenCompra.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelResumenCompra.add(labelResumenCompra);

		JScrollPane scrollPaneResumenCompra = new JScrollPane();
		scrollPaneResumenCompra.setBounds(10, 93, 764, 237);
		panelResumenCompra.add(scrollPaneResumenCompra);

		tablaResumenCompra = new JTable();
		tablaResumenCompra.setDefaultEditor(Object.class, null);
		scrollPaneResumenCompra.setViewportView(tablaResumenCompra);
		tablaResumenCompra.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPaneResumenCompra.setViewportView(tablaResumenCompra);
		Object[] columnasTablaResumenCompra = { "Horario", "Precio", "Sala", "Pelicula" };

		DefaultTableModel modeloTablaResumenCompra = new DefaultTableModel();
		modeloTablaResumenCompra.setColumnIdentifiers(columnasTablaResumenCompra);
		tablaResumenCompra.setModel(modeloTablaResumenCompra);

		JLabel labelResumenCompraPrecio = new JLabel("");
		labelResumenCompraPrecio.setBounds(39, 361, 191, 101);
		labelResumenCompraPrecio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelResumenCompra.add(labelResumenCompraPrecio);

		panelSeleccionEmision = new JPanel();
		panelSeleccionEmision.setBackground(Color.WHITE);
		panelSeleccionEmision.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelSeleccionEmision);
		panelSeleccionEmision.setLayout(null);
		panelSeleccionEmision.setVisible(false);

		JButton buttonVolverResumenCompra = new JButton("Volver");
		buttonVolverResumenCompra.setBounds(368, 427, 95, 35);
		buttonVolverResumenCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAEleccionCine();
			}

		});
		panelResumenCompra.add(buttonVolverResumenCompra);

		JButton buttonContinuarResumenCompra = new JButton("Finalizar compra");
		buttonContinuarResumenCompra.setBounds(550, 427, 95, 35);
		buttonContinuarResumenCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continuarALogin();
			}

		});
		panelResumenCompra.add(buttonContinuarResumenCompra);

		panelEleccionPelicula = new JPanel();
		panelEleccionPelicula.setBackground(Color.WHITE);
		panelEleccionPelicula.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelEleccionPelicula);
		panelEleccionPelicula.setLayout(null);

		comboBoxPeliculas = new JComboBox<String>();
		comboBoxPeliculas.setBounds(174, 122, 432, 22);
		panelEleccionPelicula.add(comboBoxPeliculas);

		JLabel lblNewLabelPelicula = new JLabel("SELECCIONA LA PELICULA QUE QUIERAS VER");
		lblNewLabelPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelPelicula.setBounds(163, 44, 510, 22);
		panelEleccionPelicula.add(lblNewLabelPelicula);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 189, 736, 231);
		panelSeleccionEmision.add(scrollPane);

		tablaEmisionesCompletas = new JTable();
		tablaEmisionesCompletas.setDefaultEditor(Object.class, null);
		tablaEmisionesCompletas.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPane.setViewportView(tablaEmisionesCompletas);
		Object[] columnasTablaEmisiones = { "Horario", "Precio", "Sala", "Pelicula" };

		 eModel = new DefaultTableModel();
		eModel.setColumnIdentifiers(columnasTablaEmisiones);
		tablaEmisionesCompletas.setModel(eModel);

		comboBoxEmision = new JComboBox<Date>();
		comboBoxEmision.setBounds(215, 80, 306, 29);
		panelSeleccionEmision.add(comboBoxEmision);
		JButton botonAceptarEleccionPeliculas = new JButton("Aceptar");

		comboBoxEleccionCine = new JComboBox<String>();
		comboBoxEleccionCine.setBounds(233, 100, 299, 22);
		panelSeleccionCine.add(comboBoxEleccionCine);

		botonAceptarEleccionPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cineSeleccionado = comboBoxEleccionCine.getSelectedItem().toString();
				mostrarPantallaElecionEmision();
				elegirPelicula();
				tablaEmisionesCompletas.removeAll();
				eModel.setRowCount(0);
			}

		});
		botonAceptarEleccionPeliculas.setBounds(442, 222, 138, 23);
		panelEleccionPelicula.add(botonAceptarEleccionPeliculas);

		JButton botonVolverAEleccionCine = new JButton("Atras");
		botonVolverAEleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAEleccionCine();
			}

		});
		botonVolverAEleccionCine.setBounds(171, 222, 101, 23);
		panelEleccionPelicula.add(botonVolverAEleccionCine);
		panelEleccionPelicula.setVisible(false);

		panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelBienvenida);
		panelBienvenida.setLayout(new BorderLayout(0, 0));

		JLabel LabelFotoBienvenida = new JLabel("");
		panelBienvenida.add(LabelFotoBienvenida, BorderLayout.CENTER);
		addImage(panelBienvenida, LabelFotoBienvenida, 0);

		JButton ButtonFinzalizarSesionEleccionCine = new JButton("Finalizar sesion");
		ButtonFinzalizarSesionEleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarFinalizarSesion();
			}

		});
		ButtonFinzalizarSesionEleccionCine.setBounds(244, 223, 154, 23);
		panelSeleccionCine.add(ButtonFinzalizarSesionEleccionCine);

		JButton ButtonContinuarEleccionCine = new JButton("Continuar");
		ButtonContinuarEleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionCine.setVisible(false);
				panelEleccionPelicula.setVisible(true);

				elegirCine();

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
				añadirCinesComboBox();

			}

		});

		JLabel lblNewLabelEmision = new JLabel("SELECCIONA LA SESION A LA QUE QUIERES IR");
		lblNewLabelEmision.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelEmision.setBounds(181, 22, 445, 29);
		panelSeleccionEmision.add(lblNewLabelEmision);

		JButton ButtonCancelarEmision = new JButton("Cancelar");
		ButtonCancelarEmision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAEleccionPeliculas();
			}

		});
		ButtonCancelarEmision.setBounds(215, 141, 89, 23);
		panelSeleccionEmision.add(ButtonCancelarEmision);

		JButton ButtonSeleccionarEmision = new JButton("Seleccionar");
		ButtonSeleccionarEmision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				elegirFecha(eModel, comboBoxPeliculas.getSelectedItem().toString(),
						comboBoxEleccionCine.getSelectedItem().toString());
			}
		});
		ButtonSeleccionarEmision.setBounds(388, 141, 115, 23);
		panelSeleccionEmision.add(ButtonSeleccionarEmision);

		JButton botonAceptarEmisionCompleta = new JButton("Aceptar");
		botonAceptarEmisionCompleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emisionElegidaPopUp(eModel, tablaEmisionesCompletas, modeloTablaResumenCompra);

			}

			private int emisionElegida(DefaultTableModel eModel, JTable tablaEmisionesCompletas) {

				JFrame frameEmision = new JFrame();
				String[] options = new String[2];
				options[0] = "Cancelar";
				options[1] = "Confirmar";

				String[] datosSeleccionados = new String[4];
				String fechaSeleccionada = "";

				for (int i = 0; i < 4; i++) {
					fechaSeleccionada = (String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), i);
					datosSeleccionados[i] = fechaSeleccionada;

				}

				int ret = JOptionPane.showOptionDialog(frameEmision.getContentPane(), datosSeleccionados,
						"Esta es la emision que usted ha elegido", 0, JOptionPane.INFORMATION_MESSAGE, null, options,
						null);

				return ret;

			}

			private void emisionElegidaPopUp(DefaultTableModel eModel, JTable tablaEmisionesCompletas,
					DefaultTableModel modeloTablaResumenCompra) {

				int ret = emisionElegida(eModel, tablaEmisionesCompletas);

				if (ret == 1) {
					volverAEleccionCine();
					anadirDatosFactura();
					añadirEmisionCompletaTablaResumen(tablaResumenCompra, modeloTablaResumenCompra);
					añadirPrecioTablaResumen(labelResumenCompraPrecio);

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

	public void elegirCine() {
		String cineSeleccionado = comboBoxEleccionCine.getSelectedItem().toString();
		resetComboPeliculas();
		añadirPeliculasComboBox(cineSeleccionado);

	}

	public void elegirPelicula() {
	 peliculaSeleccionada = comboBoxPeliculas.getSelectedItem().toString();
		resetComboEmisiones();
		añadirEmisionesComboBox(peliculaSeleccionada, cineSeleccionado);

	}

	public void elegirFecha(DefaultTableModel model, String peliculaSeleccionada, String cineSeleccionado) {
		 fechaSeleccionada = comboBoxEmision.getSelectedItem().toString();
		añadirEmisionCompletaTabla(model, fechaSeleccionada, peliculaSeleccionada, cineSeleccionado);
	}

	private void añadirPeliculasComboBox(String cineSeleccionado) {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Pelicula> peliculas = gestorBBDD.sacarPeliculasPorCine(cineSeleccionado);
		for (int i = 0; i < peliculas.size(); i++) {
			comboBoxPeliculas.addItem(peliculas.get(i).getNombre());
		}

	}

	private void mostrarPantallaElecionEmision() {
		panelEleccionPelicula.setVisible(false);
		panelSeleccionEmision.setVisible(true);

	}

	private void volverAEleccionCine() {
		panelEleccionPelicula.setVisible(false);
		panelSeleccionEmision.setVisible(false);
		panelSeleccionCine.setVisible(true);
		panelResumenCompra.setVisible(false);
	}

	private void volverAEleccionPeliculas() {

		panelSeleccionEmision.setVisible(false);
		panelEleccionPelicula.setVisible(true);

	}

	private void mostrarVentanaRegistro() {
		panelLogin.setVisible(false);
		panelResgistro.setVisible(true);

	}

	private void continuarALogin() {

		panelLogin.setVisible(true);
		panelResumenCompra.setVisible(false);
		panelResgistro.setVisible(false);

	}

	private void resetComboPeliculas() {
		comboBoxPeliculas.removeAllItems();
	}

	private void resetComboEmisiones() {
		comboBoxEmision.removeAllItems();

	}

	private void añadirEmisionesComboBox(String peliculaSeleccionada, String cineSeleccionado) {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = gestorBBDD.sacarEmisionesPorPeliculas(peliculaSeleccionada, cineSeleccionado);
		for (int i = 0; i < emisiones.size(); i++) {
			comboBoxEmision.addItem(emisiones.get(i).getFecha());
		}

	}



	private void añadirCinesComboBox() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Cine> cines = gestorBBDD.sacarTodosLosCiness();
		for (int i = 0; i < cines.size(); i++) {
			comboBoxEleccionCine.addItem(cines.get(i).getNombre());
		}

	}

	private void añadirEmisionCompletaTabla(DefaultTableModel eModel, String fechaSeleccionada,
			String peliculaSeleccionada, String cineSeleccionado) {

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

	private void anadirDatosFactura() {

		GestorBBDD gestorBBDD = new GestorBBDD();
		
		ArrayList<Emision> emisiones = gestorBBDD.sacarEmisionesPorFecha(fechaSeleccionada, peliculaSeleccionada,
				cineSeleccionado);
		Emision emisionConfirmada = new Emision();
		Pelicula peliculaSeleccionadaFactura = new Pelicula();
		Sala salaSeleccionada = new Sala();
		emisionConfirmada
				.setHorario(LocalTime.parse((String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), 0)));
		emisionConfirmada
				.setPrecio(Integer.parseInt((String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), 1)));
		emisionConfirmada.setSala(salaSeleccionada);
		emisionConfirmada.getSala().setNombre((String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), 2));
		peliculaSeleccionadaFactura.setNombre((String) eModel.getValueAt(tablaEmisionesCompletas.getSelectedRow(), 3));
		emisionConfirmada.setPelicula(peliculaSeleccionadaFactura);

		for (int i = 0; i < emisiones.size(); i++) {
			Emision emision = emisiones.get(i);
			String horaElegida = emision.getHorario().toString();
			int cod_salaElegida = emision.getSala().getCod_sala();

			if (emisiones.get(i).getHorario().toString().equals(horaElegida)
					&& emisiones.get(i).getSala().getCod_sala() == cod_salaElegida) {

				emisionConfirmada.setCod_emision(emision.getCod_emision());
				emisionesConfirmadas.add(emisionConfirmada);
			}

		}
	}

	private void añadirEmisionCompletaTablaResumen(JTable tablaResumenCompra,
			DefaultTableModel modeloTablaResumenCompra) {

		tablaResumenCompra.removeAll();
		modeloTablaResumenCompra.setRowCount(0);

		for (int i = 0; i < emisionesConfirmadas.size(); i++) {
			Emision emisionAñadida = emisionesConfirmadas.get(i);
			String hora = emisionAñadida.getHorario().toString();
			String precio = "" + emisionAñadida.getPrecio();
			String sala = emisionAñadida.getSala().getNombre();
			String pelicula = emisionAñadida.getPelicula().getNombre();
			modeloTablaResumenCompra.addRow(new String[] { hora, precio, sala, pelicula });
		}

	}

	private void añadirPrecioTablaResumen(JLabel labelResumenCompraPrecio) {
		double totalPrecio = 0;
		int i = 0;

		for (i = 0; i < emisionesConfirmadas.size(); i++) {
			Emision emisionPrecio = emisionesConfirmadas.get(i);
			int precio = emisionPrecio.getPrecio();
			totalPrecio = totalPrecio + precio;
		}
		if (i == 2) {
			totalPrecio = totalPrecio * 0.8;
		}
		if (i == 3) {
			totalPrecio = totalPrecio * 0.7;
		}
		if (i == 4) {
			totalPrecio = totalPrecio * 0.6;
		}
		if (i >= 5) {
			totalPrecio = totalPrecio * 0.5;
		}
		String precioFinalString = Double.toString(totalPrecio);
		labelResumenCompraPrecio.setText("Precio:  " + precioFinalString + " €");

	}

	private void anadirCliente(Cliente clienteParaRegistrar) {

		GestorBBDD gestorBBDD = new GestorBBDD();

		gestorBBDD.insertarNuevoCliente(clienteParaRegistrar);
	}

	private void comprobarFinalizarSesion() {
		if (emisionesConfirmadas.isEmpty()) {
			frame.dispose();

		} else
			panelSeleccionCine.setVisible(false);
		panelResumenCompra.setVisible(true);
	}

	private void eleccionFrameLoginPopUp(int eleccionFrameLogin) {

		
		 
	}

	private void comprobarLoginCliente(JTextField textFieldDniLogin, JTextField textFieldContraseñaLogin) {
		GestorBBDD gestorBBDD = new GestorBBDD();
		String dniLogin = textFieldDniLogin.getText();
		String contraseñaLogin = textFieldContraseñaLogin.getText();
		boolean logInCorrecto = gestorBBDD.comprobarCliente(dniLogin, contraseñaLogin);
		if (logInCorrecto==false) {
			JFrame frameLogin = new JFrame();
			String[] options = new String[1];
			options[0] = "Confirmar";

			int eleccionFrameLogin = JOptionPane.showOptionDialog(frameLogin.getContentPane(),
					"Su login incorrecto", "", 0,
					JOptionPane.INFORMATION_MESSAGE, null, options, null);
			eleccionFrameLoginPopUp(eleccionFrameLogin);
		} else {
		 panelLogin.setVisible(false);
		 panelFichero.setVisible(true);
		}
	}
}
