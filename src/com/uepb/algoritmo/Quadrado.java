package com.uepb.algoritmo;

import java.util.ArrayList;
import java.util.List;

public class Quadrado {

	double lenght;
	double X, Y, x_inc, y_inc;
	double media = 0.0;

	List<Ponto> listaDePontos = new ArrayList<Ponto>();

	public Quadrado() {

	}

	
	public static void main(String[] args) { 
		Quadrado r = new Quadrado();
		r.quadrado(10, 10);
	}


	public List<Ponto> quadrado(int x, int y) {
		
		Retas retas = new Retas();
		List<Ponto> r1 = retas.dda(0, 0, x, 0);
		List<Ponto> r2 = retas.dda(x, 0, x, y-1);
		List<Ponto> r3 = retas.dda(x, y, 0, y);
		List<Ponto> r4 = retas.dda(0, y, 0, 0);
		listaDePontos.clear();
		for (Ponto ponto : r1) {
			listaDePontos.add(ponto);
		}
		for (Ponto ponto : r2) {
			listaDePontos.add(ponto);
		}
		for (Ponto ponto : r3) {
			listaDePontos.add(ponto);
		}
		for (Ponto ponto : r4) {
			listaDePontos.add(ponto);
		}
		return listaDePontos;
	}
}
