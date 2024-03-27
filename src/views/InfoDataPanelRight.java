


package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import models.Genero;

public class InfoDataPanelRight extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel label4, label5;
	private String[] headerGenderTable = { "Juego", "Género Ganador" };
	private DefaultTableModel modelGender;
	private JTable tableGenders;

	public InfoDataPanelRight(ActionListener actionListener) {
		setLayout(new GridBagLayout());
		label4 = new JLabel();
		label5 = new JLabel();
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel label2 = new JLabel(Constants.FOURTH);
		label2.setFont(Constants.FONT_TITLE);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 0);
		add(label2, gbc);

		modelGender = new DefaultTableModel();
		modelGender.setColumnIdentifiers(headerGenderTable);
		tableGenders = new JTable(modelGender);
		tableGenders.getTableHeader().setBackground(Color.decode("#0C0C0D"));
		tableGenders.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.WHITE));
		tableGenders.getTableHeader().setForeground(Color.WHITE);
		tableGenders.getTableHeader().setFont(Constants.FONT_TITLE);
		tableGenders.setForeground(Color.BLACK);	
		tableGenders.setFont(Constants.FONT_NORMAL);
		tableGenders.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableGenders.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableGenders.setShowGrid(false); 
		tableGenders.setRowHeight(30);
		JScrollPane tableGendersJScrollPane = new JScrollPane(tableGenders);
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		tableGenders.setPreferredScrollableViewportSize(new Dimension(tableGenders.getPreferredSize().width, tableGenders.getRowHeight() * 6));
		tableGendersJScrollPane.getViewport().setBackground(Color.WHITE);
		add(tableGendersJScrollPane, gbc);

		JLabel label3 = new JLabel(Constants.FIVE);
		label3.setFont(Constants.FONT_TITLE);
		gbc.gridy = 2;
		add(label3, gbc);

		label4.setFont(Constants.FONT_NORMAL);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setHorizontalTextPosition(SwingConstants.CENTER);
		gbc.gridy = 3;
		add(label4, gbc);

		ButtonsPanel buttons = new ButtonsPanel(actionListener);
		buttons.setOpaque(false);
		gbc.gridy = 5;
		add(buttons, gbc);

		emptyRows();
	}

	private void emptyRows() {
		for (int i = 0; i < 10; i++) {
			modelGender.addRow(new Object[] {});
		}
	}

	public void clearTableTeams() {
		modelGender.setRowCount(0);
		tableGenders.setShowGrid(true);
	}

	public void showGenderInTable(int lap, Genero gender) {
		modelGender.addRow(new Object[] { lap, gender });
	}

	public void setTheBestGender(Genero gender) {
		label4.setText(gender.toString());
	}

	public void setRoundsText(int rounds) {
		label5.setText(Constants.TEXT_ROUNDS + rounds);
	}

}
