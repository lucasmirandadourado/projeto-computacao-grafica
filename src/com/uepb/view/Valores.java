package com.uepb.view;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class Valores extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTranslacaoX;
	private JTextField txtTranslacaoY;
	public String x, y;
	protected boolean status;
	public static List<Ponto> lstPontos;

	/**
	 * Create the dialog.
	 * 
	 * @param tipo
	 */
	public Valores(List<Ponto> lista, String tipo) {

		lstPontos = lista;
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

		JLabel lblTranslao = new JLabel("Transla\u00E7\u00E3o");
		lblTranslao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTranslao.setBounds(10, 11, 102, 40);
		contentPanel.add(lblTranslao);

		setTxtTranslacaoX(new JTextField());
		getTxtTranslacaoX().setText("0");
		getTxtTranslacaoX().setBounds(151, 75, 86, 30);
		contentPanel.add(getTxtTranslacaoX());
		getTxtTranslacaoX().setColumns(10);

		setTxtTranslacaoY(new JTextField());
		getTxtTranslacaoY().setText("0");
		getTxtTranslacaoY().setBounds(151, 129, 86, 30);
		contentPanel.add(getTxtTranslacaoY());
		getTxtTranslacaoY().setColumns(10);

		JLabel lblTranslaoEmX = new JLabel("Transla\u00E7\u00E3o em X");
		lblTranslaoEmX.setBounds(20, 75, 102, 30);
		contentPanel.add(lblTranslaoEmX);

		JLabel lblTranslaoEmY = new JLabel("Transla\u00E7\u00E3o em Y");
		lblTranslaoEmY.setBounds(20, 129, 102, 30);
		contentPanel.add(lblTranslaoEmY);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				
				x = txtTranslacaoX.getText();
				y = txtTranslacaoY.getText();
				
				List<Ponto> listaPontos = null;
				if (tipo == "translacao") {
					listaPontos = transla��o();
				}
				if (tipo == "escala") {
					listaPontos = escala();
				}
				PanelReta.setLista(listaPontos);
				TelaPrincipal.povoarRetas(listaPontos);
				setVisible(false);
			}

			private List<Ponto> escala() {
				List<Ponto> listaPontos = new Operacoes().escalaReta(lstPontos,
						Double.valueOf(x), Double.valueOf(y));
				return listaPontos;
			}

			/**
			 * @return
			 */
			private List<Ponto> transla��o() {
				List<Ponto> listaPontos = new Operacoes().translacaoMulti(lstPontos,
						Integer.valueOf(x), Integer.valueOf(y));
				return listaPontos;
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
	 * @return the txtTranslacaoY
	 */
	public JTextField getTxtTranslacaoY() {
		return txtTranslacaoY;
	}

	/**
	 * @param txtTranslacaoY
	 *            the txtTranslacaoY to set
	 */
	public void setTxtTranslacaoY(JTextField txtTranslacaoY) {
		this.txtTranslacaoY = txtTranslacaoY;
	}

	/**
	 * @return the txtTranslacaoX
	 */
	public JTextField getTxtTranslacaoX() {
		return txtTranslacaoX;
	}

	/**
	 * @param txtTranslacaoX
	 *            the txtTranslacaoX to set
	 */
	public void setTxtTranslacaoX(JTextField txtTranslacaoX) {
		this.txtTranslacaoX = txtTranslacaoX;
	}
}
