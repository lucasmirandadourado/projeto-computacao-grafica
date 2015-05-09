package com.uepb.algoritmo;

import java.util.ArrayList;
import java.util.List;


/**
 * Algoritmo da {@link Circunferencia} do ponto medio.
 * @author Lucas Miranda
 *
 */
public class Circunferencia {

	int d_old = 0;
	int x, y, raio;
	List<Ponto> listaPontos = new ArrayList<Ponto>();
	
	public Circunferencia(int x, int y, int raio) {
		this.x = x;
		this.y = y;
		
		this.raio = raio;
		d_old = 1 - raio;
	}

	public void ponto_circunferencia() {
		if (x== 0 && y == 0) {
			y = raio;
			listaPontos.add(new Ponto(x, y)); 
			listaPontos.add(new Ponto(y, x));   
			listaPontos.add(new Ponto(-y, y));  
			listaPontos.add(new Ponto(-y, x));  
		}
		while (y > x) {
			if (d_old <= 0.0) {				
				d_old += 2 * x + 3;
				x++;				
			} else {				
				d_old += (2*x) - (2*y) + 5;
				y--;
				x++;
			}
			printPixel(x, y);
		}
	}

	private void printPixel(int x, int y) {
		
		listaPontos.add(new Ponto(x, y)); //
		listaPontos.add(new Ponto(x, -y)); //
		listaPontos.add(new Ponto(-x, y)); //
		listaPontos.add(new Ponto(-x, -y)); //
		
		listaPontos.add(new Ponto(y, x)); 	//	
		listaPontos.add(new Ponto(y, -x));		//
		listaPontos.add(new Ponto(-y, x)); //
		listaPontos.add(new Ponto(-y, -x)); //
		
	}

	/**
	 * @return the listaPontos
	 */
	public List<Ponto> getListaPontos() {
		for (Ponto ponto : listaPontos) {
			System.out.println("["+ponto.x + ", " + ponto.y+"] ");
		}
		return listaPontos;
	}

	/**
	 * @param listaPontos the listaPontos to set
	 */
	public void setListaPontos(List<Ponto> listaPontos) {
		this.listaPontos = listaPontos;
	}

	/**
	 * @return the d_old
	 */
	public double getD_old() {
		d_old = 5 / 4 - raio;		
		return d_old;
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
}
