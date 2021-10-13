package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Conecta4;

public class ResumeController extends Controller {

	ResumeController(Conecta4 game) {
		super(game);
	}

	public void reset() {
		game = null;
	}

}