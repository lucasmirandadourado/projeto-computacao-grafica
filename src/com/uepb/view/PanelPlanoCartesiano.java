package com.uepb.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;





import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelPlanoCartesiano extends JPanel {

	private static final long serialVersionUID = -5345146477227642140L;
	final static int ALTURA = 600;
	final static int LARGURA = 600;
	private static BufferedImage imagemCoordenadas;
	
	public PanelPlanoCartesiano() {
		setBounds(400,30,LARGURA, ALTURA);
		
		imagemCoordenadas = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_ARGB);
		
		for (int i = 0; i < ALTURA; i++) {
			for (int j = 0; j < LARGURA; j++) {
				imagemCoordenadas.setRGB(i, j, Color.WHITE.getRGB());
				repaint();
			}
		}	
		addCoordenadas();
		setPixel();
	}

	private void setPixel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouse) {
				imagemCoordenadas.setRGB(mouse.getX(), mouse.getY(), Color.BLACK.getRGB() );
				repaint();
			}
		});
	}
	
	public void desenharPixel(int x, int y) {		
		imagemCoordenadas.setRGB(x, y, Color.BLACK.getRGB() );
		repaint();
	}
	
	private void addCoordenadas() {
		int metade = (int) LARGURA/2;
		
		for (int j = 1; j < ALTURA-1; j++) {
			imagemCoordenadas.setRGB(metade, j, Color.BLACK.getRGB());
			repaint();
		}
		metade = (int) ALTURA/2;
		for (int j = 1; j < LARGURA-1; j++) {
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
	 * @param imagemCoordenadas the imagemCoordenadas to set
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
