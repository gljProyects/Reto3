package carteleraElorrieta.vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class VentanasCartelera {
	private String[] imagePaths = { "img/logocine.png", "img/cineBilbao.png", "img/cineMadrid.png",
			"img/cinePamplona.png","img/imagenSalir.png" };
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
		frame.setBounds(250, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelEleccionPelicula = new JPanel();
		panelEleccionPelicula.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(panelEleccionPelicula);
		panelEleccionPelicula.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(143, 146, 432, 22);
		panelEleccionPelicula.add(comboBox);
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

		JPanel panelCineBilbao = new JPanel();
		panelCineBilbao.setBounds(20, 43, 246, 175);
		panelSeleccionCine.add(panelCineBilbao);
		panelCineBilbao.setLayout(new BorderLayout(0, 0));

		JLabel LabelFotoCineBilbao = new JLabel("");
		panelCineBilbao.add(LabelFotoCineBilbao, BorderLayout.CENTER);
		addImage(panelCineBilbao, LabelFotoCineBilbao, 1);

		JPanel panelCineMadrid = new JPanel();
		panelCineMadrid.setBounds(279, 43, 264, 175);
		panelSeleccionCine.add(panelCineMadrid);
		panelCineMadrid.setLayout(new BorderLayout(0, 0));

		JLabel LabelFotoCineMadrid = new JLabel("");
		panelCineMadrid.add(LabelFotoCineMadrid, BorderLayout.CENTER);
		addImage(panelCineMadrid, LabelFotoCineMadrid, 2);

		JPanel panelCinePamplona = new JPanel();
		panelCinePamplona.setBounds(553, 43, 221, 175);
		panelSeleccionCine.add(panelCinePamplona);
		panelCinePamplona.setLayout(new BorderLayout(0, 0));

		JLabel LabelFotoCinePamplona = new JLabel("");
		panelCinePamplona.add(LabelFotoCinePamplona, BorderLayout.CENTER);
		addImage(panelCinePamplona, LabelFotoCinePamplona, 3);
		
		JLabel LabelTituloCineBilbao = new JLabel("CINE BILABO");
		LabelTituloCineBilbao.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LabelTituloCineBilbao.setBounds(73, 229, 153, 23);
		panelSeleccionCine.add(LabelTituloCineBilbao);
		
		JLabel LabelTituloCineMadrid = new JLabel("CINE MADRID");
		LabelTituloCineMadrid.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LabelTituloCineMadrid.setBounds(336, 229, 161, 23);
		panelSeleccionCine.add(LabelTituloCineMadrid);
		
		JLabel LabelTituloCinePamplona = new JLabel("CINE PAMPLONA");
		LabelTituloCinePamplona.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LabelTituloCinePamplona.setBounds(574, 229, 200, 23);
		panelSeleccionCine.add(LabelTituloCinePamplona);
		
		JPanel panelSalidaSeleccionCine = new JPanel();
		panelSalidaSeleccionCine.setBounds(304, 300, 216, 160);
		panelSeleccionCine.add(panelSalidaSeleccionCine);
		panelSalidaSeleccionCine.setLayout(new BorderLayout(0, 0));
		
		JLabel LabelFotoSalida = new JLabel("");
		panelSalidaSeleccionCine.add(LabelFotoSalida, BorderLayout.CENTER);
		addImage(panelSalidaSeleccionCine, LabelFotoSalida, 4);
		
		JLabel LabelTituloSalir = new JLabel("SALIR");
		LabelTituloSalir.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LabelTituloSalir.setBounds(375, 466, 97, 23);
		panelSeleccionCine.add(LabelTituloSalir);

		panelBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBienvenida.setVisible(false);
				panelSeleccionCine.setVisible(true);
			}
		});
		
		

	}

	private void addImage(JPanel panel, JLabel label, int i) {
		ImageIcon icon = new ImageIcon(imagePaths[i]);
		Image img = icon.getImage();
		Image resizedImg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
		icon.setImage(resizedImg);
		label.setIcon(icon);
	}
}
