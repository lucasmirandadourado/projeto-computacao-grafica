package com.uepb.view.basica;

import java.util.ArrayList;
import java.util.List;

import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.operacoes2D.RetasFuncoes;

public class Quadrado {

	List<Ponto> listaDePontos = new ArrayList<Ponto>();

	public Quadrado() {

	}

	public List<Ponto> quadrado(int x, int y) {
		
		RetasFuncoes retas = new RetasFuncoes();
		List<Ponto> r1 = retas.dda(0, 0, x, 0);
		List<Ponto> r2 = retas.dda(x, 0, x, y-1);
		List<Ponto> r3 = retas.dda(x, y, 0, y);
		List<Ponto> r4 = retas.dda(0, y, 0, 0);		
			listaDePontos.clear();
			listaDePontos.addAll(r1);
			listaDePontos.addAll(r2);
			listaDePontos.addAll(r3);
			listaDePontos.addAll(r4);
		return listaDePontos;
	}
}
