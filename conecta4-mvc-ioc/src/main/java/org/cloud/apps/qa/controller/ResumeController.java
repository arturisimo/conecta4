package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.State;
import org.cloud.apps.qa.view.ControllerVisitor;

public class ResumeController extends Controller {

	ResumeController(Conecta4 game, State state) {
		super(game, state);
	}
	
	public void reset() {
		game = null;
	}
	
	@Override
	public void accept(ControllerVisitor gameView) {
		gameView.visit(this);
	}

	

}