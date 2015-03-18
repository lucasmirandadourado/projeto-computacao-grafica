package cg.view;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import cg.funcoes.Coordenadas;

@SuppressWarnings("serial")
public class PainelGrade extends JPanel {

	private int x_size, y_size, x_coor = 0, y_coor = 0;
	public BufferedImage img_buffered;
	public boolean grade = true;
	public double x1, y1;
	Coordenadas c;
	
	
	public PainelGrade(int x_size, int y_size) {
		this.setX_size(x_size);
		this.setY_size(y_size);
		
		x_coor = (int) x_size/2;
		y_coor = (int) y_size/2;
		
		c = new Coordenadas(-x_coor, -y_coor, x_coor, y_coor, x_size, y_size);
		
		x1 = c.ndcx(x_coor);
		y1 = c.ndcy(y_coor);
		
		try {
			img_buffered = new BufferedImage(x_size, y_size,
					BufferedImage.TYPE_INT_RGB);
			limpar(x_size, y_size);
			grade(x_size, y_size, BufferedImage.TYPE_INT_RGB);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void desenharUmPixel() {
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				img_buffered.setRGB((int) c.dcx(e.getX()), (int)c.dcy(e.getY()), Color.BLACK.getRGB());
				repaint();
			}			
		});		
	}
	
	public void pintarUmPixel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				img_buffered.setRGB((int) c.dcx(e.getX()), (int)c.dcy(e.getY()), Color.BLACK.getRGB());
				repaint();
			}
		});
	}

	public void limpar(int x_size, int y_size) { 
		for (int j = 0; j < y_size; j++) {
			for (int i = 0; i < x_size; i++) {
				img_buffered.setRGB(i, j, Color.WHITE.getRGB());
				repaint();
			}
		}
		coordenadas(x_size, y_size );
	}

	public void coordenadas(int x_size, int y_size) {
		for (int j = 0; j < y_size; j++) {
			img_buffered.setRGB(x_coor, j, Color.RED.getRGB());
			repaint();
		}
		for (int j = 0; j < x_size; j++) {
			try {
				img_buffered.setRGB(j, y_coor, Color.RED.getRGB());
				repaint();	
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
	}

	public void grade(int x_size, int y_size, int k) {
		for (int i = 5; i < x_size; i = i + 15) {
			for (int j = 5; j < y_size; j = j + 15) {
				img_buffered.setRGB(j, j, k);
				img_buffered.setRGB(i, j, k);
				repaint();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {  
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.create();
		g.drawImage(img_buffered, 0, 0, null);
	}

	public void setPixel(int x, int y) { 
		
		try {
			img_buffered.setRGB(x, y, Color.BLACK.getRGB());
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getX_size() {
		return x_size;
	}

	public void setX_size(int x_size) {
		this.x_size = x_size;
	}

	public int getY_size() {
		return y_size;
	}

	public void setY_size(int y_size) {
		this.y_size = y_size;
	}
}
