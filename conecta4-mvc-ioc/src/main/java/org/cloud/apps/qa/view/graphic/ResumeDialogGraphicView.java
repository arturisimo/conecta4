package org.cloud.apps.qa.view.graphic;

import javax.swing.JOptionPane;

import org.cloud.apps.qa.controller.ResumeController;
import org.cloud.apps.qa.view.util.Msgs;

public class ResumeDialogGraphicView {
		
	public boolean resume(ResumeController resumeController) {
		boolean resume =  (JOptionPane.showConfirmDialog(null, Msgs.RESUME,
				Msgs.TITLE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
		if (resume) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
		return resume;
	}
	
	
}
