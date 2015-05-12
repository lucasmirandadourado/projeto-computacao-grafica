package com.uepb.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.uepb.algoritmo.Circunferencia;
import com.uepb.algoritmo.FuncoesDeNormalizacao;
import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.transformacoes2D.Translacao;

public class PanelCircunferencia extends JPanel {

	private static final long serialVersionUID = 1L;
	PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	FuncoesDeNormalizacao funcoesDeNormalizacao = new FuncoesDeNormalizacao();
	List<Ponto> pontosCircunferencia;

	private JTextField txtOrigemX;
	private JTextField txtOrigemY;
	private JTextField txtRaio;
	private JTextField txt_transl_x;
	private JTextField txt_transl_y;
	Circunferencia circunferencia;
	List<Ponto> list;

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

		txtOrigemX = new JTextField();
		txtOrigemX.setBorder(new TitledBorder(null, "X", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtOrigemX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOrigemX.setText("0");
		txtOrigemX.setBounds(25, 82, 63, 41);
		add(txtOrigemX);
		txtOrigemX.setColumns(10);

		txtOrigemY = new JTextField();
		txtOrigemY.setBorder(new TitledBorder(null, "Y", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtOrigemY.setText("0");
		txtOrigemY.setBounds(98, 82, 63, 41);
		add(txtOrigemY);
		txtOrigemY.setColumns(10);

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
				circunferencia = new Circunferencia(Integer.valueOf(txtOrigemX
						.getText()), Integer.valueOf(txtOrigemY.getText()),
						Integer.valueOf(txtRaio.getText()));
				circunferencia.ponto_circunferencia();
				pontosCircunferencia = circunferencia.getListaPontos();
				panelPlanoCartesiano.limparImagem();
				for (Ponto pontos : circunferencia.getListaPontos()) {
					// Trata os erros, mesmo que o pixel esteja fora do
					// BufferImage!
					try {
						panelPlanoCartesiano.desenharPixel(pontos.getX() + 300,
								-pontos.getY() + 300);
					} catch (Exception e) {
						e.getClass();
					}
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
				try {
					list = tralacao.translacaoCircunferencia(
							pontosCircunferencia,
							Integer.valueOf(txt_transl_x.getText()),
							Integer.valueOf(txt_transl_y.getText()));
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Desenhe o objeto");
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Desenhe o objeto");
					return;
				}
				panelPlanoCartesiano.limparImagem();
				for (Ponto pontos : list) {
					try {
						panelPlanoCartesiano.desenharPixel(pontos.getX() + 300,
								-pontos.getY() + 300);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Desenhe o objeto");
					}
				}
			}
		});
		btnTranslao.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnTranslao.setBounds(25, 310, 232, 41);
		add(btnTranslao);

		JButton btnLimparTela = new JButton("Limpar tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					circunferencia.getListaPontos().clear();
					list.clear();
				} catch (Exception e) {
					// TODO: handle exception
				}
				panelPlanoCartesiano.limparImagem();

			}
		});
		btnLimparTela.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLimparTela.setBounds(25, 485, 232, 41);
		add(btnLimparTela);

	}
}
