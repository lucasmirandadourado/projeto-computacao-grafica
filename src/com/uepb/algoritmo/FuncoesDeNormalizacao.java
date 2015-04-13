package com.uepb.algoritmo;

public class FuncoesDeNormalizacao {

	static public double calcularNDCX(int ndh, int dcx) {

		double ndcx = (double) dcx / (ndh - 1);
		return ndcx;
		
	}
	
	static public double calcularNDCY(int ndv, int dcy){
		
		double ndcy = (double) dcy / (ndv - 1);
		return ndcy;
		
	}
	
	static public int calcularX(int xMinimo, int xMaximo, double ndcx){
		
		int x = (int) (ndcx * (xMaximo - xMinimo) / (-xMinimo));
		return x;
		
	}
	
	static public int calcularY(int yMinimo, int yMaximo, double ndcy){
		
		int y = (int) (ndcy * (yMaximo - yMinimo) / (-yMinimo));
		return y;
		
	}

}
