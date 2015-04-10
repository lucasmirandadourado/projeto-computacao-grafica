package com.uepb.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	
	
	PanelReta panelReta;
	PanelPlanoCartesiano planoCartesiano = new PanelPlanoCartesiano();
	PanelNormalizacao panelNormalizacao = new PanelNormalizacao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Interface principal.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 720);
		setLocationRelativeTo(null);
		
		JMenuBar barraDeMenu = new JMenuBar();
		setJMenuBar(barraDeMenu);
		
		JMenu menuCoordenadas = new JMenu("Coordenadas");
		barraDeMenu.add(menuCoordenadas);
		
		JMenuItem itemMenuReta = new JMenuItem("Reta");
		itemMenuReta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelReta = new PanelReta();
				getContentPane().removeAll();
				getContentPane().add(panelReta);
				validate();
				repaint();
			}
		});
		
		JMenuItem menuItemNormalizacao = new JMenuItem("Normaliza\u00E7\u00E3o");
		menuCoordenadas.add(menuItemNormalizacao);
		menuItemNormalizacao.setEnabled(false);
		
		menuCoordenadas.add(itemMenuReta);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		getContentPane().add(panelNormalizacao);
	}
}
