package com.uepb.view.circunferencia;

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
import com.uepb.algoritmo.transformacoes2D.Operacoes;
import com.uepb.view.PanelPlanoCartesiano;
import com.uepb.view.TelaPrincipal;

public class PanelCircunfTrigonometrica extends JPanel {

	private static final long serialVersionUID = 1L;
	PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	FuncoesDeNormalizacao funcoesDeNormalizacao = new FuncoesDeNormalizacao();
	List<Ponto> pontosCircunferencia;

	private JTextField txtOrigemX;
	private JTextField txtOrigemY;
	private JTextField txtRaio;
	Circunferencia circunferencia;
	private List<Ponto> list;

	public PanelCircunfTrigonometrica() {
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
				circunferencia = new Circunferencia();
				
				circunferencia.circ_trigonometrica(Integer.valueOf(txtOrigemX
						.getText()), Integer.valueOf(txtOrigemY.getText()),
						Integer.valueOf(txtRaio.getText()));
				pontosCircunferencia = circunferencia.getListaPontos();
				panelPlanoCartesiano.limparImagem();
				for (Ponto pontos : circunferencia.getListaPontos()) {
					// Trata os erros, mesmo que o pixel esteja fora do
					// BufferImage!
					try {
						panelPlanoCartesiano.desenharPixel(pontos.getX() + 300,
								-pontos.getY() + 300, Color.GREEN);
					} catch (Exception e) {
						e.getClass();
					}
				}
				TelaPrincipal.panelNormalizacao.repaint();
			}
		});
		
		btnDesenhar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDesenhar.setBounds(25, 134, 232, 41);
		add(btnDesenhar);

		JButton btnLimparTela = new JButton("Limpar tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					circunferencia.getListaPontos().clear();
					getList().clear();
				} catch (Exception e) {
					// TODO: handle exception
				}
				panelPlanoCartesiano.limparImagem();

			}
		});
		btnLimparTela.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLimparTela.setBounds(25, 589, 333, 41);
		add(btnLimparTela);

	}

	/**
	 * @return the list
	 */
	public List<Ponto> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Ponto> list) {
		this.list = list;
	}
}
