package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.Logic;
import org.cloud.apps.qa.view.util.Msgs;

public class PlayerDialogView extends ConsoleView {
	
	public PlayerDialogView(Logic logic) {
		super(logic);
	}

	public String getPlayerName(Integer turn) {
		CONSOLE.println(String.format(Msgs.PLAYER, turn));
	    return CONSOLE.readLine();
	}

		
	
}
