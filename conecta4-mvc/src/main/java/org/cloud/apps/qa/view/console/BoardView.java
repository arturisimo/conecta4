package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.Logic;
import org.cloud.apps.qa.model.Board;
import org.cloud.apps.qa.view.util.Msgs;

public class BoardView extends ConsoleView {
	
	public BoardView(Logic logic) {
		super(logic);
	}

	public void print(Board board) {
		CONSOLE.println(Msgs.TITLE);
		for (int x=0; x < board.getHoles().length; x++) {
			CONSOLE.print("[");
			  for (int y=0; y < board.getHoles()[x].length; y++) {
				  CONSOLE.print("|"+board.getHoles()[x][y].toString()+"|");
			  }
			  CONSOLE.println("]");
			  CONSOLE.println(Msgs.ROW_BOARD);
		}
	}

}
