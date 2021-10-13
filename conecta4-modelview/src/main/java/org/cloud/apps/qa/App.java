package org.cloud.apps.qa;

import org.cloud.apps.qa.view.GameView;

public class App {
	
	public static void main(String[] args) {
		
		GameView gameView = new GameView();
		
		do {
			gameView.init();
            gameView.play();
        } while (gameView.isResumeGame());
		
	}
	
	
}