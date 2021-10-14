package org.cloud.apps.qa.controller;

import java.util.EnumMap;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.State;
import org.cloud.apps.qa.model.StateValue;

public class Logic {
	
	    private Conecta4 game;
	    private State state;
	    private EnumMap<StateValue, Controller> controllers;

	    public Logic() {
	        this.state = new State();
	        this.game = new Conecta4();
	        this.controllers = new EnumMap<>(StateValue.class);
	        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
	        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
	        this.controllers.put(StateValue.RESUME, new ResumeController(this.game, this.state));
	        this.controllers.put(StateValue.EXIT, null);
	    }

	    public Controller getController() {
	        return this.controllers.get(this.state.getValueState());
	    }



		
    
    
}
