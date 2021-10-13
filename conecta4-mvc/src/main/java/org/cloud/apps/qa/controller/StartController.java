package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Conecta4;

public class StartController extends Controller {

	StartController(Conecta4 game) {
		super(game);
	}

	public void initPlayers(String[] namePlayers) {
		game.initPlayers(namePlayers); 
	}

}
