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
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Mecanografia extends JFrame {

	private JFrame JFrame = new JFrame();
	private JPanel main = new JPanel();
	private JPanel Pprincipal = new JPanel();
	private JPanel practica = new JPanel();
	private JPanel historia = new JPanel();
	private CardLayout cl = new CardLayout();
	private JButton btnToPrc = new JButton("Modo Practica");
	private JButton btnToHst = new JButton("Modo Historia");
	private final JLabel lblPrcTitle = new JLabel("Zona de Pr\u00E1ctica");
	private final JLabel lblZonaDeHistoria = new JLabel("Zona de Historia");
	private JLabel lblMuestra;
	private JButton btnPrcEmpezar;
	
	private String frase = "buenas tardes por la mañana, es un gran dia y me quiero morir";
	private JTextField txtEscribir;
	private final JLabel lblTimer = new JLabel("");
	private boolean once = true;
	private int segundo = 0, minuto = 0, hora = 0;
	

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
	public void practica() {
		btnPrcEmpezar.setVisible(false);
		lblPrcTitle.setVisible(false);
		lblMuestra.setVisible(true);
		txtEscribir.setVisible(true);
		
		lblMuestra.setText(frase);
			txtEscribir.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(once) {
					new Timer().scheduleAtFixedRate(new TimerTask() {
						@Override
						public void run() {
							lblTimer.setText(hora+":"+minuto+":"+segundo);
							segundo++;
							if(segundo == 60) {
								segundo = 0;
								minuto += 1;
							}
							else if(minuto == 60) {
								minuto = 0;
								hora +=1;
							}
			            }
					}, 0, 1000);
					}
					once = false;
				}
			});
		
		
	}
	
	public Mecanografia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		setBounds(200, 100, 450, 300);
		main.setMinimumSize(new Dimension(100, 100));
		main.setLayout(cl);
		
		main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main);
		
		main.add(Pprincipal, "prin");
		main.setSize(100, 100);
		Pprincipal.setLayout(null);
		
		btnToPrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(main, "prc");
			}
		});
		btnToPrc.setBounds(getWidth() , getHeight(), 150, 57);
		
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
		lblPrcTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrcTitle.setBounds(128, 72, 180, 36);
		
		practica.add(lblPrcTitle);
		
		lblMuestra = new JLabel("Texto de muestra");
		lblMuestra.setVisible(false);
		lblMuestra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMuestra.setBounds(303, 29, 427, 32);
		practica.add(lblMuestra);
		
		btnPrcEmpezar = new JButton("Empezar");
		btnPrcEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				practica();
			}
		});
		btnPrcEmpezar.setBounds(168, 165, 89, 23);
		practica.add(btnPrcEmpezar);
		
		txtEscribir = new JTextField();
		txtEscribir.setVisible(false);
		txtEscribir.setBounds(328, 178, 305, 20);
		practica.add(txtEscribir);
		txtEscribir.setColumns(10);
		lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTimer.setBounds(10, 11, 94, 36);
		
		practica.add(lblTimer);
		main.add(historia, "hst");
		historia.setLayout(null);
		lblZonaDeHistoria.setBounds(131, 87, 148, 25);
		lblZonaDeHistoria.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		historia.add(lblZonaDeHistoria);
		cl.show(main, "prin");
		
		
		
	}
}
