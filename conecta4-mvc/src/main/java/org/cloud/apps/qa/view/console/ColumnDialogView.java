package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.Logic;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class ColumnDialogView extends ConsoleView {
	
	public ColumnDialogView(Logic logic) {
		super(logic);
	}

	private static final Console CONSOLE = Console.getInstance();
	
	public int getColumn(Player player) {
		CONSOLE.println(String.format(Msgs.TURN, player.getName(), player.getColour(), logic.getMaxOption()));
		return CONSOLE.readIntInRange(0, logic.getMaxOption());
	}
	
}
