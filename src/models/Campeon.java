package models;

import java.util.ArrayList;

public class Campeon {

	private ArrayList<Equipo> equipos;
	private ArrayList<Suerte> arquerosSuerte;
	private ArrayList<Genero> estadisticasGenero;
	private ArrayList<Arquero> arqueros;

	public Campeon(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
		this.arquerosSuerte = new ArrayList<>();
		this.estadisticasGenero = new ArrayList<>();
	}

	public void iniciarCampeonato(int juegos) {
		for (int i = 0; i < juegos; i++) {
			Juego juego = new Juego(equipos);
			juego.iniciarJuego();
			reiniciarResistencia();
			agregarSuerteJuegoCompetidor();
			agregarPartidaGanada();
			agregarPuntosEnJuego(equipos);
			reiniciarContadorSuerte(equipos);
			estadisticasGenero.add(
				juego.getContadorVictoriasMujeres() > juego.getContadorVictoriasHombres() ? Genero.FEMENINO
							: Genero.MASCULINO);
		}
	}

	private void agregarPartidaGanada() {
		if (equipos.get(0).getPuntos() > equipos.get(1).getPuntos()) {
			equipos.get(0).setContadorGanarJuego();
		} else {
			equipos.get(1).setContadorGanarJuego();
		}
	}

	private void agregarPuntosEnJuego(ArrayList<Equipo> equipos) {
		for (Equipo equipo : equipos) {
			equipo.agregarPuntosALista();
			equipo.reiniciarPuntosJuego();
		}
	}

	private void reiniciarContadorSuerte(ArrayList<Equipo> equipos) {
		for (Equipo equipo : equipos) {
			for (Arquero c : equipo.getCompetidores()) {
				c.reiniciarContadorSuerte();
			}
		}
	}

	private void reiniciarResistencia() {
		for (Equipo equipo : equipos) {
			equipo.reiniciarResistencia();
		}
	}

	private void agregarSuerteJuegoCompetidor() {
		Arquero competidor = getMaximaSuerteCompetidor();
		arquerosSuerte.add(new Suerte(competidor.getNombre(), competidor.getSuerte()));
	}

	public Arquero getCompetidorConMaximaExperiencia() {
		return equipos.get(0).competidorConMayorExperiencia().getExperiencia() > equipos.get(1).competidorConMayorExperiencia().getExperiencia()
				? equipos.get(0).competidorConMayorExperiencia()
				: equipos.get(1).competidorConMayorExperiencia();
	}

	public Equipo ganarJuego() {
		return equipos.get(0).getContadorGanarJuego() > equipos.get(1).getContadorGanarJuego() ? equipos.get(0)
				: equipos.get(1);
	}

	public ArrayList<Suerte> getArquerosSuerte() {
		return arquerosSuerte;
	}

	public ArrayList<Genero> getEstadisticasGenero() {
		return estadisticasGenero;
	}

	public Genero getMejorGenero() {
		int conteoMasculino = 0;
		int conteoFemenino = 0;
		for (Genero genero : estadisticasGenero) {
			if (genero == Genero.MASCULINO) {
				conteoMasculino++;
			} else {
				conteoFemenino++;
			}
		}
		return conteoMasculino > conteoFemenino ? Genero.MASCULINO : Genero.FEMENINO;
	}

	private Arquero getMaximaSuerteCompetidor() {
		return equipos.get(0).competidorConMayorSuerte().getContadorSuerte() > equipos.get(1).competidorConMayorSuerte().getContadorSuerte()
				? equipos.get(0).competidorConMayorSuerte()
				: equipos.get(1).competidorConMayorSuerte();
	}

	public ArrayList<Arquero> getCompetidores() {
		arqueros = new ArrayList<>();
		for (Equipo equipo : equipos) {
			for (Arquero competidor : equipo.getCompetidores()) {
				arqueros.add(competidor);
			}
		}
		return arqueros;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public static Genero generarGenero() {
		Uniform uniforme = new Uniform(1);
		return uniforme.getAleatory().get(0) > 0.5 ? Genero.FEMENINO : Genero.MASCULINO;
	}

	public void reiniciarJuego() {
		arquerosSuerte = new ArrayList<>();
		estadisticasGenero = new ArrayList<>();
		arqueros = new ArrayList<>();
	}
}
