package models;

import java.util.ArrayList;

public class Juego {

	private ArrayList<Equipo> equipos;
	private int victoriasEquipoUno;
	private int victoriasEquipoDos;
	private Arquero arqueroSuerteActual;
	private int contadorArqueroSuperSuerte;
	private int contadorVictoriasHombres;
	private int contadorVictoriasMujeres;

	public Juego(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
		this.contadorVictoriasHombres = 0;
		this.contadorVictoriasMujeres = 0;
	}

	public void iniciarJuego() {
		victoriasEquipoUno = 0;
		victoriasEquipoDos = 0;
		while (victoriasEquipoUno < 10 && victoriasEquipoDos < 10) {
			lanzarEquipos(equipos);
		}
	}

	private void lanzarEquipos(ArrayList<Equipo> equipos) {
		for (Equipo equipo : equipos) {
			lanzarFlechasCompetidores(equipo);
		}
		validarEquipoGanadorEnVuelta();
		validarYReiniciar();
	}

	public void validarYReiniciar() {
		for (Equipo equipo : equipos) {
			suerteCompetidor(equipo);
			validarSuperSuerteCompetidor();
			validarExperienciaCompetidor();
			equipo.reiniciarSuerte();
			equipo.setPuntosJuego(equipo.getPuntajeParcial());
			equipo.reiniciarPuntajeParcial();
			equipo.agregarPuntosALaboratorio();
			equipo.reiniciarPuntajeCompetidores();
		}
	}

	private void validarExperienciaCompetidor() {
		if (this.equipos.get(0).competidorConMayorPuntaje().getPuntajeCompetidor() > this.equipos.get(1).competidorConMayorPuntaje()
				.getPuntajeCompetidor()) {
			this.equipos.get(0).competidorConMayorPuntaje().setExperiencia();
			validarGéneroGanadorLaboratorio(this.equipos.get(0).competidorConMayorPuntaje());
		} else {
			this.equipos.get(1).competidorConMayorPuntaje().setExperiencia();
			validarGéneroGanadorLaboratorio(this.equipos.get(1).competidorConMayorPuntaje());
		}
	}

	private void validarGéneroGanadorLaboratorio(Arquero competidor) {
		if (competidor.getGenero().equals(Genero.MASCULINO)) {
			contadorVictoriasHombres++;
		} else {
			contadorVictoriasMujeres++;
		}
	}

	private void validarSuperSuerteCompetidor() {
		if (contadorArqueroSuperSuerte == 3) {
			lanzarFlechaSuerte(arqueroSuerteActual, buscarEquipo(arqueroSuerteActual));
			contadorArqueroSuperSuerte = 0;
		}
	}

	private void suerteCompetidor(Equipo equipo) {
		Arquero temp = equipo.competidorConMayorPuntaje();
		if (arqueroSuerteActual != null) {
			if (arqueroSuerteActual.equals(temp)) {
				contadorArqueroSuperSuerte++;
			}
		}
		lanzarFlechaSuerte(temp, equipo);
	}

	private void validarEquipoGanadorEnVuelta() {
		if (this.equipos.get(0).getPuntajeParcial() > this.equipos.get(1).getPuntajeParcial()) {
			victoriasEquipoUno++;
		} else {
			victoriasEquipoDos++;
		}
	}

	private void lanzarFlechasCompetidores(Equipo equipo) {
		for (Arquero competidor : equipo.getCompetidores()) {
			lanzarFlecha(competidor);
			equipo.setPuntajeParcial(competidor.getPuntajeCompetidor());
			equipo.setPuntaje(competidor.getPuntajeCompetidor());
			if (competidor.getExperiencia() == competidor.getExperienciaTope()) {
				competidor.setTieneResistencia(true);
			}
		}
	}

	private void lanzarFlecha(Arquero competidor) {
		switch (competidor.getGenero()) {
		case FEMENINO:
			for (int i = 0; i < competidor.getResistencia() / 5; i++) {
				competidor.setPuntajeCompetidor(puntosEnLanzamientoFemenino(Math.random()));
			}
			validarBonificaciónResistencia(competidor);
			break;
		case MASCULINO:
			for (int i = 0; i < competidor.getResistencia() / 5; i++) {
				competidor.setPuntajeCompetidor(puntosEnLanzamientoMasculino(Math.random()));
			}
			validarBonificaciónResistencia(competidor);
			break;
		}
	}

	private void validarBonificaciónResistencia(Arquero competidor) {
		if (competidor.tieneResistencia()) {
			validarResistenciaBonificación(competidor);
		} else {
			competidor.setResistencia((int) (Math.random() * 2 + 1));
		}
	}

	private void validarResistenciaBonificación(Arquero competidor) {
		if (competidor.getVueltasSinResistencia() == 0) {
			competidor.setTieneResistencia(false);
		} else {
			competidor.setVueltasSinResistencia();
		}
	}

	private void lanzarFlechaSuerte(Arquero competidor, Equipo equipo) {
		switch (competidor.getGenero()) {
		case FEMENINO:
			competidor.setContadorSuerte();
			for (int i = 0; i < competidor.getResistencia() / 5; i++) {
				equipo.setPuntaje(puntosEnLanzamientoFemenino(Math.random()));
			}
			break;
		case MASCULINO:
			competidor.setContadorSuerte();
			for (int i = 0; i < competidor.getResistencia() / 5; i++) {
				equipo.setPuntaje(puntosEnLanzamientoMasculino(Math.random()));
			}
			break;
		}
	}

	private int puntosEnLanzamientoFemenino(double xi) {
		if (xi > 0 && xi < 0.3) {
			return 10;
		} else if (xi >= 0.3 && xi < 0.68) {
			return 9;
		} else if (xi >= 0.68 && xi < 0.95) {
			return 8;
		}
		return 0;
	}

	private int puntosEnLanzamientoMasculino(double xi) {
		if (xi > 0 && xi < 0.2) {
			return 10;
		} else if (xi >= 0.2 && xi < 0.53) {
			return 9;
		} else if (xi >= 0.53 && xi < 0.93) {
			return 8;
		}
		return 0;
	}

	private Equipo buscarEquipo(Arquero competidor) {
		for (Equipo equipo : equipos) {
			for (Arquero c : equipo.getCompetidores()) {
				if (c.equals(competidor)) {
					return equipo;
				}
			}
		}
		return null;
	}

	public int getContadorVictoriasHombres() {
		return contadorVictoriasHombres;
	}

	public int getContadorVictoriasMujeres() {
		return contadorVictoriasMujeres;
	}
}