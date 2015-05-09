package com.uepb.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.uepb.algoritmo.Circunferencia;
import com.uepb.algoritmo.Coordenadas;
import com.uepb.algoritmo.FuncoesDeNormalizacao;
import com.uepb.algoritmo.Ponto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCircunferencia extends JPanel {

	private static final long serialVersionUID = 1L;
	PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	FuncoesDeNormalizacao funcoesDeNormalizacao = new FuncoesDeNormalizacao();
	private JTextField txtOrigem;
	private JTextField textField;
	private JTextField txtRaio;
	

	public PanelCircunferencia() {
		setBackground(Color.DARK_GRAY);
		
		setBounds(0, 0, 1008, 660);
		setLayout(null);
	
		panelPlanoCartesiano.setBounds(400, 30, 600, 600);
		
		add(panelPlanoCartesiano);
		
		JPanel panelBackgroundCoordenadasDoDispositivo = new JPanel();
		panelBackgroundCoordenadasDoDispositivo.setBackground(Color.GRAY);
		panelBackgroundCoordenadasDoDispositivo.setBounds(0, 30, 358, 41);
		add(panelBackgroundCoordenadasDoDispositivo);
		panelBackgroundCoordenadasDoDispositivo.setLayout(null);
		
		JLabel labelCoordenadasDeOrigem = new JLabel("Coordenadas da origem");
		labelCoordenadasDeOrigem.setForeground(Color.WHITE);
		labelCoordenadasDeOrigem.setFont(new Font("Century Gothic", Font.BOLD, 18));
		labelCoordenadasDeOrigem.setBounds(10, 0, 307, 41);
		panelBackgroundCoordenadasDoDispositivo.add(labelCoordenadasDeOrigem);
		
		txtOrigem = new JTextField();
		txtOrigem.setBorder(new TitledBorder(null, "X", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtOrigem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOrigem.setText("0");
		txtOrigem.setBounds(25, 82, 63, 41);
		add(txtOrigem);
		txtOrigem.setColumns(10);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(null, "Y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setText("0");
		textField.setBounds(98, 82, 63, 41);
		add(textField);
		textField.setColumns(10);
		
		txtRaio = new JTextField();
		txtRaio.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtRaio.setBorder(new TitledBorder(null, "Raio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtRaio.setText("100");
		txtRaio.setBounds(171, 82, 86, 41);
		add(txtRaio);
		txtRaio.setColumns(10);
		
		JButton btnDesenhar = new JButton("Desenhar");
		btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Circunferencia circunferencia = new Circunferencia(Integer.valueOf(txtOrigem.getText()), Integer.valueOf(txtOrigem.getText()), Integer.valueOf(txtRaio.getText()));
				circunferencia.ponto_circunferencia();
				
				for (Ponto pontos : circunferencia.getListaPontos()) {
					panelPlanoCartesiano.desenharPixel(pontos.getX()+300, pontos.getY()+300);
				}
			}
		});
		btnDesenhar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDesenhar.setBounds(25, 134, 136, 41);
		add(btnDesenhar);
		
		
		
		
	}
}
