package interfaceGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelReta extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelReta() {
		setBackground(Color.BLUE);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(0, 0, 1008, 661);
		setLayout(null);
		
		JMenuBar barraDeMenu = new JMenuBar();
		barraDeMenu.setBounds(0, 0, 1008, 21);
		add(barraDeMenu);
		
		JMenu menuPixel = new JMenu("Pixel");
		barraDeMenu.add(menuPixel);
		
		JMenuItem itemMenuPixelENormalizao = new JMenuItem("Pixel e Normaliza\u00E7\u00E3o");
		itemMenuPixelENormalizao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cardLayout = (CardLayout) (TelaPrincipal.cards.getLayout());
				cardLayout.show(TelaPrincipal.cards, "panelPixelNormalizacao");
				
			}
		});
		menuPixel.add(itemMenuPixelENormalizao);
		
		JMenuItem itemMenuReta = new JMenuItem("Reta");
		itemMenuReta.setEnabled(false);
		menuPixel.add(itemMenuReta);
		
		JMenuItem itemMenuPontoMedio = new JMenuItem("Ponto M\u00E9dio");
		menuPixel.add(itemMenuPontoMedio);
	}

}
