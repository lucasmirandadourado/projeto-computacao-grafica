package com.uepb.algoritmo.transformacoes2D;

import java.util.ArrayList;
import java.util.List;

import com.uepb.algoritmo.Matriz;
import com.uepb.algoritmo.Ponto;

// 2D Composta
public class Operacoes {

	private int x, y;
	private double[][] matrizTr = new double[3][3];
	Matriz matriz = new Matriz();

	private double[][] gerarMatrizTranslacao(int x, int y) {
		double[][] matriz = new double[3][3];

		matriz[0][0] = 1;
		matriz[0][1] = 0;
		matriz[0][2] = x;

		matriz[1][0] = 0;
		matriz[1][1] = 1;
		matriz[1][2] = y;

		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	private double[][] gerarMatrizEscala(int x, int y) {
		double[][] matriz = new double[3][3];
		if (x == 0) {
			x = 1;
		}
		if (y == 0 ) {
			y = 1;
		}
		matriz[0][0] = x;
		matriz[1][0] = 0;
		matriz[2][0] = 0;

		matriz[0][1] = 0;
		matriz[1][1] = y;
		matriz[2][1] = 0;

		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	private double[][] gerarMatrizRotacao(double t) {
		double[][] matriz = new double[3][3];

		double sen = Math.sin(t);
		double cos = Math.cos(t);

		matriz[0][0] = cos;
		matriz[1][0] = -sen;
		matriz[2][0] = 0;

		matriz[0][1] = sen;
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

		return list;
	}

	public double[][] translacaoMulti(double[][] matriz, int x, int y) {

		try {
			return this.matriz.multiplicaMatrizes(gerarMatrizTranslacao(x, y), matriz);
		} catch (Exception e) {

		}
		return matriz;
	}

	public List<Ponto> escalaReta(List<Ponto> objeto, int x, int y) {	

		double[][] matriz = new double[3][objeto.size() + 1];

		// Criando o objeto de matriz
		for (int i = 0; i < objeto.size(); i++) {
			matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna i na linha 2 = 1
		}

//		for (int i = 0; i < matriz.length; i++) {
//			System.out.print(" Ma " + matriz[i][0]);
//			System.out.print(" " + matriz[i][1]);
//			System.out.println(" " + matriz[i][2]);
//		}
//		System.out.println();
		int translacaox = objeto.get(0).getX();
		int translacaoy = objeto.get(0).getY();
		
//		System.out.println("Matriz: "+matriz.length + ", " + matriz[0].length);

		// Fazer a translação do objeto
		double[][] fatorTranslacao = translacaoMulti(matriz, -2, -1);

//		for (int i = 0; i < matriz.length; i++) {
//			System.out.print(" Tr " + fatorTranslacao[i][0]);
//			System.out.print(" " + fatorTranslacao[i][1]);
//			System.out.println(" " + fatorTranslacao[i][2]);
//			
//		}
		
		double[][] escala = gerarMatrizEscala(2, 0);
		
//		System.out.println("Escala: "+escala[0].length);
		
//		for (int i = 0; i < escala.length; i++) {
//			System.out.print(" Escala: " + escala[i][0]);
//					System.out.print(" " + escala[i][1]);
//				  System.out.println(" " + escala[i][2]);
//		}
		
		double[][] a = new Matriz().multiplicaMatrizes(escala, fatorTranslacao);
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(" A: " + a[i][0]);
//					System.out.print(" " + a[i][1]);
//				  System.out.println(" " + a[i][2]);
//		}
		
		double[][] b = translacaoMulti(a, translacaox, translacaoy);
//		for (int i = 0; i < b.length; i++) {
//			System.out.print(" Resultado: " + b[i][0]);
//					System.out.print(" " + b[i][1]);
//				  System.out.println(" " + b[i][2]);
//		}
		
		List<Ponto> list = new ArrayList<Ponto>(); 
		
		for (int i = 0; i < b.length; i++) {
			list.add(new Ponto((int) b[i][0], (int) b[i][1], 0));
		}
		return list;
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
		lis.add(new Ponto(2, 1, 0));
		lis.add(new Ponto(3, 1, 0));
		lis.add(new Ponto(4, 1, 0));

		Operacoes op = new Operacoes();

		op.escalaReta(lis, 2, 1);
	}
}
