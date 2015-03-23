package cg.view;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;

import cg.funcoes.Coordenadas;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class PainelGrade extends JPanel {

	private int x_size, y_size, x_coor = 0, y_coor = 0;
	public BufferedImage img_buffered;
	public boolean grade = true;
	public double x1, y1;
	JLabel lblLblxy;
	Coordenadas c;
	
	
	public PainelGrade(int x_size, int y_size) {
		
		
		setForeground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
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
		/**
		 * AQui, acontecerá um evento que pegará a posição em que o Mouse está e será impresso no JLabel.
		 * 
		 */
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				img_buffered.setRGB(e.getX(), e.getY(), Color.BLUE.getRGB());
				lblLblxy.setText(""+e.getX()+ ", " + e.getY());
				lblLblxy.repaint();
			}
		});
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 10, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 25, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCoordenadasDoMundo = new JLabel("Coordenadas do mundo");
		GridBagConstraints gbc_lblCoordenadasDoMundo = new GridBagConstraints();
		gbc_lblCoordenadasDoMundo.fill = GridBagConstraints.BOTH;
		gbc_lblCoordenadasDoMundo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoordenadasDoMundo.gridx = 1;
		gbc_lblCoordenadasDoMundo.gridy = 1;
		panel.add(lblCoordenadasDoMundo, gbc_lblCoordenadasDoMundo);
		
		JLabel lblCoordenadasDoDispositivo = new JLabel("Coordenadas do dispositivo");
		GridBagConstraints gbc_lblCoordenadasDoDispositivo = new GridBagConstraints();
		gbc_lblCoordenadasDoDispositivo.insets = new Insets(0, 0, 5, 0);
		gbc_lblCoordenadasDoDispositivo.gridx = 3;
		gbc_lblCoordenadasDoDispositivo.gridy = 1;
		panel.add(lblCoordenadasDoDispositivo, gbc_lblCoordenadasDoDispositivo);
		
		lblLblxy = new JLabel("");
		GridBagConstraints gbc_lblLblxy = new GridBagConstraints();
		gbc_lblLblxy.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblxy.gridx = 1;
		gbc_lblLblxy.gridy = 2;
		panel.add(lblLblxy, gbc_lblLblxy);
		
		JLabel lblLblxydispo = new JLabel("");
		GridBagConstraints gbc_lblLblxydispo = new GridBagConstraints();
		gbc_lblLblxydispo.insets = new Insets(0, 0, 5, 0);
		gbc_lblLblxydispo.gridx = 3;
		gbc_lblLblxydispo.gridy = 2;
		panel.add(lblLblxydispo, gbc_lblLblxydispo);
		this.setX_size(x_size);
		this.setY_size(y_size);
	}

	public void desenharUmPixel() {
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				img_buffered.setRGB((int) c.dcx(e.getX()), (int)c.dcy(e.getY()), Color.BLUE.getRGB());
				repaint();
			}			
		});		
	}
	
	public void pintarUmPixel() {
				
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				img_buffered.setRGB((int) c.dcx(e.getX()), (int)c.dcy(e.getY()), Color.BLUE.getRGB());
				updateUI();
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
