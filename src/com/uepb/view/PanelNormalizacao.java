package com.uepb.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelNormalizacao extends JPanel {

	PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	
	/**
	 * Create the panel.
	 */
	public PanelNormalizacao() {
		setBackground(Color.DARK_GRAY);
		
		setBounds(0, 0, 1008, 660);
		setLayout(null);
		panelPlanoCartesiano.setBounds(400, 30, 600, 600);
		
		add(panelPlanoCartesiano);
		
		JPanel panelBackgroundCoordenadasDoDispositivo = new JPanel();
		panelBackgroundCoordenadasDoDispositivo.setBackground(Color.LIGHT_GRAY);
		panelBackgroundCoordenadasDoDispositivo.setBounds(0, 30, 358, 41);
		add(panelBackgroundCoordenadasDoDispositivo);
		panelBackgroundCoordenadasDoDispositivo.setLayout(null);
		
		JLabel labelCoordenadasDoDispositivo = new JLabel("Coordenadas do Dispositivo");
		labelCoordenadasDoDispositivo.setForeground(Color.WHITE);
		labelCoordenadasDoDispositivo.setFont(new Font("Century Gothic", Font.BOLD, 20));
		labelCoordenadasDoDispositivo.setBounds(10, 0, 307, 41);
		panelBackgroundCoordenadasDoDispositivo.add(labelCoordenadasDoDispositivo);
		

	}
}
