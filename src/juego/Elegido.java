package juego;

import java.awt.Color;

import entorno.Entorno;

public class Elegido {

	private int x, y, ancho, alto;

	public Elegido() {
		this.ancho = 10;
		this.alto = 10;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarTriangulo(this.x, this.y, 10, 10, 0, Color.RED);
	}

}
