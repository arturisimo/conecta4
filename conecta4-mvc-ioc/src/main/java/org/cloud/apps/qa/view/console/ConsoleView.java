package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.Logic;
import org.cloud.apps.qa.view.util.Console;

public abstract class ConsoleView {

    protected Logic logic;
    protected static final Console CONSOLE = Console.getInstance();
    
    public ConsoleView(Logic logic) {
        this.logic = logic;
    }
    
}