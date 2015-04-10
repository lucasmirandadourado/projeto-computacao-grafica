package com.uepb.algoritmo;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Coordenadas {

	public int x_usuario_max, y_usuario_max, 
		x_usuario_min, y_usuario_min, 
		x_disp, y_disp;
	public double ndc_x = 0.0d, ndc_y = 0.0d;
	private int comprimento, largura;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();	     
	/**
	 * Metodo construtor.
	 *  
	 * 
	 * @param x_min
	 * @param y_min
	 * @param x_max
	 * @param y_max
	 */
	public Coordenadas(int x_min, int y_min, int x_max, int y_max, int wigth, int heigt) { 
		this.x_usuario_min = x_min;
		this.y_usuario_min = y_min;
		this.x_usuario_max = x_max;
		this.y_usuario_max = y_max;
		this.comprimento = wigth;
		this.largura = heigt;
	}
	
	public double ndcx (long x) { 
		ndc_x = Math.subtractExact(x, x_usuario_min) / Math.subtractExact(x_usuario_max, x_usuario_min);
		return ndc_x;
	}
	
	public double ndcy (long y) {
		ndc_y = Math.subtractExact(y, y_usuario_min) / Math.subtractExact(y_usuario_max, y_usuario_min);
		return ndc_y;
	}
	
	public int dcx (double x) {
		int dc_x = Integer.valueOf((int) Math.round((comprimento-1)*ndc_x));
		return dc_x;
	}

	public int dcy (double y) {
		int dc_y = Integer.valueOf((int) Math.round((largura-1) * ndc_y));
		return dc_y;
	}
	
}
