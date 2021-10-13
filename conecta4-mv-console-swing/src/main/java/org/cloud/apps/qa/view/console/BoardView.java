package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.model.Board;
import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class BoardView {
	
	private Board board;
	private static final Console CONSOLE = Console.getInstance();
	
	public BoardView(Board board) {
		super();
		this.board = board;
	}

	public void print() {
		CONSOLE.println(Msgs.TITLE);
		for (int x=0; x < board.getHoles().length; x++) {
			CONSOLE.print("[");
			  for (int y=0; y < board.getHoles()[x].length; y++) {
				  CONSOLE.print("|"+board.getHoles()[x][y].toString()+"|");
			  }
			  CONSOLE.println("]");
			  CONSOLE.println("[---------------------]");
		}
	}

}
