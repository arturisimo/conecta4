package org.cloud.apps.qa.view;

import org.cloud.apps.qa.controller.Logic;
import org.cloud.apps.qa.model.Conecta4;

public abstract class GameView {
	
	protected Conecta4 game;
	protected Logic logic;
	 
	public GameView(Conecta4 game) {
	        this.game = game;
	        this.logic = new Logic(game);
	}
	
	public abstract void init();
	public abstract void play();
	public abstract boolean isResumeGame();
	
}
