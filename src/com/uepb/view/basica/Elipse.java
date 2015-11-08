package com.uepb.view.basica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.operacoes2D.ElipseEquacao;
import com.uepb.view.TelaPrincipal;

public class Elipse extends JFrame
{
	private JTextField txtX;
	private JTextField txtY;

	public Elipse() {
		setResizable(false);
		setTitle("Elipse");
		setVisible(true);
		setSize(450, 243);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblElipse = new JLabel("Elipse");
		lblElipse.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
		lblElipse.setBounds(23, 23, 98, 33);
		getContentPane().add(lblElipse);
		
		JLabel lblRaioX = new JLabel("Raio X");
		lblRaioX.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblRaioX.setBounds(23, 82, 46, 14);
		getContentPane().add(lblRaioX);
		
		txtX = new JTextField();
		txtX.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtX.setBounds(23, 107, 86, 20);
		getContentPane().add(txtX);
		txtX.setColumns(10);
		
		JLabel lblRaioY = new JLabel("Raio Y");
		lblRaioY.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblRaioY.setBounds(223, 82, 46, 14);
		getContentPane().add(lblRaioY);
		
		txtY = new JTextField();
		txtY.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtY.setBounds(223, 107, 86, 20);
		getContentPane().add(txtY);
		txtY.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(322, 162, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.planoCartesiano.limparImagem();
				ElipseEquacao ee = new ElipseEquacao();
				int x = Integer.valueOf(txtX.getText());
				int y = Integer.valueOf(txtY.getText());
				ee.midpointElipse(x, y);
				List<Ponto> lista = ee.getListaPontos();
				TelaPrincipal.setLista(lista);
				TelaPrincipal.povoarRetas(lista, Color.BLUE);
				TelaPrincipal.panelNormalizacao.repaint();
				setVisible(false);
			}
		});
		btnOk.setBounds(223, 162, 89, 23);
		getContentPane().add(btnOk);		
		
	}
}
