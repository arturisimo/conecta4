package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.StartController;
import org.cloud.apps.qa.view.util.Msgs;

public class PlayerDialogView extends ConsoleView {
	
	void initGame(StartController startController) {
		
		String[] namePlayers = new String[startController.getNumPlayers()];
		for (int i = 0; i < namePlayers.length; i++) {
			CONSOLE.println(String.format(Msgs.PLAYER, i));
			namePlayers[i] = CONSOLE.readLine();
		}	
		startController.initPlayers(namePlayers);
		startController.nextState();
		 
    }
		
	
}
