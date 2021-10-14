package org.cloud.apps.qa;

import org.cloud.apps.qa.controller.Controller;
import org.cloud.apps.qa.controller.Logic;
import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.ModeGame;
import org.cloud.apps.qa.view.ControllerVisitor;
import org.cloud.apps.qa.view.console.GameConsoleView;
import org.cloud.apps.qa.view.graphic.GameGraphicView;
import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class App {
	
	private static final Console CONSOLE = Console.getInstance();
	
	public static void main(String[] args) {
		
		Logic logic = new Logic();
		
		String mode = getModeGame();
		ControllerVisitor gameView = factoryGames(ModeGame.get(mode));
		
		Controller controller;
	    do {
            controller = logic.getController();
            if (controller != null) controller.accept(gameView);
	    } while (controller != null);
	    
	}
	
	private static String getModeGame() {
		CONSOLE.println(Msgs.PLAY_MODE);
		return CONSOLE.readLine(ModeGame.G.name(),ModeGame.C.name());
	}

	/**
	 * violacion OPEN/CLOSE Principle
	 */
	private static ControllerVisitor factoryGames(ModeGame mode) {
		
		switch (mode) {
		case G:
			return new GameGraphicView();
		case C:
		default:	
			return new GameConsoleView();
		}
	}
	
	
}