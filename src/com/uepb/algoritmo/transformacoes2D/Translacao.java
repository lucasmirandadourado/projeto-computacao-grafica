package com.uepb.algoritmo.transformacoes2D;

import java.util.ArrayList;
import java.util.List;

import com.uepb.algoritmo.Matriz;
import com.uepb.algoritmo.Ponto;

// 2D Composta
public class Translacao {

	private int x, y;
	private int[][] matrizTr = new int[3][3];
	Matriz matriz = new Matriz();

	public Translacao() {

	}

	private int[][] gerarMatrizTranslacao(int x, int y) {
		matrizTr[0][0] = 1;
		matrizTr[1][0] = 0;
		matrizTr[2][0] = x;

		matrizTr[0][1] = 0;
		matrizTr[1][1] = 1;
		matrizTr[2][1] = y;

		matrizTr[0][2] = 0;
		matrizTr[1][2] = 0;
		matrizTr[2][2] = 1;

		return matrizTr;
	}

	public List<Ponto> translacaoCircunferencia(List<Ponto> objeto, int x, int y) {
		List<Ponto> list = new ArrayList<Ponto>();
		for (Ponto ponto : objeto) {
			ponto.setX(ponto.getX()+x);
			ponto.setY(ponto.getY()+y);
			list.add(ponto);
		}
		
		return list;
	}
	public int[][] translacaoMulti(int[][] matriz, int x, int y) {
		gerarMatrizTranslacao(x, y);
		try {
			return this.matriz.multiplicaMatrizes(gerarMatrizTranslacao(x, y),
					matriz);
		} catch (Exception e) {
			System.exit(0);
		}
		return matriz;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
