/**
 * 
 */
package com.uepb.algoritmo;

/**
 * @author Lucas Miranda
 *
 */
public class CircunferenciaBresenham {

	int x = 0;
	int y = 0;
	int raio = 0;

	double d = 0;
	double a = 0, b = 0, c = 0;
	double d_start = 0;

	/**
	 * 
	 */
	public CircunferenciaBresenham(int xCenter, int yCenter, int raio) {
		this.x = xCenter;
		this.y = yCenter;
		this.raio = raio;

		a = y;
		b = -x;
		c = x * b;

		// d = F(x, y)
		d = a * (x + 1) + b * (y + 0.5) + c;

		if (d < 0) {

		} else {

		}

	}

	public void bresenham1(int x1, int y1, int x2, int y2){        
	       int slope;
	       int dx, dy, incE, incNE, d, x, y;
	       // Onde inverte a linha x1 > x2       
	       if (x1 > x2){
	           bresenham1(x2, y2, x1, y1);
	            return;
	       }        
	       dx = x2 - x1;
	       dy = y2 - y1;
	   
	       if (dy < 0){            
	           slope = -1;
	           dy = -dy;
	       }
	       else{            
	          slope = 1;
	       }
	       // Constante de Bresenham
	       incE = 2 * dy;
	       incNE = 2 * dy - 2 * dx;
	       d = 2 * dy - dx;
	       y = y1;       
	       for (x = x1; x <= x2; x++){
//	           putpixel(x, y);
	           if (d <= 0){
	             d += incE;
	           }
	           else{
	             d += incNE;
	             y += slope;
	           }
	       }
	}
	
	private double incE() {
		return 2 * x + 3;
	}

	private double incNE() {
		return 2 * x - 2 * y + 5;
	}

	private double dStart(int raio) {
		d_start = x * x + (this.raio - 0.5) * (raio - 0.5) - raio * raio;
		return d_start;
	}

	public static void main(String[] args) {
		new CircunferenciaBresenham(0, 0, 5);

	}
}
