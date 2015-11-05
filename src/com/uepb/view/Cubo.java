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

import com.uepb.algoritmo.operacoes3d.Cubo3D;
import com.uepb.algoritmo.operacoes3d.Ponto3D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.SwingConstants;

public class Cubo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	public String x, y, z;
	protected boolean status;
	private JTextField txtZ;

	/**
	 * Create the dialog.
	 * @param lista 
	 * 
	 * @param tipo
	 */
	public Cubo() {
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

		JLabel lblTranslao = new JLabel("Crie um cubo");
		lblTranslao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTranslao.setBounds(10, 16, 245, 40);
		contentPanel.add(lblTranslao);

		setTxtTranslacaoX(new JTextField());
		
		getTxtTranslacaoX().setBounds(70, 72, 185, 30);
		contentPanel.add(getTxtTranslacaoX());
		getTxtTranslacaoX().setColumns(10);

		setTxtTranslacaoY(new JTextField());
		
		getTxtTranslacaoY().setBounds(70, 118, 185, 30);
		contentPanel.add(getTxtTranslacaoY());
		getTxtTranslacaoY().setColumns(10);

		JLabel lblX = new JLabel("X:");
		lblX.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblX.setBounds(20, 72, 40, 30);
		contentPanel.add(lblX);

		JLabel lblY = new JLabel("Y:");
		lblY.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblY.setBounds(20, 118, 40, 30);
		contentPanel.add(lblY);
		
		JLabel lblZ = new JLabel("Z:");
		lblZ.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblZ.setBounds(20, 164, 40, 30);
		contentPanel.add(lblZ);
		
		txtZ = new JTextField();
		txtZ.setHorizontalAlignment(SwingConstants.LEFT);
		txtZ.setColumns(10);
		txtZ.setBounds(70, 164, 185, 30);
		contentPanel.add(txtZ);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				
				PanelPlanoCartesiano.add3D(true);
				
				int x = Integer.valueOf(txtX.getText());
				int y = Integer.valueOf(txtY.getText());
				int z = Integer.valueOf(txtZ.getText());
				
				TelaPrincipal.getLista().clear();
				List<Ponto3D> cubo = new Cubo3D().criarCubo(x,y,z);
				
				TelaPrincipal.setListaGLOBAL3D(cubo);
				TelaPrincipal.povoar3D(Color.BLUE); 
				TelaPrincipal.panelNormalizacao.repaint();
				setVisible(false);
				repaint();
				validate();
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
