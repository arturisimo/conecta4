package org.cloud.apps.qa;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.ModeGame;
import org.cloud.apps.qa.view.GameView;
import org.cloud.apps.qa.view.console.GameConsoleView;
import org.cloud.apps.qa.view.graphic.GameGraphicView;
import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class App {
	
	private static final Console CONSOLE = Console.getInstance();
	
	Conecta4 game;
	
	public static void main(String[] args) {

		String mode = getModeGame();
		GameView gameView = factoryGames(mode);
		do {
			gameView.init();
	        gameView.play();
	    } while (gameView.isResumeGame());
	}
	
	private static String getModeGame() {
		CONSOLE.println(Msgs.PLAY_MODE);
		return CONSOLE.readLine(ModeGame.G.name(),ModeGame.C.name());
	}
	
	/**
	 * violacion OPEN/CLOSE Principle
	 */
	private static GameView factoryGames(String mode) {
		Conecta4 conecta4 = new Conecta4();
		
		switch (mode) {
		case "G":
			return new GameGraphicView(conecta4);
		case "C":
		default:	
			return new GameConsoleView(conecta4);
		}
	}
	
	
}