package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import models.Arquero;
import models.Equipo;
import models.Suerte;

public class InfoDataPanelLeft extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] headerPlayersTable = { "Juego", "Jugador", "Suerte" };
	private DefaultTableModel modelPlayers;
	private String[] headerTeamTable = { "Equipo", "Juegos Ganados", "Puntaje" };
	private DefaultTableModel modelTeams;
	private JLabel label4, label5;
	private JTable tablePlayers, tableTeams; ;

	public InfoDataPanelLeft() {
		setLayout(new GridBagLayout());
		label4 = new JLabel();
		label5 = new JLabel();
		initComponents();
		setVisible(true);
	}

	public void initComponents() {
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel label2 = new JLabel(Constants.FIRST);
		label2.setFont(Constants.FONT_TITLE);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 0);
		add(label2, gbc);

		modelPlayers = new DefaultTableModel();
		modelPlayers.setColumnIdentifiers(headerPlayersTable);
		tablePlayers = new JTable(modelPlayers);
		tablePlayers.getTableHeader().setBackground(Color.decode("#0C0C0D"));
		tablePlayers.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.WHITE));
		tablePlayers.getTableHeader().setForeground(Color.WHITE);
		tablePlayers.getTableHeader().setFont(Constants.FONT_TITLE);
		tablePlayers.setForeground(Color.BLACK);
		tablePlayers.setFont(Constants.FONT_NORMAL);
		tablePlayers.getColumnModel().getColumn(0).setPreferredWidth(80);
		tablePlayers.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablePlayers.getColumnModel().getColumn(2).setPreferredWidth(150);
		tablePlayers.setShowGrid(false);
		tablePlayers.setRowHeight(30);
		JScrollPane tablePlayersJScrollPane = new JScrollPane(tablePlayers);
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		tablePlayers.setPreferredScrollableViewportSize(
				new Dimension(tablePlayers.getPreferredSize().width, tablePlayers.getRowHeight() * 6));
		tablePlayersJScrollPane.getViewport().setBackground(Color.WHITE);
		add(tablePlayersJScrollPane, gbc);

		JLabel label3 = new JLabel(Constants.SECOND);
		label3.setFont(Constants.FONT_TITLE);
		gbc.gridy = 2;
		add(label3, gbc);

		label4.setFont(Constants.FONT_NORMAL);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setHorizontalTextPosition(SwingConstants.CENTER);
		gbc.gridy = 3;
		add(label4, gbc);

		label5.setFont(Constants.FONT_NORMAL);
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setHorizontalTextPosition(SwingConstants.CENTER);
		gbc.gridy = 4;
		add(label5, gbc);

		JLabel label6 = new JLabel(Constants.THIRD);
		label6.setFont(Constants.FONT_TITLE);
		gbc.gridy = 5;
		add(label6, gbc);


		modelTeams = new DefaultTableModel();
		modelTeams.setColumnIdentifiers(headerTeamTable);
		tableTeams = new JTable(modelTeams);
		tableTeams.getTableHeader().setBackground(Color.decode("#0C0C0D"));
		tableTeams.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.WHITE));
		tableTeams.getTableHeader().setForeground(Color.WHITE);
		tableTeams.getTableHeader().setFont(Constants.FONT_TITLE);
		tableTeams.setBackground(Color.WHITE);
		tableTeams.setForeground(Color.BLACK);	
		tableTeams.setFont(Constants.FONT_NORMAL);
		tableTeams.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableTeams.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableTeams.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableTeams.setShowGrid(false);
		tableTeams.setRowHeight(30);
		JScrollPane tableTeamsJScrollPane = new JScrollPane(tableTeams);
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.BOTH;
		tableTeams.setPreferredScrollableViewportSize(new Dimension(tableTeams.getPreferredSize().width, tableTeams.getRowHeight() * 6));
		tableTeamsJScrollPane.getViewport().setBackground(Color.WHITE);
		add(tableTeamsJScrollPane, gbc); 
		
		emptyRows();

	}

	private void emptyRows() {
		for (int i = 0; i < 10; i++) {
			modelPlayers.addRow(new Object[] {});
			modelTeams.addRow(new Object[] {});
		}
	}

	public void clearTables() {
		modelPlayers.setRowCount(0);
		modelTeams.setRowCount(0);
		tableTeams.setShowGrid(true);
		tablePlayers.setShowGrid(true);
	}

	public void showPlayerInTable(int lap, Suerte player) {
		modelPlayers.addRow(new Object[] { lap, player.getNombre(), player.getSuerte() });
	}

	public void showTeamsInTable(Equipo team) {
		modelTeams.addRow(new Object[] { team.getNombreEquipo(), team.getContadorGanarJuego(), team.getPuntaje() });
	}


	public void setCompetitor(Arquero competitor) {
		label4.setText(Constants.TEXT_PLAYER + competitor.getNombre());
		label5.setText(Constants.TEXT_EXPERIENCE + competitor.getExperiencia());
	}
}
