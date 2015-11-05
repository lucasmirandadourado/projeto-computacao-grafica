package com.uepb.view.basica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.uepb.algoritmo.operacoes2D.RetasFuncoes;
import com.uepb.view.PanelReta;
import com.uepb.view.TelaPrincipal;

public class Retas extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtX2;
	private JTextField txtY2;

	/**
	 * Create the dialog.
	 */
	public Retas(String tipo) {
		setVisible(true);
		setResizable(false);
		setSize(400, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblRetas = new JLabel("Retas");
		lblRetas.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
		lblRetas.setBounds(20, 24, 155, 30);
		contentPanel.add(lblRetas);

		JLabel lblPontoInicial = new JLabel("Ponto inicial");
		lblPontoInicial.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblPontoInicial.setBounds(20, 91, 131, 14);
		contentPanel.add(lblPontoInicial);

		JLabel lblPontoFinal = new JLabel("Ponto final");
		lblPontoFinal.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblPontoFinal.setBounds(161, 91, 131, 14);
		contentPanel.add(lblPontoFinal);

		txtX = new JTextField();
		txtX.setBorder(new TitledBorder(null, "X", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtX.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		txtX.setBounds(20, 116, 49, 40);
		contentPanel.add(txtX);
		txtX.setColumns(10);

		txtY = new JTextField();
		txtY.setBorder(new TitledBorder(null, "Y", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtY.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		txtY.setBounds(89, 116, 49, 40);
		contentPanel.add(txtY);
		txtY.setColumns(10);

		txtX2 = new JTextField();
		txtX2.setBorder(new TitledBorder(null, "X", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtX2.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		txtX2.setColumns(10);
		txtX2.setBounds(161, 116, 49, 40);
		contentPanel.add(txtX2);

		txtY2 = new JTextField();
		txtY2.setBorder(new TitledBorder(null, "Y", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtY2.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		txtY2.setColumns(10);
		txtY2.setBounds(227, 116, 49, 40);
		contentPanel.add(txtY2);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tipo.equals("dda")) {
					
					TelaPrincipal.setLista(new RetasFuncoes().dda(
							Integer.valueOf(txtX.getText()),
							Integer.valueOf(txtY.getText()),
							Integer.valueOf(txtX2.getText()),
							Integer.valueOf(txtY2.getText())));

					PanelReta.panelPlanoCartesiano.limparImagem();
					TelaPrincipal.povoarRetas(TelaPrincipal.getLista(), Color.BLUE);
				}

				if (tipo.equals("pm")) {
					TelaPrincipal.getLista().clear();
					TelaPrincipal.setLista(new RetasFuncoes()
							.retaPontoMedio(Integer.valueOf(txtX.getText()),
									Integer.valueOf(txtY.getText()),
									Integer.valueOf(txtX2.getText()),
									Integer.valueOf(txtY2.getText())));

					PanelReta.panelPlanoCartesiano.limparImagem();
					TelaPrincipal.povoarRetas(TelaPrincipal.getLista(), Color.BLUE);

				}
				TelaPrincipal.panelNormalizacao.repaint();
				setVisible(false);
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}
}
