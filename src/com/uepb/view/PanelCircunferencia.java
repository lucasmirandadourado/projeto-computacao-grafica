package com.uepb.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.uepb.algoritmo.Circunferencia;
import com.uepb.algoritmo.Coordenadas;
import com.uepb.algoritmo.FuncoesDeNormalizacao;
import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.transformacoes2D.Translacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.UIManager;

public class PanelCircunferencia extends JPanel {

	private static final long serialVersionUID = 1L;
	PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	FuncoesDeNormalizacao funcoesDeNormalizacao = new FuncoesDeNormalizacao();
	List<Ponto> pontosCircunferencia;

	private JTextField txtOrigem;
	private JTextField textField;
	private JTextField txtRaio;
	private JTextField txt_transl_x;
	private JTextField txt_transl_y;

	public PanelCircunferencia() {
		setBackground(Color.DARK_GRAY);

		setBounds(0, 0, 1008, 660);
		setLayout(null);

		panelPlanoCartesiano.setBounds(400, 30, 600, 600);

		add(panelPlanoCartesiano);

		JPanel panelBackgroundCoordenadasDoDispositivo = new JPanel();
		panelBackgroundCoordenadasDoDispositivo.setBackground(Color.GRAY);
		panelBackgroundCoordenadasDoDispositivo.setBounds(0, 30, 390, 41);
		add(panelBackgroundCoordenadasDoDispositivo);
		panelBackgroundCoordenadasDoDispositivo.setLayout(null);

		JLabel labelCoordenadasDeOrigem = new JLabel("Coordenadas da origem");
		labelCoordenadasDeOrigem.setBounds(10, 0, 307, 41);
		panelBackgroundCoordenadasDoDispositivo.add(labelCoordenadasDeOrigem);
		labelCoordenadasDeOrigem.setForeground(Color.WHITE);
		labelCoordenadasDeOrigem.setFont(new Font("Century Gothic", Font.BOLD,
				18));

		txtOrigem = new JTextField();
		txtOrigem.setBorder(new TitledBorder(null, "X", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtOrigem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOrigem.setText("0");
		txtOrigem.setBounds(25, 82, 63, 41);
		add(txtOrigem);
		txtOrigem.setColumns(10);

		textField = new JTextField();
		textField.setBorder(new TitledBorder(null, "Y", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		textField.setText("0");
		textField.setBounds(98, 82, 63, 41);
		add(textField);
		textField.setColumns(10);

		txtRaio = new JTextField();
		txtRaio.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtRaio.setBorder(new TitledBorder(null, "Raio", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtRaio.setText("100");
		txtRaio.setBounds(171, 82, 86, 41);
		add(txtRaio);
		txtRaio.setColumns(10);

		JButton btnDesenhar = new JButton("Desenhar");
		btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Circunferencia circunferencia = new Circunferencia(Integer
						.valueOf(txtOrigem.getText()), Integer
						.valueOf(txtOrigem.getText()), Integer.valueOf(txtRaio
						.getText()));
				circunferencia.ponto_circunferencia();
				pontosCircunferencia = circunferencia.getListaPontos();
				for (Ponto pontos : circunferencia.getListaPontos()) {
					panelPlanoCartesiano.desenharPixel(pontos.getX() + 300,
							pontos.getY() + 300);
				}
			}
		});
		btnDesenhar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDesenhar.setBounds(25, 134, 232, 41);
		add(btnDesenhar);

		JPanel panelBackgroundTranslacao = new JPanel();
		panelBackgroundTranslacao.setBackground(Color.GRAY);
		panelBackgroundTranslacao.setBounds(0, 206, 390, 41);
		add(panelBackgroundTranslacao);
		panelBackgroundTranslacao.setLayout(null);

		JLabel labeltranslacao = new JLabel("Transla\u00E7\u00E3o");
		labeltranslacao.setBounds(10, 0, 390, 41);
		panelBackgroundTranslacao.add(labeltranslacao);
		labeltranslacao.setForeground(Color.WHITE);
		labeltranslacao.setFont(new Font("Century Gothic", Font.BOLD, 18));

		txt_transl_x = new JTextField();
		txt_transl_x.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "X", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		txt_transl_x.setText("0");
		txt_transl_x.setBounds(25, 258, 63, 41);
		add(txt_transl_x);
		txt_transl_x.setColumns(10);

		txt_transl_y = new JTextField();
		txt_transl_y.setBorder(new TitledBorder(null, "Y",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txt_transl_y.setText("0");
		txt_transl_y.setBounds(98, 258, 63, 41);
		add(txt_transl_y);
		txt_transl_y.setColumns(10);

		JButton btnTranslao = new JButton("Transla\u00E7\u00E3o");
		btnTranslao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Translacao tralacao = new Translacao();
				List<Ponto> list = tralacao.translacaoCircunferencia(pontosCircunferencia,
						Integer.valueOf(txt_transl_x.getText()),
						Integer.valueOf(txt_transl_y.getText()));
				
				for (Ponto pontos : list) {
					panelPlanoCartesiano.desenharPixel(pontos.getX() + 300,
							pontos.getY() + 300);
				}
			}
		});
		btnTranslao.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnTranslao.setBounds(25, 310, 232, 41);
		add(btnTranslao);

	}
}
