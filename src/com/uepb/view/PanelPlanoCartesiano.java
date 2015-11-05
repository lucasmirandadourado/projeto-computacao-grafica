package com.uepb.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.uepb.algoritmo.Ponto;

public class PanelPlanoCartesiano extends JPanel {

	private static final long serialVersionUID = -5345146477227642140L;
	final static int ALTURA = 600;
	final static int LARGURA = 600;
	private static BufferedImage imagemCoordenadas;

	public List<Ponto> lista = new ArrayList<Ponto>();
	public PanelPlanoCartesiano() {
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent event) {
				
			}
			@Override
			public void mouseDragged(MouseEvent event) {
				int x = event.getPoint().x;
				int y = event.getPoint().y;
				lista.add(new Ponto(x, y, 0));
			}
		});
		setBounds(400, 30, LARGURA, ALTURA);
		imagemCoordenadas = new BufferedImage(LARGURA, ALTURA,
				BufferedImage.TYPE_INT_ARGB);
		limparImagem();
		setPixel();

	}

	/**
	 * Limpa a tela com branco. Ap�s limpar coloca as coordenadas.
	 */
	public void limparImagem() {
		for (int i = 0; i < ALTURA; i++) {
			for (int j = 0; j < LARGURA; j++) {
				imagemCoordenadas.setRGB(i, j, Color.WHITE.getRGB());
				repaint();
			}
		}
		addCoordenadas();
	}

	/**
	 * Adicionando a 3 dimensão.
	 * 
	 * @param dimencao
	 */
	public static void add3D(boolean dimencao) {
		if (dimencao) {
			for (int j = 1; j < LARGURA - 1; j++) {
				imagemCoordenadas.setRGB(j, LARGURA - j, Color.BLACK.getRGB());
			}
		}
	}

	private void setPixel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouse) {
				imagemCoordenadas.setRGB(mouse.getX(), mouse.getY(),
						Color.RED.getRGB());
				repaint();
			}
		});
	}

	public void desenharPixel(int x, int y, Color color) {
		imagemCoordenadas.setRGB(x, y, color.getRGB());
		
		repaint();
	}

	private void addCoordenadas() {
		int metade = (int) LARGURA / 2;

		for (int j = 1; j < ALTURA - 1; j++) {
			imagemCoordenadas.setRGB(metade, j, Color.BLACK.getRGB());
			repaint();
		}
		metade = (int) ALTURA / 2;
		for (int j = 1; j < LARGURA - 1; j++) {
			imagemCoordenadas.setRGB(j, metade, Color.BLACK.getRGB());
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.create();
		g.drawImage(imagemCoordenadas, 0, 0, null);

	}

	/**
	 * @return the imagemCoordenadas
	 */
	public static BufferedImage getImagemCoordenadas() {
		return imagemCoordenadas;
	}

	/**
	 * @param imagemCoordenadas
	 *            the imagemCoordenadas to set
	 */
	public static void setImagemCoordenadas(BufferedImage imagemCoordenadas) {
		PanelPlanoCartesiano.imagemCoordenadas = imagemCoordenadas;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the altura
	 */
	public static int getAltura() {
		return ALTURA;
	}

	/**
	 * @return the largura
	 */
	public static int getLargura() {
		return LARGURA;
	}
}
