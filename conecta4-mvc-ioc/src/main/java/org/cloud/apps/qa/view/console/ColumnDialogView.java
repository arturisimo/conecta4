package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.PlayController;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.util.Msgs;

public class ColumnDialogView extends ConsoleView {
	
	private PlayController playController;
	
	public ColumnDialogView(PlayController playController) {
		super();
		this.playController = playController;
	}

	public int getColumn(Player player) {
		CONSOLE.println(String.format(Msgs.TURN, player.getName(), player.getColour(), playController.getMaxOption()));
		return CONSOLE.readIntInRange(0, playController.getMaxOption());
	}
	
}
