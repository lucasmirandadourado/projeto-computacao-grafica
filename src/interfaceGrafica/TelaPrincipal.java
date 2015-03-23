package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	static JPanel cards;
	static PanelPixelNormalizacao panelPixelNormalizacao;
	static PanelReta panelReta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 720);
		
		panelPixelNormalizacao = new PanelPixelNormalizacao();
		
		panelReta = new PanelReta();
		
		cards = new JPanel(new CardLayout());
		cards.add(panelPixelNormalizacao,"panelPixelNormalizacao");
		cards.add(panelReta, "panelReta");
		
		this.getContentPane().add(cards, BorderLayout.CENTER);
	
	}
}
