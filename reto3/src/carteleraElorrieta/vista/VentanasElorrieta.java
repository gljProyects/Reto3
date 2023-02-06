package carteleraElorrieta.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanasElorrieta {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanasElorrieta window = new VentanasElorrieta();
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
	public VentanasElorrieta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPeliculas = new JPanel();
		panelPeliculas.setBounds(0, 0, 634, 361);
		frame.getContentPane().add(panelPeliculas);
		panelPeliculas.setLayout(null);
		
		JComboBox<String> comboBoxEleccionPelicula = new JComboBox<String>();
		comboBoxEleccionPelicula.setBounds(122, 96, 404, 22);
		panelPeliculas.add(comboBoxEleccionPelicula);
		
		
		
	}
}
