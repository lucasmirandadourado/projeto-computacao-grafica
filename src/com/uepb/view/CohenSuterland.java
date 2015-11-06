/**
 * 
 */
package com.uepb.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.Recorte;
import com.uepb.view.basica.Quadrado;
import com.uepb.view.basica.Retangulo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 *
 */
public class CohenSuterland extends JFrame{
	private JTextField txtX1;
	private JTextField txtY1;
	private JTextField txtX2;
	private JTextField txtY2;

	/**
	 * 
	 */
	public CohenSuterland() {
		setTitle("Cohen-Suterland");
		setSize(500, 350);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCohensuterland = new JLabel("Cohen-Suterland");
		lblCohensuterland.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
		lblCohensuterland.setBounds(28, 29, 173, 33);
		getContentPane().add(lblCohensuterland);
		
		JLabel lblSelecioneAJanela = new JLabel("<html>\r\n<body>\r\n<p>Selecione a janela para fazer o recorte do algoritmo de Cohen-Suterland. </p>\r\n<p>Utilize o Mouse para delimitar os pontos. Ou insira as coordenadas nos campos abaixo.</p>\r\n</body>\r\n</html>\r\n");
		lblSelecioneAJanela.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblSelecioneAJanela.setBounds(28, 73, 430, 64);
		getContentPane().add(lblSelecioneAJanela);
		
		JLabel lblPonto = new JLabel("Ponto 1");
		lblPonto.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblPonto.setBounds(26, 148, 46, 14);
		getContentPane().add(lblPonto);
		
		txtX1 = new JTextField();
		txtX1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtX1.setBounds(28, 173, 86, 20);
		getContentPane().add(txtX1);
		txtX1.setColumns(10);
		
		txtY1 = new JTextField();
		txtY1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtY1.setBounds(124, 173, 86, 20);
		getContentPane().add(txtY1);
		txtY1.setColumns(10);
		
		txtX2 = new JTextField();
		txtX2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtX2.setBounds(28, 229, 86, 20);
		getContentPane().add(txtX2);
		txtX2.setColumns(10);
		
		txtY2 = new JTextField();
		txtY2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtY2.setBounds(124, 229, 86, 20);
		getContentPane().add(txtY2);
		txtY2.setColumns(10);
		
		JLabel lblPonto_2 = new JLabel("Ponto 2");
		lblPonto_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblPonto_2.setBounds(28, 204, 64, 14);
		getContentPane().add(lblPonto_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(354, 277, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recorte recorte = new Recorte();
				
				int x1 = Integer.valueOf(txtX1.getText());
				int y1 = Integer.valueOf(txtY1.getText());
				
				int x2 = Integer.valueOf(txtX2.getText());
				int y2 = Integer.valueOf(txtY2.getText());
				
				List<Ponto> list = new ArrayList<Ponto>();
				Quadrado retangulo = new Quadrado();
				
				list.addAll(retangulo.retangulo(x1, y1, x2, y2));
				
				int x_min = 0;
				int x_max = 0;
				int y_min = 0;
				int y_max = 0;
				
				if (x1 >= x2) {
					x_min = x2;
					x_max = x1;
				} else {
					x_min = x1;
					x_max = x2;
				}
				
				
				if (y1 >= y2) {
					y_max = y1;
					y_min = y2;
				} else {
					y_max = y2;
					y_min = y1;
				}
				TelaPrincipal.planoCartesiano.limparImagem();
				System.out.println(x_min+" "+ x_max+" "+ y_min+" "+ y_max);
				recorte.CohenSutherlandLineClip(TelaPrincipal.getLista().get(0).getX(), TelaPrincipal.getLista().get(0).getY(), 
						TelaPrincipal.getLista().get(TelaPrincipal.getLista().size()-1).getX(), TelaPrincipal.getLista().get(TelaPrincipal.getLista().size()-1).getY(), x_min, x_max, y_min, y_max);
				
				TelaPrincipal.povoarRetas(list, Color.RED);
				TelaPrincipal.panelNormalizacao.repaint();
				setVisible(false);
			}
		});
		btnOk.setBounds(245, 277, 89, 23);
		getContentPane().add(btnOk);
		setVisible(true);
		
	}
}
