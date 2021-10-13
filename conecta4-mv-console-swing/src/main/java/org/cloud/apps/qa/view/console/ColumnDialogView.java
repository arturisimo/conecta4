package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class ColumnDialogView {
	
	private static final Console CONSOLE = Console.getInstance();
	
	public int getColumn(Player player) {
		CONSOLE.println(String.format(Msgs.TURN, player.getName(), player.getColour(), Conecta4.getMaxOption()));
		return CONSOLE.readIntInRange(0, Conecta4.getMaxOption());
	}
	
}
