package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class ResumeDialogView {
	private static final Console CONSOLE = Console.getInstance();
	
	public boolean resumeGame() {
		CONSOLE.println(Msgs.RESUME);
		String response = CONSOLE.readLine("S","N");
		return "S".equals(response);
	}
}
