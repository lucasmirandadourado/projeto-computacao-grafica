package com.uepb.algoritmo;

import java.awt.Color;

import com.uepb.algoritmo.operacoes2D.RetasFuncoes;
import com.uepb.view.TelaPrincipal;
import com.uepb.view.basica.Retas;

public class Recorte {
	
	public boolean[] code(int x, int y, int xmin, int xmax, int ymin, int ymax){
		boolean[] code = new boolean[4] ;
		
		for (int i = 0; i < code.length; i++) {
			code[i] = false;
		}		
		
		if (y > ymax) code[0] = true;
		if (y < ymin) code[1] = true;
		if (x > xmax) code[2] = true;
		if (x < xmin) code[3] = true;
		
		return code;
	}
	
	public boolean vazio(boolean bit[]){
		
		for (int i = 0; i < bit.length; i++) {
			if(bit[i] == true){
				return false;
			}
		}
		
		return true;
		
	}
	
	public boolean andi(boolean bit1[], boolean bit2[]){
		
		for (int i = 0; i < bit2.length; i++) {
			if(bit1[i] && bit2[i]){
				return false;
			} 
		}
		return true;
	}
	

	
	public void CohenSutherlandLineClip(int x0, int y0, int x1, int y1, int xmin, int xmax, int ymin, int ymax){
	
		boolean[] outcode0 = new boolean[4];
		boolean[] outcode1 = new boolean[4];
		boolean[] outcodeOut = new boolean[4];
		double x= 0, y = 0; 
		boolean accept = false, done = false;

	 outcode0 = code(x0, y0, xmin, xmax, ymin, ymax); 
	 outcode1 = code(x1, y1, xmin, xmax, ymin, ymax);

	 do {
	   if (vazio(outcode0)  && vazio(outcode1) ) { 
	       accept = true;  done = true;               /* trivial draw and exit */
	       System.out.println("aceitacao trivial");
	   } else if(!andi(outcode0, outcode1)) {
	       done = true;                               /* trivial reject and exit */
	       System.out.println("rejeicao trivial");
	   } else {                                       /* discart an out part */
	     outcodeOut = (!vazio(outcode0)) ?  outcode0 : outcode1;        /* pick an out vertice */
	     System.out.println("Ponto escolhido: " + outcodeOut);
	     if (outcodeOut[0] == true) {                                       /* discart top */
	       x = x0 + (x1 - x0) * (ymax - y0) / (y1 - y0);  y = ymax;
	     } else if(outcodeOut[1] == true) {                                 /* discart bottom */
	       x = x0 + (x1 - x0) * (ymin - y0) / (y1 - y0);  y = ymin;
	     } else if(outcodeOut[2] == true) {                                 /* discart right */
	       y = y0 + (y1 - y0) * (xmax - x0) / (x1 - x0);  x = xmax;
	     } else if(outcodeOut[3] == true) {                                 /* discart left */
	       y = y0 + (y1 - y0) * (xmin - x0) / (x1 - x0);  x = xmin;
	     }
	     
	     if (outcodeOut == outcode0) {
	        x0 = (int)x;
	        y0 = (int)y; 
	        outcode0 = code(x0, y0, xmin, xmax, ymin, ymax);
	     } else {
	        x1 = (int)x; 
	        y1 = (int)y; 
	        outcode1 = code(x1, y1, xmin, xmax, ymin, ymax);
	     }

	   }
	  } while (!done);

	   if (accept){
		   RetasFuncoes reta = new RetasFuncoes();
		   reta.dda(x0, y0, x1, y1);
		   TelaPrincipal.povoarRetas(reta.getListaDePontos(), Color.BLUE);
		   TelaPrincipal.panelNormalizacao.repaint();
	   }
	}

	
	
}
