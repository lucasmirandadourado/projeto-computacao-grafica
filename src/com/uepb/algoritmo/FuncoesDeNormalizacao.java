package com.uepb.algoritmo;

public class FuncoesDeNormalizacao {

	public static double ndcx;
	public static double ndcy;
	public static double dcx;
	public static double dcy;
	
	
	static public double calcularNDCX(int ndh, int dcx) {

		double ndcx = (double) dcx / (ndh - 1);
		return ndcx;
		
	}
	
	static public double calcularNDCY(int ndv, int dcy){
		
		double ndcy = (double) dcy / (ndv - 1);
		return ndcy;
		
	}
	
	static public int calcularDCX(int ndh, double ndcx){
		dcx = ((ndh-1)* ndcx); 
		return (int) Math.round(dcx);
				
	}
	
	static public int calcularDCY(int ndv, double ndcy){
		dcy = ((ndv-1)* ndcy); 
		return (int) Math.round(dcy);
		
	}

}
