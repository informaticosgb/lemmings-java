package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;

public class Plataforma 
{
	private int x, y, ancho, alto, velocidad;
	private boolean seleccionado;

	// plataformas fijas
	public Plataforma()
	{
		this.ancho = 120;
		this.alto = 50;
	}

	// plataformas random
	public Plataforma(boolean plataformasRandom)
	{
		if (plataformasRandom)
		{
			Random gen = new Random();
			this.x = gen.nextInt(200) + 1;
			this.y = gen.nextInt(200) + 1;
			this.velocidad = 3;
			this.seleccionado = false;
		}
		// throw new RuntimeException("");
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getAncho() 
	{
		return ancho;
	}

	public void setAncho(int ancho)
	{
		this.ancho = ancho;
	}

	public int getAlto()
	{
		return alto;
	}

	public void setAlto(int alto)
	{
		this.alto = alto;
	}

	public int getVelocidad() 
	{
		return velocidad;
	}

	public void setVelocidad(int velocidad) 
	{
		this.velocidad = velocidad;
	}

	public boolean seleccionado()
	{
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado)
	{
		this.seleccionado = seleccionado;
	}

	public void dibujar(Entorno entorno, Color color) 
	{
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, color);
	}

	public boolean colisiona(Plataforma otra)
	{
		if ((otra.getY() >= this.y - (this.alto / 2)) && (otra.getY() <= this.y + (this.alto / 2)
				&& (otra.getX() >= this.x - (this.ancho / 2)) && (otra.getX() <= this.x + (this.ancho / 2)))) {
			return true;
	}
		return false;
	}

	public void subir()
	{
		this.y -= this.velocidad;
	}

	public void bajar() 
	{
		this.y += this.velocidad;
	}
}
