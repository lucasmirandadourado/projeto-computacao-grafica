package com.uepb.view.basica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import com.uepb.algoritmo.Ponto;
import com.uepb.view.PanelReta;
import com.uepb.view.TelaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class Retangulo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	public String x, y;
	protected boolean status;
	public static List<Ponto> lstPontos;

	/**
	 * Create the dialog.
	 * @param lista 
	 * 
	 * @param tipo
	 */
	public Retangulo() {
		status = true;
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setAutoRequestFocus(false);

		setSize(307, 276);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTranslao = new JLabel("Crie um quadrado.");
		lblTranslao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTranslao.setBounds(10, 11, 245, 40);
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

		JLabel lblTranslaoEmX = new JLabel("Largura:");
		lblTranslaoEmX.setBounds(20, 75, 102, 30);
		contentPanel.add(lblTranslaoEmX);

		JLabel lblTranslaoEmY = new JLabel("Comprimento:");
		lblTranslaoEmY.setBounds(20, 129, 102, 30);
		contentPanel.add(lblTranslaoEmY);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				
				x = txtX.getText();
				y = txtY.getText();
				
				TelaPrincipal.getLista().clear();
				
				List<Ponto> listaPontos = new Quadrado().quadrado(Integer.valueOf(x), Integer.valueOf(y));
				
				TelaPrincipal.setLista(listaPontos);
				
				TelaPrincipal.povoarRetas(listaPontos, Color.BLUE);
				TelaPrincipal.panelNormalizacao.repaint();
				
				repaint();
				validate();
				setVisible(false);
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
		return txtY;
	}

	/**
	 * @param txtTranslacaoY
	 *            the txtTranslacaoY to set
	 */
	public void setTxtTranslacaoY(JTextField txtTranslacaoY) {
		this.txtY = txtTranslacaoY;
	}

	/**
	 * @return the txtTranslacaoX
	 */
	public JTextField getTxtTranslacaoX() {
		return txtX;
	}

	/**
	 * @param txtTranslacaoX
	 *            the txtTranslacaoX to set
	 */
	public void setTxtTranslacaoX(JTextField txtTranslacaoX) {
		this.txtX = txtTranslacaoX;
	}
}
