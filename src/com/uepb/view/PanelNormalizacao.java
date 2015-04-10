package com.uepb.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class PanelNormalizacao extends JPanel {

	PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	static JLabel labelDCX;
	static JLabel labelDCY;
	
	/**
	 * Create the panel.
	 */
	public PanelNormalizacao() {
		setBackground(Color.DARK_GRAY);
		
		setBounds(0, 0, 1008, 660);
		setLayout(null);
		panelPlanoCartesiano.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent eventoDeMouse) {
				labelDCX.setText("DCX (X): "+Integer.toString(eventoDeMouse.getX() - 300));
				labelDCY.setText("DCY (Y): "+Integer.toString((eventoDeMouse.getY() - 300) * -1));
				repaint();
			}
		});
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
		
		labelDCX = new JLabel("DCX (X): ");
		labelDCX.setForeground(Color.WHITE);
		labelDCX.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelDCX.setBounds(10, 82, 348, 41);
		add(labelDCX);
		
		labelDCY = new JLabel("DCY (Y): ");
		labelDCY.setForeground(Color.WHITE);
		labelDCY.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelDCY.setBounds(10, 113, 348, 41);
		add(labelDCY);
		

	}
}
