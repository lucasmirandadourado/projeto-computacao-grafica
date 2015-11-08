package com.uepb.view;

import javax.swing.JFrame; 
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.operacoes2D.Operacoes;
import com.uepb.algoritmo.operacoes2D.RetasFuncoes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class ReflexaoReta extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Ponto> list;
	
	public ReflexaoReta() {
		setResizable(false);
		setTitle("Reflexão em torno de uma reta");
		setSize(400, 249);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblRotao = new JLabel("Reflexão");
		lblRotao.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
		lblRotao.setBounds(22, 24, 96, 22);
		getContentPane().add(lblRotao);
		
		JLabel lblAntesDeFazer = new JLabel("<html><body>\r\n<p>Antes de fazer qualquer ação, crie um objeto.</p>\r\n</body>\r\n</html>");
		lblAntesDeFazer.setBounds(22, 72, 336, 48);
		getContentPane().add(lblAntesDeFazer);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(269, 154, 89, 23);
		getContentPane().add(btnCancelar);
		
		RetasFuncoes retas =  new RetasFuncoes();
		list = retas.dda(-300, -300, 300, 300);
		TelaPrincipal.povoarRetas(list, Color.RED);
		TelaPrincipal.panelNormalizacao.repaint();
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.planoCartesiano.limparImagem();
				Operacoes op = new Operacoes();
				
					List<Ponto> li = op.reflexaoReta(TelaPrincipal.getLista());
					TelaPrincipal.povoarRetas(list, Color.RED);
					TelaPrincipal.povoarRetas(li, Color.BLUE);
					TelaPrincipal.panelNormalizacao.repaint();
				
				
			}
		});
		btnOk.setBounds(170, 154, 89, 23);
		getContentPane().add(btnOk);
		setVisible(true);
		
	}
}
