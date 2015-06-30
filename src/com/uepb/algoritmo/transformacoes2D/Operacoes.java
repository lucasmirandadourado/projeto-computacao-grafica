package com.uepb.algoritmo.transformacoes2D;

import java.util.ArrayList;
import java.util.List;

import com.uepb.algoritmo.Matriz;
import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.Retas;

// 2D Composta
public class Operacoes {

	private int x, y;
	Matriz matriz = new Matriz();

	private double[][] gerarMatrizTranslacao(int tx, int ty) {
		double[][] matriz = new double[3][3];

		matriz[0][0] = 1;
		matriz[0][1] = 0;
		matriz[0][2] = tx;

		matriz[1][0] = 0;
		matriz[1][1] = 1;
		matriz[1][2] = ty;

		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	private double[][] gerarMatrizEscala(double sx, double sy) {
		double[][] matriz = new double[3][3];
		if (sx == 0) {
			sx = 1;
		}
		if (sy == 0) {
			sy = 1;
		}
		matriz[0][0] = sx;
		matriz[1][0] = 0;
		matriz[2][0] = 0;

		matriz[0][1] = 0;
		matriz[1][1] = sy;
		matriz[2][1] = 0;

		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	private double[][] gerarMatrizRotacao(double angulo) {

		double[][] matriz = new double[3][3];

		double sen = Math.sin(Math.toRadians(angulo));
		double cos = Math.cos(Math.toRadians(angulo));
		System.out.println(sen + ", " + cos);
		matriz[0][0] = cos;
		matriz[1][0] = sen;
		matriz[2][0] = 0;

		matriz[0][1] = -sen;
		matriz[1][1] = cos;
		matriz[2][1] = 0;

		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	public List<Ponto> translacaoCircunferencia(List<Ponto> objeto, int x, int y) {
		List<Ponto> list = new ArrayList<Ponto>();
		for (Ponto ponto : objeto) {
			ponto.setX(ponto.getX() + x);
			ponto.setY(ponto.getY() + y);
			list.add(ponto);
		}
		// for (Ponto ponto : list) {
		// System.out.println(ponto.toString());
		// }
		return list;
	}

	/**
	 * 
	 * @param matriz
	 * @param x
	 * @param y
	 * @return
	 */
	public double[][] translacaoMulti(double[][] matriz, int x, int y) {

		try {
			double[][] d =Matriz.multiplicaMatrizes(gerarMatrizTranslacao(x, y), matriz);
			
			return d;
		} catch (Exception e) {
			System.out.println("ERRO NA TRANSLAÇÃO");
		}
		return matriz;
	}

	public List<Ponto> escalaReta(List<Ponto> objeto, double x, double y) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[3][objeto.size() + 1];

		// Criando o objeto de matriz
		for (int i = 0; i < objeto.size(); i++) {
			matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna i na linha 2 = 1
		}

		int translacaox = objeto.get(0).getX();
		int translacaoy = objeto.get(0).getY();
		
		// Fazer a translação do objeto
		double[][] matrizNaOrigem = translacaoMulti(matriz, -translacaox, -translacaoy);
	
		// Matriz da escala.
		double[][] escala = gerarMatrizEscala(x, y);

		// Gerando a matriz da escala
		double[][] a = new Matriz().multiplicaMatrizes(escala, matrizNaOrigem);
		
		// Voltar a reta a posição de origem
		double[][] b = translacaoMulti(a, translacaox, translacaoy);
		
		int size = b[0].length-2;
		
		list = new Retas().dda((int) b[0][0], (int) b[1][0], (int) b[0][size], (int) b[1][size]);
		
		return list;
	}

	public List<Ponto> rotacao(List<Ponto> lis, int i) {
		// TODO Auto-generated method stub
		return null;
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

	public static void main(String[] args) {
		List<Ponto> lis = new ArrayList<Ponto>();
		lis.add(new Ponto(4, 1, 1));
		lis.add(new Ponto(5, 1, 1));
		lis.add(new Ponto(6, 1, 1));
		lis.add(new Ponto(7, 1, 1));
		lis.add(new Ponto(8, 1, 1));
		lis.add(new Ponto(9, 1, 1));

		Operacoes op = new Operacoes();

		List<Ponto> a = op.rotacao(lis, 30);

	}
}
