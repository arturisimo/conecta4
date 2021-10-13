package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.Logic;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.util.Msgs;

public class PlayView extends ConsoleView {
	
	private ColumnDialogView columnView;
	private BoardView boardView;
	
	public PlayView(Logic logic) {
		super(logic);
		this.columnView = new ColumnDialogView(logic);
	    this.boardView = new BoardView(logic);
	}

	public void play() {
		Player[] players = logic.getPlayers();
		Player turnPlayer;
		int turn = 0;
		do {
			turnPlayer = players[turn];
			int column = columnView.getColumn(turnPlayer);
			
			putPiece(turnPlayer, column);
			
			boardView.print(logic.getBoard());
			
			turn = turn == 0 ? 1 : 0;
			
		} while (!logic.isEndGame(turnPlayer));
		
		CONSOLE.println(logic.getEndMessage());
		
	}
	
	
	private void putPiece(Player player, Integer column) {
        boolean check;
        do {
            check = logic.checkPutPiece(column);
            if (!check) {
            	CONSOLE.println(String.format(Msgs.FULL_COLUMN_ERROR, column));
            	column = columnView.getColumn(player);
            }
        } while (!check);
        logic.putPiece(player, column);
    }
	
}
