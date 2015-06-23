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
		m = Math.abs(y2 - y1) / Math.abs(x2 - x1);
		System.out.println("M: " + m);
		if (0.0 <= m && m <= 1.0 && (x1 < x2)) {
			imprimirPrimeiroOctante(x1, y1, x2, y2);
		}
		if (1.0 < m && m < Integer.MAX_VALUE && (y1 < y2)) {
			imprimirSegundoOctante(x1, y1, x2, y2);
		}
		if (-1.0 > m && m > -9000 && (y1 < y2)) {
			imprimirTerceiroOctante(x1, y1, x2, y2);
		}
		if (0.0 >= m && m >= -1.0 && (x2 < x1)) {
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
		// System.out.println("x_inc: " + x_inc + ", y_inc: " + y_inc);
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

	void imprimirTerceiroOctante(int x1, int y1, int x2, int y2) {
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
		System.out.println("x: " + X + "," + Y);
		while (X < x2) {
			X += x_inc;
			Y += y_inc;
			setPixel(X, Y);
			System.out.println("x: " + X + "," + Y);
		}
	}

	/**
	 * Adiciona os {@link Ponto}s na lista dos pontos.
	 * 
	 * @param x
	 * @param y
	 */
	private void setPixel(float x, float y) {
		listaDePontos.add(new Ponto(Math.round(x), Math.round(y), 0));
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

	/**
	 * Algoritmo de ponto médio. Verifica se o <code>d</code> é maior que ZERO.
	 * Caso seja maior será incrementado o valor de x e y com <code>incNE</code>
	 * . Caso contrario será incrementado com <code>incE</code>
	 * 
	 * O Primeiro oitante, quarto, quinto e oitavo a largura é maior que o
	 * comprimento. Já o restante é o contrario, o comprimento é maior que a
	 * largura
	 * 
	 * @param x
	 * @param y
	 * @param x2
	 * @param y2
	 */
	public void line(int x, int y, int x2, int y2) {
		int wigth = x2 - x;
		int height = y2 - y;
		int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;

		if (wigth < 0) { 
			dx1 = -1;
		} else if (wigth > 0){
			dx1 = 1;
		}
		
		if (height < 0){
			dy1 = -1;
		} else if (height > 0){
			dy1 = 1;
		}
		
		if (wigth < 0){
			dx2 = -1;
		} else if (wigth > 0)
			dx2 = 1;

		int maior = Math.abs(wigth);
		int menor = Math.abs(height);
		
		if (!(maior > menor)) {
			maior = Math.abs(height);
			menor = Math.abs(wigth);
			if (height < 0)
				dy2 = -1;
			else if (height > 0)
				dy2 = 1;
			dx2 = 0;
		}
		int nummero = maior + 1;
		for (int i = 0; i <= maior; i++) {
			setPixel(x, y);
			nummero += menor;
			if (!(nummero < maior)) {
				nummero -= maior;
				x += dx1;
				y += dy1;
			} else {
				x += dx2;
				y += dy2;
			}
		}
	}

//	public static void main(String[] args) {
//		Retas r = new Retas();
//		r.line(30, 18, 20, 10);
//	}
}
