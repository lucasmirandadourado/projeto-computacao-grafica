package com.uep.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class TesteInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8760934689051887118L;
	private JPanel contentPane;
	Panel2 novoPanel2;

	PlanoCoordenadas planoCartesiano = new PlanoCoordenadas();	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteInterface frame = new TesteInterface();
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
	public TesteInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCoordenadas = new JMenu("Coordenadas");
		menuBar.add(mnCoordenadas);
		
		JMenuItem mntmPontos = new JMenuItem("Pontos");
		mntmPontos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				novoPanel2 = new Panel2();
				getContentPane().removeAll();
				getContentPane().add(novoPanel2);
				validate();
				repaint();
			}
		});
		
		mnCoordenadas.add(mntmPontos);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		getContentPane().add(planoCartesiano);
	}

}
