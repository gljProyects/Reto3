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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class VentanasCartelera {
	private String[] imagePaths = { "img/logocine.png", "img/cineBilbao.png", "img/cineMadrid.png",
			"img/cinePamplona.png", "img/imagenSalir.png" };
	private JFrame frame;
	private JTable tableSeleccionEmision;

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
		frame.setBounds(250, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		

		JPanel panelEleccionPelicula = new JPanel();
		panelEleccionPelicula.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelEleccionPelicula);
		panelEleccionPelicula.setLayout(null);

		JComboBox<String> comboBoxPeliculas = new JComboBox<String>();
		comboBoxPeliculas.setBounds(143, 146, 432, 22);
		panelEleccionPelicula.add(comboBoxPeliculas);

		JLabel lblNewLabelPelicula = new JLabel("SELECCIONA LA PELICULA QUE QUIERAS VER");
		lblNewLabelPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelPelicula.setBounds(156, 113, 510, 22);
		panelEleccionPelicula.add(lblNewLabelPelicula);
		panelEleccionPelicula.setVisible(false);

		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelBienvenida);
		panelBienvenida.setLayout(new BorderLayout(0, 0));

		JLabel LabelFotoBienvenida = new JLabel("");
		panelBienvenida.add(LabelFotoBienvenida, BorderLayout.CENTER);
		addImage(panelBienvenida, LabelFotoBienvenida, 0);

		JPanel panelSeleccionCine = new JPanel();
		panelSeleccionCine.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelSeleccionCine);
		panelSeleccionCine.setLayout(null);
		panelSeleccionCine.setVisible(false);
		
		JComboBox<String> comboBoxEleccionCine = new JComboBox<String>();
		comboBoxEleccionCine.setBounds(334, 95, 299, 22);
		panelSeleccionCine.add(comboBoxEleccionCine);

		JButton ButtonSalirEleccionCine = new JButton("Salir");
		ButtonSalirEleccionCine.setBounds(292, 285, 89, 23);
		panelSeleccionCine.add(ButtonSalirEleccionCine);

		JButton ButtonContinuarEleccionCine = new JButton("Continuar");
		ButtonContinuarEleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionCine.setVisible(false);
				panelEleccionPelicula.setVisible(true);
				// elegirPeliculasCineBilbao(comboBoxPeliculas);
			}
		});
		ButtonContinuarEleccionCine.setBounds(575, 285, 89, 23);
		panelSeleccionCine.add(ButtonContinuarEleccionCine);

		JPanel panelCineBilbao = new JPanel();
		panelCineBilbao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panelSeleccionCine.setVisible(false);
				panelEleccionPelicula.setVisible(true);
				elegirPeliculasCineBilbao(comboBoxPeliculas);

			}

			private void elegirPeliculasCineBilbao(JComboBox<String> comboBoxPeliculas) {
				GestorBBDD gestorBBDD = new GestorBBDD();
				ArrayList<Pelicula> peliculas = gestorBBDD.sacarTodasLasPeliculas();
				for (int i = 0; i < peliculas.size(); i++) {
					comboBoxPeliculas.addItem(peliculas.get(i).getNombre());
				}

			}
		});

		panelBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarEleccionCine();
			}

			private void mostrarEleccionCine() {
				panelBienvenida.setVisible(false);
				panelSeleccionCine.setVisible(true);
				eleccionCines(comboBoxEleccionCine);

			}

			private void eleccionCines(JComboBox<String> comboBoxEleccionCine) {
				GestorBBDD gestorBBDD = new GestorBBDD();
				ArrayList<Cine> cines = gestorBBDD.sacarTodosLosCiness();
				for (int i = 0; i < cines.size(); i++) {
					comboBoxEleccionCine.addItem(cines.get(i).getNombre());
				}

			}
		});
		
		JPanel panelSeleccionEmision = new JPanel();
		panelSeleccionEmision.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelSeleccionEmision);
		panelSeleccionEmision.setLayout(null);

		JLabel lblNewLabelEmision = new JLabel("SELECCIONA LA SESION A LA QUE QUIERES IR");
		lblNewLabelEmision.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelEmision.setBounds(74, 80, 445, 29);
		panelSeleccionEmision.add(lblNewLabelEmision);

		JComboBox<Date> comboBoxEmision = new JComboBox<Date>();
		comboBoxEmision.setBounds(74, 139, 306, 29);
		panelSeleccionEmision.add(comboBoxEmision);

		
		JButton ButtonAceptarEmision = new JButton("Aceptar");
		ButtonAceptarEmision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionEmision.setVisible(false);
				//panelEleccionP.setVisible(true);
				// elegirPeliculasCineBilbao(comboBoxPeliculas);
			}
		});
		ButtonAceptarEmision.setBounds(80, 297, 89, 23);
		panelSeleccionEmision.add(ButtonAceptarEmision);

		JButton ButtonCancelarEmision = new JButton("Cancelar");
		ButtonCancelarEmision.setBounds(243, 297, 89, 23);
		panelSeleccionEmision.add(ButtonCancelarEmision);
		
		JButton ButtonSeleccionarEmision = new JButton("Seleccionar");
		ButtonSeleccionarEmision.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				elegirEmisiones(comboBoxEmision);

			}

			private void elegirEmisiones(JComboBox<Date> comboBoxEmisiones) {
				GestorBBDD gestorBBDD = new GestorBBDD();
				ArrayList<Emision> emisiones = gestorBBDD.sacarTodosLasEmisiones();
				for (int i = 0; i < emisiones.size(); i++) {
					comboBoxEmisiones.addItem(emisiones.get(i).getFecha());
				}

			}
		});
		ButtonSeleccionarEmision.setBounds(80, 245, 89, 23);
		panelSeleccionEmision.add(ButtonSeleccionarEmision);
		
		JScrollPane scrollPaneSeleccionEmision = new JScrollPane();
		scrollPaneSeleccionEmision.setBounds(581, 96, 193, 297);
		panelSeleccionEmision.add(scrollPaneSeleccionEmision);
		
		tableSeleccionEmision = new JTable();
		scrollPaneSeleccionEmision.setViewportView(tableSeleccionEmision);
	}

	private void addImage(JPanel panel, JLabel label, int i) {
		ImageIcon icon = new ImageIcon(imagePaths[i]);
		Image img = icon.getImage();
		Image resizedImg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
		icon.setImage(resizedImg);
		label.setIcon(icon);
	}
}
