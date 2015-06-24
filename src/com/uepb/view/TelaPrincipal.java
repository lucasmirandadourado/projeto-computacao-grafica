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
import javax.swing.ImageIcon;
import java.awt.Dimension;


@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	
	
	PanelReta panelReta;
	PanelCircunferencia panelCircunferencia;
	PanelCircunfTrigonometrica panelCircunfTringo;
	PanelCircunfExplicita panelCircunfExplicita;
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
					frame.setResizable(false);
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
		barraDeMenu.setMaximumSize(new Dimension(2312, 1));
		setJMenuBar(barraDeMenu);
		

		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.setMaximumSize(new Dimension(80, 60));
		mntmHome.setIgnoreRepaint(true);
		mntmHome.setInheritsPopupMenu(true);
		mntmHome.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/uepb/icon/home.png")));
		mntmHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(null);
				setContentPane(contentPane);
				
				getContentPane().add(panelNormalizacao);
				
				validate();
				repaint();
				
			}
		});
		barraDeMenu.add(mntmHome);
		
		JMenu menuCoordenadas = new JMenu("Coordenadas");
		menuCoordenadas.setMaximumSize(new Dimension(90, 60));
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
		
		JMenuItem menuItemNormalizacao = new JMenuItem("Normalização");
		menuCoordenadas.add(menuItemNormalizacao);
		menuItemNormalizacao.setEnabled(false);
		
		menuCoordenadas.add(itemMenuReta);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu mnCircunferencia = new JMenu("Circunferencia");
		mnCircunferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCircunferencia = new PanelCircunferencia();
				getContentPane().removeAll();				
				getContentPane().add(panelCircunferencia);
				validate();
				repaint();
			}
		});
		menuCoordenadas.add(mnCircunferencia);
		
		JMenuItem mntmPontoMedio = new JMenuItem("Ponto medio");
		mntmPontoMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCircunferencia = new PanelCircunferencia();
				getContentPane().removeAll();				
				getContentPane().add(panelCircunferencia);
				validate();
				repaint();
			}
		});
		mnCircunferencia.add(mntmPontoMedio);
		
		JMenuItem mntmEquaoExplicita = new JMenuItem("Equa\u00E7\u00E3o explicita");
		mntmEquaoExplicita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCircunfExplicita = new PanelCircunfExplicita();
				getContentPane().removeAll();				
				getContentPane().add(panelCircunfExplicita);
				validate();
				repaint();
			}
		});
		mnCircunferencia.add(mntmEquaoExplicita);
		
		JMenuItem mntmTrigonometrica = new JMenuItem("Trigonometrica");
		mnCircunferencia.add(mntmTrigonometrica);
		mntmTrigonometrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCircunfTringo = new PanelCircunfTrigonometrica();
				getContentPane().removeAll();				
				getContentPane().add(panelCircunferencia);
				validate();
				repaint();
			}
		});
		menuCoordenadas.add(mntmSair);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		getContentPane().add(panelNormalizacao);
	}
}
