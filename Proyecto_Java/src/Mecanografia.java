import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;

public class Mecanografia extends JFrame {

	private JFrame JFrame = new JFrame();
	private JPanel main = new JPanel();
	private JPanel Pprincipal = new JPanel();
	private JPanel practica = new JPanel();
	private JPanel historia = new JPanel();
	private CardLayout cl = new CardLayout();
	private final JButton btnToPrc = new JButton("Modo Practica");
	private JButton btnToHst = new JButton("Modo Historia");
	private final JLabel lblNewLabel = new JLabel("Zona de Pr\u00E1ctica");
	private final JLabel lblZonaDeHistoria = new JLabel("Zona de Historia");
	
	private int JFrame_width;
	private int JFrame_height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mecanografia frame = new Mecanografia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mecanografia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		JFrame_width = getWidth();
		JFrame_height = getHeight();
		setBounds(100, 100, 450, 300);
		main.setLayout(cl);
		
		main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main);
		
		main.add(Pprincipal, "prin");
		Pprincipal.setLayout(null);
		
		btnToPrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(main, "prc");
			}
		});
		btnToPrc.setBounds(137, 106, 150, 57);
		
		Pprincipal.add(btnToPrc);
		btnToHst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(main, "hst");
			}
		});
		
		
		btnToHst.setBounds(137, 174, 150, 57);
		Pprincipal.add(btnToHst);
		main.add(practica, "prc");
		practica.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(128, 72, 180, 36);
		
		practica.add(lblNewLabel);
		main.add(historia, "hst");
		historia.setLayout(null);
		lblZonaDeHistoria.setBounds(131, 87, 148, 25);
		lblZonaDeHistoria.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		historia.add(lblZonaDeHistoria);
		cl.show(main, "prin");
		
		
		
	}
}
