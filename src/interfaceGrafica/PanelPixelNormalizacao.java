package interfaceGrafica;

import algoritmos.Normalizacao;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.SystemColor;

public class PanelPixelNormalizacao extends JPanel {

	public BufferedImage planoCartesiano;
	public Graphics g;
	static Normalizacao normalizacao = new Normalizacao();

	/**
	 * Create the panel.
	 */
	public PanelPixelNormalizacao() {

		setBackground(SystemColor.controlDkShadow);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(0, 0, 1008, 661);
		setLayout(null);

		JMenuBar barraDeMenu = new JMenuBar();
		barraDeMenu.setBounds(0, 0, 1008, 21);
		add(barraDeMenu);

		JMenu menuPixel = new JMenu("Pixel");
		barraDeMenu.add(menuPixel);

		JMenuItem itemMenuPixelENormalizao = new JMenuItem(
				"Pixel e Normaliza\u00E7\u00E3o");
		itemMenuPixelENormalizao.setEnabled(false);
		menuPixel.add(itemMenuPixelENormalizao);

		JMenuItem itemMenuReta = new JMenuItem("Reta");
		itemMenuReta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CardLayout cardLayout = (CardLayout) (TelaPrincipal.cards
						.getLayout());
				cardLayout.show(TelaPrincipal.cards, "panelReta");

			}
		});
		menuPixel.add(itemMenuReta);

		JMenuItem itemMenuPontoMedio = new JMenuItem("Ponto M\u00E9dio");
		menuPixel.add(itemMenuPontoMedio);

		JLabel labelNDH = new JLabel("ndh: ");
		labelNDH.setForeground(Color.WHITE);
		labelNDH.setBounds(36, 190, 168, 34);
		labelNDH.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		add(labelNDH);

		JLabel labelNDV = new JLabel("ndv: ");
		labelNDV.setForeground(Color.WHITE);
		labelNDV.setBounds(36, 217, 168, 34);
		labelNDV.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		add(labelNDV);

		JPanel panelCoordenadasDoDispositivo = new JPanel();
		panelCoordenadasDoDispositivo.setBackground(Color.GRAY);
		panelCoordenadasDoDispositivo.setBounds(0, 134, 339, 34);
		add(panelCoordenadasDoDispositivo);
		panelCoordenadasDoDispositivo.setLayout(null);

		JLabel labelCoordenadasDoDispositivo = new JLabel(
				"Coordenadas do Dispositivo");
		labelCoordenadasDoDispositivo.setForeground(Color.WHITE);
		labelCoordenadasDoDispositivo.setFont(new Font("Century Gothic",
				Font.BOLD, 20));
		labelCoordenadasDoDispositivo.setBounds(10, 0, 280, 34);
		panelCoordenadasDoDispositivo.add(labelCoordenadasDoDispositivo);

		JLabel labelPixelNormalizacao = new JLabel("Pixel e Normalização");
		labelPixelNormalizacao
				.setFont(new Font("Century Gothic", Font.BOLD, 30));
		labelPixelNormalizacao.setBounds(10, 43, 329, 51);
		add(labelPixelNormalizacao);

		JPanel panelCoordenadasNormalizadas = new JPanel();
		panelCoordenadasNormalizadas.setLayout(null);
		panelCoordenadasNormalizadas.setBackground(Color.GRAY);
		panelCoordenadasNormalizadas.setBounds(0, 270, 339, 34);
		add(panelCoordenadasNormalizadas);

		JLabel labelCoordenadasNormalizadas = new JLabel(
				"Coordenadas Normalizadas");
		labelCoordenadasNormalizadas.setForeground(Color.WHITE);
		labelCoordenadasNormalizadas.setFont(new Font("Century Gothic",
				Font.BOLD, 20));
		labelCoordenadasNormalizadas.setBounds(10, 0, 280, 34);
		panelCoordenadasNormalizadas.add(labelCoordenadasNormalizadas);

		JLabel labelNDCX = new JLabel("ndcx: ");
		labelNDCX.setForeground(Color.WHITE);
		labelNDCX.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		labelNDCX.setBounds(36, 336, 168, 34);
		add(labelNDCX);

		planoCartesiano = new BufferedImage(601, 601,
				BufferedImage.TYPE_INT_RGB);

		JPanel panelBufferedImage = new JPanel() {

			@Override
			public void paintComponent(Graphics g) {

				// Background do BufferedImage de cor branca
				for (int i = 0; i < planoCartesiano.getHeight(); i++) {
					for (int j = 0; j < planoCartesiano.getWidth(); j++) {
						planoCartesiano.setRGB(i, j, Color.WHITE.getRGB());
					}
				}

				// Fazendo a linha das coordenadas x e y
				for (int i = 0; i < planoCartesiano.getHeight(); i++) {
					planoCartesiano.setRGB(i, planoCartesiano.getHeight() / 2,
							Color.BLACK.getRGB());
					planoCartesiano.setRGB(planoCartesiano.getWidth() / 2, i,
							Color.BLACK.getRGB());
				}
				g.drawImage(planoCartesiano, 0, 0, null);

			}
		};

		panelBufferedImage.setBackground(Color.WHITE);
		panelBufferedImage.setBounds(398, 43, 601, 601);
		// Evento de Arrastar Mouse - Exibe as coordenadas nas labels ndh e ndv
		panelBufferedImage.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent eventoDeMouse) {
				labelNDH.setText("ndh (x): "
						+ Integer.toString(eventoDeMouse.getX() - 300));
				labelNDV.setText("ndv (y): "
						+ Integer.toString(((eventoDeMouse.getY() - 300)) * -1));
				labelNDCX.setText("ndcx : "
						+ Float.toString(normalizacao.calcularNDCX(
								eventoDeMouse.getX() - 300, -300, 300)));
				
			}
		});
		add(panelBufferedImage);

	}
}
