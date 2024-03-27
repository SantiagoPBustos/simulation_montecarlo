package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import models.Arquero;
import models.Equipo;
import models.Genero;
import models.Suerte;

public class PrincipalPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private InfoDataPanelLeft top;
	private InfoDataPanelRight right;

	public PrincipalPanel(ActionListener actionListener) {
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		setLayout(new GridLayout(1, 2));

		top = new InfoDataPanelLeft();
		top.setOpaque(false);
		add(top);

		right = new InfoDataPanelRight(actionListener);
		right.setOpaque(false);
		add(right);
	}

	public void clearTables() {
		top.clearTables();
	}

	public void showPlayerInTable(int lap, Suerte player) {
		top.showPlayerInTable(lap, player);
	}

	public void showGenderInTable(int lap, Genero gender) {
		right.showGenderInTable(lap, gender);
	}

	public void setCompetitor(Arquero competitor) {
		top.setCompetitor(competitor);
	}

	public void clearTableTeams() {
		right.clearTableTeams();
	}

	public void showTeamsInTable(Equipo team) {
		top.showTeamsInTable(team);
	}

	public void setTheBestGender(Genero gender) {
		right.setTheBestGender(gender);
	}

	public void setRoundsText(int rounds) {
		right.setRoundsText(rounds);
	}
}
