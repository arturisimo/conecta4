package org.cloud.apps.qa.view.graphic;

import javax.swing.JOptionPane;

import org.cloud.apps.qa.view.util.Msgs;

public class ResumeDialogGraphicView {
		
	boolean resumeGame() {
		return (JOptionPane.showConfirmDialog(null, Msgs.RESUME,
				Msgs.TITLE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}
	
	
}
