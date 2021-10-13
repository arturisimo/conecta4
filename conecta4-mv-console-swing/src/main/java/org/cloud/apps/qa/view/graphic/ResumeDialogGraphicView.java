package org.cloud.apps.qa.view.graphic;

import javax.swing.JOptionPane;

import org.cloud.apps.qa.view.util.Msgs;

public class ResumeDialogGraphicView {
		
	private boolean newGame;

	public ResumeDialogGraphicView() {
		this.newGame = (JOptionPane.showConfirmDialog(null, Msgs.RESUME,
				Msgs.TITLE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}

	boolean resumeGame() {
		return this.newGame;
	}
	
	
}
