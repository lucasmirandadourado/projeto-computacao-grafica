package cg.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private PainelGrade panel;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtX_1;
	private JTextField txtY_1;
	private int comprimento = 0, altura = 0;

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
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Computa\u00E7\u00E3o Gr\u00E1fica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		comprimento = 700;
		altura = 650;

		panel = new PainelGrade(comprimento, altura);
		panel.setForeground(Color.WHITE);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);

		Panel panel_norte = new Panel();
		getContentPane().add(panel_norte, BorderLayout.NORTH);
		GridBagLayout gbl_panel_norte = new GridBagLayout();
		gbl_panel_norte.columnWidths = new int[] { 168, 0, 0 };
		gbl_panel_norte.rowHeights = new int[] { 24, 0 };
		gbl_panel_norte.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_norte.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_norte.setLayout(gbl_panel_norte);

		JMenuBar menuBar = new JMenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.insets = new Insets(0, 0, 0, 5);
		gbc_menuBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		panel_norte.add(menuBar, gbc_menuBar);

		JMenu mnDesenhar = new JMenu("Desenhar");
		menuBar.add(mnDesenhar);

		JMenuItem mntmRetas = new JMenuItem("Retas");
		mnDesenhar.add(mntmRetas);

		Panel panel_sul = new Panel();
		panel_sul.setBackground(Color.YELLOW);
		getContentPane().add(panel_sul, BorderLayout.SOUTH);

		Label label = new Label(
				"Projeto de interface gr\u00E1fica. Per\u00EDodo 2015.1");
		label.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		panel_sul.add(label);

		JPanel panel_esquerdo = new JPanel();
		getContentPane().add(panel_esquerdo, BorderLayout.WEST);
		GridBagLayout gbl_panel_esquerdo = new GridBagLayout();
		gbl_panel_esquerdo.columnWidths = new int[] { 10, 55, 50, 5, 10, 0 };
		gbl_panel_esquerdo.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_panel_esquerdo.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel_esquerdo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_esquerdo.setLayout(gbl_panel_esquerdo);

		JButton btnPincel = new JButton("");
		btnPincel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.desenharUmPixel();
			}
		});
		btnPincel.setBackground(Color.WHITE);
		btnPincel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnPincel.setBorder(new TitledBorder(null, "Pincel",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnPincel.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/lib/pincel.png")));
		GridBagConstraints gbc_btnPincel = new GridBagConstraints();
		gbc_btnPincel.fill = GridBagConstraints.BOTH;
		gbc_btnPincel.insets = new Insets(0, 0, 5, 5);
		gbc_btnPincel.gridx = 1;
		gbc_btnPincel.gridy = 1;
		panel_esquerdo.add(btnPincel, gbc_btnPincel);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.limpar(comprimento, altura);
				panel.repaint();
				panel.validate();
			}
		});

		JButton btnPixel = new JButton("Pixel");
		btnPixel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 panel.pintarUmPixel();				 
			}
		});
		GridBagConstraints gbc_btnPixel = new GridBagConstraints();
		gbc_btnPixel.insets = new Insets(0, 0, 5, 5);
		gbc_btnPixel.gridx = 2;
		gbc_btnPixel.gridy = 1;
		panel_esquerdo.add(btnPixel, gbc_btnPixel);

		GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
		gbc_btnLimpar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpar.gridx = 3;
		gbc_btnLimpar.gridy = 1;
		panel_esquerdo.add(btnLimpar, gbc_btnLimpar);

		JCheckBox chckbxGrade = new JCheckBox("Grade");
		GridBagConstraints gbc_chckbxGrade = new GridBagConstraints();
		gbc_chckbxGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxGrade.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGrade.gridx = 1;
		gbc_chckbxGrade.gridy = 2;
		panel_esquerdo.add(chckbxGrade, gbc_chckbxGrade);

		chckbxGrade.setSelected(true);
		chckbxGrade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxGrade.isSelected()) {
					panel.coordenadas(comprimento, altura);
					panel.updateUI();
					panel.repaint();
				} else {
					for (int i = 0; i <= panel.getWidth(); i++) {
						panel.limpar(comprimento, altura);
						panel.coordenadas(comprimento, altura);
						panel.repaint();
						panel.validate();
					}
				}
			}
		});

		JLabel lblPontosIniciais = new JLabel("Pontos iniciais");
		lblPontosIniciais.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPontosIniciais = new GridBagConstraints();
		gbc_lblPontosIniciais.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPontosIniciais.gridwidth = 2;
		gbc_lblPontosIniciais.insets = new Insets(0, 0, 5, 5);
		gbc_lblPontosIniciais.gridx = 1;
		gbc_lblPontosIniciais.gridy = 3;
		panel_esquerdo.add(lblPontosIniciais, gbc_lblPontosIniciais);

		txtX = new JTextField();
		txtX.setText("x");
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 1;
		gbc_txtX.gridy = 4;
		panel_esquerdo.add(txtX, gbc_txtX);
		txtX.setColumns(10);

		txtY = new JTextField();
		txtY.setText("y");
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 2;
		gbc_txtY.gridy = 4;
		panel_esquerdo.add(txtY, gbc_txtY);
		txtY.setColumns(10);

		JLabel lblPontosFinals = new JLabel("Pontos finals");
		lblPontosFinals.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPontosFinals = new GridBagConstraints();
		gbc_lblPontosFinals.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPontosFinals.insets = new Insets(0, 0, 5, 5);
		gbc_lblPontosFinals.gridx = 1;
		gbc_lblPontosFinals.gridy = 5;
		panel_esquerdo.add(lblPontosFinals, gbc_lblPontosFinals);

		txtX_1 = new JTextField();
		txtX_1.setText("x2");
		GridBagConstraints gbc_txtX_1 = new GridBagConstraints();
		gbc_txtX_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtX_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX_1.gridx = 1;
		gbc_txtX_1.gridy = 6;
		panel_esquerdo.add(txtX_1, gbc_txtX_1);
		txtX_1.setColumns(10);

		txtY_1 = new JTextField();
		txtY_1.setText("y2");
		GridBagConstraints gbc_txtY_1 = new GridBagConstraints();
		gbc_txtY_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtY_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY_1.gridx = 2;
		gbc_txtY_1.gridy = 6;
		panel_esquerdo.add(txtY_1, gbc_txtY_1);
		txtY_1.setColumns(10);

		JButton btnReta = new JButton("Reta");

		btnReta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setPixel(Integer.valueOf(txtX.getText()),
						Integer.valueOf(txtY.getText()));
				repaint();
			}
		});

		btnReta.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		GridBagConstraints gbc_btnReta = new GridBagConstraints();
		gbc_btnReta.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReta.insets = new Insets(0, 0, 5, 5);
		gbc_btnReta.gridx = 1;
		gbc_btnReta.gridy = 7;
		panel_esquerdo.add(btnReta, gbc_btnReta);
		repaint();

	}
}
