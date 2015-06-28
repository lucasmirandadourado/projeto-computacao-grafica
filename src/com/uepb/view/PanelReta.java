package com.uepb.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.uepb.algoritmo.FuncoesDeNormalizacao;
import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.Retas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelReta extends JPanel {

	private static final long serialVersionUID = 1L;
	static PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	FuncoesDeNormalizacao funcoesDeNormalizacao = new FuncoesDeNormalizacao();
	private static Retas retas = new Retas();
	private static List<Ponto> lista = new ArrayList<Ponto>();

	private JTextField txt_x1;
	private JTextField txt_y1;
	private JTextField txt_x2;
	private JTextField txt_y2;
	
	public int x, y, x2, y2;
	
	public PanelReta() {
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

		txt_x1 = new JTextField();
		txt_x1.setBorder(new TitledBorder(null, "X", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txt_x1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_x1.setText("0");
		txt_x1.setBounds(25, 82, 63, 41);
		add(txt_x1);
		txt_x1.setColumns(10);

		txt_y1 = new JTextField();
		txt_y1.setBorder(new TitledBorder(null, "Y", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txt_y1.setText("0");
		txt_y1.setBounds(98, 82, 63, 41);
		add(txt_y1);
		txt_y1.setColumns(10);

		JPanel panelBackgroundTranslacao = new JPanel();
		panelBackgroundTranslacao.setBackground(Color.GRAY);
		panelBackgroundTranslacao.setBounds(2, 150, 390, 41);
		add(panelBackgroundTranslacao);
		panelBackgroundTranslacao.setLayout(null);

		JLabel labeltranslacao = new JLabel("Coordenadas finais");
		labeltranslacao.setBounds(0, 0, 390, 41);
		panelBackgroundTranslacao.add(labeltranslacao);
		labeltranslacao.setForeground(Color.WHITE);
		labeltranslacao.setFont(new Font("Century Gothic", Font.BOLD, 18));

		txt_x2 = new JTextField();
		txt_x2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "X", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		txt_x2.setText("0");
		txt_x2.setBounds(25, 202, 63, 41);
		add(txt_x2);
		txt_x2.setColumns(10);

		txt_y2 = new JTextField();
		txt_y2.setBorder(new TitledBorder(null, "Y", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txt_y2.setText("0");
		txt_y2.setBounds(98, 202, 63, 41);
		add(txt_y2);
		txt_y2.setColumns(10);

		JPanel panel_algoritmoDDA = new JPanel();
		panel_algoritmoDDA.setBackground(Color.GRAY);
		panel_algoritmoDDA.setBounds(0, 267, 390, 41);
		add(panel_algoritmoDDA);
		panel_algoritmoDDA.setLayout(null);

		JLabel lblAlgoritmoDda = new JLabel("Algoritmo DDA");
		lblAlgoritmoDda.setBounds(0, 0, 390, 41);
		panel_algoritmoDDA.add(lblAlgoritmoDda);
		lblAlgoritmoDda.setForeground(Color.WHITE);
		lblAlgoritmoDda.setFont(new Font("Century Gothic", Font.BOLD, 18));

		JPanel panel_algoritmoPontoMedio = new JPanel();
		panel_algoritmoPontoMedio.setBackground(Color.GRAY);
		panel_algoritmoPontoMedio.setBounds(0, 382, 390, 41);
		add(panel_algoritmoPontoMedio);
		panel_algoritmoPontoMedio.setLayout(null);

		JLabel lblAlgoritmoPontoMedio = new JLabel("Algoritmo Ponto médio");
		lblAlgoritmoPontoMedio.setBounds(0, 0, 390, 41);
		panel_algoritmoPontoMedio.add(lblAlgoritmoPontoMedio);
		lblAlgoritmoPontoMedio.setForeground(Color.WHITE);
		lblAlgoritmoPontoMedio
				.setFont(new Font("Century Gothic", Font.BOLD, 18));

		JButton btnPontoMedio = new JButton("Ponto m\u00E9dio");
		btnPontoMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getLista().clear();
				getRetas().retaPontoMedio(Integer.valueOf(txt_x1.getText()),
						Integer.valueOf(txt_y1.getText()),
						Integer.valueOf(txt_x2.getText()),
						Integer.valueOf(txt_y2.getText()));
				setLista(getRetas().getListaDePontos());
				System.out.println("Lista: "+getRetas().getListaDePontos());
				panelPlanoCartesiano.limparImagem();
				try {
					for (Ponto ponto : getLista()) {
						panelPlanoCartesiano.desenharPixel(ponto.getX() + 300,
								-ponto.getY() + 300);
					}
				} catch (Exception e) {

				}
			}
		});
		btnPontoMedio.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnPontoMedio.setBounds(25, 434, 232, 41);
		add(btnPontoMedio);

		JButton btnDDA = new JButton("DDA");
		btnDDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getLista().clear();
				lista = getRetas().dda(Integer.valueOf(txt_x1.getText()),
						Integer.valueOf(txt_y1.getText()),
						Integer.valueOf(txt_x2.getText()),
						Integer.valueOf(txt_y2.getText()));
				setLista(lista);
				
				panelPlanoCartesiano.limparImagem();
				try {
					for (Ponto ponto : getLista()) {
						panelPlanoCartesiano.desenharPixel(ponto.getX() + 300, -ponto.getY() + 300);
						
					}
				} catch (Exception e) {

				}
			}
		});

		TelaPrincipal.mntmTranslao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Valores(lista, "translacao");				
			}			
		});
		
		TelaPrincipal.mntmEscala.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Valores(lista, "escala");
				
			}
		});
		
		btnDDA.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDDA.setBounds(25, 319, 232, 41);
		add(btnDDA);

		JButton btnLimparTela = new JButton("Limpar tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlanoCartesiano.limparImagem();
			}
		});

		btnLimparTela.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLimparTela.setBounds(25, 589, 232, 41);
		add(btnLimparTela);

	}
	
	/**
	 * @param listaPontos
	 */
	public static void povoarRetas(List<Ponto> listaPontos) {
				
		try {
			for (Ponto ponto : getLista()) {
				panelPlanoCartesiano.desenharPixel(ponto.getX() + 300, -ponto.getY() + 300);
				System.out.println(ponto.getX()+", "+ponto.getY());
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @return the lista
	 */
	public static List<Ponto> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public static void setLista(List<Ponto> lista) {
		PanelReta.lista = lista;
	}

	/**
	 * @return the retas
	 */
	public static Retas getRetas() {
		return retas;
	}

	/**
	 * @param retas the retas to set
	 */
	public static void setRetas(Retas retas) {
		PanelReta.retas = retas;
	}
}
