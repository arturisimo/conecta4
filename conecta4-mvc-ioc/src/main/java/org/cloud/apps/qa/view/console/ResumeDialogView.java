package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.Logic;
import org.cloud.apps.qa.view.util.Msgs;

public class ResumeDialogView  extends ConsoleView {
	
	public ResumeDialogView(Logic logic) {
		super(logic);
	}

	public boolean resumeGame() {
		CONSOLE.println(Msgs.RESUME);
		String response = CONSOLE.readLine("S","N");
		return "S".equals(response);
	}
}
