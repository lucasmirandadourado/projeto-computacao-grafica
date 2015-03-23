package algoritmos;

public class Normalizacao {
	
	static public float calcularNDCX(int xAtual, int xMinimo, int xMaximo){
		
		float ndcx = (xAtual - xMinimo) / (xMaximo - xMinimo);
		return ndcx;
	}
	
	static public float calcularNDCY(float yAtual, float yMinimo, float yMaximo){
		
		float ndcy = (yAtual - yMinimo) / (yMaximo - yMinimo); 
		return ndcy;
	}
	
	static public int calcularDCX(int ndh, float ndcx){
		
		int dcx = Math.round((ndh - 1) * ndcx);
		return dcx;
	}
	
	static public int calcularDCY(int ndv, float ndcy){
		
		int dcy = Math.round((ndv - 1) * ndcy);
		return dcy;
	}

}
