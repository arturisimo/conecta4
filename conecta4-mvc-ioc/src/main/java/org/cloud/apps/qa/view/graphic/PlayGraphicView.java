package org.cloud.apps.qa.view.graphic;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cloud.apps.qa.controller.PlayController;
import org.cloud.apps.qa.view.util.Constraints;
import org.cloud.apps.qa.view.util.Msgs;


public class PlayGraphicView  extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 4937373266494434821L;
	private JTextField input;
	private JButton button;
	private Integer column;
	
	private PlayController playController;
	
	public PlayGraphicView() {
	    super();
	    this.setLayout(new GridBagLayout());
	    this.setSize(500,500);
	    input = new JTextField(1);
		this.add(input, new Constraints(0, 2, 1, 1));
	    this.button = new JButton(Msgs.ACCEPT);
	    this.add(button, new Constraints(0, 3, 1, 1));
	    this.button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			column = Integer.parseInt(input.getText());
			if (0 > column || column > playController.getMaxOption()) {
				column = null;
				JOptionPane.showMessageDialog(null, String.format(Msgs.NUMBER_ERROR, 0, playController.getMaxOption()), "ERROR", JOptionPane.WARNING_MESSAGE);
			}
			input.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, String.format(Msgs.NUMBER_ERROR, 0, playController.getMaxOption()), "ERROR", JOptionPane.WARNING_MESSAGE);
		}
		
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public void play(PlayController playController2) {
		// TODO Auto-generated method stub
		
	}
	
}