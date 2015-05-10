package com.uepb.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.uepb.algoritmo.Matriz;

public class MatrizTest {

	Matriz matriz;

	@Test
	public void multiplicar() throws Exception {
		matriz = new Matriz();
		int[][] matrizA = { { 1, 2, 3 }, { 4, 5, 6 }, { 1, 1, 1 } };
		int[][] matrizB = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[][] result = { { 6, 12, 18 }, { 15, 30, 45 }, { 3, 6, 9 } };
		// assertEquals(result, matriz.multiplicaMatrizes(matrizA, matrizB));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void mutiplicar3x2() {
		int[][] matriz33 = {{2, 0, 0}
				, {0, 1, 0}
				, {0, 0, 1}};
		int[][] matriz32 = {{2, 4}
				, {1, 1}
				, {1, 1}};
		
		int[][] matrizResp = {{4, 8}
		, {1, 1}
		, {1, 1}};
		try {
			int[][] a = matriz.multiplicaMatrizes(matriz33, matriz32);
			System.out.println(a[0][0]);
			assertEquals(matrizResp, a);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
