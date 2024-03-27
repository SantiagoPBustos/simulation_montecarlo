package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.Arquero;
import models.Genero;
import models.Suerte;
import models.Equipo;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private PrincipalPanel left;

	public MainFrame(ActionListener actionListener) {
		super(Constants.APP_NAME);
		this.setMinimumSize(new Dimension(1200, 850));
		left = new PrincipalPanel(actionListener);
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());

		JLabel label1 = new JLabel(Constants.APP_NAME);
		label1.setFont(Constants.FONT_TITLE);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setVerticalAlignment(SwingConstants.TOP);
		label1.setBorder(new EmptyBorder(20, 0, 0, 0));
		add(label1, BorderLayout.PAGE_START);

		left.setOpaque(false);
		add(left);
	}

	public void clearTables() {
		left.clearTables();
	}

	public void showPlayerInTable(int lap, Suerte player) {
		left.showPlayerInTable(lap, player);
	}

	public void showGenderInTable(int lap, Genero gender) {
		left.showGenderInTable(lap, gender);
	}

	public void setCompetitor(Arquero competitor) {
		left.setCompetitor(competitor);
	}

	public void clearTableTeams() {
		left.clearTableTeams();
	}

	public void showTeamsInTable(Equipo team) {
		left.showTeamsInTable(team);
	}

	public void setTheBestGender(Genero gender) {
		left.setTheBestGender(gender);
	}

	public void setRoundsText(int rounds) {
		left.setRoundsText(rounds);
	}
}
