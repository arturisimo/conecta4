package org.cloud.apps.qa.view.graphic;

import java.awt.GridBagLayout;

import javax.swing.JFrame;

import org.cloud.apps.qa.view.util.Msgs;

public class FrameView extends JFrame {
	
	private static final long serialVersionUID = 6838941282842730691L;
	
	public FrameView() {
		super(Msgs.TITLE);
		this.getContentPane().setLayout(new GridBagLayout());
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

	}
	
	
	
}
