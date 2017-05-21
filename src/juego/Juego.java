package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	private Entorno entorno;
	private Image imagen;
	private Herramientas herramienta;
	private Plataforma[] plataformas;
	private Plataforma[] plataformasRandom;
	private Lemmings[] lemmings;
	private int cantPresionadas = 0;

	Juego() {
		this.entorno = new Entorno(this, "Lemmings - Grupo 1 - Albarracin & Benitez <3", 800, 600);

		// Inicializar lo que haga falta para el juego
		this.lemmings = new Lemmings[5]; // por cada plataforma
		this.plataformas = new Plataforma[4]; // fijas
		this.plataformasRandom = new Plataforma[4]; // random
		for (int i = 0; i < this.plataformas.length; i++) // plataformas fijas
			this.plataformas[i] = new Plataforma();

		// establecemos puntos de aparición de las plataformas fijas
		this.plataformas[0].setX(60);
		this.plataformas[0].setY(60);

		this.plataformas[1].setX(60);
		this.plataformas[1].setY(310);

		this.plataformas[2].setX(60);
		this.plataformas[2].setY(540);

		this.plataformas[3].setX(780);
		this.plataformas[3].setY(540);
		this.plataformas[3].setAncho(60);

		for (int i = 0; i < this.plataformas.length; i++) // plataformas random
		{
			this.plataformasRandom[i] = new Plataforma(true);
		}

		this.plataformasRandom[0].setSeleccionado(true);

		// establecemos ancho y alto de las plataformas random
		this.plataformasRandom[0].setAlto(50);
		this.plataformasRandom[0].setAncho(250);

		this.plataformasRandom[1].setAlto(20);
		this.plataformasRandom[1].setAncho(150);

		this.plataformasRandom[2].setAlto(60);
		this.plataformasRandom[2].setAncho(200);

		this.plataformasRandom[3].setAlto(50);
		this.plataformasRandom[3].setAncho(50);

		for (int i = 0; i < this.lemmings.length; i++) {
			this.lemmings[i] = new Lemmings();
		}

		// Inicia el juego
		this.entorno.iniciar();
	}

	public void tick() {

		// System.out.println(this.cantPresionadas);
		for (int i = 0; i < lemmings.length; i++)
			this.lemmings[i].dibujar(this.entorno); // dibujamos los lemmings

		for (int i = 0; i < plataformas.length; i++)
			this.plataformas[i].dibujar(this.entorno, Color.YELLOW);// dibujamos
																	// las
																	// plataformas
																	// fijas

		for (int i = 0; i < this.plataformasRandom.length; i++) {
			this.plataformasRandom[i].dibujar(this.entorno, Color.PINK);// dibujamos
																		// las
																		// plataformas
																		// random

		}

		boolean aux = false;

		if (this.plataformasRandom[0].seleccionado()) {
			// plataforma cero, default
			if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA))
				this.plataformasRandom[0].subir();
			if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO))
				this.plataformasRandom[0].bajar();

			if (this.entorno.sePresiono(this.entorno.TECLA_DERECHA)) {
				System.out.println("se presiono");
				this.plataformasRandom[0].setSeleccionado(false);
				aux = true;
				this.plataformasRandom[1].setSeleccionado(aux);

			}

		}

		System.out.println(aux);

		// System.out.println(this.plataformasRandom[1].seleccionado());

		if (this.plataformasRandom[1].seleccionado()) {
			// plataforma cero, default
			if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA))
				this.plataformasRandom[1].subir();
			if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO))
				this.plataformasRandom[1].bajar();

			if (this.entorno.sePresiono(this.entorno.TECLA_DERECHA)) {
				this.plataformasRandom[0].setSeleccionado(false);
				this.plataformasRandom[1].setSeleccionado(false);
				this.plataformasRandom[2].setSeleccionado(true);
			}
		}

		if (this.plataformasRandom[2].seleccionado()) {
			// plataforma cero, default
			if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA))
				this.plataformasRandom[2].subir();
			if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO))
				this.plataformasRandom[2].bajar();

			if (this.entorno.sePresiono(this.entorno.TECLA_DERECHA)) {
				this.plataformasRandom[0].setSeleccionado(false);
				this.plataformasRandom[1].setSeleccionado(false);
				this.plataformasRandom[2].setSeleccionado(false);
				this.plataformasRandom[3].setSeleccionado(true);
			}
		}

		if (this.plataformasRandom[3].seleccionado()) {
			// plataforma cero, default
			if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA))
				this.plataformasRandom[3].subir();
			if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO))
				this.plataformasRandom[3].bajar();

			if (this.entorno.sePresiono(this.entorno.TECLA_DERECHA)) {
				this.plataformasRandom[0].setSeleccionado(true);
				this.plataformasRandom[1].setSeleccionado(false);
				this.plataformasRandom[2].setSeleccionado(false);
				this.plataformasRandom[3].setSeleccionado(false);
			}
		}

	}

	public static void main(String[] args) {
		Juego juego = new Juego();
		// System.out.println(juego.plataformasRandom[1].seleccionado());
	}
}
