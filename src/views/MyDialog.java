package views;

import java.util.ArrayList;
import javax.swing.*;
import models.Arquero;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private DispersionGraphicPanel panel; 

	public MyDialog(JFrame parent) {
        super(parent, Constants.TEXT_DIALOG, true);
        panel = new DispersionGraphicPanel(); 
        panel.setBounds(0, 0, 200, 200);
        add(panel);
        setSize(700, 600);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        revalidate();
        repaint(); 
    }
	
	public void graphicPlayerData(ArrayList<Arquero> competitors) {
		panel.graphicPlayerData(competitors);
	}
}
