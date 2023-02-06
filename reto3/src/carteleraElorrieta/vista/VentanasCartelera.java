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

public class VentanasCartelera {
	private String[] imagePaths = { "img/logocine.png", "img/horror.png" };
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
		frame.setBounds(100, 100, 500, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBounds(100, 100, 500, 250);
		frame.getContentPane().add(panelBienvenida);
		panelBienvenida.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		panelBienvenida.add(lblNewLabel, BorderLayout.EAST);
		
		
		
		addImage(panelBienvenida, lblNewLabel, 0);	
		
		panelBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBienvenida.setVisible(false);
			}
		});
		
		JPanel panelSeleccionCine = new JPanel();
		panelSeleccionCine.setBounds(100, 100, 500, 250);
		frame.getContentPane().add(panelSeleccionCine);
		panelSeleccionCine.setLayout(new BorderLayout(0, 0));
		
	}

	private void addImage(JPanel panel, JLabel label, int i) {
		ImageIcon icon = new ImageIcon(imagePaths[i]);
		Image img = icon.getImage();
		Image resizedImg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
		icon.setImage(resizedImg);
		label.setIcon(icon);
	}
}
