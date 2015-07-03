package com.uepb.algoritmo;

public class Matriz {

	public static double[][] multiplicaMatrizes(double[][] matrizA, double[][] matrizB) throws Exception {
		
		int linha = matrizA.length;
		int coluna = matrizB[0].length;
		
		if (matrizA[0].length == matrizB.length) {
			
			double[][] matrizResultado = new double[matrizA[0].length][matrizB[0].length];			

			for (int i = 0; i < linha; i++) {
				for (int j = 0; j < coluna; j++) {
					for (int k = 0; k < linha; k++) {
						matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
					}
				}
			}

			return matrizResultado;
		} else {
			throw new Exception("Erro ao multiplicar a matriz.");
		}
	}
}
