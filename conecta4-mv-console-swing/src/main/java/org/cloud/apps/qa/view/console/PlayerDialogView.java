package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class PlayerDialogView {
	
	private static final Console CONSOLE = Console.getInstance();
	
	public String getPlayerName(Integer turn) {
		CONSOLE.println(String.format(Msgs.PLAYER, turn));
	    return CONSOLE.readLine();
	}

		
	
}
