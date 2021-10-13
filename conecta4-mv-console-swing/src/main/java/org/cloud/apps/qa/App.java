package org.cloud.apps.qa;

import org.cloud.apps.qa.model.ModeGame;
import org.cloud.apps.qa.view.GameView;
import org.cloud.apps.qa.view.console.GameConsoleView;
import org.cloud.apps.qa.view.graphic.GameGraphicView;
import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class App {
	
	private static final Console CONSOLE = Console.getInstance();
	
	public static void main(String[] args) {

		CONSOLE.println(Msgs.PLAY_MODE);
		String mode = CONSOLE.readLine(ModeGame.G.name(),ModeGame.C.name());
		
		GameView gameView = factoryGames(ModeGame.get(mode));
		
		do {
			gameView.init();
	        gameView.play();
	    } while (gameView.isResumeGame());
	
	}

	/**
	 * violacion OPEN/CLOSE Principle
	 */
	private static GameView factoryGames(ModeGame mode) {
		switch (mode) {
		case G:
			return new GameGraphicView();
		case C:
		default:	
			return new GameConsoleView();
		}
	}
	
	
}