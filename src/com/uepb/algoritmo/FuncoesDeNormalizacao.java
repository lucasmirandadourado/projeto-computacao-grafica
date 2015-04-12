package com.uepb.algoritmo;

public class FuncoesDeNormalizacao {

	static public double calcularNDCX(int ndh, int dcx) {

		System.out.println("ndh: "+ndh);
		System.out.println("dcx: "+dcx);
		
		double ndcx = (double) dcx / (ndh - 1);
		System.out.println("ndcx: "+ndcx+"\n");
		
		return ndcx;
		
	}
	
	static public double calcularNDCY(int ndv, int dcy){
		
		System.out.println("ndv: "+ndv);
		System.out.println("dcy: "+dcy);
		
		double ndcy = (double) dcy / (ndv - 1);
		System.out.println("ndcy: "+ndcy+"\n");
		
		return ndcy;
		
	}

}
