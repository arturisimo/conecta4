package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.Player;

public class PlayController extends Controller {

	PlayController(Conecta4 game) {
		super(game);
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

}
