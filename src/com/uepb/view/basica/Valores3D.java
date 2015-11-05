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
import com.uepb.algoritmo.operacoes3d.Operacoes3D;
import com.uepb.algoritmo.operacoes3d.Ponto3D;
import com.uepb.view.PanelPlanoCartesiano;
import com.uepb.view.PanelReta;
import com.uepb.view.TelaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class Valores3D extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	public String x, y, z;
	private JTextField txtZ;

	/**
	 * Create the dialog.
	 * 
	 * @param tipo
	 */
	public Valores3D(String tipo) {
		setVisible(true);
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
		lblTranslao.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblTranslao.setBounds(10, 16, 102, 40);
		contentPanel.add(lblTranslao);

		setTxtTranslacaoX(new JTextField());
		getTxtTranslacaoX().setText("10");
		getTxtTranslacaoX().setBounds(164, 72, 105, 30);
		contentPanel.add(getTxtTranslacaoX());
		getTxtTranslacaoX().setColumns(10);

		setTxtTranslacaoY(new JTextField());
		getTxtTranslacaoY().setText("0");
		getTxtTranslacaoY().setBounds(164, 118, 105, 30);
		contentPanel.add(getTxtTranslacaoY());
		getTxtTranslacaoY().setColumns(10);

		JLabel lblTranslaoEmX = new JLabel("Transla\u00E7\u00E3o em X");
		lblTranslaoEmX.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblTranslaoEmX.setBounds(20, 72, 134, 30);
		contentPanel.add(lblTranslaoEmX);

		JLabel lblTranslaoEmY = new JLabel("Transla\u00E7\u00E3o em Y");
		lblTranslaoEmY.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblTranslaoEmY.setBounds(20, 118, 134, 30);
		contentPanel.add(lblTranslaoEmY);
		
		JLabel lblTranslaoEmZ = new JLabel("Transla\u00E7\u00E3o em Z");
		lblTranslaoEmZ.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblTranslaoEmZ.setBounds(20, 164, 134, 30);
		contentPanel.add(lblTranslaoEmZ);
		
		txtZ = new JTextField();
		txtZ.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		txtZ.setText("0");
		txtZ.setColumns(10);
		txtZ.setBounds(164, 164, 105, 30);
		contentPanel.add(txtZ);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				
				int x = Integer.valueOf(txtX.getText());
				int y = Integer.valueOf(txtY.getText()); 
				int z = Integer.valueOf(txtZ.getText());
				
				List<Ponto3D> listaPontos = null;
				if (tipo == "translacao") {					
					listaPontos = translacao(x, y, z);
				}
			
				PanelPlanoCartesiano.add3D(true);
				TelaPrincipal.setListaGLOBAL3D(listaPontos);
				TelaPrincipal.povoar3D(Color.BLUE);
				TelaPrincipal.panelNormalizacao.repaint();
				setVisible(false);
			} 
			/**
			 * @return
			 */
			private List<Ponto3D> translacao(int x, int y, int z) {
				List<Ponto3D> listaPontos = new Operacoes3D().translacaoMulti3D(TelaPrincipal.getListaGLOBAL3D(), x, y, z);
				return listaPontos;
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		txtY.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
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
		txtX.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
	}
}
