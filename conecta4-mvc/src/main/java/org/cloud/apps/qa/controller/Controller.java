package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Conecta4;

public abstract class Controller {

    protected Conecta4 game;

    Controller(Conecta4 game) {
        this.game = game;
    }

}

