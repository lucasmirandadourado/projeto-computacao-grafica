package com.uepb.teste;

import org.junit.Assert;
import org.junit.Test;

import com.uepb.algoritmo.Matriz;

public class MatrizTest {

	Matriz matriz;

	@Test
	public void multiplicar() throws Exception {
		matriz = new Matriz();
		int[][] matrizA = {{1, 2, 3},{4, 5, 6},{1, 1, 1}};
		int[][] matrizB = {{1, 2, 3}, {1, 2, 3} , {1, 2, 3}};
		int[][] result = {{6, 12, 18}, {15, 30, 45}, {3, 6, 9}};
		Assert.assertEquals(result, matriz.multiplicaMatrizes(matrizA, matrizB));		
	}
}
