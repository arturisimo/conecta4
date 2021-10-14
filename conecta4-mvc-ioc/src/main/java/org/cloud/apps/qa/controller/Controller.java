package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.State;
import org.cloud.apps.qa.view.ControllerVisitor;

public abstract class Controller {

    protected Conecta4 game;
    protected State state;

    Controller(Conecta4 game, State state) {
        this.game = game;
        this.state = state;
    }
    
    public void nextState() {
        this.state.next();
    }

	public abstract void accept(ControllerVisitor gameView);
    
    
}

