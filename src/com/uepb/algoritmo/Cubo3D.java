package com.uepb.algoritmo;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Side;

public class Cubo3D {

	int x, y, z, w;
	Matriz matriz = new Matriz();

	private double[][] gerarMatrizTranslacao(int tx, int ty, int tz) {
		double[][] matriz = new double[4][4];

		matriz[0][0] = 1;
		matriz[0][1] = 0;
		matriz[0][2] = 0;
		matriz[0][3] = tx;

		matriz[1][0] = 0;
		matriz[1][1] = 1;
		matriz[1][2] = tx;
		matriz[1][3] = ty;

		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 0;
		matriz[2][3] = tz;

		matriz[3][0] = 0;
		matriz[3][1] = 0;
		matriz[3][2] = 0;
		matriz[3][3] = 1;

		return matriz;
	}

	private double[][] gerarMatrizEscala(double sx, double sy, double sz) {
		double[][] matriz = new double[4][4];
		if (sx == 0) {
			sx = 1;
		}
		if (sy == 0) {
			sy = 1;
		}
		if (sz == 0) {
			sy = 1;
		}
		// coluna 0
		matriz[0][0] = sx;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		matriz[3][0] = 0;

		// Coluna 1
		matriz[0][1] = 0;
		matriz[1][1] = sy;
		matriz[2][1] = 0;
		matriz[3][1] = 0;

		// Coluna 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = sy;
		matriz[3][2] = 1;

		// Coluna 3
		matriz[0][3] = 0;
		matriz[1][3] = 0;
		matriz[2][3] = 0;
		matriz[3][3] = 0;

		return matriz;
	}

	private double[][] gerarMatrizReflexaoXY() {

		double[][] matriz = new double[4][4];

		// Coluna 0
		matriz[0][0] = 1;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		matriz[3][0] = 0;
		
		// Coluna 1
		matriz[0][1] = 0;
		matriz[1][1] = 1;
		matriz[2][1] = 0;
		matriz[3][1] = 0;

		// Coluna 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = -1;
		matriz[3][2] = 0;

		// Coluna 3
		matriz[0][3] = 0;
		matriz[1][3] = 0;
		matriz[2][3] = 0;
		matriz[3][3] = 1;
		
		return matriz;
		
	}

	private double[][] gerarMatrizReflexaoYZ() {

		double[][] matriz = new double[4][4];

		// Coluna 0
		matriz[0][0] = -1;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		matriz[3][0] = 0;
		
		// Coluna 1
		matriz[0][1] = 0;
		matriz[1][1] = 1;
		matriz[2][1] = 0;
		matriz[3][1] = 0;

		// Coluna 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;
		matriz[3][2] = 0;

		// Coluna 3
		matriz[0][3] = 0;
		matriz[1][3] = 0;
		matriz[2][3] = 0;
		matriz[3][3] = 1;
		
		return matriz;
	}
	
	private double[][] gerarMatrizReflexaoXZ() { 

		double[][] matriz = new double[4][4];

		// Coluna 0
		matriz[0][0] = 1;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		matriz[3][0] = 0;
		
		// Coluna 1
		matriz[0][1] = 0;
		matriz[1][1] = -1;
		matriz[2][1] = 0;
		matriz[3][1] = 0;

		// Coluna 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;
		matriz[3][2] = 0;

		// Coluna 3
		matriz[0][3] = 0;
		matriz[1][3] = 0;
		matriz[2][3] = 0;
		matriz[3][3] = 1;
		
		return matriz;
		
	}
	
