package models;

import java.util.ArrayList;

public class Equipo {

	private String nombreEquipo;
	private int puntaje;
	private int puntajeParcial;
	private int contadorGanarJuego;
	private ArrayList<Arquero> competidores;
	private ArrayList<Integer> puntosJuego;
	private ArrayList<Integer> puntosLaboratorio;
	private int puntos;

	public Equipo(String nombreEquipo, ArrayList<Arquero> competidores) {
		this.nombreEquipo = nombreEquipo;
		this.puntaje = 0;
		this.competidores = competidores;
		this.puntajeParcial = 0;
		this.contadorGanarJuego = 0;
		this.puntosJuego = new ArrayList<>();
		this.puntos = 0;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = (this.puntaje + puntaje);
	}

	public ArrayList<Arquero> getCompetidores() {
		return competidores;
	}

	public void reiniciarPuntajeCompetidores() {
		for (Arquero competidor : competidores) {
			competidor.reiniciarPuntajeCompetidor();
		}
	}

	public int getPuntajeParcial() {
		return puntajeParcial;
	}

	public void setPuntajeParcial(int puntajeParcial) {
		this.puntajeParcial = (this.puntajeParcial + puntajeParcial);
	}

	public void reiniciarPuntajeParcial() {
		this.puntajeParcial = 0;
	}

	public Arquero competidorConSuerte() {
		Arquero competidorTemp = competidores.get(0);
		for (Arquero competidor : competidores) {
			if (competidor.getSuerte() > competidorTemp.getSuerte()) {
				competidorTemp = competidor;
			}
		}
		return competidorTemp;
	}

	public void reiniciarResistencia() {
		for (Arquero competidor : competidores) {
			competidor.reiniciarResistencia();
		}
	}

	public Arquero competidorConMayorPuntaje() {
		Arquero competidorTemp = competidores.get(0);
		for (Arquero competidor : competidores) {
			if (competidor.getSuerte() > competidorTemp.getSuerte()) {
				competidorTemp = competidor;
			}
		}
		return competidorTemp;
	}

	public void reiniciarSuerte() {
		for (Arquero competidor : competidores) {
			competidor.setSuerte();
		}
	}

	public Arquero competidorConMayorSuerte() {
		Arquero competidorTemp = competidores.get(0);
		for (Arquero competidor : competidores) {
			if (competidor.getContadorSuerte() > competidorTemp.getContadorSuerte()) {
				competidorTemp = competidor;
			}
		}
		return competidorTemp;
	}

	public Arquero competidorConMayorExperiencia() {
		Arquero competidorTemp = competidores.get(0);
		for (Arquero competidor : competidores) {
			if (competidor.getExperiencia() > competidorTemp.getExperiencia()) {
				competidorTemp = competidor;
			}
		}
		return competidorTemp;
	}

	public int getContadorGanarJuego() {
		return contadorGanarJuego;
	}

	public void setContadorGanarJuego() {
		this.contadorGanarJuego++;
	}

	public ArrayList<Integer> getPuntosJuego() {
		return puntosJuego;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntosJuego(int puntos) {
		this.puntos = (this.puntos + puntos);
	}

	public ArrayList<Integer> getPuntosLaboratorio() {
		puntosLaboratorio = new ArrayList<>();
		for (int i = 0; i < competidores.get(0).getPuntosPorVuelta().size(); i++) {
			int puntos = 0;
			for (Arquero competidor : competidores) {
				puntos += competidor.getPuntosPorVuelta().get(i);
			}
			puntosLaboratorio.add(puntos);
		}
		return puntosLaboratorio;
	}

	public void reiniciarPuntosJuego() {
		this.puntos = 0;
	}

	public void agregarPuntosALista() {
		puntosJuego.add(getPuntos());
	}

	public void agregarPuntosALaboratorio() {
		for (Arquero competidor : competidores) {
			competidor.agregarPuntoAVuelta();
		}
	}

}
