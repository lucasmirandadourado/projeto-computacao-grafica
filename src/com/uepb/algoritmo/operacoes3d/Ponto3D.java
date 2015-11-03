package com.uepb.algoritmo.operacoes3d;

/**
 * Ponto. Tem três valores. X, Y e Z
 * 
 * @author Lucas Miranda Dourado
 *
 */
public class Ponto3D {
	private int x = 0, y = 0, z = 0, w = 1;

	/**
	 * Coordenadas com 3D (Três dimenções)
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param w 
	 */
	public Ponto3D(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * @param z
	 *            the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}

	
	@Override
	public String toString() {
		return "Ponto [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public String imprime3D() {
		return "Ponto [x=" + x + ", y=" + y + ", z=" + z + ", w=" + getW() + "]";

	}

}
