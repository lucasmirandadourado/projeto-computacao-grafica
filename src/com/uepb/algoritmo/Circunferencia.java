package com.uepb.algoritmo;

public class Circunferencia {

	private int x = 0, y = 0;
	private int raio = 1;

	/**
	 * Definiir as variaveis de decisão, sabendo que a equação de
	 * <code> d = F(xi + 1, yi + 1/2) = a.(xi+1) + b.(yi+1) + c </code>
	 * */
	private double d = 0, d_old = 0, d_new = 0;

	/**
	 * Sendo chamada esse metodo construtor, será definido a
	 * {@link Circunferencia} com o ponto na origem.
	 * 
	 * @param raio
	 */
	public Circunferencia(int xCentro, int yCentro, int raio) {
		this.x = xCentro;
		this.y = yCentro;
		this.raio = raio;
		
//		if (!(x == 0 && y == 0)) {
//			/**
//			 * Deverá ser feito a translação. determinar os pontos. Depois
//			 * deverá ser feita a translação para o ponto de origem.
//			 *
//			 */
//		} else {
			// A circunferencia está na origem!
			// Determina que o y = raio!
			y = raio;
			double p = 1 - raio;
			
			circlePlotPolnts(0, 0, x, y);
			while (x < y) {	
				x++;
				if (p < 0) {
					p += 2*x +1;
				} else {
					y--;
					p+= 2*(x-y)+1;
				}
				circlePlotPolnts(xCentro, yCentro, x, y);
			}
//		}
	}

	/**
	 * A partir do ponto do primeiro oitante, será automaticamente descoberto o
	 * restante dos pontos dos outros oitantes.
	 * 
	 * @param xCenter
	 * @param yCenter
	 * @param x
	 * @param y
	 */
	public void circlePlotPolnts(int xCenter, int yCenter, int x, int y) {
		System.out.print(Double.valueOf(xCenter + x) + "   \t" + Double.valueOf(yCenter + y)+"\n");
		System.out.print(Double.valueOf(xCenter - x) + "   \t" + Double.valueOf(yCenter + y)+"\n");
		System.out.print(Double.valueOf(xCenter + x) + "   \t" + Double.valueOf(yCenter - y)+"\n");
		System.out.print(Double.valueOf(xCenter - x) + "   \t" + Double.valueOf(yCenter - y)+"\n");		
		System.out.print(Double.valueOf(xCenter + y) + "   \t" + Double.valueOf(yCenter + x)+"\n");
		System.out.print(Double.valueOf(xCenter - y) + "   \t" + Double.valueOf(yCenter + x)+"\n");
		System.out.print(Double.valueOf(xCenter + y) + "   \t" + Double.valueOf(yCenter - x)+"\n");
		System.out.print(Double.valueOf(xCenter - y) + "   \t" + Double.valueOf(yCenter - y)+"\n");
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the raio
	 */
	public int getRaio() {
		return raio;
	}

	/**
	 * @param raio
	 *            the raio to set
	 */
	public void setRaio(int raio) {
		this.raio = raio;
	}

	public static void main(String[] args) {
		new Circunferencia(0,0,5);
		
	}
}
