package com.uepb.algoritmo;

import java.util.ArrayList;
import java.util.List;

public class Retas {

	float lenght;
	float X, Y, x_inc, y_inc;
	double m = 0;
	
	List<Ponto> listaDePontos = new ArrayList<Ponto>();

	
	public Retas() {

	}

	/**
	 * Algoritmo do declive. Utiliza-se da equação fundamental da reta (y =
	 * mx+b)
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void dda(int x1, int y1, int x2, int y2) {
		lenght = Math.abs(x2 - x1);
		m = Math.abs(y2-y1)/Math.abs(x2-x1);
		
		if (0.0 <= m && m <= 1.0 && (x1 < x2)) {
			imprimirPrimeiroOctante(x1, y1, x2, y2);
		}
		if (1.0 < m && m < Integer.MAX_VALUE && (y1 < y2)) {
			imprimirSegundoOctante(x1, y1, x2, y2);
		}
		if (-1.0 > m && m > -9000 && (y1<y2)) {
			imprimirTerceiroOctante(x1, y1, x2, y2);
		}
		if (0.0 >= m && m >= -1.0 && (x2<x1)) {
			imprimirQuartoOctante(x1, y1, x2, y2);
		}
		if (0.0 <= m && m <= 1.0 && (x2 < x1)) {
			imprimirQuintoOctante(x1, y1, x2, y2);
		} 
		if (1.0 < m && m < Integer.MAX_VALUE && (y2 < y1)) {
			imprimirSextoOctante(x1, y1, x2, y2);
		}
		if (-1.0 > m && m > -9000 && (y2 < y1)) {
			imprimirSetimoOctante(x1, y1, x2, y2);
		}
		if (0.0 > m && m > -1 && (y2 < y1)) {
			imprimirOitavoOctante(x1, y1, x2, y2);
		}
	}	
	
	private void imprimirOitavoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
		X = x1;
		Y = y1;

		setPixel(X, Y);
		
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
		}
	}

	private void imprimirSetimoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
		X = x1;
		Y = y1;

		setPixel(X, Y);
		
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
		}
	}

	private void imprimirSextoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
		X = x1;
		Y = y1;

		setPixel(X, Y);
		
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
		}
	}

	private void imprimirQuintoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
		X = x1;
		Y = y1;

		setPixel(X, Y);
		
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
		}
	}

	void imprimirQuartoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
		X = x1;
		Y = y1;

		setPixel(X, Y);
		
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
		}
	}

	void imprimirTerceiroOctante(int x1, int y1, int x2, int y2 ) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
		X = x1;
		Y = y1;

		setPixel(X, Y);
		
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
		}
	}

	void imprimirSegundoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
		X = x1;
		Y = y1;

		setPixel(X, Y);
		
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
		}
	}

	void imprimirPrimeiroOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
		X = x1;
		Y = y1;

		setPixel(X, Y);
		
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
		}
	}

	/**
	 * Algoritmo de ponto médio. Verifica se o <code>d</code> é maior que ZERO.
	 * Caso seja maior será incrementado o valor de x e y com <code>incNE</code>
	 * . Caso contrario será incrementado com <code>incE</code>
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void retaPontoMedio(int x1, int y1, int x2, int y2) {
		int dx, dy, incE, incNE, d, x, y;
			
		dx = x2 - x1;
		dy = y2 - y1;
					
		d = 2 * dy - dx;
		incE = 2 * dy;
		incNE = (2 * dy) - (2 * dx);

		x = x1;
		y = y1;
		setPixel(x, y);
		while (x < x2) {
			if (d <= 0) {
				d = d + incE;
				x = x + 1;
			} else {
				d = d + incNE;
				x = x + 1;
				y = y + 1;
			}
			setPixel(x, y);
		}
	
	}

	/**
	 * Adiciona os {@link Ponto}s na lista dos pontos.
	 * 
	 * @param x
	 * @param y
	 */
	private void setPixel(float x, float y) {
		listaDePontos.add(new Ponto(Math.round(x), Math.round(y)));
	}

	/**
	 * @return the listaDePontos
	 */
	public List<Ponto> getListaDePontos() {
		return listaDePontos;
	}

	/**
	 * @param listaDePontos
	 *            the listaDePontos to set
	 */
	public void setListaDePontos(List<Ponto> listaDePontos) {
		this.listaDePontos = listaDePontos;
	}
}
