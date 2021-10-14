package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.ResumeController;
import org.cloud.apps.qa.view.util.Msgs;

public class ResumeDialogView  extends ConsoleView {
	
	
	public void resume(ResumeController resumeController) {
		CONSOLE.println(Msgs.RESUME);
		String response = CONSOLE.readLine("S","N");
		boolean resumeGame = "S".equals(response);
		if (resumeGame) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
		
	}
}
