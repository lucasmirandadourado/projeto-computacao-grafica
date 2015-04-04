package com.uepb.algoritmo;

public class Matriz {

	public Matriz() {}
	
	public int[][] multiplicaMatrizes(int[][] matrizA, int[][] matrizB) throws Exception{
		
		if(matrizA[0].length == matrizB.length){
			int[][] matrizResultado = new int[matrizA.length][matrizB[0].length]; 
			
			for (int i = 0; i < matrizA.length; i++) {
				for (int j = 0; j < matrizB[0].length; j++) {
					for (int k = 0; k < matrizA.length; k++) {
						matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
					}
				}
			}
			
			return matrizResultado;
		}
		else{
			throw new Exception("Erro ao multiplicar a matriz.");
			
		}
		
	}
	
	public void imprimeMatriz(int[][] matriz){
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println("");
		}
	}

}
