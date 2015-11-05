package com.uepb.view.cisalhamento;

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
import com.uepb.view.PanelPlanoCartesiano;
import com.uepb.view.PanelReta;
import com.uepb.view.TelaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class ValoresCisalhamento3D extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	public String x, y, z;
	protected boolean status;

	/**
	 * Create the dialog.
	 * @param tipo 
	 * 
	 * @param tipo
	 */
	public ValoresCisalhamento3D(String tipo) {

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

		JLabel lblTranslao = new JLabel("Cisalhamento");
		lblTranslao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTranslao.setBounds(10, 16, 102, 40);
		contentPanel.add(lblTranslao);

		setTxtTranslacaoX(new JTextField());
		getTxtTranslacaoX().setText("0");
		getTxtTranslacaoX().setBounds(189, 72, 86, 30);
		contentPanel.add(getTxtTranslacaoX());
		getTxtTranslacaoX().setColumns(10);

		JLabel lblCisalhamentoEmX = new JLabel("Valor do cisalhamento");
		lblCisalhamentoEmX.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblCisalhamentoEmX.setBounds(20, 72, 159, 30);
		contentPanel.add(lblCisalhamentoEmX);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				
				x = txtX.getText();
				
				List<Ponto3D> listaPontos = null;
				if (tipo.equals("X")) {
					listaPontos = cisalhamentoX(Double.valueOf(x));	
				} 
				
				if (tipo.equals("Y")) { 
					listaPontos = cisalhamentoY(Double.valueOf(x));	
				}
				
				if (tipo.equals("Z")) {
					listaPontos = cisalhamentoZ(Double.valueOf(x));	
				}
				
				PanelPlanoCartesiano.add3D(true);
				TelaPrincipal.setListaGLOBAL3D(listaPontos);
				TelaPrincipal.povoar3D(Color.BLUE);
				TelaPrincipal.panelNormalizacao.repaint();
				setVisible(false);
			}

			private List<Ponto3D> cisalhamentoZ(Double a) {
				List<Ponto3D> lis = new Operacoes3D().cisalhamentoEmZ(TelaPrincipal.getListaGLOBAL3D(), a); 
				return lis;
			}

			private List<Ponto3D> cisalhamentoY(Double a) {
				List<Ponto3D> lis = new Operacoes3D().cisalhamentoEmY(TelaPrincipal.getListaGLOBAL3D(), a); 
				return lis;
			}

			private List<Ponto3D> cisalhamentoX(Double a) {
				List<Ponto3D> lis = new Operacoes3D().cisalhamentoEmX(TelaPrincipal.getListaGLOBAL3D(), a); 
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
	 * @param txtTranslacaoY
	 *            the txtTranslacaoY to set
	 */
	public void setTxtTranslacaoY(JTextField txtTranslacaoY) {
		this.txtX = txtTranslacaoY;
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
		txtX.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}
