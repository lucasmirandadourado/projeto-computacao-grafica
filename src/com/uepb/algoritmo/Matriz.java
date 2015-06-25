package com.uepb.algoritmo;

public class Matriz {

	public static double[][] multiplicaMatrizes(double[][] matrizA, double[][] matrizB) {
		int linha = matrizA.length;
		int coluna = matrizB[0].length;
		double[][] matrizResultado = new double[linha][coluna];
		if(matrizA[0].length == matrizB.length){
			
			for (int i = 0; i < linha; i++) {
				for (int j = 0; j < coluna; j++) {
					for (int k = 0; k < linha; k++) {
						matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
					}
				}
			}		
		}
		
		return matrizResultado;		
	}
	
	public static void imprimeMatriz(double[][] matriz){
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print((int)matriz[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
