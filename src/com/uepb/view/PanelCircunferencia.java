package com.uepb.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.uepb.algoritmo.Circunferencia;
import com.uepb.algoritmo.FuncoesDeNormalizacao;
import com.uepb.algoritmo.Ponto;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

public class PanelCircunferencia extends JPanel {

	private static final long serialVersionUID = -4870823813233015151L;

	final static int ALTURA = 600;
	final static int LARGURA = 600;
	private static BufferedImage imagemCoordenadas;

	public PanelCircunferencia() {
		setLayout(new BorderLayout(0, 0));

		setBounds(400, 30, LARGURA, ALTURA);

		imagemCoordenadas = new BufferedImage(LARGURA, ALTURA,
				BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < ALTURA; i++) {
			for (int j = 0; j < LARGURA; j++) {
				imagemCoordenadas.setRGB(i, j, Color.WHITE.getRGB());
				repaint();
			}
		}

		Circunferencia c = new Circunferencia(0, 0, 100);
		c.ponto_circunferencia();
		List<Ponto> lista = new ArrayList<Ponto>();
		lista = c.getListaPontos();
		FuncoesDeNormalizacao normalizar = new FuncoesDeNormalizacao();
		
		for (Ponto ponto : lista) {
			System.out.println(ponto.getX());
			System.out.println(ponto.getY());
			
			imagemCoordenadas.setRGB((int) (ponto.getX()+LARGURA/2), (int) (ponto.getY()+ALTURA/2),
					Color.RED.getRGB());
			repaint();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.create();

		g.drawImage(imagemCoordenadas, 0, 0, null);
	}
}
