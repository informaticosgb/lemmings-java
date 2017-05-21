package juego;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import entorno.Entorno;

public class Lemmings 
{
	private Point centro;
	private int diametro, velocidad;
	private final int alturaPermitida = 100;
	private boolean estaVivo;

	public Lemmings()
	{	
		Random gen = new Random();
		this.centro = new Point(gen.nextInt(100), gen.nextInt(100));
		this.diametro = 15;
		this.velocidad = 2;
		this.estaVivo = true;
	}

	public Point getCentro() 
	{
		return centro;
	}

	public void setCentro(Point centro) 
	{
		this.centro = centro;
	}

	public int getDiametro()
	{
		return diametro;
	}

	public void setDiametro(int diametro)
	{
		this.diametro = diametro;
	}

	public int getVelocidad() 
	{
		return velocidad;
	}

	public void setVelocidad(int velocidad)
	{
		this.velocidad = velocidad;
	}

	public boolean isEstaVivo()
	{
		return estaVivo;
	}

	public void setEstaVivo(boolean estaVivo)
	{
		this.estaVivo = estaVivo;
	}

	public int getAlturaPermitida() 
	{
		return alturaPermitida;
	}

	public void dibujar(Entorno entorno)
	{
		entorno.dibujarCirculo(this.centro.x, this.centro.y, this.diametro, Color.BLUE);
	}
}
