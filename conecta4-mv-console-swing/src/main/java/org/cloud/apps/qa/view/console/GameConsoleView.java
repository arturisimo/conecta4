package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.GameView;
import org.cloud.apps.qa.view.util.Console;
import org.cloud.apps.qa.view.util.Msgs;

public class GameConsoleView implements GameView {
	
	private Conecta4 game;
	private static final Console CONSOLE = Console.getInstance();
	private int turn = 0;
	private BoardView boardView;
	private PlayerDialogView playerDialogView;
	private ColumnDialogView columnDialogView;
	private ResumeDialogView resumeDialogView;
	
	
	public GameConsoleView() {
		this.game = new Conecta4();
		this.playerDialogView = new PlayerDialogView();
		this.columnDialogView = new ColumnDialogView();
		this.resumeDialogView = new ResumeDialogView();
	}
	
	@Override
	public void init() {
		
		String[] players = new String[Conecta4.getNumPlayers()];
		for (int i = 0; i < players.length; i++) {
			players[i] = playerDialogView.getPlayerName(i);
		}	
		game.init(players);
		boardView = new BoardView(game.getBoard());
	}
	
	@Override
	public void play() {
		Player[] players = game.getPlayers();
		Player turnPlayer;
		do {
			turnPlayer = players[turn];
			int column = columnDialogView.getColumn(turnPlayer);
			
			putPiece(turnPlayer, column);
			
			boardView.print();
			
			turn = turn == 0 ? 1 : 0;
			
		} while (!game.end(turnPlayer));
		
		CONSOLE.println(game.getWinner().map(winner -> String.format(Msgs.WINNER, winner.getName())).orElse(Msgs.NO_PIECES));
	}

	private void putPiece(Player player, Integer column) {
        boolean check;
        do {
            check = game.checkPutPiece(column);
            if (!check) {
            	CONSOLE.println(String.format(Msgs.FULL_COLUMN_ERROR, column));
            	column = columnDialogView.getColumn(player);
            }
        } while (!check);
        this.game.putPiece(player, column);
    }
	
	@Override
	public boolean isResumeGame() {
		return resumeDialogView.resumeGame();
	}
	
	
}
	