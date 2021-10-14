package org.cloud.apps.qa.view.graphic;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cloud.apps.qa.controller.StartController;
import org.cloud.apps.qa.view.util.Constraints;
import org.cloud.apps.qa.view.util.Msgs;

public class PlayerDialogGraphicView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8047384606282622229L;
	private String[] players;
	private JTextField[] inputs;
	private FrameView frameView;
	
	public PlayerDialogGraphicView() {
	    super();
	    this.setLayout(new GridBagLayout());
	    this.setSize(500,500);
	}
	
	public String[] getPlayers() {
		return players;
	}

	public void playersPanel(StartController startController) {
		players = new String[startController.getNumPlayers()];
	    
	    inputs = new JTextField[players.length];
	    JLabel[] labels = new JLabel[players.length];
	    
		for (int turn = 0; turn < players.length; turn++) {
			labels[turn] = new JLabel(String.format(String.format(Msgs.PLAYER, turn)));
		    this.add(labels[turn], new Constraints(0, turn+1, 1, 1));
		    inputs[turn] = new JTextField(1);
		    this.add(inputs[turn], new Constraints(0, turn+2, 1, 1));
		}
		JButton button = new JButton(Msgs.ACCEPT);
	    this.add(button, new Constraints(0, 5, 1, 1));
	    button.addActionListener(this);
	    this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < players.length; i++) {
			players[i] = inputs[i].getText();
		}
	}

	public void initGame(StartController startController) {
		// TODO Auto-generated method stub
		
	}
	
}
