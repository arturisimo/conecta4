package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.PlayController;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.util.Msgs;

public class PlayView extends ConsoleView {
	
	private ColumnDialogView columnView;
	private BoardView boardView;
	
	public PlayView() {
		super();
		this.boardView = new BoardView();
	}

	public void play(PlayController playController) {
		Player[] players = playController.getPlayers();
		Player turnPlayer;
		this.columnView = new ColumnDialogView(playController);
	    int turn = 0;
		do {
			turnPlayer = players[turn];
			int column = columnView.getColumn(turnPlayer);
			
			putPiece(playController, turnPlayer, column);
			
			boardView.print(playController.getBoard());
			
			turn = turn == 0 ? 1 : 0;
			
		} while (!playController.isEndGame(turnPlayer));
		
		CONSOLE.println(playController.getEndMessage());
		playController.nextState();
		
	}
	
	
	private void putPiece(PlayController playController, Player player, Integer column) {
        boolean check;
        do {
            check = playController.checkPutPiece(column);
            if (!check) {
            	CONSOLE.println(String.format(Msgs.FULL_COLUMN_ERROR, column));
            	column = columnView.getColumn(player);
            }
        } while (!check);
        playController.putPiece(player, column);
    }

	
	
}
