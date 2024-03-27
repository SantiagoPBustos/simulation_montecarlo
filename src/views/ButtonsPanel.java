package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Commands;

public class ButtonsPanel extends JPanel {

	private JButton btnGraph, btnAdd, btnInit;
	private static final long serialVersionUID = 1L;

	public ButtonsPanel(ActionListener actionListener) {
		super();
		btnGraph = new JButton();
		btnAdd = new JButton();
		btnInit = new JButton();
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.setLayout(new GridLayout(1, 3));
		this.setVisible(true);

		btnGraph.setText(Constants.TEXT_GRAPH);
		ImageIcon imgGraph = new ImageIcon(getClass().getResource(Constants.PATH + Constants.PATH_GRAPH));
		btnGraph.setIcon(new ImageIcon(imgGraph.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGraph.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGraph.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGraph.setContentAreaFilled(false);
		btnGraph.setBorderPainted(false);
		btnGraph.setForeground(Color.WHITE);
		btnGraph.setFont(Constants.FONT_TITLE);
		btnGraph.addActionListener(actionListener);
		btnGraph.setActionCommand(Commands.GRAPH.toString());
		add(btnGraph);

		btnAdd.setText(Constants.TEXT_ADD);
		ImageIcon imgAdd = new ImageIcon(getClass().getResource(Constants.PATH + Constants.PATH_ADD));
		btnAdd.setIcon(new ImageIcon(imgAdd.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(Constants.FONT_TITLE);
		btnAdd.addActionListener(actionListener);
		btnAdd.setActionCommand(Commands.ADD_TOTAL_ROUNDS.toString());
		add(btnAdd);

		btnInit.setText(Constants.TEXT_PLAY);
		ImageIcon imgInit = new ImageIcon(getClass().getResource(Constants.PATH + Constants.PATH_PLAY));
		btnInit.setIcon(new ImageIcon(imgInit.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnInit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInit.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnInit.setContentAreaFilled(false);
		btnInit.setBorderPainted(false);
		btnInit.setForeground(Color.WHITE);
		btnInit.setFont(Constants.FONT_TITLE);
		btnInit.addActionListener(actionListener);
		btnInit.setActionCommand(Commands.START_GAME.toString());
		add(btnInit);

		revalidate();
	}
}

