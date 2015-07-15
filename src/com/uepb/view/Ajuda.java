package com.uepb.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ajuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Ajuda() {
		setResizable(false);
		setBounds(100, 100, 450, 422);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblSobre = new JLabel("Sobre");
		lblSobre.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		lblSobre.setBounds(22, 22, 86, 31);
		contentPanel.add(lblSobre);

		JLabel lblProjetoDesenvolvidoPelos = new JLabel(
				"<html><head><meta charset='UTF-8'></head><body><p>Projeto desenvolvido pelos alunos: Alcinael Fernandes Daniel Marques e Lucas Miranda. Projeto da cadeira de Computa��o gr�fica orientado pelo professor Robson Pequeno.</p><h4>Atalhos</h4><ul><li>Ctrl + c = Cubo</li><li>Ctrl + e = Cirfunferencia - Algoritmo equa��o explicita</li><li>Ctrl + h = Sobre</li><li>Ctrl + r = Reta</li><li>Ctrl + r = Cirfunferencia - Algoritmo de ponto m�dio</li><li>Ctrl + t = Cirfunferencia - Algoritmo trigonimetrico</li></ul><h5>UEPB</h5></body></html>");
		lblProjetoDesenvolvidoPelos.setMaximumSize(new Dimension(838, 300));
		lblProjetoDesenvolvidoPelos
				.setHorizontalTextPosition(SwingConstants.LEFT);
		lblProjetoDesenvolvidoPelos.setVerticalTextPosition(SwingConstants.TOP);
		lblProjetoDesenvolvidoPelos.setHorizontalAlignment(SwingConstants.LEFT);
		lblProjetoDesenvolvidoPelos
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblProjetoDesenvolvidoPelos.setVerticalAlignment(SwingConstants.TOP);
		lblProjetoDesenvolvidoPelos.setFont(new Font("Segoe UI Light",
				Font.PLAIN, 14));
		lblProjetoDesenvolvidoPelos.setBounds(22, 64, 384, 238);
		contentPanel.add(lblProjetoDesenvolvidoPelos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
