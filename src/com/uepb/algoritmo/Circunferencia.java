package com.uepb.algoritmo;

import java.util.ArrayList; 
import java.util.List;

import com.uepb.algoritmo.transformacoes2D.Operacoes;


/**
 * Algoritmo da {@link Circunferencia} do ponto medio.
 * @author Lucas Miranda
 *
 */
public class Circunferencia {

	int d_old = 0;
	int x, y, raio, x_dif, y_dif;
	List<Ponto> listaPontos = new ArrayList<Ponto>();
	Operacoes operacoes = new Operacoes();
	
	public Circunferencia() {
		// TODO Auto-generated constructor stub
	}
	
	public Circunferencia(int x, int y, int raio) {
		this.x = x;
		this.y = y;		
		this.raio = raio;
	}

	public void circunferenciaPontoMedio() {
		boolean trans = false;
		if(x!=0 || y!=0) {
			trans = true;
			x_dif = x;
			y_dif = y;
			x=0;
			y=0;
		}
		if (x== 0 && y == 0) {
			y = raio;
			d_old = 1 - raio;
			listaPontos.add(new Ponto(0, 0, 0));
			listaPontos.add(new Ponto(x, y, 0)); 
			listaPontos.add(new Ponto(y, x, 0));   
			listaPontos.add(new Ponto(-y, x, 0));  
			listaPontos.add(new Ponto(-y, x, 0));  
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
		
		if (trans) {
			listaPontos = operacoes.translacaoMulti(listaPontos, x_dif, y_dif);
		}
	}

	public List<Ponto> circ_explicita(int x, int y, int raio) {
		listaPontos.clear();
		
		for (int i = -raio; i < raio; i++) {
			listaPontos.add(new Ponto(i, (int) Math.sqrt(raio*raio - i*i), 0));
			listaPontos.add(new Ponto(i, -1*(int) Math.sqrt(raio*raio - i*i), 0));
		}
		imprimirLista();
		return listaPontos;
	}
	
	public List<Ponto> circ_trigonometrica(int x, int y, int raio){
		listaPontos.clear();
		
		for (int i = -raio; i < raio; i++) {
			listaPontos.add(new Ponto((int) (raio*Math.cos(i)), (int) (raio*Math.sin(i)), 0));
			listaPontos.add(new Ponto((int) (raio*Math.cos(i)), (int) -(raio*Math.sin(i)), 0));
		}
		imprimirLista();
		return listaPontos;
	}
	
	private void imprimirLista() {
		for (Ponto ponto : listaPontos) {
			System.out.println(ponto.toString());
		}
	}
	
	private void printPixel(int x, int y) {
		
		listaPontos.add(new Ponto(x, y, 0)); 
		listaPontos.add(new Ponto(x, -y, 0)); 
		listaPontos.add(new Ponto(-x, y, 0));
		listaPontos.add(new Ponto(-x, -y, 0)); 
		
		listaPontos.add(new Ponto(y, x, 0));
		listaPontos.add(new Ponto(y, -x, 0));
		listaPontos.add(new Ponto(-y, x, 0)); 
		listaPontos.add(new Ponto(-y, -x, 0)); 		
	}

	/**
	 * @return the listaPontos
	 */
	public List<Ponto> getListaPontos() {
		for (Ponto ponto : listaPontos) {
			System.out.println("["+ponto.getX() + ", " + ponto.getY()+"] ");
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
	
	public static void main(String[] args) { 
		new Circunferencia().circ_trigonometrica(0, 0, 5);
	}
}