	private double[][] gerarMatrizCisalhamentoX(int a) { 

		double[][] matriz = new double[3][3];

		// Linha 0
		matriz[0][0] = 1;
		matriz[1][0] = 0;
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

	private double[][] gerarMatrizCisalhamentoY(int b) {

		double[][] matriz = new double[3][3];

		// Linha 0
		matriz[0][0] = 1;
		matriz[1][0] = b;
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

	private double[][] gerarMatrizCisalhamentoZ(int sx, int sy) { 

		double[][] matriz = new double[4][4];

		// Linha 0
		matriz[0][0] = 1;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		matriz[3][0] = 0;
		// Linha 1
		matriz[0][1] = 0;
		matriz[1][1] = 1;
		matriz[2][1] = 0;
		matriz[3][1] = 0;
		// Linha 2
		matriz[0][2] = sx;
		matriz[1][2] = sy;
		matriz[2][2] = 1;
		matriz[3][2] = 0;

		matriz[0][3] = 0;
		matriz[1][3] = 0;
		matriz[2][3] = 0;
		matriz[3][3] = 1;
		
		return matriz;
	}

	
	private double[][] gerarMatrizCisalhamentoXY(int a, int b) {

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

	// Opera��es b�sicas
	private double[][] translacaoMulti(double[][] matriz, int x, int y, int z) {

		try {
			double[][] d = Matriz.multiplicaMatrizes(
					gerarMatrizTranslacao(x, y, z), matriz);

			return d;
		} catch (Exception e) {
			System.out.println("ERRO NA TRANSLA��O");
		}
		return matriz;
	}

	public List<Ponto> translacaoMulti(List<Ponto> objeto, int x, int y, int z) {
		List<Ponto> list = new ArrayList<Ponto>();
		
		double[][] matriz = new double[4][objeto.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < objeto.size(); i++) {
			matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = objeto.get(i).getZ(); // Coluna i na linha 2 
			matriz[3][i] = objeto.get(i).getW(); // Coluna i na linha 3
		}
		double[][] d = null;
		try {
			d = Matriz.multiplicaMatrizes3D(gerarMatrizTranslacao(x, y, z),
					matriz);
		} catch (Exception e) {
			System.out.println("ERRO NA TRANSLA��O");
		}
		for (int i = 0; i < d[0].length; i++) {
			list.add(new Ponto((int) d[0][i], (int) d[1][i], (int) d[2][i], (int) d[3][i]));

		}
		return list;
	}

	public List<Ponto> escalaReta(List<Ponto> objeto, double x, double y,
			double z) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[4][objeto.size() + 1];

		// Criando o objeto de matriz
		for (int i = 0; i < objeto.size(); i++) {
			matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = objeto.get(i).getZ(); // Coluna i na linha 2 = 1
			matriz[2][i] = 1; // Coluna i na linha 2 = 1
		}

		int translacaox = objeto.get(0).getX();
		int translacaoy = objeto.get(0).getY();
		int translacaoz = objeto.get(0).getZ();

		// Fazer a transla��o do objeto
		double[][] matrizNaOrigem = translacaoMulti(matriz, -translacaox,
				-translacaoy, -translacaoz);

		// Matriz da escala.
		double[][] escala = gerarMatrizEscala(x, y, z);

		// Gerando a matriz da escala
		double[][] a = null;
		try {
			a = new Matriz().multiplicaMatrizes(escala, matrizNaOrigem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Voltar a reta a posi��o de origem
		double[][] b = translacaoMulti(a, translacaox, translacaoy, translacaoz);

		int size = b[0].length - 2;

		list = new Retas().dda((int) b[0][0], (int) b[1][0], (int) b[0][size],
				(int) b[1][size]);

		return list;
	}

	public List<Ponto> rotacaoX(List<Ponto> lis, int angulo) { 
		double[][] matriz = new double[4][lis.size()];

		int transx = lis.get(0).getX();
		int transy = lis.get(0).getY();
		int transz = lis.get(0).getZ();
		
		List<Ponto> trans = translacaoMulti(lis, -transx, -transy, -transz);	

		double[][] matrizNaOrigem = new double[4][lis.size()];

		int size = trans.size();

		for (int i = 0; i < lis.size(); i++) {
			matrizNaOrigem[0][i] = (double) lis.get(i).getX();
			matrizNaOrigem[1][i] = (double) lis.get(i).getY();
			matrizNaOrigem[2][i] = (double) lis.get(i).getZ();
			matrizNaOrigem[3][i] = 1;
		}
		
		// Gerar a matriz de rota��o
		double[][] rotacao = gerarMatrizRotacaoZ(angulo);

		// Fazer a rota��o
		double[][] lisPonto = null;
		try {
			lisPonto = Matriz.multiplicaMatrizes3D(rotacao, matrizNaOrigem);
		} catch (Exception e) {
			System.err.println("Erro ao multiplicar a matriz de rota��o");
			e.printStackTrace();
		}

		lis.clear();
		for (int i = 0; i < lisPonto[0].length; i++) {
			lis.add(new Ponto((int) lisPonto[0][i], (int) lisPonto[1][i],
					(int) lisPonto[2][i], (int) lisPonto[3][i]));
		}
		
		List<Ponto> resultado = translacaoMulti(lis, transx, transy, transz);
		
		return resultado;
	}

	public List<Ponto> rotacaoY(List<Ponto> lis, int angulo) {
		double[][] matriz = new double[4][lis.size()];

		int transx = lis.get(0).getX();
		int transy = lis.get(0).getY();
		int transz = lis.get(0).getZ();
		
//		List<Ponto> trans = translacaoMulti(lis, -transx, -transy, -transz);	

		double[][] matrizNaOrigem = new double[4][lis.size()];

//		int size = trans.size();

		for (int i = 0; i < lis.size(); i++) {
			matrizNaOrigem[0][i] = (double) lis.get(i).getX();
			matrizNaOrigem[1][i] = (double) lis.get(i).getY();
			matrizNaOrigem[2][i] = (double) lis.get(i).getZ();
			matrizNaOrigem[3][i] = 1;
		}
		
		// Gerar a matriz de rota��o
		double[][] rotacao = gerarMatrizRotacaoY(angulo);

		// Fazer a rota��o
		double[][] lisPonto = null;
		try {
			lisPonto = Matriz.multiplicaMatrizes3D(rotacao, matrizNaOrigem);
		} catch (Exception e) {
			System.err.println("Erro ao multiplicar a matriz de rota��o");
			e.printStackTrace();
		}

		lis.clear();
		for (int i = 0; i < lisPonto[0].length; i++) {
			lis.add(new Ponto((int) lisPonto[0][i], (int) lisPonto[1][i],
					(int) lisPonto[2][i], (int) lisPonto[3][i]));
		}
		
//		List<Ponto> resultado = translacaoMulti(lis, transx, transy, transz);
		
		return lis;

	}

	public List<Ponto> rotacaoZ(List<Ponto> lis, int angulo) {
		double[][] matriz = new double[4][lis.size()];

		int transx = lis.get(0).getX();
		int transy = lis.get(0).getY();
		int transz = lis.get(0).getZ();
		
//		List<Ponto> trans = translacaoMulti(lis, -transx, -transy, -transz);	

		double[][] matrizNaOrigem = new double[4][lis.size()];

//		int size = trans.size();

		for (int i = 0; i < lis.size(); i++) {
			matrizNaOrigem[0][i] = (double) lis.get(i).getX();
			matrizNaOrigem[1][i] = (double) lis.get(i).getY();
			matrizNaOrigem[2][i] = (double) lis.get(i).getZ();
			matrizNaOrigem[3][i] = 1;
		}
		
		// Gerar a matriz de rota��o
		double[][] rotacao = gerarMatrizRotacaoX(angulo);

		// Fazer a rota��o
		double[][] lisPonto = null;
		try {
			lisPonto = Matriz.multiplicaMatrizes3D(rotacao, matrizNaOrigem);
		} catch (Exception e) {
			System.err.println("Erro ao multiplicar a matriz de rota��o");
			e.printStackTrace();
		}

		lis.clear();
		for (int i = 0; i < lisPonto[0].length; i++) {
			lis.add(new Ponto((int) lisPonto[0][i], (int) lisPonto[1][i],
					(int) lisPonto[2][i], (int) lisPonto[3][i]));
		}
		
//		List<Ponto> resultado = translacaoMulti(lis, transx, transy, transz);
		
		return lis;

	}
	
	private double[][] gerarMatrizRotacaoX(int angulo) {
		double[][] matriz = new double[4][4];

		double sen = Math.sin(Math.toRadians(angulo));
		double cos = Math.cos(Math.toRadians(angulo));
		
		// Linha 0
		matriz[0][0] = 1;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		matriz[3][0] = 0;
		
		// Linha 1
		matriz[0][1] = 0;
		matriz[1][1] = cos;
		matriz[2][1] = -sen;
		matriz[3][1] = 0;
		
		// Linha 2
		matriz[0][2] = 0;
		matriz[1][2] = sen;
		matriz[2][2] = cos;
		matriz[3][2] = 0;
		
		// linha 3
		matriz[0][3] = 0;
		matriz[1][3] = 0;
		matriz[2][3] = 0;
		matriz[3][3] = 1;
		
		return matriz;
	}

	private double[][] gerarMatrizRotacaoY(int angulo) {
		double[][] matriz = new double[4][4];

		double sen = Math.sin(Math.toRadians(angulo));
		double cos = Math.cos(Math.toRadians(angulo));
		
		// Linha 0
		matriz[0][0] = cos;
		matriz[1][0] = 0;
		matriz[2][0] = sen;
		matriz[3][0] = 0;
		
		// Linha 1
		matriz[0][1] = 0;
		matriz[1][1] = 1;
		matriz[2][1] = 0;
		matriz[3][1] = 0;
		
		// Linha 2
		matriz[0][2] = -sen;
		matriz[1][2] = 0;
		matriz[2][2] = cos;
		matriz[3][2] = 0;
		
		// linha 3
		matriz[0][3] = 0;
		matriz[1][3] = 0;
		matriz[2][3] = 0;
		matriz[3][3] = 1;
		
		return matriz;
	}
	
	private double[][] gerarMatrizRotacaoZ(int angulo) {
		double[][] matriz = new double[4][4];

		double sen = Math.sin(Math.toRadians(angulo));
		double cos = Math.cos(Math.toRadians(angulo));
		
		// Linha 0
		matriz[0][0] = cos;
		matriz[1][0] = sen;
		matriz[2][0] = 0;
		matriz[3][0] = 0;
		
		// Linha 1
		matriz[0][1] = -sen;
		matriz[1][1] = cos;
		matriz[2][1] = 0;
		matriz[3][1] = 0;
		
		// Linha 2
		matriz[0][2] = 0;
		matriz[1][2] = 0;
		matriz[2][2] = 1;
		matriz[3][2] = 0;
		
		// linha 3
		matriz[0][3] = 0;
		matriz[1][3] = 0;
		matriz[2][3] = 0;
		matriz[3][3] = 1;
		
		return matriz;
	}

	
	public List<Ponto> reflexaoXY(List<Ponto> lista) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[4][lista.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lista.size(); i++) {
			matriz[0][i] = lista.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lista.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = lista.get(i).getZ(); // Coluna i na linha 1
			matriz[3][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] reflexao = gerarMatrizReflexaoXY();

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes3D(reflexao, matriz);
		} catch (Exception e) {
			System.out.println("Erro na reflex�o.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i], (int) matrizRefetida[3][i]));
		}

		
		return list;
	}

	public List<Ponto> reflexaoYZ(List<Ponto> lista) { 
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[4][lista.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lista.size(); i++) {
			matriz[0][i] = lista.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lista.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = lista.get(i).getZ(); // Coluna i na linha 1
			matriz[3][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] reflexao = gerarMatrizReflexaoYZ();

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes3D(reflexao, matriz);
		} catch (Exception e) {
			System.out.println("Erro na reflex�o.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i], (int) matrizRefetida[3][i]));
		}

		return list;
	}
	
	public List<Ponto> reflexaoXZ(List<Ponto> lista) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[4][lista.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lista.size(); i++) {
			matriz[0][i] = lista.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lista.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = lista.get(i).getZ(); // Coluna i na linha 1
			matriz[3][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] reflexao = gerarMatrizReflexaoXZ();

		double[][] matrizRefetida = null;
		try {
			matrizRefetida = Matriz.multiplicaMatrizes3D(reflexao, matriz);
		} catch (Exception e) {
			System.out.println("Erro na reflex�o.");
			e.printStackTrace();
		}

		list.clear();
		for (int i = 0; i < matrizRefetida[0].length; i++) {
			list.add(new Ponto((int) matrizRefetida[0][i],
					(int) matrizRefetida[1][i], (int) matrizRefetida[2][i], (int) matrizRefetida[3][i]));
		}

		return list;
	}
		
	public List<Ponto> cisalhamentoEmXY(List<Ponto> lista, int a, int b) {
		List<Ponto> list = new ArrayList<Ponto>();
		double[][] matriz = new double[3][lista.size()];

		// Criando o objeto de matriz
		for (int i = 0; i < lista.size(); i++) {
			matriz[0][i] = lista.get(i).getX(); // Coluna i na linha 0
			matriz[1][i] = lista.get(i).getY(); // Coluna i na linha 1
			matriz[2][i] = 1; // Coluna j na linha 2 = 1
		}

		double[][] cisalhamento = gerarMatrizCisalhamentoXY(a, b);

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

	public List<Ponto> criarCubo(int x, int y, int z) {
		List<Ponto> lista = new ArrayList<Ponto>();
		// L1
		if (x < 0) {
			for (int i = x; i <= 0; i++) {
				lista.add(new Ponto(i, 0, 0, 1));
			}
		} else {
			for (int i = 0; i <= x; i++) {
				lista.add(new Ponto(i, 0, 0, 1));
			}
		}
		// L2
		if (y < 0) {
			for (int i = y; i <= 0; i++) {
				lista.add(new Ponto(x, i, 0, 1));
			}
		} else {
			for (int i = 0; i <= y; i++) {
				lista.add(new Ponto(x, i, 0, 1));
			}
		}
		// L3
		if (x < 0) {
			for (int i = x; i <= 0; i++) {
				lista.add(new Ponto(i, y, 0, 1));
			}
		} else {
			for (int i = 0; i <= x; i++) {
				lista.add(new Ponto(i, y, 0, 1));
			}
		}

		// L4
		for (int i = 0; i <= y; i++) {
			lista.add(new Ponto(0, i, 0, 1));
		}
		// L1'
		if (x < 0) {
			for (int i = x; i <= 0; i++) {
				lista.add(new Ponto(i, 0, z, 1));
			}
		} else {
			for (int i = 0; i <= x; i++) {
				lista.add(new Ponto(i, 0, z, 1));
			}
		}

		// L2'
		for (int i = 0; i <= y; i++) {
			lista.add(new Ponto(x, i, z, 1));
		}

		// L3'
		if (x < 0) {
			for (int i = x; i <= 0; i++) {
				lista.add(new Ponto(i, y, z, 1));
			}
		} else {
			for (int i = 0; i <= x; i++) {
				lista.add(new Ponto(i, y, z, 1));
			}
		}

		// L4'
		for (int i = 0; i <= y; i++) {
			lista.add(new Ponto(0, i, z, 1));
		}

		// t1
		for (int i = 0; i <= z; i++) {
			lista.add(new Ponto(0, 0, i, 1));
		}

		// t2
		for (int i = 0; i <= z; i++) {
			lista.add(new Ponto(x, 0, i, 1));
		}

		// t3
		for (int i = 0; i <= z; i++) {
			lista.add(new Ponto(x, y, i, 1));
		}

		// t4
		for (int i = 0; i <= z; i++) {
			lista.add(new Ponto(0, y, i, 1));
		}
		return lista;
	}

}
