package org.cloud.apps.qa.view.graphic;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cloud.apps.qa.model.Board;
import org.cloud.apps.qa.view.util.Constraints;

public class BoardGraphicView extends JPanel {
	
	private static final long serialVersionUID = -5145459046873722740L;
	
	public BoardGraphicView() {
		super();
		this.setLayout(new GridBagLayout());
		this.setSize(400,400);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void print(Board board) {
		
		for (int x=0; x < board.getHoles().length; x++) {
			StringBuilder row = new StringBuilder("[");
			for (int y=0; y < board.getHoles()[x].length; y++) {
				  row.append(" | "+board.getHoles()[x][y].toString()+" | ");
			}
			row.append("]");
			add(new JLabel(row.toString()), new Constraints(0, x+1, 1, 1));
			//add(new JLabel(Msgs.ROW_BOARD), new Constraints(0, x+3, 1, 1));
		}
		
	}
	
	
}
