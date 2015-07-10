package com.uepb.algoritmo.transformacoes2D;

import java.util.ArrayList;
import java.util.List;

import com.uepb.algoritmo.Matriz;
import com.uepb.algoritmo.Ponto;

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

		// Linha 0
		matriz[0][0] = cos;
		matriz[1][0] = sen;
		matriz[2][0] = 0;
		// Linha 1
		matriz[0][1] = -sen;
		matriz[1][1] = cos;
		matriz[2][1] = 0;
		// Linha 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	private double[][] gerarMatrizReflexaoX() {

		double[][] matriz = new double[3][3];

		// Linha 0
		matriz[0][0] = 1;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		// Linha 1
		matriz[0][1] = 0;
		matriz[1][1] = -1;
		matriz[2][1] = 0;
		// Linha 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	private double[][] gerarMatrizReflexaoY() {

		double[][] matriz = new double[3][3];

		// Linha 0
		matriz[0][0] = -1;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		// Linha 1
		matriz[0][1] = 0;
		matriz[1][1] = 1;
		matriz[2][1] = 0;
		// Linha 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	private double[][] gerarMatrizReflexaoXY() {

		double[][] matriz = new double[3][3];

		// Linha 0
		matriz[0][0] = -1;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		// Linha 1
		matriz[0][1] = 0;
		matriz[1][1] = -1;
		matriz[2][1] = 0;
		// Linha 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	private double[][] gerarMatrizCisalhamentoX(int a, int b) {

		double[][] matriz = new double[3][3];
		
		// Linha 0
		matriz[0][0] = 1;
		matriz[1][0] = b;
		matriz[2][0] = 0;
		// Linha 1
		matriz[0][1] = a;
		matriz[1][1] = 1;
		matriz[2][1] = 0;
		// Linha 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;

		return matriz;
	}

	// Operações básicas
	private double[][] translacaoMulti(double[][] matriz, int x, int y) {

		try {
			double[][] d = Matriz.multiplicaMatrizes(
					gerarMatrizTranslacao(x, y), matriz);

			return d;
		} catch (Exception e) {
			System.out.println("ERRO NA TRANSLAÇÃO");
		}
		return matriz;
	}

	public List<Ponto> translacaoMulti(List<Ponto> objeto, int x, int y) {
		List<Ponto> list = new ArrayList<Ponto>();

		double[][] matriz = new double[3][objeto.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < objeto.size(); i++) {
			matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna i na linha 2 = 1
		}

		double[][] d = null;
		try {
			d = Matriz.multiplicaMatrizes(gerarMatrizTranslacao(x, y), matriz);
		} catch (Exception e) {
			System.out.println("ERRO NA TRANSLAÇÃO");
		}

		for (int i = 0; i < d[0].length; i++) {
			list.add(new Ponto((int) d[0][i], (int) d[1][i], (int) d[2][i]));
		}
		System.out.println(list.toString() + "a\n");
		return list;
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
		double[][] matrizNaOrigem = translacaoMulti(matriz, -translacaox,
				-translacaoy);

		// Matriz da escala.
		double[][] escala = gerarMatrizEscala(x, y);

		// Gerando a matriz da escala
		double[][] a = null;
		try {
			new Matriz();
			a = Matriz.multiplicaMatrizes(escala, matrizNaOrigem);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Voltar a reta a posição de origem
		double[][] b = translacaoMulti(a, translacaox, translacaoy);

		for (int i = 0; i < b[0].length; i++) {
			list.add(new Ponto((int) b[0][i], (int) b[1][i], (int) b[2][i]));
		}
		return list;
	}

	public List<Ponto> rotacao(List<Ponto> lis, int angulo) {

		double[][] matriz = new double[3][lis.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lis.size(); i++) {
			matriz[0][i] = lis.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lis.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna j na linha 2 = 1
		}

		int translacaoX = lis.get(0).getX();
		int translacaoY = lis.get(0).getY();
		
		List<Ponto> trans = translacaoMulti(lis, -translacaoX, -translacaoY);

		double[][] matrizNaOrigem = new double[3][lis.size()];

		int size = trans.size();

		for (int i = 0; i < size; i++) {
			matrizNaOrigem[0][i] = (double) trans.get(i).getX();
			matrizNaOrigem[1][i] = (double) trans.get(i).getY();
			matrizNaOrigem[2][i] = (double) trans.get(i).getZ();
		}

		// Gerar a matriz de rotação
		double[][] rotacao = gerarMatrizRotacao(angulo);

		// Fazer a rotação
		double[][] lisPonto = null;
		try {
			lisPonto = Matriz.multiplicaMatrizes(rotacao, matriz);
		} catch (Exception e) {
			System.err.println("Erro ao multiplicar a matriz de rotação");
			e.printStackTrace();
		}
		matrizNaOrigem = null;
		matrizNaOrigem = translacaoMulti(lisPonto, translacaoX, translacaoY);
		lis.clear();
		for (int i = 0; i < matrizNaOrigem[0].length; i++) {
			lis.add(new Ponto((int) matrizNaOrigem[0][i], (int) matrizNaOrigem[1][i],
					(int) matrizNaOrigem[2][i]));
		}
		
		return lis;
	}

	// Reflexão
	public List<Ponto> reflexaoX(List<Ponto> lstPontos) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[3][lstPontos.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lstPontos.size(); i++) {
			matriz[0][i] = lstPontos.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lstPontos.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] reflexao = gerarMatrizReflexaoX();

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes(reflexao, matriz);
		} catch (Exception e) {
			System.out.println("Erro na reflexão.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i]));

		}

		return list;
	}

	public List<Ponto> reflexaoY(List<Ponto> lstPontos) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[3][lstPontos.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lstPontos.size(); i++) {
			matriz[0][i] = lstPontos.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lstPontos.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] reflexao = gerarMatrizReflexaoY();

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes(reflexao, matriz);
		} catch (Exception e) {
			System.out.println("Erro na reflexão.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i]));

		}

		return list;
	}

	public List<Ponto> reflexaoXY(List<Ponto> lista) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[3][lista.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lista.size(); i++) {
			matriz[0][i] = lista.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lista.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] reflexao = gerarMatrizReflexaoXY();

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes(reflexao, matriz);
		} catch (Exception e) {
			System.out.println("Erro na reflexão.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i]));
		}

		return list;
	}

	public List<Ponto> cisalhamentoEmX(List<Ponto> lista, Integer a, Integer b) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[3][lista.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lista.size(); i++) {
			matriz[0][i] = lista.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lista.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] cisalhamento = gerarMatrizCisalhamentoX(a, b);

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes(cisalhamento, matriz);
		} catch (Exception e) {
			System.out.println("Erro no  cisalhamento em X e Y.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i]));

		}

		return list;
	}

	public List<Ponto> cisalhamentoEmY(List<Ponto> lista, Integer a, Integer b) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[3][lista.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lista.size(); i++) {
			matriz[0][i] = lista.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lista.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] cisalhamento = gerarMatrizCisalhamentoX(a, b);

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes(cisalhamento, matriz);
		} catch (Exception e) {
			System.out.println("Erro no  cisalhamento em X e Y.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i]));

		}

		return list;
	}

	public List<Ponto> cisalhamentoEmZ(List<Ponto> lista, int a, int b) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[3][lista.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lista.size(); i++) {
			matriz[0][i] = lista.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lista.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] cisalhamento = gerarMatrizCisalhamentoX(a, b);

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes(cisalhamento, matriz);
		} catch (Exception e) {
			System.out.println("Erro no  cisalhamento em X e Y.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i]));

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
}
