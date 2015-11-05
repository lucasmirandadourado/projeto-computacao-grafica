package com.uepb.view.circunferencia;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.uepb.algoritmo.Ponto;
import com.uepb.view.PanelReta;
import com.uepb.view.TelaPrincipal;
import com.uepb.view.basica.Circunferencia;
import com.uepb.view.basica.Quadrado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class CircunferenciaTrigonometrica extends JFrame {
	private JTextField txt_raio;

	public CircunferenciaTrigonometrica() {
		setResizable(false);
		setVisible(true);
		setTitle("Circunferencia Ponto M\u00E9dio");
		setSize(457, 246);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCircunferenciaAlgoritmo = new JLabel("Circunferencia - Algoritmo trigonometrico");
		lblCircunferenciaAlgoritmo.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		lblCircunferenciaAlgoritmo.setBounds(10, 11, 431, 50);
		getContentPane().add(lblCircunferenciaAlgoritmo);
		
		txt_raio = new JTextField();
		txt_raio.setBorder(new TitledBorder(null, "Raio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txt_raio.setBounds(56, 81, 108, 39);
		getContentPane().add(txt_raio);
		txt_raio.setColumns(10);
		
		JButton btnDesenhar = new JButton("Desenhar");
		btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				
				int raio = Integer.valueOf(txt_raio.getText());
				
				TelaPrincipal.getLista().clear();
				
				List<Ponto> listaPontos = new Circunferencia(0, 0, raio).circ_trigonometrica(0, 0, raio);
				
				TelaPrincipal.setLista(listaPontos);
				
				TelaPrincipal.povoarRetas(listaPontos, Color.BLUE);
				TelaPrincipal.panelNormalizacao.repaint();
				
				repaint();
				validate();
				setVisible(false);
			}
		});
		btnDesenhar.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		btnDesenhar.setBounds(173, 147, 125, 30);
		getContentPane().add(btnDesenhar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		btnCancelar.setBounds(308, 147, 125, 30);
		getContentPane().add(btnCancelar);
		
	}
}
