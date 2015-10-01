package com.uepb.view.rotacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.transformacoes2D.Operacoes;
import com.uepb.view.PanelReta;
import com.uepb.view.TelaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ValoresRotacao extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRotacao;
	public String x, y;
	protected boolean status;

	/**
	 * Create the dialog.
	 * 
	 * @param tipo
	 */
	public ValoresRotacao() {

		status = true;
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setAutoRequestFocus(false);

		setBounds(100, 100, 307, 276);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblRotacao = new JLabel("Rota\u00E7\u00E3o");
		lblRotacao.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblRotacao.setBounds(10, 11, 102, 40);
		contentPanel.add(lblRotacao);

		setTxtTranslacaoX(new JTextField());
		getTxtTranslacaoX().setText("0");
		getTxtTranslacaoX().setBounds(151, 75, 86, 30);
		contentPanel.add(getTxtTranslacaoX());
		getTxtTranslacaoX().setColumns(10);

		JLabel lblAngulo = new JLabel("Angulo");
		lblAngulo.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		lblAngulo.setBounds(20, 75, 102, 30);
		contentPanel.add(lblAngulo);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				PanelReta.panelPlanoCartesiano.limparImagem();

				List<Ponto> listaPontos = new ArrayList<Ponto>();
				listaPontos.clear();
				listaPontos = rotacao();
				
				TelaPrincipal.setLista(listaPontos);
				TelaPrincipal.povoarRetas(listaPontos);
				TelaPrincipal.panelNormalizacao.repaint();
				setVisible(false);
				
			}

			private List<Ponto> rotacao() {
				
				List<Ponto> list = new Operacoes().rotacao(Integer.valueOf(txtRotacao.getText()));
				if (list.isEmpty()) {
					System.out.println("Vazia");
				}
				return list;
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status = false;
				setVisible(false);
			}
		});

		cancelButton.setActionCommand("Cancelar");
		buttonPane.add(cancelButton);

	}

	/**
	 * @param txtTranslacaoY
	 *            the txtTranslacaoY to set
	 */
	public void setTxtTranslacaoY(JTextField txtTranslacaoY) {
	}

	/**
	 * @return the txtTranslacaoX
	 */
	public JTextField getTxtTranslacaoX() {
		return txtRotacao;
	}

	/**
	 * @param txtTranslacaoX
	 *            the txtTranslacaoX to set
	 */
	public void setTxtTranslacaoX(JTextField txtTranslacaoX) {
		this.txtRotacao = txtTranslacaoX;
	}
}
