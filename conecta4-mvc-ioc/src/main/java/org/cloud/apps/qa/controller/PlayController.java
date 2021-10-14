package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Board;
import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.model.State;
import org.cloud.apps.qa.view.ControllerVisitor;
import org.cloud.apps.qa.view.util.Msgs;

public class PlayController extends Controller {

	PlayController(Conecta4 game, State state) {
		super(game, state);
	}

	public boolean checkPutPiece(Integer column) {
		 return game.checkPutPiece(column);
	}

	public boolean isEndGame(Player player) {
		return game.end(player);
	}

	public void putPiece(Player player, Integer column) {
		game.putPiece(player, column);
	}
	
	public String getEndMessage() {
		return game.getWinner().map(winner -> String.format(Msgs.WINNER, winner.getName())).orElse(Msgs.NO_PIECES);
	}
	
	public int getMaxOption() {
		return Conecta4.COLUMNS -1;
	}
	
	public int getNumPlayers() {
		return Conecta4.NUM_PLAYERS;
	}
	
	public Player[] getPlayers() {
		return game.getPlayers();
	}
	
	public Board getBoard() {
		return game.getBoard();
	}
	
	@Override
	public void accept(ControllerVisitor gameView) {
		gameView.visit(this);
	}
	
	
}
