package com.uepb.algoritmo.operacoes2D;

import java.util.ArrayList;
import java.util.List;

import com.uepb.algoritmo.Ponto;

public class RetasFuncoes {

	double lenght;
	double X, Y, x_inc, y_inc;
	double media = 0.0;

	List<Ponto> listaDePontos = new ArrayList<Ponto>();

	public RetasFuncoes() {

	}

	/**
	 * Algoritmo do declive. Utiliza-se da equção fundamental da reta (y = mx+b)
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public List<Ponto> dda(int x1, int y1, int x2, int y2) {
		lenght = Math.abs(x2 - x1);
		media = (double) (Math.abs(y2 - y1)) / (double) (Math.abs(x2 - x1));

		if (0.0 <= media && media <= 1.0 && (x1 < x2)) {
			imprimirPrimeiroOctante(x1, y1, x2, y2);
		}
		if (1.0 < media && media <= Double.POSITIVE_INFINITY && (y1 < y2)) {
			imprimirSegundoOctante(x1, y1, x2, y2);
		}
		if (-1.0 > media && media > Double.NEGATIVE_INFINITY && (y1 < y2)) {
			imprimirTerceiroOctante(x1, y1, x2, y2);
		}
		if (0.0 >= media && media >= -1.0 && (x2 < x1)) {
			imprimirQuartoOctante(x1, y1, x2, y2);
		}
		if (0.0 <= media && media <= 1.0 && (x2 < x1)) {
			imprimirQuintoOctante(x1, y1, x2, y2);
		}
		if (1.0 < media && media <= Double.POSITIVE_INFINITY && (y2 < y1)) {
			imprimirSextoOctante(x1, y1, x2, y2);
		}
		if (-1.0 > media && media >= Double.NEGATIVE_INFINITY && (y2 < y1)) {
			imprimirSetimoOctante(x1, y1, x2, y2);
		}
		if (0.0 > media && media > -1 && (y2 < y1)) {
			imprimirOitavoOctante(x1, y1, x2, y2);
		}
		return listaDePontos;
	}

	private void imprimirOitavoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
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
		X = x1;
		Y = y1;

		setPixel(X, Y);

		if (X == x2) {
			while (Y > y2) {

				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		} else if (X > x2) {
			while (Y > y2) {

				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		} else {
			while (X <= x2) {
				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		}
	}

	private void imprimirSextoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		X = x1;
		Y = y1;

		setPixel(X, Y);
		if (X == x2) {
			while (Y > y2) {
				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		} else if (X > x2) {
			while (Y > y2) {
				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		} else {
			while (X <= x2) {
				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		}
	}

	private void imprimirQuintoOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
		X = x1;
		Y = y1;

		setPixel(X, Y);
		while (X > x2) {
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
		x_inc = (double) (x2 - x1) / lenght;
		y_inc = (double) (y2 - y1) / lenght;

		X = x1;
		Y = y1;
		setPixel(X, Y);
		if (X == x2) {
			while (Y <= y2) {
				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		} else if (X < 0 && x2 < 0) {
			while (X >= x2) {
				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		} else {
			while (X <= x2) {
				X += x_inc;
				Y += y_inc;
				setPixel(X, Y);
			}
		}

	}

	void imprimirPrimeiroOctante(int x1, int y1, int x2, int y2) {
		if (lenght <= Math.abs(y2 - y1)) {
			lenght = Math.abs(y2 - y1);
		}
		x_inc = (x2 - x1) / lenght;
		y_inc = (y2 - y1) / lenght;
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
	 * Adiciona os {@link Ponto}s na lista dos pontos.
	 * 
	 * @param x
	 * @param y
	 */
	private void setPixel(double x, double y) {
		listaDePontos
				.add(new Ponto((int) Math.round(x), (int) Math.round(y), 0));
		
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
	 * comprimento. Já o restante é o contrário, o comprimento é maior que a
	 * largura
	 * 
	 * @param x
	 * @param y
	 * @param x2
	 * @param y2
	 */
	public List<Ponto> retaPontoMedio(int x, int y, int x2, int y2) {
		int wigth = x2 - x;
		int height = y2 - y;
		int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;

		if (wigth < 0) {
			dx1 = -1;
		} else if (wigth > 0) {
			dx1 = 1;
		}

		if (height < 0) {
			dy1 = -1;
		} else if (height > 0) {
			dy1 = 1;
		}

		if (wigth < 0) {
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
		return listaDePontos;
	}
}
