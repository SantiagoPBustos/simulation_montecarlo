package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Campeon;
import models.Arquero;
import models.Genero;
import models.Suerte;
import models.Equipo;
import views.Constants;
import views.MainFrame;
import views.MyDialog;

public class Controlador implements ActionListener {

	private Campeon Campeonn;
	private MainFrame frame;
	private int totalRounds;

	public Controlador() {
		data();
		init();
	}

	private void data() {
		ArrayList<Arquero> firstEquipoCompetitors = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			firstEquipoCompetitors.add(new Arquero("Jugador Equipo Uno : NPC " + (i + 1), Campeon.generarGenero()));
		}
		Equipo firstEquipo = new Equipo("Equipo Uno", firstEquipoCompetitors);
		ArrayList<Arquero> secondEquipoCompetitors = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			secondEquipoCompetitors.add(new Arquero("Jugador Equipo Dos : NPC" + (i + 1), Campeon.generarGenero()));
		}
		Equipo secondEquipo = new Equipo("Equipo Dos ", secondEquipoCompetitors);

		ArrayList<Equipo> Equipos = new ArrayList<>();
		Equipos.add(firstEquipo);
		Equipos.add(secondEquipo);

		Campeonn = new Campeon(Equipos);
		frame = new MainFrame(this);
	}

	private void init() {
		totalRounds = 0;
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
			case ADD_TOTAL_ROUNDS:
				addTotalRounds();
				break;
			case START_GAME:
				startGame();
				break;
			case GRAPH:
				MyDialog dialog = new MyDialog(frame);
				dialog.pack();
				dialog.graphicPlayerData(Campeonn.getCompetidores());
				dialog.setVisible(true);
				break;
			default:
				break;
		}
	}

	private void addTotalRounds() {
		totalRounds = Integer.valueOf(JOptionPane.showInputDialog(Constants.TEXT_ADD_ROUNDS));
		frame.setRoundsText(totalRounds);
	}

	private void startGame() {
		Campeonn.reiniciarJuego();
		if (totalRounds != 0) {
			Campeonn.iniciarCampeonato(totalRounds);
			frame.clearTables();
			frame.clearTableTeams();

			ArrayList<Suerte> competitors = Campeonn.getArquerosSuerte();
			for (int i = 0; i < competitors.size(); i++) {
				frame.showPlayerInTable((i + 1), competitors.get(i));
			}

			Arquero theBestCompetitor = Campeonn.getCompetidorConMaximaExperiencia();
			frame.setCompetitor(theBestCompetitor);

			Equipo theBestEquipo = Campeonn.ganarJuego();
			frame.showTeamsInTable(theBestEquipo);

			ArrayList<Genero> theBestGenders = Campeonn.getEstadisticasGenero();
			for (int i = 0; i < theBestGenders.size(); i++) {
				frame.showGenderInTable(i + 1, theBestGenders.get(i));
			}

			Genero gender = Campeonn.getMejorGenero();
			frame.setTheBestGender(gender);
		} else {
			JOptionPane.showMessageDialog(frame, Constants.TEXT_FIRST_ADD_ROUNDS);
		}
	}
}