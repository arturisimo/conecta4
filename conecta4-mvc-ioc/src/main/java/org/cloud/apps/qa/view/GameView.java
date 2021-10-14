package org.cloud.apps.qa.view;

import org.cloud.apps.qa.model.Conecta4;

public abstract class GameView implements ControllerVisitor {
	
	protected Conecta4 game;
	 
	public GameView(Conecta4 game) {
	        this.game = game;
	}
	
}
