package com.uepb.view;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import com.uepb.algoritmo.FuncoesDeNormalizacao;

import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PanelNormalizacao extends JPanel {

	PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	FuncoesDeNormalizacao funcoesDeNormalizacao = new FuncoesDeNormalizacao();
	
	static JLabel labelDCX;
	static JLabel labelDCY;
	static JLabel labelNDCX;
	static JLabel labelNDCY;
	static JLabel lblY;
	static JLabel lblX;
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
				
				int dcx = eventoDeMouse.getX() - 300;
				int dcy = (eventoDeMouse.getY() - 300) * -1;
				
				double ndcx = funcoesDeNormalizacao.calcularNDCX(panelPlanoCartesiano.LARGURA, dcx);
				double ndcy = funcoesDeNormalizacao.calcularNDCX(panelPlanoCartesiano.ALTURA, dcy);
				
				labelNDCX.setText("ndcx : "+String.format("%.4f", ndcx));
				labelNDCY.setText("ndcy : "+String.format("%.4f", ndcy));
				
				labelDCX.setText("dcx (x): "+Integer.toString(funcoesDeNormalizacao.calcularDCX(600, ndcx)));
				labelDCY.setText("dcy (y): "+Integer.toString(funcoesDeNormalizacao.calcularDCY(600, ndcy)));
								
				lblX.setText("x: "+Integer.valueOf(dcx));
				lblY.setText("y: "+Integer.valueOf(dcy));
				
				repaint();
			}
		});
		panelPlanoCartesiano.setBounds(400, 30, 600, 600);
		
		add(panelPlanoCartesiano);
		
		JPanel panelBackgroundCoordenadasDoDispositivo = new JPanel();
		panelBackgroundCoordenadasDoDispositivo.setBackground(Color.GRAY);
		panelBackgroundCoordenadasDoDispositivo.setBounds(0, 30, 358, 41);
		add(panelBackgroundCoordenadasDoDispositivo);
		panelBackgroundCoordenadasDoDispositivo.setLayout(null);
		
		JLabel labelCoordenadasDoDispositivo = new JLabel("Coordenadas do Dispositivo");
		labelCoordenadasDoDispositivo.setForeground(Color.WHITE);
		labelCoordenadasDoDispositivo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		labelCoordenadasDoDispositivo.setBounds(10, 0, 307, 41);
		panelBackgroundCoordenadasDoDispositivo.add(labelCoordenadasDoDispositivo);
		
		labelDCX = new JLabel("dcx (x): ");
		labelDCX.setForeground(Color.WHITE);
		labelDCX.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelDCX.setBounds(10, 82, 348, 41);
		add(labelDCX);
		
		labelDCY = new JLabel("dcy (y): ");
		labelDCY.setForeground(Color.WHITE);
		labelDCY.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelDCY.setBounds(10, 113, 348, 41);
		add(labelDCY);
		
		JPanel panelBackgroundCoordenadasDoDispositivoNormalizada = new JPanel();
		panelBackgroundCoordenadasDoDispositivoNormalizada.setLayout(null);
		panelBackgroundCoordenadasDoDispositivoNormalizada.setBackground(Color.GRAY);
		panelBackgroundCoordenadasDoDispositivoNormalizada.setBounds(0, 186, 358, 41);
		add(panelBackgroundCoordenadasDoDispositivoNormalizada);
		
		JLabel labelNormalizacaoDoDispositivo = new JLabel("Normaliza\u00E7\u00E3o do dispositivo");
		labelNormalizacaoDoDispositivo.setForeground(Color.WHITE);
		labelNormalizacaoDoDispositivo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		labelNormalizacaoDoDispositivo.setBounds(10, 0, 307, 41);
		panelBackgroundCoordenadasDoDispositivoNormalizada.add(labelNormalizacaoDoDispositivo);
		
		labelNDCX = new JLabel("ndcx: ");
		labelNDCX.setForeground(Color.WHITE);
		labelNDCX.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelNDCX.setBounds(10, 238, 348, 41);
		add(labelNDCX);
		
		labelNDCY = new JLabel("ndcy: ");
		labelNDCY.setForeground(Color.WHITE);
		labelNDCY.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelNDCY.setBounds(10, 270, 348, 41);
		add(labelNDCY);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 343, 358, 41);
		add(panel);
		
		JLabel lblCoordenadasDoDispositivo = new JLabel("Coordenadas do dispositivo");
		lblCoordenadasDoDispositivo.setForeground(Color.WHITE);
		lblCoordenadasDoDispositivo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblCoordenadasDoDispositivo.setBounds(10, 0, 307, 41);
		panel.add(lblCoordenadasDoDispositivo);
		
		lblX = new JLabel("x: ");
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblX.setBounds(10, 395, 348, 41);
		add(lblX);
		
		lblY = new JLabel("y: ");
		lblY.setForeground(Color.WHITE);
		lblY.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblY.setBounds(10, 427, 348, 41);
		add(lblY);
		

	}
}