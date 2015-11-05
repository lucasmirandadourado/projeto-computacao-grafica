package com.uepb.view;

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
import com.uepb.algoritmo.operacoes3d.Operacoes3D;
import com.uepb.algoritmo.operacoes3d.Ponto3D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class ValoresEscala3D extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	public String x, y, z;
	protected boolean status;
	private JTextField txtZ;

	/**
	 * Create the dialog.
	 * 
	 * @param tipo
	 */
	public ValoresEscala3D() {
		
		setVisible(true);
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

		JLabel lblTranslao = new JLabel("Escala");
		lblTranslao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTranslao.setBounds(10, 16, 102, 40);
		contentPanel.add(lblTranslao);

		setTxtTranslacaoX(new JTextField());
		getTxtTranslacaoX().setText("0");
		getTxtTranslacaoX().setBounds(151, 72, 86, 30);
		contentPanel.add(getTxtTranslacaoX());
		getTxtTranslacaoX().setColumns(10);

		setTxtTranslacaoY(new JTextField());
		getTxtTranslacaoY().setText("0");
		getTxtTranslacaoY().setBounds(151, 118, 86, 30);
		contentPanel.add(getTxtTranslacaoY());
		getTxtTranslacaoY().setColumns(10);

		JLabel lblCisalhamentoEmX = new JLabel("Cisalhamento em X");
		lblCisalhamentoEmX.setBounds(20, 72, 121, 30);
		contentPanel.add(lblCisalhamentoEmX);

		JLabel lblCisalhamentoEmY = new JLabel("Cisalhamento em Y");
		lblCisalhamentoEmY.setBounds(20, 118, 121, 30);
		contentPanel.add(lblCisalhamentoEmY);
		
		JLabel lblCisalhamentoEmZ = new JLabel("Cisalhamento em Z");
		lblCisalhamentoEmZ.setBounds(20, 164, 121, 30);
		contentPanel.add(lblCisalhamentoEmZ);
		
		txtZ = new JTextField();
		txtZ.setText("0");
		txtZ.setColumns(10);
		txtZ.setBounds(151, 164, 86, 30);
		contentPanel.add(txtZ);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				
				x = txtX.getText();
				y = txtY.getText();
				z = txtZ.getText();
				
				List<Ponto3D> listaPontos = escala(Double.valueOf(x), Double.valueOf(y), Double.valueOf(z));	
				
				PanelPlanoCartesiano.add3D(true);
				TelaPrincipal.setListaGLOBAL3D(listaPontos);
				TelaPrincipal.povoar3D(Color.BLUE);
				TelaPrincipal.panelNormalizacao.repaint();
				setVisible(false);
			}

			private List<Ponto3D> escala(Double x, Double y, Double z) {
				List<Ponto3D> lis = new Operacoes3D().escala(TelaPrincipal.getListaGLOBAL3D(), x, y, z); 
				return lis;
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
