package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Board;
import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.State;
import org.cloud.apps.qa.view.ControllerVisitor;

public class StartController extends Controller {

	StartController(Conecta4 game, State state) {
		super(game, state);
	}

	public void initPlayers(String[] namePlayers) {
		game.initPlayers(namePlayers); 
	}
	
	public int getNumPlayers() {
		return Conecta4.NUM_PLAYERS;
	}
	
	public Board getBoard() {
		return game.getBoard();
	}
	
	@Override
	public void accept(ControllerVisitor gameView) {
		gameView.visit(this);
	}

}
