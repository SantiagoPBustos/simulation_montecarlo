package models;

import java.util.ArrayList;
import java.util.Random;

public class Arquero {

	private final int RESISTENCIA_INICIAL = this.generarResistenciaInicial();

	private String nombreArquero;
	private int resistencia;
	private int experiencia;
	private float suerte;
	private int contadorSuerte;
	private int contadorVueltasGanadas;
	private int puntajeArquero;
	private Genero genero;
	private ArrayList<Integer> puntosPorVuelta;
	private int vueltasSinResistencia;
	private boolean tieneResistencia;
	private int experienciaTope;

	public Arquero(String nombre, Genero genero) {
		this.nombreArquero = nombre;
		this.resistencia = RESISTENCIA_INICIAL;
		this.experiencia = 10;
		this.suerte = (float) numeroAleatorio(1, 3);
		this.contadorSuerte = 0;
		this.contadorVueltasGanadas = 0;
		this.genero = genero;
		this.puntajeArquero = 0;
		this.puntosPorVuelta = new ArrayList<>();
		this.experienciaTope = experiencia + 10;
		this.vueltasSinResistencia = 3;
		this.tieneResistencia = false;
	}

	private int numeroAleatorio(int min, int max) {
		Random random = new Random();
		int valor = random.nextInt(max + min) + min;
		return valor;
	}

	private double numeroDobleAleatorio(int min, int max) {
		Random random = new Random();
		double valor = (random.nextDouble() * (max - min)) + min;
		return valor;
	}

	private int generarResistenciaInicial() {
		int aux = numeroAleatorio(0, 1);
		if (aux == 0) {
			return 35 + numeroAleatorio(1, 10);
		} else {
			return 35 - numeroAleatorio(1, 10);
		}
	}

	public String getNombre() {
		return nombreArquero;
	}

	public int getVueltasSinResistencia() {
		return vueltasSinResistencia;
	}

	public void setVueltasSinResistencia() {
		this.vueltasSinResistencia--;
	}

	public int getExperienciaTope() {
		return experienciaTope;
	}

	public void setExperienciaTope() {
		this.experienciaTope = (this.experienciaTope + 9);
	}

	public boolean tieneResistencia() {
		return tieneResistencia;
	}

	public void setTieneResistencia(boolean tieneResistencia) {
		this.tieneResistencia = tieneResistencia;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int valorCansancio) {
		this.resistencia = (this.resistencia - valorCansancio);
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia() {
		this.experiencia = (this.experiencia + 3);
	}

	public float getSuerte() {
		return suerte;
	}

	public void setSuerte() {
		this.suerte = (float) numeroDobleAleatorio(0, 3);
	}

	public int getContadorSuerte() {
		return contadorSuerte;
	}

	public void setContadorSuerte() {
		this.contadorSuerte++;
	}

	public void reiniciarContadorSuerte() {
		this.contadorSuerte = 0;
	}

	public int getContadorVueltasGanadas() {
		return contadorVueltasGanadas;
	}

	public void setContadorVueltasGanadas() {
		this.contadorVueltasGanadas = 0;
	}

	public Genero getGenero() {
		return genero;
	}

	public void reiniciarResistencia() {
		this.resistencia = RESISTENCIA_INICIAL;
	}

	public int getPuntajeCompetidor() {
		return puntajeArquero;
	}

	public void setPuntajeCompetidor(int puntajeCompetidor) {
		this.puntajeArquero = (this.puntajeArquero + puntajeCompetidor);
	}

	public void reiniciarPuntajeCompetidor() {
		this.puntajeArquero = 0;
	}

	public void agregarPuntoAVuelta() {
		this.puntosPorVuelta.add(getPuntajeCompetidor());
	}

	public ArrayList<Integer> getPuntosPorVuelta() {
		return puntosPorVuelta;
	}
}